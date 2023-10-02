package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public abstract class TransformConditions {
    private TransformConditions nextCondition;

    public static TransformConditions link(TransformConditions first, TransformConditions... chain) {
        TransformConditions head = first;
        for (TransformConditions next : chain) {
            head.nextCondition = next;
            head = next;
        }

        return first;
    }

    public abstract boolean check(Level level, BlockPos blockPos);

    protected boolean checkNext(Level level, BlockPos blockPos) {
        if (nextCondition == null)
            return true;

        return nextCondition.check(level, blockPos);
    }

}
