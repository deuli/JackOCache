package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.Config;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.items.jackoslicer.transformconditions.*;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;

/**
 * Class used to determine if the conditions for a pumpkin transformation is correct.
 * Uses the <a href="https://refactoring.guru/design-patterns/chain-of-responsibility">Chain of Responsibility</a>
 * design pattern.
 */
public class PumpkinTransformation {
    /**
     * An ArrayList containing every possible transformation. <br>
     * When transforming, it cycles through every single entry until one chain return true completely.
     */
    public static final ArrayList<PumpkinTransformation> PUMPKIN_TRANSFORMATIONS = new ArrayList<>() {{
        add(new PumpkinTransformation(ModBlocks.UWU_PUMPKIN.get(), TransformConditions.link(
                new DimensionCondition(Level.NETHER),
                new HeightCondition(-64, 35)
        )));
        add(new PumpkinTransformation(ModBlocks.NICE_PUMPKIN.get(), TransformConditions.link(
                new TagCondition(-1, BlockTags.LOGS)
        )));
        add(new PumpkinTransformation(ModBlocks.EMOTE_PUMPKIN.get(), TransformConditions.link(
                new SignCondition("", ":^)")
        )));
        add(new PumpkinTransformation(ModBlocks.PUMPKING.get(), TransformConditions.link(
                new BlockCondition(1, Blocks.GOLD_BLOCK, true)
        )));
        add(new PumpkinTransformation(ModBlocks.GHOST_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(-1, Blocks.SOUL_SAND, true)
        )));
        add(new PumpkinTransformation(ModBlocks.SNOW_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(1, Blocks.SNOW, true),
                new BlockCondition(-1, Blocks.SNOW_BLOCK, true)
        )));
        add(new PumpkinTransformation(ModBlocks.MELON_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(1, Blocks.MELON, true)
        )));
        add(new PumpkinTransformation(ModBlocks.MELON_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(-1, Blocks.MELON, true)
        )));
        add(new PumpkinTransformation(ModBlocks.ALPHA_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(3, Blocks.NETHERRACK, true),
                new BlockCondition(2, Blocks.SOUL_SAND, true),
                new BlockCondition(1, Blocks.GLOWSTONE, true),
                new BlockCondition(-1, Blocks.JACK_O_LANTERN, true)
        )));
        add(new PumpkinTransformation(ModBlocks.SPOOKYJAM_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(-1, Blocks.WHITE_STAINED_GLASS, true)
        )));
        add(new PumpkinTransformation(ModBlocks.COOL_PUMPKIN.get(), TransformConditions.link(
                new BiomeCondition(Biomes.BEACH)
        )));
        add(new PumpkinTransformation(ModBlocks.ANGRY_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(1, Blocks.FIRE, true)
        )));
        add(new PumpkinTransformation(ModBlocks.PUKING_PUMPKIN.get(), TransformConditions.link(
                new BlockCondition(1, 0, 0, Blocks.PUMPKIN_STEM, true),
                new BlockCondition(0, 0, 1, Blocks.PUMPKIN_STEM, true),
                new BlockCondition(-1, 0, 0, Blocks.PUMPKIN_STEM, true),
                new BlockCondition(0, 0, -1, Blocks.PUMPKIN_STEM, true)
        )));
        add(new PumpkinTransformation(ModBlocks.NERD_PUMPKIN.get(), TransformConditions.link(
                new SignCondition("", "Actually")
        )));
        add(new PumpkinTransformation(ModBlocks.NERD_PUMPKIN.get(), TransformConditions.link(
                new SignCondition("", "Ackchyually")
        )));
    }};

    /**
     * The pumpkin it transforms into.
     */
    private final Block result;

    /**
     * The first condition evaluated.
     */
    private final TransformConditions first;

    public PumpkinTransformation(Block result, TransformConditions first) {
        this.result = result;
        this.first = first;
    }

    /**
     * Starts evaluating the chain.
     *
     * @param level    the world
     * @param blockPos the block position of the pumpkin
     * @return {@code true} if every condition is met, otherwise {@code false}
     */
    public boolean check(Level level, BlockPos blockPos) {
        return Config.transformations.getOrDefault(result, true) && first.check(level, blockPos);
    }

    public Block getResult() {
        return result;
    }
}
