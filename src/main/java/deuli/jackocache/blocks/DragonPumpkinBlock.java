package deuli.jackocache.blocks;

import deuli.jackocache.utils.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DragonPumpkinBlock extends CarvedPumpkinBlock {
    private static final VoxelShape MAIN_HEAD = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SNOUT = Block.box(2.0D, 0.0D, -16.0D, 14.0D, 9.0D, 16.0D);
    private static final VoxelShape LEFT_NOSE = Block.box(11.0D, 9.0D, -14.0D, 13.0D, 11.0D, -10.0D);
    private static final VoxelShape RIGHT_NOSE = Block.box(3.0D, 9.0D, -14.0D, 5.0D, 11.0D, -10.0D);
    private static final VoxelShape LEFT_EAR = Block.box(11.0D, 16.0D, 6.0D, 13.0D, 20.0D, 12.0D);
    private static final VoxelShape RIGHT_EAR = Block.box(3.0D, 16.0D, 6.0D, 5.0D, 20.0D, 12.0D);
    private static final VoxelShape DRAGON_PUMPKIN = Shapes.or(MAIN_HEAD, SNOUT, LEFT_NOSE, RIGHT_NOSE, LEFT_EAR, RIGHT_EAR);

    public DragonPumpkinBlock() {
        super(Properties.copy(Blocks.JACK_O_LANTERN));
    }

    public DragonPumpkinBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelShapeUtils.rotateHorizontal(DRAGON_PUMPKIN, pState.getValue(HorizontalDirectionalBlock.FACING));
    }
}
