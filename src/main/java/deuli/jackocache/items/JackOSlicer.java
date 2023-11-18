package deuli.jackocache.items;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.init.ModTiers;
import deuli.jackocache.items.jackoslicer.PumpkinDrop;
import deuli.jackocache.items.jackoslicer.PumpkinTransformation;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JackOSlicer extends SwordItem {

    public JackOSlicer() {
        super(ModTiers.PUMPKIN, 3, -2.4F, new Item.Properties());
    }

    @SubscribeEvent
    public static void livingEntityDeath(LivingDeathEvent event) {
        LivingEntity target = event.getEntity();
        if (!PumpkinDrop.PUMPKIN_DROPS.contains(target.getEncodeId()) && event.getSource().getEntity() != null) {
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            if (attacker.getMainHandItem().is(ModItems.JACK_O_SLICER.get())) {
                ItemStack pumpkin = new ItemStack(Items.PUMPKIN);

                if (attacker instanceof Player player && player.getInventory().contains(pumpkin) && target.getHealth() <= 0) {
                    PumpkinDrop pumpkinDrop;
                    if (target instanceof Player playerTarget) {
                        if (!PumpkinDrop.PLAYER_PUMPKIN_DROPS.containsKey(playerTarget.getDisplayName().getString()))
                            pumpkinDrop = new PumpkinDrop(ModBlocks.PLAYER_PUMPKIN.get(), 0.70F);
                        else
                            return;
                    }
                    else
                        pumpkinDrop = new PumpkinDrop(ModBlocks.SINISTER_PUMPKIN.get());

                    if (player.getRandom().nextFloat() <= pumpkinDrop.getChance()) {
                        target.spawnAtLocation(pumpkinDrop.getPumpkin());

                        int pumpkinSlot = player.getInventory().findSlotMatchingItem(pumpkin);
                        player.getInventory().removeItem(pumpkinSlot, 1);

                        player.level().playSound(null, target.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);
                    }
                }
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide() && level.getBlockState(pContext.getClickedPos()).is(Blocks.PUMPKIN)) {
            Block pumpkin = ModBlocks.GENERIC_PUMPKIN.get();
            for (PumpkinTransformation transformation : PumpkinTransformation.PUMPKIN_TRANSFORMATIONS) {
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

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity interactionTarget, InteractionHand hand) {
        if (interactionTarget instanceof Player playerTarget && playerTarget.getInventory().getArmor(3).is(Blocks.CARVED_PUMPKIN.asItem())) {
            Item pumpkin = PumpkinDrop.PLAYER_PUMPKIN_DROPS.getOrDefault(playerTarget.getDisplayName().getString(), ModBlocks.PLAYER_PUMPKIN.get().asItem());
            Level level = interactionTarget.level();

            playerTarget.getInventory().getArmor(3).shrink(1);

            ItemEntity itemEntity = new ItemEntity(level, interactionTarget.getX(), interactionTarget.getY() + 1, interactionTarget.getZ(), new ItemStack(pumpkin));
            itemEntity.setPickUpDelay(20);
            final double MULTIPLIER = 0.05;
            itemEntity.setDeltaMovement((player.getX() - interactionTarget.getX()) * MULTIPLIER, 0.4, (player.getZ() - interactionTarget.getZ()) * MULTIPLIER);
            level.addFreshEntity(itemEntity);

            level.playSound(null, interactionTarget.blockPosition(), SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.PLAYERS, 1, 1);
            level.playSound(null, interactionTarget.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);

            player.getItemInHand(hand).hurtAndBreak(1, player, (playerBreak) -> {
                playerBreak.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
