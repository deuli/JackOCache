package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.items.jackoslicer.transformconditions.*;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class PumpkinTransformation {
    public static final ArrayList<PumpkinTransformation> PUMPKIN_TRANSFORMATIONS = new ArrayList<>() {{
        add(new PumpkinTransformation(ModBlocks.UWU_PUMPKIN.get(), TransformConditions.link(
                new DimensionCondition(Level.NETHER),
                new HeightCondition(-64, 35)
        )));
        add(new PumpkinTransformation(ModBlocks.NICE_PUMPKIN.get(), TransformConditions.link(
                new TagCondition(0, -1, 0, BlockTags.LOGS)
        )));
        add(new PumpkinTransformation(ModBlocks.EMOTE_PUMPKIN.get(), TransformConditions.link(
                new SignCondition("", ":^)")
        )));
    }};

    private final Block result;

    private final TransformConditions conditions;

    public PumpkinTransformation(Block result, TransformConditions conditions) {
        this.result = result;
        this.conditions = conditions;
    }

    public boolean check(Level level, BlockPos blockPos) {
        return conditions.check(level, blockPos);
    }

    public Block getResult() {
        return result;
    }
}
