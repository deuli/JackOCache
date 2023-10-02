package deuli.jackocache.items;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
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
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JackOSlicer extends SwordItem {

    private final ArrayList<PumpkinTransformation> pumpkinTransformations = new ArrayList<>() {{
        add(new PumpkinTransformation(ModBlocks.UWU_PUMPKIN.get(), TransformConditions.link(
                new DimensionCondition(Level.NETHER),
                new HeightCondition(-64, 35)
        )));
        add(new PumpkinTransformation(ModBlocks.NICE_PUMPKIN.get(), TransformConditions.link(
                new TagCondition(0, -1, 0, BlockTags.LOGS)
        )));
        add(new PumpkinTransformation(ModBlocks.EMOTE_PUMPKIN.get(), TransformConditions.link(
                new SignCondition("", ":^)")
        )));
        add(new PumpkinTransformation(Blocks.BEDROCK, TransformConditions.link(
                new BiomeCondition(Biomes.DARK_FOREST)
        )));
    }};

    public JackOSlicer() {
        super(ModTiers.PUMPKIN, 3, -2.4F, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @SubscribeEvent
    public static void livingEntityDeath(LivingDeathEvent event) {
        System.out.println("Death");
        ItemStack pumpkin = new ItemStack(Items.PUMPKIN);

        LivingEntity target = event.getEntity();
        if (event.getSource().getEntity() instanceof Player player && player.getInventory().contains(pumpkin) && target.getHealth() <= 0) {
            PumpkinDrop pumpkinDrop = PumpkinDrop.PUMPKIN_DROPS.getOrDefault(target.getEncodeId(), new PumpkinDrop(ModBlocks.SINISTER_PUMPKIN.get()));

            if (player.getRandom().nextFloat() <= pumpkinDrop.getChance()) {
                target.spawnAtLocation(pumpkinDrop.getPumpkin());

                int pumpkinSlot = player.getInventory().findSlotMatchingItem(pumpkin);
                player.getInventory().removeItem(pumpkinSlot, 1);

                player.level().playSound(null, target.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock() == Blocks.PUMPKIN) {
            Block pumpkin = ModBlocks.GENERIC_PUMPKIN.get();
            for (PumpkinTransformation transformation : pumpkinTransformations) {
                if (transformation.check(level, pContext.getClickedPos())) {
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
}
