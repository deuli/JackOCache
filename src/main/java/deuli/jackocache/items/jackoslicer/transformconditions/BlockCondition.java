package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

/**
 * Checks if the block in a certain position offset from the pumpkin matches given block.
 */
public class BlockCondition extends TransformConditions {
    private final Vec3i offset;
    private final Block block;
    /**
     * If the block should be destroyed if the condition matches.
     */
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
        if (level.getBlockState(blockPos.offset(offset)).is(block)) {
            boolean result = checkNext(level, blockPos);

            if (result && destroyBlock)
                level.destroyBlock(blockPos.offset(offset), false); //Block isn't updated!

            return result;
        }

        return false;
    }
}
