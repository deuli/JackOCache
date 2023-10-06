package deuli.jackocache.items.jackoslicer.transformconditions;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

/**
 * An abstract <a href="https://refactoring.guru/design-patterns/chain-of-responsibility">Chain of Responsibility</a>.
 *
 * @see BiomeCondition
 * @see BlockCondition
 * @see DimensionCondition
 * @see HeightCondition
 * @see SignCondition
 * @see TagCondition
 */
public abstract class TransformConditions {
    /**
     * The next condition to be evaluated.
     */
    private TransformConditions nextCondition;

    /**
     * Static method that links all the conditions together and returns the {@code first} condition.
     *
     * @param first the first condition
     * @param chain all other conditions
     * @return {@code first} - the first condition
     */
    public static TransformConditions link(TransformConditions first, TransformConditions... chain) {
        TransformConditions head = first;
        for (TransformConditions next : chain) {
            head.nextCondition = next;
            head = next;
        }

        return first;
    }

    /**
     * The method used to evaluate the condition.
     *
     * @param level the world
     * @param blockPos the block position of the pumpkin
     * @return {@code true} if the condition is met, otherwise {@code false}
     */
    public abstract boolean check(Level level, BlockPos blockPos);

    /**
     * Evaluate the next condition. If the chain reaches its end, which means {@code nextCondition} is null and every
     * condition has been fulfilled, return {@code true}. Otherwise, the next condition is checked.
     *
     * @param level the world
     * @param blockPos the block position of the pumpkin
     * @return
     */
    protected boolean checkNext(Level level, BlockPos blockPos) {
        if (nextCondition == null)
            return true;

        return nextCondition.check(level, blockPos);
    }

}
