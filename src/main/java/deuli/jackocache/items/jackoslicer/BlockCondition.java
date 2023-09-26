package deuli.jackocache.items.jackoslicer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BlockCondition extends TransformConditions {

    private Vec3i offset;
    private Block block;
    public boolean destroyBlock;

    public BlockCondition(Vec3i offset, Block block, boolean destroyBlock) {
        this.offset = offset;
        this.block = block;
        this.destroyBlock = destroyBlock;
    }

    public BlockCondition(int x, int y, int z, Block block, boolean destroyBlock) {
        this(new Vec3i(x, y, z), block, destroyBlock);
    }

    public BlockCondition(Vec3i offset, Block block) {
        this(offset, block, true);
    }

    public BlockCondition(int x, int y, int z, Block block) {
        this(new Vec3i(x, y, z), block, true);
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if(level.getBlockState(blockPos.offset(offset)).is(block))
        {
            boolean result = checkNext(level, blockPos);

            if(result && destroyBlock)
                level.destroyBlock(blockPos.offset(offset), false);

            return result;
        }

        return false;
    }
}
