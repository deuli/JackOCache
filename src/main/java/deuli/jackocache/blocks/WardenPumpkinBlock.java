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
import net.minecraft.world.phys.shapes.VoxelShape;

public class WardenPumpkinBlock extends CarvedPumpkinBlock {
    private static final VoxelShape WARDEN_PUMPKIN = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 16.0D, 13.0D);

    public WardenPumpkinBlock() {
        super(Properties.copy(Blocks.JACK_O_LANTERN));
    }

    public WardenPumpkinBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelShapeUtils.rotateHorizontal(WARDEN_PUMPKIN, pState.getValue(HorizontalDirectionalBlock.FACING));
    }
}
