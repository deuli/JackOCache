package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JackOCache.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        pumpkin(ModBlocks.SINISTER_PUMPKIN);
        pumpkin(ModBlocks.SINISTER_JACK_O_LANTERN);

        pumpkin(ModBlocks.GENERIC_PUMPKIN);
        pumpkin(ModBlocks.GENERIC_JACK_O_LANTERN);

        pumpkin(ModBlocks.CREEPER_PUMPKIN);
        pumpkin(ModBlocks.CREEP_O_LANTERN);

        entirePumpkin(ModBlocks.ENDERMAN_PUMPKIN);
        jackOLantern(ModBlocks.END_O_LANTERN, ModBlocks.ENDERMAN_PUMPKIN);

        pumpkin(ModBlocks.SKELETON_PUMPKIN);
        pumpkin(ModBlocks.BONE_O_LANTERN);

        entirePumpkin(ModBlocks.ROTTEN_PUMPKIN);
        jackOLantern(ModBlocks.ROT_O_LANTERN, ModBlocks.ROTTEN_PUMPKIN);

        horizontalBlockWithModel(ModBlocks.VILLAGER_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.HMM_O_LANTERN);

        pumpkin(ModBlocks.UWU_PUMPKIN);
        pumpkin(ModBlocks.UWU_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.PIG_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.OINK_O_LANTERN);

        pumpkin(ModBlocks.SPIDER_PUMPKIN);
        pumpkin(ModBlocks.WEB_O_LANTERN);

        pumpkin(ModBlocks.GHAST_PUMPKIN);
        pumpkin(ModBlocks.SCREAM_O_LANTERN);

        pumpkin(ModBlocks.SLIME_PUMPKIN);
        pumpkin(ModBlocks.GOO_O_LANTERN);

        pumpkin(ModBlocks.NICE_PUMPKIN);
        pumpkin(ModBlocks.NICE_O_LANTERN);

        pumpkin(ModBlocks.EMOTE_PUMPKIN);
        pumpkin(ModBlocks.EMOTE_O_LANTERN);

        pumpkin(ModBlocks.DOG_PUMPKIN);
        pumpkin(ModBlocks.BARK_O_LANTERN);

        pumpkin(ModBlocks.CAT_PUMPKIN);
        pumpkin(ModBlocks.MEOW_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.CHICKEN_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.CLUCK_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.DRAGON_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.THE_END_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.WITHER_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.WITHERING_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.PUMPKING);
        horizontalBlockWithModel(ModBlocks.ROYAL_O_LANTERN);

        pumpkin(ModBlocks.PLAYER_PUMPKIN);
        pumpkin(ModBlocks.UUH_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.SHEEP_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.BAH_O_LANTERN);

        entirePumpkin(ModBlocks.GHOST_PUMPKIN).renderType("translucent");
        jackOLantern(ModBlocks.SPOOK_O_LANTERN, ModBlocks.GHOST_PUMPKIN).renderType("translucent");

        entirePumpkin(ModBlocks.SNOW_PUMPKIN);
        jackOLantern(ModBlocks.FROST_O_LANTERN, ModBlocks.SNOW_PUMPKIN);

        entirePumpkin(ModBlocks.SYNTH_PUMPKIN);
        jackOLantern(ModBlocks.SYNTH_O_LANTERN, ModBlocks.SYNTH_PUMPKIN);

        horizontalBlock(ModBlocks.MELON_PUMPKIN,
                new ResourceLocation("block/melon_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/melon_pumpkin"),
                new ResourceLocation("block/melon_top"));
        horizontalBlock(ModBlocks.MEL_O_LANTERN,
                new ResourceLocation("block/melon_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/mel_o_lantern"),
                new ResourceLocation("block/melon_top"));

        entirePumpkin(ModBlocks.ALPHA_PUMPKIN);
        jackOLantern(ModBlocks.ALPHA_JACK_O_LANTERN, ModBlocks.ALPHA_PUMPKIN);

        pumpkin(ModBlocks.SPOOKYJAM_PUMPKIN);
        pumpkin(ModBlocks.SPOOKYJAM_JACK_O_LANTERN);

        pumpkin(ModBlocks.COOL_PUMPKIN);
        pumpkin(ModBlocks.COOL_JACK_O_LANTERN);

        entirePumpkin(ModBlocks.ANGRY_PUMPKIN);
        jackOLantern(ModBlocks.ANGRY_JACK_O_LANTERN, ModBlocks.ANGRY_PUMPKIN);

        pumpkin(ModBlocks.SNOW_GOLEM_PUMPKIN);
        pumpkin(ModBlocks.SNOWBALL_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.ILLAGER_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.HRNGH_O_LANTERN);

        entirePumpkin(ModBlocks.GUARDIAN_PUMPKIN);
        jackOLantern(ModBlocks.LASER_O_LANTERN, ModBlocks.GUARDIAN_PUMPKIN);

        pumpkin(ModBlocks.PUKING_PUMPKIN);
        pumpkin(ModBlocks.PUKING_JACK_O_LANTERN);

        pumpkin(ModBlocks.BAT_PUMPKIN);
        pumpkin(ModBlocks.SQUEAK_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.ROTTEN_VILLAGER_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.ROTTEN_HMM_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.WITCH_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.HEEHEEHEE_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.NERD_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.NERD_JACK_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.NERD_CREEPER_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.NERD_CREEP_O_LANTERN);

        horizontalBlockWithModel(ModBlocks.WARDEN_PUMPKIN);
        horizontalBlockWithModel(ModBlocks.SCULK_O_LANTERN);
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a pumpkin block using vanilla
     * pumpkin's side and top textures. The texture name is "$PUMPKINRESOURCEID$.png".
     *
     * @param pumpkin
     * @return the new orientable model
     * @see #entirePumpkin(RegistryObject)
     * @see #jackOLantern(RegistryObject, RegistryObject)
     */
    private BlockModelBuilder pumpkin(RegistryObject<Block> pumpkin) {
        String pumpkinID = pumpkin.getId().getPath();
        return horizontalBlock(pumpkin,
                mcLoc("block/pumpkin_side"),
                modLoc("block/" + pumpkinID),
                mcLoc("block/pumpkin_top"));
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a pumpkin block.
     * The texture names are "$PUMPKINRESOURCEID$.png", "$PUMPKINRESOURCEID$_side.png" and "$PUMPKINRESOURCEID$_top.png".
     *
     * @param pumpkin
     * @return the new orientable model
     * @see #pumpkin(RegistryObject)
     * @see #jackOLantern(RegistryObject, RegistryObject)
     */
    private BlockModelBuilder entirePumpkin(RegistryObject<Block> pumpkin) {
        String pumpkinID = pumpkin.getId().getPath();
        return horizontalBlock(pumpkin,
                modLoc("block/" + pumpkinID + "_side"),
                modLoc("block/" + pumpkinID),
                modLoc("block/" + pumpkinID + "_top"));
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a jack o'lantern block using the
     * block's unlit counterpart's side and top textures.  The texture names are "$PJACKOLANTERNRESOURCEID$.png",
     * "$PUMPKINRESOURCEID$_side.png" and "$PUMPKINRESOURCEID$_top.png".
     *
     * @param jackolantern
     * @param pumpkin
     * @return the new orientable model
     * @see #pumpkin(RegistryObject)
     * @see #entirePumpkin(RegistryObject)
     */
    private BlockModelBuilder jackOLantern(RegistryObject<Block> jackolantern, RegistryObject<Block> pumpkin) {
        String jackolanternID = jackolantern.getId().getPath();
        String pumpkinID = pumpkin.getId().getPath();
        return horizontalBlock(jackolantern,
                modLoc("block/" + pumpkinID + "_side"),
                modLoc("block/" + jackolanternID),
                modLoc("block/" + pumpkinID + "_top"));
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a block using the specified
     * textures for the side, front and top of the block.
     *
     * @param block
     * @param side  the texture for the side of the block
     * @param front the texture for the front of the block
     * @param top   the texture for the top of the block
     * @return the new orientable model
     */
    private BlockModelBuilder horizontalBlock(RegistryObject<Block> block, ResourceLocation side, ResourceLocation front, ResourceLocation top) {
        BlockModelBuilder orientable = models().orientable(block.getId().getPath(), side, front, top);
        horizontalBlock(block.get(), orientable);

        return orientable;
    }

    /**
     * Generates north, east, south and west block states for a block that already has a model.
     *
     * @param block
     */
    private void horizontalBlockWithModel(RegistryObject<Block> block) {
        horizontalBlock(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }
}