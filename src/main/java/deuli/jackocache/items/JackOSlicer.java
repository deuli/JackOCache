package deuli.jackocache.items;

import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.init.ModTiers;
import deuli.jackocache.items.jackoslicer.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JackOSlicer extends SwordItem {

    private HashMap<String, PumpkinDrop> pumpkinDrops = new HashMap<>(){{
        put("minecraft:creeper", new PumpkinDrop(ModBlocks.CREEPER_PUMPKIN.get()));
        put("minecraft:enderman", new PumpkinDrop(ModBlocks.ENDERMAN_PUMPKIN.get()));
        put("minecraft:skeleton", new PumpkinDrop(ModBlocks.SKELETON_PUMPKIN.get()));
        put("minecraft:zombie", new PumpkinDrop(ModBlocks.ROTTEN_PUMPKIN.get()));
        put("minecraft:villager", new PumpkinDrop(ModBlocks.VILLAGER_PUMPKIN.get(), 0.95F));
        put("minecraft:pig", new PumpkinDrop(ModBlocks.PIG_PUMPKIN.get(), 0.35F));
        put("minecraft:spider", new PumpkinDrop(ModBlocks.SPIDER_PUMPKIN.get()));
        put("minecraft:ghast", new PumpkinDrop(ModBlocks.GHAST_PUMPKIN.get(), 0.80F));
    }};

    private ArrayList<PumpkinTransformation> pumpkinTransformations = new ArrayList<>() {{
        add(new PumpkinTransformation(ModBlocks.UWU_PUMPKIN.get(), TransformConditions.link(
                new DimensionCondition(Level.NETHER),
                new HeightCondition(-64, 35)
        )));
        add(new PumpkinTransformation(Blocks.ACACIA_LOG, TransformConditions.link(
                new TagCondition(0, -1, 0, BlockTags.LOGS)
        )));
        add(new PumpkinTransformation(Blocks.DEEPSLATE_GOLD_ORE, TransformConditions.link(
                new BlockCondition(0, 1, 0, Blocks.GOLD_BLOCK)
        )));
        add(new PumpkinTransformation(Blocks.BEDROCK, TransformConditions.link(
                new BiomeCondition(Biomes.DARK_FOREST)
        )));
    }};

    public JackOSlicer() {
        super(ModTiers.PUMPKIN, 3, -2.4F, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker)
    {
//        if(pAttacker instanceof Player player)
//            player.displayClientMessage(Component.literal(pTarget.getEncodeId()), true);

        ItemStack pumpkin = new ItemStack(Items.PUMPKIN);

        if(pAttacker instanceof Player player && player.getInventory().contains(pumpkin) && pTarget.getHealth() <= 0)
        {
            PumpkinDrop pumpkinDrop = pumpkinDrops.getOrDefault(pTarget.getEncodeId(), new PumpkinDrop(ModBlocks.SINISTER_PUMPKIN.get()));

            if(player.getRandom().nextFloat() <= pumpkinDrop.chance)
            {
                pTarget.spawnAtLocation(pumpkinDrop.pumpkin);

                int pumpkinSlot = player.getInventory().findSlotMatchingItem(pumpkin);
                player.getInventory().removeItem(pumpkinSlot, 1);

                player.level().playSound(null, pTarget.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if(pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock() == Blocks.PUMPKIN)
        {
            Block pumpkin = ModBlocks.GENERIC_PUMPKIN.get();
            for(PumpkinTransformation transformation : pumpkinTransformations)
            {
                if(transformation.check(level, pContext.getClickedPos()))
                {
                    pumpkin = transformation.getResult();
                    break;
                }
            }

            level.destroyBlock(pContext.getClickedPos(), false);

            Block.popResource(level, pContext.getClickedPos(), new ItemStack(pumpkin));

            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), (player) -> {
                player.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return super.useOn(pContext);
    }

    private class PumpkinDrop {

        private final Block pumpkin;
        private float chance = 0.5F;

        public PumpkinDrop(Block pumpkin, float chance) {
            this.pumpkin = pumpkin;
            this.chance = chance;
        }

        public PumpkinDrop(Block pumpkin) {
            this.pumpkin = pumpkin;
        }
    }
}
