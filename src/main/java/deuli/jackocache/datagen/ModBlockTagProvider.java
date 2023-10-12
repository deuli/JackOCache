package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlockTags;
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
        ModBlocks.PUMPKINS.forEach(registryObject -> tag(BlockTags.MINEABLE_WITH_AXE).add(registryObject.get()));
        ModBlocks.PUMPKINS.forEach(registryObject -> tag(BlockTags.SWORD_EFFICIENT).add(registryObject.get()));
        ModBlocks.CARVED_PUMPKINS.forEach(registryObject -> tag(BlockTags.ENDERMAN_HOLDABLE).add(registryObject.get()));

        ModBlocks.CARVED_PUMPKINS.forEach(registryObject -> tag(ModBlockTags.CARVED_PUMPKINS).add(registryObject.get()));
        ModBlocks.JACK_O_LANTERN.forEach(registryObject -> tag(ModBlockTags.JACK_O_LANTERNS).add(registryObject.get()));
        tag(ModBlockTags.PUMPKINS).addTags(ModBlockTags.CARVED_PUMPKINS, ModBlockTags.JACK_O_LANTERNS);
    }
}