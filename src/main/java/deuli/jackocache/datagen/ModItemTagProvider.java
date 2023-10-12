package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItemTags;
import deuli.jackocache.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, JackOCache.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.SWORDS).add(ModItems.JACK_O_SLICER.get().asItem());

        ModBlocks.CARVED_PUMPKINS.forEach(registryObject -> tag(ModItemTags.CARVED_PUMPKINS).add(registryObject.get().asItem()));
        ModBlocks.JACK_O_LANTERN.forEach(registryObject -> tag(ModItemTags.JACK_O_LANTERNS).add(registryObject.get().asItem()));
        this.tag(ModItemTags.PUMPKINS).addTags(ModItemTags.CARVED_PUMPKINS, ModItemTags.JACK_O_LANTERNS);
    }
}