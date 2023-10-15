package deuli.jackocache.other;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.items.jackoslicer.PumpkinDrop;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PumpkinEvents {
    @SubscribeEvent
    public static void replacePumpkins(EntityJoinLevelEvent event) {
        Random random = new Random();
        Entity entity = event.getEntity();
//        LocalDate localdate = LocalDate.now();
        if ((entity instanceof Zombie || entity instanceof Skeleton) &&
//                localdate.getMonth() == Month.OCTOBER && localdate.getDayOfMonth() == 31 &&
                random.nextFloat() <= (1 - (1.0 / (ModBlocks.PUMPKINS.size() + 1)))) {
            ItemStack helmet = ((Monster) entity).getItemBySlot(EquipmentSlot.HEAD);

            ItemStack pumpkin;
            if (helmet.is(Blocks.CARVED_PUMPKIN.asItem()))
                pumpkin = new ItemStack(ModBlocks.CARVED_PUMPKINS.get(random.nextInt(ModBlocks.CARVED_PUMPKINS.size())).get());
            else if (helmet.is(Blocks.JACK_O_LANTERN.asItem()))
                pumpkin = new ItemStack(ModBlocks.JACK_O_LANTERN.get(random.nextInt(ModBlocks.JACK_O_LANTERN.size())).get());
            else
                return;

            entity.setItemSlot(EquipmentSlot.HEAD, pumpkin);
            Item pumpkinItem = pumpkin.getItem();
            if (PumpkinDrop.PUMPKIN_DROP_CHANCES.containsKey(pumpkinItem))
                ((Monster) entity).setDropChance(EquipmentSlot.HEAD, PumpkinDrop.PUMPKIN_DROP_CHANCES.get(pumpkinItem));
        }
    }
}