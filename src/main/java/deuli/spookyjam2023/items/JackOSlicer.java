package deuli.spookyjam2023.items;

import deuli.spookyjam2023.init.ModItems;
import deuli.spookyjam2023.init.ModTiers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;

public class JackOSlicer extends SwordItem {

    public JackOSlicer() {
        super(ModTiers.PUMPKIN, 3, -2.4F, new Item.Properties());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker)
    {
        ItemStack pumpkin = new ItemStack(Items.PUMPKIN);

        if(pAttacker instanceof Player player &&
                player.getInventory().contains(pumpkin) &&
                pTarget.getHealth() <= 0)
        {
            pTarget.spawnAtLocation(ModItems.SINISTER_PUMPKIN.get());

            int pumpkinSlot = player.getInventory().findSlotMatchingItem(pumpkin);
            player.getInventory().removeItem(pumpkinSlot, 1);

            player.level().playSound(null, pTarget.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
