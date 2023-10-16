package deuli.jackocache.datagen;

import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.JACK_O_SLICER.get())
                .pattern(" P ")
                .pattern("GSG")
                .pattern(" L ")
                .define('P', Blocks.CARVED_PUMPKIN)
                .define('G', Items.GOLD_INGOT)
                .define('S', Items.IRON_SWORD)
                .define('L', Blocks.JACK_O_LANTERN)
                .unlockedBy(getHasName(Blocks.JACK_O_LANTERN), has(Blocks.JACK_O_LANTERN))
                .save(pWriter);

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
        jackOLantern(ModBlocks.CHICKEN_PUMPKIN.get(), ModBlocks.CLUCK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.DRAGON_PUMPKIN.get(), ModBlocks.THE_END_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.WITHER_PUMPKIN.get(), ModBlocks.WITHERING_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.PUMPKING.get(), ModBlocks.ROYAL_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.PLAYER_PUMPKIN.get(), ModBlocks.UUH_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SHEEP_PUMPKIN.get(), ModBlocks.BAH_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.GHOST_PUMPKIN.get(), ModBlocks.SPOOK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SNOW_PUMPKIN.get(), ModBlocks.FROST_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SYNTH_PUMPKIN.get(), ModBlocks.SYNTH_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.MELON_PUMPKIN.get(), ModBlocks.MEL_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.ALPHA_PUMPKIN.get(), ModBlocks.ALPHA_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SPOOKYJAM_PUMPKIN.get(), ModBlocks.SPOOKYJAM_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.COOL_PUMPKIN.get(), ModBlocks.COOL_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.ANGRY_PUMPKIN.get(), ModBlocks.ANGRY_JACK_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.SNOW_GOLEM_PUMPKIN.get(), ModBlocks.SNOWBALL_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.ILLAGER_PUMPKIN.get(), ModBlocks.HRNGH_O_LANTERN.get(), pWriter);
        jackOLantern(ModBlocks.GUARDIAN_PUMPKIN.get(), ModBlocks.LASER_O_LANTERN.get(), pWriter);
    }

    /**
     * Generates a crafting recipe based on the jack o'lantern crafting recipe.
     * <table>
     *     <tr>
     *         <td>A</td>
     *         <td>X</td>
     *     </tr>
     *     <tr>
     *         <td>B</td>
     *         <td>X</td>
     *     </tr>
     * </table>
     * A = {@code pumpkin} <br>
     * B = Torch <br>
     * X = Empty <br>
     * Result = {@code jackOLantern}
     *
     * @param pumpkin
     * @param jackOLantern
     * @param pWriter
     */
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