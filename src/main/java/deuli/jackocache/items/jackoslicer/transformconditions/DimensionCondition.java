package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

/**
 * Checks if the block is in a certain dimension.
 */
public class DimensionCondition extends TransformCondition {
    private final ResourceKey<Level> dimension;

    public DimensionCondition(ResourceKey<Level> dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if (level.dimension() == dimension)
            return checkNext(level, blockPos);

        return false;
    }
}
