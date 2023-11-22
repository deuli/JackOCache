package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Checks if the pumpkin has a sign placed on it with a matching line anywhere on the sign.
 */
public class SignContainsOnlyCondition extends TransformCondition {
    private final String content;

    public SignContainsOnlyCondition(String content) {
        this.content = content;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        return checkSign(level, blockPos.north(), Direction.NORTH) ||
                checkSign(level, blockPos.east(), Direction.EAST) ||
                checkSign(level, blockPos.south(), Direction.SOUTH) ||
                checkSign(level, blockPos.west(), Direction.WEST);
    }

    private boolean checkSign(Level level, BlockPos blockPos, Direction direction) {
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.getBlock() instanceof WallSignBlock && level.getExistingBlockEntity(blockPos) instanceof SignBlockEntity signBlockEntity &&
                blockState.getValue(HorizontalDirectionalBlock.FACING) == direction) {
            Component[] messages = signBlockEntity.getText(true).getMessages(true);
            int empty = 0;
            boolean containsContent = false;
            for (Component component : messages) {
                String message = component.getString();
                if (message.equals(content))
                    containsContent = true;
                else if (message.isEmpty())
                    empty++;

                if (empty == 3 && containsContent) {
                    level.destroyBlock(blockPos, false);
                    return true;
                }
            }
        }

        return false;
    }

}
