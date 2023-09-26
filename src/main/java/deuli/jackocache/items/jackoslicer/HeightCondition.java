package deuli.jackocache.items.jackoslicer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class HeightCondition extends TransformConditions {

    private int minHeight;
    private int maxHeight;

    public HeightCondition(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if(blockPos.getY() >= minHeight && blockPos.getY() <= maxHeight)
            return checkNext(level, blockPos);

        return false;
    }
}
