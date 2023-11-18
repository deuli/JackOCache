package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.items.JackOSlicer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class used to determine what pumpkins are dropped by mobs and the chance.
 */
public class PumpkinDrop {
    public static final ArrayList<String> PUMPKIN_DROPS = new ArrayList<>();

    public static final HashMap<String, Item> PLAYER_PUMPKIN_DROPS = new HashMap<>();

    public final static HashMap<Item, Float> PUMPKIN_DROP_CHANCES = new HashMap<>() {{
        put(ModBlocks.PLAYER_PUMPKIN.get().asItem(), 0.5F);
        put(ModBlocks.UUH_O_LANTERN.get().asItem(), 0.5F);
        put(ModBlocks.SYNTH_PUMPKIN.get().asItem(), 0.2F);
        put(ModBlocks.SYNTH_O_LANTERN.get().asItem(), 0.2F);
    }};

    /**
     * The dropped pumpkin.
     */
    private final Block pumpkin;

    /**
     * The chance for the pumpkin to drop.
     *
     * @default 0.5
     */
    private float chance = 0.5F;

    public PumpkinDrop(Block pumpkin, float chance) {
        this.pumpkin = pumpkin;
        this.chance = chance;
    }

    public PumpkinDrop(Block pumpkin) {
        this.pumpkin = pumpkin;
    }

    public Block getPumpkin() {
        return pumpkin;
    }

    public float getChance() {
        return chance;
    }

    public static ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context, Item pumpkin) {
        return doApply(generatedLoot, context, pumpkin, null);
    }

    public static ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context, Item pumpkin, String playerName) {
        if (context.hasParam(LootContextParams.THIS_ENTITY) && context.hasParam(LootContextParams.KILLER_ENTITY)) {
            LivingEntity target = (LivingEntity) context.getParam(LootContextParams.THIS_ENTITY);
            LivingEntity killer = (LivingEntity) context.getParam(LootContextParams.KILLER_ENTITY);
            ItemStack tool = killer.getMainHandItem();
            if ((playerName == null || (target instanceof Player && target.getDisplayName().getString().equals(playerName))) &&
                    tool.getItem() == ModItems.JACK_O_SLICER.get() && killer.getMainHandItem().is(ModItems.JACK_O_SLICER.get())) {
                if (killer instanceof Player player && player.getInventory().contains(new ItemStack(Items.PUMPKIN))) {
                    generatedLoot.add(new ItemStack(pumpkin));

                    JackOSlicer.pumpkinDropEffects(player, target);
                }
            }
        }

        return generatedLoot;
    }
}