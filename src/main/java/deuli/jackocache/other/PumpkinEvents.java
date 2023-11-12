package deuli.jackocache.other;

import deuli.jackocache.Config;
import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModEntityTypeTags;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.items.jackoslicer.PumpkinDrop;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PumpkinEvents {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void addPumpkin(EntityJoinLevelEvent event) {
        Random random = new Random();
        Entity entity = event.getEntity();
        LocalDate localdate = LocalDate.now();
        if (Config.alwaysHalloween &&
                entity.getType().is(ModEntityTypeTags.HALLOWEEN_MOBS) &&
                ((Monster) entity).getItemBySlot(EquipmentSlot.HEAD).isEmpty() &&
                !(localdate.getMonth() == Month.OCTOBER && localdate.getDayOfMonth() == 31) &&
                random.nextFloat() <= 0.25F) {

            entity.setItemSlot(EquipmentSlot.HEAD, new ItemStack(random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
            ((Monster) entity).setDropChance(EquipmentSlot.HEAD, 0.0F);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void replacePumpkins(EntityJoinLevelEvent event) {
        Random random = new Random();
        Entity entity = event.getEntity();
        if (entity.getType().is(ModEntityTypeTags.HALLOWEEN_MOBS) &&
                random.nextFloat() <= Config.replaceChance) {
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

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void giveJackOSlicer(EntityJoinLevelEvent event) {
        Random random = new Random();
        Entity entity = event.getEntity();
        if (entity.getType().is(ModEntityTypeTags.JACK_O_SLICER_MOBS) &&
                entity instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().isEmpty() &&
                random.nextFloat() <= (event.getLevel().getDifficulty() == Difficulty.HARD ? Config.jackOSlicerMobChanceHard : Config.jackOSlicerMobChance)) {
            ItemStack jackOSlicer = new ItemStack(ModItems.JACK_O_SLICER.get());
            jackOSlicer.setDamageValue(random.nextInt(jackOSlicer.getMaxDamage()));
            entity.setItemSlot(EquipmentSlot.MAINHAND, jackOSlicer);
            ((Zombie) entity).setDropChance(EquipmentSlot.MAINHAND, Config.jackOSlicerDropChance);

            if (((Zombie) entity).getItemBySlot(EquipmentSlot.HEAD).isEmpty() && random.nextFloat() <= 0.25F) {
                Map.Entry<Item, Float> dropChance = PumpkinDrop.PUMPKIN_DROP_CHANCES.entrySet().stream().toList().get(random.nextInt(PumpkinDrop.PUMPKIN_DROP_CHANCES.size()));
                entity.setItemSlot(EquipmentSlot.HEAD, new ItemStack(dropChance.getKey()));
                ((Zombie) entity).setDropChance(EquipmentSlot.HEAD, dropChance.getValue());
            }
        }
    }
}