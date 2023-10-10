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
        registerPumpkin(ModBlocks.SINISTER_PUMPKIN);
        registerPumpkin(ModBlocks.SINISTER_JACK_O_LANTERN);

        registerPumpkin(ModBlocks.GENERIC_PUMPKIN);
        registerPumpkin(ModBlocks.GENERIC_JACK_O_LANTERN);

        registerPumpkin(ModBlocks.CREEPER_PUMPKIN);
        registerPumpkin(ModBlocks.CREEP_O_LANTERN);

        registerEntirePumpkin(ModBlocks.ENDERMAN_PUMPKIN);
        registerJackOLantern(ModBlocks.END_O_LANTERN, ModBlocks.ENDERMAN_PUMPKIN);

        registerPumpkin(ModBlocks.SKELETON_PUMPKIN);
        registerPumpkin(ModBlocks.BONE_O_LANTERN);

        registerEntirePumpkin(ModBlocks.ROTTEN_PUMPKIN);
        registerJackOLantern(ModBlocks.ROT_O_LANTERN, ModBlocks.ROTTEN_PUMPKIN);

        registerHorizontalBlockWithModel(ModBlocks.VILLAGER_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.HMM_O_LANTERN);

        registerPumpkin(ModBlocks.UWU_PUMPKIN);
        registerPumpkin(ModBlocks.UWU_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.PIG_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.OINK_O_LANTERN);

        registerPumpkin(ModBlocks.SPIDER_PUMPKIN);
        registerPumpkin(ModBlocks.WEB_O_LANTERN);

        registerPumpkin(ModBlocks.GHAST_PUMPKIN);
        registerPumpkin(ModBlocks.SCREAM_O_LANTERN);

        registerPumpkin(ModBlocks.SLIME_PUMPKIN);
        registerPumpkin(ModBlocks.GOO_O_LANTERN);

        registerPumpkin(ModBlocks.NICE_PUMPKIN);
        registerPumpkin(ModBlocks.NICE_O_LANTERN);

        registerPumpkin(ModBlocks.EMOTE_PUMPKIN);
        registerPumpkin(ModBlocks.EMOTE_O_LANTERN);

        registerPumpkin(ModBlocks.DOG_PUMPKIN);
        registerPumpkin(ModBlocks.BARK_O_LANTERN);

        registerPumpkin(ModBlocks.CAT_PUMPKIN);
        registerPumpkin(ModBlocks.MEOW_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.CHICKEN_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.CLUCK_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.DRAGON_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.THE_END_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.WITHER_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.WITHERING_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.PUMPKING);
        registerHorizontalBlockWithModel(ModBlocks.ROYAL_O_LANTERN);

        registerPumpkin(ModBlocks.PLAYER_PUMPKIN);
        registerPumpkin(ModBlocks.UUH_O_LANTERN);

        registerHorizontalBlockWithModel(ModBlocks.SHEEP_PUMPKIN);
        registerHorizontalBlockWithModel(ModBlocks.BAH_O_LANTERN);

        registerEntirePumpkin(ModBlocks.GHOST_PUMPKIN).renderType("translucent");
        registerJackOLantern(ModBlocks.SPOOK_O_LANTERN, ModBlocks.GHOST_PUMPKIN).renderType("translucent");

        registerEntirePumpkin(ModBlocks.SNOW_PUMPKIN);
        registerJackOLantern(ModBlocks.FROST_O_LANTERN, ModBlocks.SNOW_PUMPKIN);

        registerEntirePumpkin(ModBlocks.SYNTH_PUMPKIN);
        registerJackOLantern(ModBlocks.SYNTH_O_LANTERN, ModBlocks.SYNTH_PUMPKIN);

        registerHorizontalBlock(ModBlocks.MELON_PUMPKIN,
                new ResourceLocation("block/melon_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/melon_pumpkin"),
                new ResourceLocation("block/melon_top"));
        registerHorizontalBlock(ModBlocks.MEL_O_LANTERN,
                new ResourceLocation("block/melon_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/mel_o_lantern"),
                new ResourceLocation("block/melon_top"));

        registerHorizontalBlock(ModBlocks.ALPHA_PUMPKIN,
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_pumpkin_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_pumpkin"),
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_pumpkin_top"));
        registerHorizontalBlock(ModBlocks.ALPHA_JACK_O_LANTERN,
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_pumpkin_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_jack_o_lantern"),
                new ResourceLocation(JackOCache.MOD_ID, "block/alpha_pumpkin_top"));
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a pumpkin block using vanilla
     * pumpkin's side and top textures. The texture name is "$PUMPKINRESOURCEID$.png".
     *
     * @param pumpkin
     * @return the new orientable model
     * @see #registerEntirePumpkin(RegistryObject)
     * @see #registerJackOLantern(RegistryObject, RegistryObject)
     */
    private BlockModelBuilder registerPumpkin(RegistryObject<Block> pumpkin) {
        String pumpkinID = pumpkin.getId().getPath();
        return registerHorizontalBlock(pumpkin,
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
     * @see #registerPumpkin(RegistryObject)
     * @see #registerJackOLantern(RegistryObject, RegistryObject)
     */
    private BlockModelBuilder registerEntirePumpkin(RegistryObject<Block> pumpkin) {
        String pumpkinID = pumpkin.getId().getPath();
        return registerHorizontalBlock(pumpkin,
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
     * @see #registerPumpkin(RegistryObject)
     * @see #registerEntirePumpkin(RegistryObject)
     */
    private BlockModelBuilder registerJackOLantern(RegistryObject<Block> jackolantern, RegistryObject<Block> pumpkin) {
        String jackolanternID = jackolantern.getId().getPath();
        String pumpkinID = pumpkin.getId().getPath();
        return registerHorizontalBlock(jackolantern,
                modLoc("block/" + pumpkinID + "_side"),
                modLoc("block/" + jackolanternID),
                modLoc("block/" + pumpkinID + "_top"));
    }

    /**
     * Generates an orientable model and north, east, south and west block states for a block using the specified
     * textures for the side, front and top of the block.
     *
     * @param block
     * @param side the texture for the side of the block
     * @param front the texture for the front of the block
     * @param top the texture for the top of the block
     * @return the new orientable model
     */
    private BlockModelBuilder registerHorizontalBlock(RegistryObject<Block> block, ResourceLocation side, ResourceLocation front, ResourceLocation top) {
        BlockModelBuilder orientable = models().orientable(block.getId().getPath(), side, front, top);
        horizontalBlock(block.get(), orientable);

        return orientable;
    }

    /**
     * Generates north, east, south and west block states for a block that already has a model.
     *
     * @param block
     */
    private void registerHorizontalBlockWithModel(RegistryObject<Block> block) {
        horizontalBlock(block.get(), models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }
}