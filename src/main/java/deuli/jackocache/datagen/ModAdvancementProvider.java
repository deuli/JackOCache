package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    public static class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
        private final List<RegistryObject<Block>> HOSTILE_PUMPKINS = List.of(
                ModBlocks.CREEPER_PUMPKIN,
                ModBlocks.ENDERMAN_PUMPKIN,
                ModBlocks.SKELETON_PUMPKIN,
                ModBlocks.ROTTEN_PUMPKIN,
                ModBlocks.SPIDER_PUMPKIN,
                ModBlocks.GHAST_PUMPKIN,
                ModBlocks.SLIME_PUMPKIN,
                ModBlocks.ILLAGER_PUMPKIN,
                ModBlocks.GUARDIAN_PUMPKIN
        );
        private final List<RegistryObject<Block>> FRIENDLY_PUMPKINS = List.of(
                ModBlocks.VILLAGER_PUMPKIN,
                ModBlocks.PIG_PUMPKIN,
                ModBlocks.DOG_PUMPKIN,
                ModBlocks.CAT_PUMPKIN,
                ModBlocks.CHICKEN_PUMPKIN,
                ModBlocks.SHEEP_PUMPKIN,
                ModBlocks.SNOW_GOLEM_PUMPKIN,
                ModBlocks.BAT_PUMPKIN
        );
        private final List<RegistryObject<Block>> TRANSFORM_PUMPKINS = List.of(
                ModBlocks.GENERIC_PUMPKIN,
                ModBlocks.UWU_PUMPKIN,
                ModBlocks.NICE_PUMPKIN,
                ModBlocks.EMOTE_PUMPKIN,
                ModBlocks.PUMPKING,
                ModBlocks.GHOST_PUMPKIN,
                ModBlocks.SNOW_PUMPKIN,
                ModBlocks.MELON_PUMPKIN,
                ModBlocks.ALPHA_PUMPKIN,
                ModBlocks.SPOOKYJAM_PUMPKIN,
                ModBlocks.COOL_PUMPKIN,
                ModBlocks.ANGRY_PUMPKIN,
                ModBlocks.PUKING_PUMPKIN
        );
        private final List<RegistryObject<Block>> SPECIAL_PUMPKINS = List.of(
                ModBlocks.DRAGON_PUMPKIN,
                ModBlocks.WITHER_PUMPKIN,
                ModBlocks.PLAYER_PUMPKIN,
                ModBlocks.SYNTH_PUMPKIN
        );

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
            Advancement root = Advancement.Builder.advancement().display(
                            ModBlocks.SINISTER_PUMPKIN.get().asItem(),
                            Component.literal(JackOCache.MOD_NAME),
                            Component.literal("Time to collect some pumpkins"),
                            new ResourceLocation("textures/block/pumpkin_side.png"),
                            FrameType.TASK, true, false, false)
                    .addCriterion("has_pumpkin",
                            InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.PUMPKIN.asItem()))
                    .save(saver, new ResourceLocation(JackOCache.MOD_ID, "root"), existingFileHelper);

            Advancement carved = Advancement.Builder.advancement().parent(root).display(
                            Blocks.CARVED_PUMPKIN.asItem(),
                            Component.literal("Carved"),
                            Component.literal("Carve a pumpkin with shears"),
                            null, FrameType.TASK, true, false, false)
                    .addCriterion("carved_pumpkin",
                            ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                    LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(Blocks.CARVED_PUMPKIN).build()),
                                    ItemPredicate.Builder.item().of(Items.SHEARS)))
                    .save(saver, new ResourceLocation(JackOCache.MOD_ID, "carved_pumpkin"), existingFileHelper);

            Advancement jackOLantern = Advancement.Builder.advancement().parent(carved).display(
                            Blocks.JACK_O_LANTERN.asItem(),
                            Component.literal("Spooky Lamp"),
                            Component.literal("Add a torch to a carved pumpkin"),
                            null, FrameType.TASK, true, false, false)
                    .addCriterion("has_jack_o_lantern",
                            InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.JACK_O_LANTERN))
                    .save(saver, new ResourceLocation(JackOCache.MOD_ID, "jack_o_lantern"), existingFileHelper);

            Advancement jackOSlicer = Advancement.Builder.advancement().parent(jackOLantern).display(
                            ModItems.JACK_O_SLICER.get(),
                            Component.literal("Spooky Sword"),
                            Component.literal("Construct the weapon of Halloween"),
                            null, FrameType.TASK, true, true, false)
                    .addCriterion("has_jack_o_slicer",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JACK_O_SLICER.get()))
                    .save(saver, new ResourceLocation(JackOCache.MOD_ID, "jack_o_slicer"), existingFileHelper);

            ItemStack enchantedSinisterPumpkin = new ItemStack(ModBlocks.PUMPKING.get());
            enchantedSinisterPumpkin.enchant(Enchantments.BINDING_CURSE, 0);
            Advancement.Builder allPumpkinsBuilder = Advancement.Builder.advancement().parent(jackOSlicer).display(
                    enchantedSinisterPumpkin,
                    Component.literal("King of Halloween"),
                    Component.literal("Collect every pumpkin offered by " + JackOCache.MOD_NAME),
                    null, FrameType.CHALLENGE, true, true, false);
            for (RegistryObject<Block> carvedPumpkin : ModBlocks.CARVED_PUMPKINS)
                allPumpkinsBuilder.addCriterion("has_" + carvedPumpkin.getId().getPath(),
                        InventoryChangeTrigger.TriggerInstance.hasItems(carvedPumpkin.get()));
            Advancement allPumpkins = allPumpkinsBuilder.save(saver, new ResourceLocation(JackOCache.MOD_ID, "all_pumpkins"), existingFileHelper);

            Advancement sinisterPumpkin = Advancement.Builder.advancement().parent(allPumpkins).display(
                            ModBlocks.SINISTER_PUMPKIN.get(),
                            ModBlocks.SINISTER_PUMPKIN.get().getName(),
                            Component.literal("Obtain a ").append(ModBlocks.SINISTER_PUMPKIN.get().getName()),
                            null, FrameType.TASK, true, true, false)
                    .addCriterion("has_" + ModBlocks.SINISTER_PUMPKIN.getId().getPath(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SINISTER_PUMPKIN.get()))
                    .save(saver, new ResourceLocation(JackOCache.MOD_ID, ModBlocks.SINISTER_PUMPKIN.getId().getPath()), existingFileHelper);

            Advancement last = sinisterPumpkin;
            for (RegistryObject<Block> object : HOSTILE_PUMPKINS) {
                Block block = object.get();
                last = Advancement.Builder.advancement().parent(last).display(
                                block,
                                block.getName(),
                                Component.literal("Obtain a ").append(block.getName()),
                                null, FrameType.TASK, true, true, false)
                        .addCriterion("has_" + object.getId().getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(block))
                        .save(saver, object.getId().withPrefix("hostile/"), existingFileHelper);
            }

            last = sinisterPumpkin;
            for (RegistryObject<Block> object : FRIENDLY_PUMPKINS) {
                Block block = object.get();
                last = Advancement.Builder.advancement().parent(last).display(
                                block,
                                block.getName(),
                                Component.literal("Obtain a ").append(block.getName()),
                                null, FrameType.TASK, true, true, false)
                        .addCriterion("has_" + object.getId().getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(block))
                        .save(saver, object.getId().withPrefix("friendly/"), existingFileHelper);
            }

            last = allPumpkins;
            for (RegistryObject<Block> object : TRANSFORM_PUMPKINS) {
                Block block = object.get();
                last = Advancement.Builder.advancement().parent(last).display(
                                block,
                                block.getName(),
                                Component.literal("Obtain a ").append(block.getName()),
                                null, FrameType.TASK, true, true, false)
                        .addCriterion("has_" + object.getId().getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(block))
                        .save(saver, object.getId().withPrefix("transform/"), existingFileHelper);
            }

            last = allPumpkins;
            for (RegistryObject<Block> object : SPECIAL_PUMPKINS) {
                Block block = object.get();
                last = Advancement.Builder.advancement().parent(last).display(
                                block,
                                block.getName(),
                                Component.literal("Obtain a ").append(block.getName()),
                                null, FrameType.GOAL, true, true, false)
                        .addCriterion("has_" + object.getId().getPath(),
                                InventoryChangeTrigger.TriggerInstance.hasItems(block))
                        .save(saver, object.getId().withPrefix("zpecial/"), existingFileHelper); //With Z so it load below transform pumpkins
            }
        }
    }
}
