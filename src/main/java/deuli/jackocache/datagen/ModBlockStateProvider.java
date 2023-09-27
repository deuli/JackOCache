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

    private ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JackOCache.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
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
    }

    private void registerPumpkin(RegistryObject<Block> pumpkin)
    {
        String pumpkinID = pumpkin.getId().getPath();
        registerHorizontalBlock(pumpkin,
                mcLoc("block/pumpkin_side"),
                modLoc("block/" + pumpkinID),
                mcLoc("block/pumpkin_top"));
    }

    private void registerEntirePumpkin(RegistryObject<Block> pumpkin)
    {
        String pumpkinID = pumpkin.getId().getPath();
        registerHorizontalBlock(pumpkin,
                modLoc("block/" + pumpkinID + "_side"),
                modLoc("block/" + pumpkinID),
                modLoc("block/" + pumpkinID + "_top"));
    }

    private void registerJackOLantern(RegistryObject<Block> jackolantern, RegistryObject<Block> pumpkin)
    {
        String jackolanternID = jackolantern.getId().getPath();
        String pumpkinID = pumpkin.getId().getPath();
        registerHorizontalBlock(jackolantern,
                modLoc("block/" + pumpkinID + "_side"),
                modLoc("block/" + jackolanternID),
                modLoc("block/" + pumpkinID + "_top"));
    }

    private void registerHorizontalBlock(RegistryObject<Block> block, ResourceLocation side, ResourceLocation front, ResourceLocation top)
    {
        BlockModelBuilder orientable = models().orientable(block.getId().getPath(), side, front, top);
        horizontalBlock(block.get(), orientable);
    }
}