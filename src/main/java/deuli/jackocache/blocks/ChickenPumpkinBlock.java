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

public class ChickenPumpkinBlock extends CarvedPumpkinBlock {
    private static final VoxelShape CHICKEN = Block.box(4.0D, 0.0D, 5.0D, 12.0D, 12.0D, 11.0D);
    private static final VoxelShape BEAK = Block.box(4.0D, 4.0D, 1.0D, 12.0D, 8.0D, 5.0D);
    private static final VoxelShape WATTLE = Block.box(6.0D, 0.0D, 3.0D, 10.0D, 4.0D, 5.0D);
    private static final VoxelShape CHICKEN_PUMPKIN = Shapes.or(CHICKEN, BEAK, WATTLE);

    public ChickenPumpkinBlock() {
        super(Properties.copy(Blocks.JACK_O_LANTERN));
    }

    public ChickenPumpkinBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelShapeUtils.rotateHorizontal(CHICKEN_PUMPKIN, pState.getValue(HorizontalDirectionalBlock.FACING));
    }
}
