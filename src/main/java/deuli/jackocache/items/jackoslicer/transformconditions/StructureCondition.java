package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * Checks if the pumpkin is inside a structure.
 */
public class StructureCondition extends TransformCondition {
    private final ResourceKey<Structure> structure;

    public StructureCondition(ResourceKey<Structure> structure) {
        this.structure = structure;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if (level instanceof ServerLevel serverLevel && serverLevel.structureManager().getStructureWithPieceAt(blockPos, structure).isValid())
            return checkNext(level, blockPos);

        return false;
    }
}
