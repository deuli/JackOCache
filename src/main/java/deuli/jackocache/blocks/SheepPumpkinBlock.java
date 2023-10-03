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

public class SheepPumpkinBlock extends CarvedPumpkinBlock {
    private static final VoxelShape HEAD = Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 1.0D);
    private static final VoxelShape WOOL = Block.box(0.0D, 0.0D, 1.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SHEEP_PUMPKIN = Shapes.or(HEAD, WOOL);

    public SheepPumpkinBlock() {
        super(Properties.copy(Blocks.JACK_O_LANTERN));
    }

    public SheepPumpkinBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return VoxelShapeUtils.rotateHorizontal(SHEEP_PUMPKIN, pState.getValue(HorizontalDirectionalBlock.FACING));
    }
}
