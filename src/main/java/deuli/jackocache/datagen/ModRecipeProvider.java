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
        jackOLantern(ModBlocks.SINISTER_PUMPKIN.get(), ModBlocks.SINISTER_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.GENERIC_PUMPKIN.get(), ModBlocks.GENERIC_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.CREEPER_PUMPKIN.get(), ModBlocks.CREEP_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.ENDERMAN_PUMPKIN.get(), ModBlocks.END_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SKELETON_PUMPKIN.get(), ModBlocks.BONE_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.ROTTEN_PUMPKIN.get(), ModBlocks.ROT_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.VILLAGER_PUMPKIN.get(), ModBlocks.HMM_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.UWU_PUMPKIN.get(), ModBlocks.UWU_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.PIG_PUMPKIN.get(), ModBlocks.OINK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SPIDER_PUMPKIN.get(), ModBlocks.WEB_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.GHAST_PUMPKIN.get(), ModBlocks.SCREAM_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SLIME_PUMPKIN.get(), ModBlocks.GOO_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.NICE_PUMPKIN.get(), ModBlocks.NICE_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.EMOTE_PUMPKIN.get(), ModBlocks.EMOTE_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.DOG_PUMPKIN.get(), ModBlocks.BARK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.CAT_PUMPKIN.get(), ModBlocks.MEOW_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.WITHER_PUMPKIN.get(), ModBlocks.WITHERING_O_LANTERN.get(), pWriter);
    }

    private void jackOLantern(Block pumpkin, Block jackOLantern, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, jackOLantern)
                .pattern("A")
                .pattern("B")
                .define('A', pumpkin)
                .define('B', Items.TORCH)
                .unlockedBy(getHasName(pumpkin), has(pumpkin))
                .group("jackolanterns")
                .save(pWriter);
    }
}