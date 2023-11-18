package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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
}