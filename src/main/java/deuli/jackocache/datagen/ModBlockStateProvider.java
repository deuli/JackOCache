package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    private ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JackOCache.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        registerPumpkinStatesAndModels(ModBlocks.SINISTER_PUMPKIN);
        registerPumpkinStatesAndModels(ModBlocks.SINISTER_JACK_O_LANTERN);
        registerPumpkinStatesAndModels(ModBlocks.GENERIC_PUMPKIN);
        registerPumpkinStatesAndModels(ModBlocks.GENERIC_JACK_O_LANTERN);
    }

    private void registerPumpkinStatesAndModels(RegistryObject<Block> pumpkin)
    {
        String pumpkinID = pumpkin.getId().getPath();
        BlockModelBuilder orientable = models().orientable(pumpkinID,
                new ResourceLocation("block/pumpkin_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/" + pumpkinID),
                new ResourceLocation("block/pumpkin_top"));
        horizontalBlock(pumpkin.get(), orientable);
    }
}