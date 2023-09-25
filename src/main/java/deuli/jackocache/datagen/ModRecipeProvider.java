package deuli.jackocache.datagen;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        jackOLantern(ModBlocks.SINISTER_PUMPKIN.get(), ModBlocks.LIT_SINISTER_PUMPKIN.get(), pWriter);
        jackOLantern(ModBlocks.GENERIC_PUMPKIN.get(), ModBlocks.LIT_GENERIC_PUMPKIN.get(), pWriter);
    }

    private void jackOLantern(Block pumpkin, Block jackOLantern, Consumer<FinishedRecipe> pWriter)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, jackOLantern)
                .pattern("A")
                .pattern("B")
                .define('A', pumpkin)
                .define('B', Items.TORCH)
                .unlockedBy(getHasName(pumpkin), has(pumpkin))
                .save(pWriter);
    }
}