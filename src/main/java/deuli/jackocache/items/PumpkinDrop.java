package deuli.jackocache.items;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class PumpkinDrop {
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
        put("minecraft:chicken", new PumpkinDrop(ModBlocks.CHICKEN_PUMPKIN.get()));
        put("minecraft:ender_dragon", new PumpkinDrop(ModBlocks.DRAGON_PUMPKIN.get(), 1.00F));
        put("minecraft:wither", new PumpkinDrop(ModBlocks.WITHER_PUMPKIN.get(), 1.00F));
    }};

    private final Block pumpkin;

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