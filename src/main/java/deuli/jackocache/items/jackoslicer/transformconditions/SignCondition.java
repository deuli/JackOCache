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
 * Checks if the pumpkin has a sign placed on it with matching contents.
 */
public class SignCondition extends TransformCondition {
    private String[] signContents = new String[4];

    public SignCondition(String[] signContents) {
        this.signContents = signContents;
    }

    public SignCondition(String first, String second, String third, String fourth) {
        this.signContents[0] = first;
        this.signContents[1] = second;
        this.signContents[2] = third;
        this.signContents[3] = fourth;
    }

    public SignCondition(String first, String second, String third) {
        this(first, second, third, "");
    }

    public SignCondition(String first, String second) {
        this(first, second, "", "");
    }

    public SignCondition(String first) {
        this(first, "", "", "");
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
            Component[] message = signBlockEntity.getText(true).getMessages(true);
            for (int i = 0; i < message.length; i++)
                if (!message[i].getString().equals(signContents[i]))
                    return false;
        } else
            return false;

        level.destroyBlock(blockPos, false);
        return true;
    }

}
