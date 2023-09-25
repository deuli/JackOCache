package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    private ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JackOCache.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        BlockModelBuilder orientable = models().orientable(ModBlocks.SINISTER_PUMPKIN.getId().getPath(),
                new ResourceLocation("block/pumpkin_side"),
                new ResourceLocation(JackOCache.MOD_ID, "block/sinister_pumpkin"),
                new ResourceLocation("block/pumpkin_top"));
        horizontalBlock(ModBlocks.SINISTER_PUMPKIN.get(), orientable);
    }
}