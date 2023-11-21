package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

/**
 * Checks if the block is between a certain Y level.
 */
public class HeightCondition extends TransformCondition {
    private final int minHeight;
    private final int maxHeight;

    public HeightCondition(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if (blockPos.getY() >= minHeight && blockPos.getY() <= maxHeight)
            return checkNext(level, blockPos);

        return false;
    }
}
