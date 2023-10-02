package deuli.jackocache.items.jackoslicer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class PumpkinTransformation {
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
