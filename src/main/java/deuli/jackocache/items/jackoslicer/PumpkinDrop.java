package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

/**
 * Class used to determine what pumpkins are dropped by mobs and the chance.
 */
public class PumpkinDrop {
    /**
     * HashMap containing the possible pumpkin drops. <br>
     * The key is a string which references the mob's encode ID. <br>
     * The value is a {@code PumpkinDrop} instance with the block and its chance.
     */
    public static final HashMap<String, PumpkinDrop> PUMPKIN_DROPS = new HashMap<>() {{
        put("minecraft:creeper", new PumpkinDrop(ModBlocks.CREEPER_PUMPKIN.get()));
        put("minecraft:enderman", new PumpkinDrop(ModBlocks.ENDERMAN_PUMPKIN.get()));
        put("minecraft:skeleton", new PumpkinDrop(ModBlocks.SKELETON_PUMPKIN.get()));
        put("minecraft:zombie", new PumpkinDrop(ModBlocks.ROTTEN_PUMPKIN.get()));
        put("minecraft:villager", new PumpkinDrop(ModBlocks.VILLAGER_PUMPKIN.get(), 0.95F));
        put("minecraft:pig", new PumpkinDrop(ModBlocks.PIG_PUMPKIN.get(), 0.35F));
        put("minecraft:spider", new PumpkinDrop(ModBlocks.SPIDER_PUMPKIN.get()));
        put("minecraft:ghast", new PumpkinDrop(ModBlocks.GHAST_PUMPKIN.get(), 0.80F));
        put("minecraft:slime", new PumpkinDrop(ModBlocks.SLIME_PUMPKIN.get(), 0.40F));
        put("minecraft:wolf", new PumpkinDrop(ModBlocks.DOG_PUMPKIN.get(), 0.65F));
        put("minecraft:cat", new PumpkinDrop(ModBlocks.CAT_PUMPKIN.get(), 0.75F));
        put("minecraft:chicken", new PumpkinDrop(ModBlocks.CHICKEN_PUMPKIN.get(), 0.35F));
        put("minecraft:ender_dragon", new PumpkinDrop(ModBlocks.DRAGON_PUMPKIN.get(), 1.00F));
        put("minecraft:wither", new PumpkinDrop(ModBlocks.WITHER_PUMPKIN.get(), 1.00F));
        put("minecraft:sheep", new PumpkinDrop(ModBlocks.SHEEP_PUMPKIN.get(), 0.35F));
        put("minecraft:snow_golem", new PumpkinDrop(ModBlocks.SNOW_GOLEM_PUMPKIN.get()));
        put("minecraft:evoker", new PumpkinDrop(ModBlocks.ILLAGER_PUMPKIN.get()));
        put("minecraft:pillager", new PumpkinDrop(ModBlocks.ILLAGER_PUMPKIN.get()));
        put("minecraft:vindicator", new PumpkinDrop(ModBlocks.ILLAGER_PUMPKIN.get()));
    }};

    public static final HashMap<String, PumpkinDrop> PLAYER_PUMPKIN_DROPS = new HashMap<>() {{
        put("deuli", new PumpkinDrop(ModBlocks.SYNTH_PUMPKIN.get(), 0.70F));
    }};

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