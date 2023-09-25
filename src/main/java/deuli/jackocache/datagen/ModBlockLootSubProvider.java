package deuli.jackocache.datagen;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {

    protected ModBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SINISTER_PUMPKIN.get());
        this.dropSelf(ModBlocks.SINISTER_JACK_O_LANTERN.get());
        this.dropSelf(ModBlocks.GENERIC_PUMPKIN.get());
        this.dropSelf(ModBlocks.GENERIC_JACK_O_LANTERN.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
