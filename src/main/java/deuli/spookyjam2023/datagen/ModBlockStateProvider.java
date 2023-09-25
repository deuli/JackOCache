package deuli.spookyjam2023.datagen;

import deuli.spookyjam2023.SpookyJam2023;
import deuli.spookyjam2023.init.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    private ExistingFileHelper exFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SpookyJam2023.MOD_ID, exFileHelper);
        this.exFileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        BlockModelBuilder orientable = models().orientable(ModBlocks.SINISTER_PUMPKIN.getId().getPath(),
                new ResourceLocation("block/pumpkin_side"),
                new ResourceLocation(SpookyJam2023.MOD_ID, "block/sinister_pumpkin"),
                new ResourceLocation("block/pumpkin_top"));
        horizontalBlock(ModBlocks.SINISTER_PUMPKIN.get(), orientable);
    }
}