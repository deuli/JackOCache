package deuli.jackocache.items.jackoslicer;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class DimensionCondition extends TransformConditions {

    private ResourceKey<Level> dimension;

    public DimensionCondition(ResourceKey<Level> dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if(level.dimension() == dimension)
            return checkNext(level, blockPos);

        return false;
    }
}
