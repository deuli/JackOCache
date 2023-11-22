package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.loot.AddPlayerPumpkinLootModifier;
import deuli.jackocache.loot.AddPumpkinLootModifier;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, JackOCache.MOD_ID);
    }

    @Override
    protected void start() {
        addPumpkin(EntityType.CREEPER, ModBlocks.CREEPER_PUMPKIN);
        addPumpkin(EntityType.ENDERMAN, ModBlocks.ENDERMAN_PUMPKIN);
        addPumpkin(EntityType.SKELETON, ModBlocks.SKELETON_PUMPKIN);
        addPumpkin(EntityType.WITHER_SKELETON, ModBlocks.SKELETON_PUMPKIN);
        addPumpkin(EntityType.STRAY, ModBlocks.SKELETON_PUMPKIN);
        addPumpkin(EntityType.ZOMBIE, ModBlocks.ROTTEN_PUMPKIN);
        addPumpkin(EntityType.HUSK, ModBlocks.ROTTEN_PUMPKIN);
        addPumpkin(EntityType.DROWNED, ModBlocks.ROTTEN_PUMPKIN);
        addPumpkin(EntityType.VILLAGER, ModBlocks.VILLAGER_PUMPKIN, 0.95F);
        addPumpkin(EntityType.WANDERING_TRADER, ModBlocks.VILLAGER_PUMPKIN, 0.75F);
        addPumpkin(EntityType.PIG, ModBlocks.PIG_PUMPKIN, 0.35F);
        addPumpkin(EntityType.SPIDER, ModBlocks.SPIDER_PUMPKIN);
        addPumpkin(EntityType.CAVE_SPIDER, ModBlocks.SPIDER_PUMPKIN);
        addPumpkin(EntityType.GHAST, ModBlocks.GHAST_PUMPKIN, 0.80F);
        addPumpkin(EntityType.SLIME, ModBlocks.SLIME_PUMPKIN, 0.30F);
        addPumpkin(EntityType.WOLF, ModBlocks.DOG_PUMPKIN, 0.65F);
        addPumpkin(EntityType.CAT, ModBlocks.CAT_PUMPKIN, 0.75F);
        addPumpkin(EntityType.CHICKEN, ModBlocks.CHICKEN_PUMPKIN, 0.35F);
        addPumpkin(EntityType.ENDER_DRAGON, ModBlocks.DRAGON_PUMPKIN, 1.00F);
        addPumpkin(EntityType.WITHER, ModBlocks.WITHER_PUMPKIN, 1.00F);
        addPumpkin(EntityType.SHEEP, ModBlocks.SHEEP_PUMPKIN, 0.35F);
        addPumpkin(EntityType.SNOW_GOLEM, ModBlocks.SNOW_GOLEM_PUMPKIN);
        addPumpkin(EntityType.EVOKER, ModBlocks.ILLAGER_PUMPKIN);
        addPumpkin(EntityType.PILLAGER, ModBlocks.ILLAGER_PUMPKIN);
        addPumpkin(EntityType.VINDICATOR, ModBlocks.ILLAGER_PUMPKIN);
        addPumpkin(EntityType.GUARDIAN, ModBlocks.GUARDIAN_PUMPKIN);
        addPumpkin(EntityType.ELDER_GUARDIAN, ModBlocks.GUARDIAN_PUMPKIN, 0.80F);
        addPumpkin(EntityType.BAT, ModBlocks.BAT_PUMPKIN, 0.75F);
        addPumpkin(EntityType.ZOMBIE_VILLAGER, ModBlocks.ROTTEN_VILLAGER_PUMPKIN, 0.80F);
        addPumpkin(EntityType.WITCH, ModBlocks.WITCH_PUMPKIN, 0.60F);
        addPumpkin(EntityType.WARDEN, ModBlocks.WARDEN_PUMPKIN, 1.00F);

        addPlayerPumpkin("deuli", ModBlocks.SYNTH_PUMPKIN, 0.70F);
    }

    private String getModifier(EntityType entityType, RegistryObject<Block> pumpkin) {
//        return entityType.getDescription().getString().toLowerCase().replace(" ", "_") + "_" + pumpkin.getId().getPath();
        return getModifier(entityType.getDescription().getString().toLowerCase().replace(" ", "_"), pumpkin);
    }

    private String getModifier(String name, RegistryObject<Block> pumpkin) {
        return pumpkin.getId().getPath() + "_from_" + name;
    }

    private void addPumpkin(EntityType entityType, RegistryObject<Block> pumpkin, float chance) {
        add(getModifier(entityType, pumpkin), new AddPumpkinLootModifier(new LootItemCondition[]{
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().of(entityType)).build(),
                LootItemRandomChanceCondition.randomChance(chance).build()
        }, pumpkin.get().asItem(), EntityType.getKey(entityType).toString()));
    }

    private void addPumpkin(EntityType entityType, RegistryObject<Block> pumpkin) {
        addPumpkin(entityType, pumpkin, 0.5F);
    }

    private void addPlayerPumpkin(String playerName, RegistryObject<Block> pumpkin, float chance) {
        add(getModifier(playerName, pumpkin), new AddPlayerPumpkinLootModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(chance).build()
        }, pumpkin.get().asItem(), playerName));
    }
}
