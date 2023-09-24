package deuli.spookyjam2023.items;

import deuli.spookyjam2023.init.ModTiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
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
        if(pAttacker instanceof Player && pTarget.getHealth() <= 0)
        {
            if(pTarget instanceof Creeper)
            {
                pTarget.spawnAtLocation(Items.TNT);
            }
            else if(pTarget instanceof Zombie)
            {
                pTarget.spawnAtLocation(Items.DIAMOND);
            }
            else if(pTarget instanceof Skeleton)
            {
                pTarget.spawnAtLocation(Items.BONE_BLOCK);
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
