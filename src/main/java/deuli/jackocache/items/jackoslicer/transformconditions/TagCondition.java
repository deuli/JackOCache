package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Checks if the block has a certain tag.
 */
public class TagCondition extends TransformConditions {
    private final Vec3i offset;
    private final TagKey<Block> tag;
    public boolean destroyBlock;

    public TagCondition(Vec3i offset, TagKey<Block> tag, boolean destroyBlock) {
        this.offset = offset;
        this.tag = tag;
        this.destroyBlock = destroyBlock;
    }

    public TagCondition(int x, int y, int z, TagKey<Block> tag, boolean destroyBlock) {
        this(new Vec3i(x, y, z), tag, destroyBlock);
    }

    public TagCondition(Vec3i offset, TagKey<Block> tag) {
        this(offset, tag, true);
    }

    public TagCondition(int x, int y, int z, TagKey<Block> tag) {
        this(new Vec3i(x, y, z), tag, true);
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if (level.getBlockState(blockPos.offset(offset)).getTags().anyMatch(e -> e.equals(tag))) {
            boolean result = checkNext(level, blockPos);

            if (result && destroyBlock)
                level.destroyBlock(blockPos.offset(offset), false);

            return result;
        }

        return false;
    }
}
