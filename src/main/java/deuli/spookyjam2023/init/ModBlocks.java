package deuli.spookyjam2023.init;

import deuli.spookyjam2023.SpookyJam2023;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SpookyJam2023.MOD_ID);

    public static final RegistryObject<Block> SINISTER_PUMPKIN = BLOCKS.register("sinister_pumpkin",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN)));
    public static final RegistryObject<Block> LIT_SINISTER_PUMPKIN = BLOCKS.register("lit_sinister_pumpkin",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> GENERIC_PUMPKIN = BLOCKS.register("generic_pumpkin",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN)));
    public static final RegistryObject<Block> LIT_GENERIC_PUMPKIN = BLOCKS.register("lit_generic_pumpkin",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));
}
