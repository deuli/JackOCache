package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, JackOCache.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModEntityTypeTags.HALLOWEEN_MOBS).add(
                EntityType.ZOMBIE,
                EntityType.ZOMBIFIED_PIGLIN,
                EntityType.ZOMBIE_VILLAGER,
                EntityType.HUSK,
                EntityType.DROWNED
        ).addTag(EntityTypeTags.SKELETONS);

        tag(ModEntityTypeTags.JACK_O_SLICER_MOBS).add(
                EntityType.ZOMBIE,
                EntityType.ZOMBIFIED_PIGLIN,
                EntityType.ZOMBIE_VILLAGER,
                EntityType.HUSK);
    }
}
