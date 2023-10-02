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

public class WitherPumpkinBlock extends CarvedPumpkinBlock {
    private static final VoxelShape MAIN_HEAD = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape RIGHT_HEAD = Block.box(-16.0D, 0.0D, 4.0D, -4.0D, 12.0D, 16.0D);
    private static final VoxelShape LEFT_HEAD = Block.box(20.0D, 0.0D, 4.0D, 32.0D, 12.0D, 16.0D);
    private static final VoxelShape RIGHT_SPINE = Block.box(-4.0D, 0.0D, 10.0D, 0.0D, 6.0D, 16.0D);
    private static final VoxelShape LEFT_SPINE = Block.box(20.0D, 0.0D, 10.0D, 20.0D, 6.0D, 16.0D);
    private static final VoxelShape WITHER_PUMPKIN = Shapes.or(MAIN_HEAD, RIGHT_HEAD, LEFT_HEAD, RIGHT_SPINE, LEFT_SPINE);

    public WitherPumpkinBlock() {
        super(Properties.copy(Blocks.JACK_O_LANTERN));
    }

    public WitherPumpkinBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelShapeUtils.rotateHorizontal(WITHER_PUMPKIN, pState.getValue(HorizontalDirectionalBlock.FACING));
    }
}
