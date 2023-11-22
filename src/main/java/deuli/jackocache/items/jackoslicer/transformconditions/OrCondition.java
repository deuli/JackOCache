package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

/**
 * Checks if one of the conditions is fulfilled
 */
public class OrCondition extends TransformCondition {
    private final TransformCondition[] transformConditions;

    public OrCondition(TransformCondition... transformConditions) {
        this.transformConditions = transformConditions;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        for (TransformCondition condition : transformConditions)
            if (condition.check(level, blockPos))
                return checkNext(level, blockPos);

        return false;
    }
}
