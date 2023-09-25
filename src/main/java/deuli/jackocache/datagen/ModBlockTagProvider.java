package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JackOCache.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SINISTER_PUMPKIN.get(),
                        ModBlocks.SINISTER_JACK_O_LANTERN.get(),
                        ModBlocks.GENERIC_PUMPKIN.get(),
                        ModBlocks.GENERIC_JACK_O_LANTERN.get());

        this.tag(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.SINISTER_PUMPKIN.get(),
                        ModBlocks.SINISTER_JACK_O_LANTERN.get(),
                        ModBlocks.GENERIC_PUMPKIN.get(),
                        ModBlocks.GENERIC_JACK_O_LANTERN.get());

        this.tag(BlockTags.ENDERMAN_HOLDABLE)
                .add(ModBlocks.SINISTER_PUMPKIN.get(),
                        ModBlocks.GENERIC_PUMPKIN.get());
    }
}
