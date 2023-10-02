package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public class BiomeCondition extends TransformConditions {
    private final ResourceKey<Biome> biome;

    public BiomeCondition(ResourceKey<Biome> biome) {
        this.biome = biome;
    }

    @Override
    public boolean check(Level level, BlockPos blockPos) {
        if (level.getBiome(blockPos).unwrapKey().get() == biome)
            return checkNext(level, blockPos);

        return false;
    }
}
