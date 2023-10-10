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
                        ModBlocks.GENERIC_JACK_O_LANTERN.get(),

                        ModBlocks.CREEPER_PUMPKIN.get(),
                        ModBlocks.CREEP_O_LANTERN.get(),

                        ModBlocks.ENDERMAN_PUMPKIN.get(),
                        ModBlocks.END_O_LANTERN.get(),

                        ModBlocks.SKELETON_PUMPKIN.get(),
                        ModBlocks.BONE_O_LANTERN.get(),

                        ModBlocks.ROTTEN_PUMPKIN.get(),
                        ModBlocks.ROT_O_LANTERN.get(),

                        ModBlocks.SYNTH_PUMPKIN.get(),
                        ModBlocks.SYNTH_O_LANTERN.get(),

                        ModBlocks.VILLAGER_PUMPKIN.get(),
                        ModBlocks.HMM_O_LANTERN.get(),

                        ModBlocks.UWU_PUMPKIN.get(),
                        ModBlocks.UWU_O_LANTERN.get(),

                        ModBlocks.PIG_PUMPKIN.get(),
                        ModBlocks.OINK_O_LANTERN.get(),

                        ModBlocks.SPIDER_PUMPKIN.get(),
                        ModBlocks.WEB_O_LANTERN.get(),

                        ModBlocks.GHAST_PUMPKIN.get(),
                        ModBlocks.SCREAM_O_LANTERN.get(),

                        ModBlocks.SLIME_PUMPKIN.get(),
                        ModBlocks.GOO_O_LANTERN.get(),

                        ModBlocks.NICE_PUMPKIN.get(),
                        ModBlocks.NICE_O_LANTERN.get(),

                        ModBlocks.EMOTE_PUMPKIN.get(),
                        ModBlocks.EMOTE_O_LANTERN.get(),

                        ModBlocks.DOG_PUMPKIN.get(),
                        ModBlocks.BARK_O_LANTERN.get(),

                        ModBlocks.CAT_PUMPKIN.get(),
                        ModBlocks.MEOW_O_LANTERN.get(),

                        ModBlocks.CHICKEN_PUMPKIN.get(),
                        ModBlocks.CLUCK_O_LANTERN.get(),

                        ModBlocks.DRAGON_PUMPKIN.get(),
                        ModBlocks.THE_END_O_LANTERN.get(),

                        ModBlocks.WITHER_PUMPKIN.get(),
                        ModBlocks.WITHERING_O_LANTERN.get(),

                        ModBlocks.PUMPKING.get(),
                        ModBlocks.ROYAL_O_LANTERN.get(),

                        ModBlocks.PLAYER_PUMPKIN.get(),
                        ModBlocks.UUH_O_LANTERN.get(),

                        ModBlocks.SHEEP_PUMPKIN.get(),
                        ModBlocks.BAH_O_LANTERN.get(),

                        ModBlocks.GHOST_PUMPKIN.get(),
                        ModBlocks.SPOOK_O_LANTERN.get(),

                        ModBlocks.SNOW_PUMPKIN.get(),
                        ModBlocks.FROST_O_LANTERN.get(),

                        ModBlocks.MELON_PUMPKIN.get(),
                        ModBlocks.MEL_O_LANTERN.get()
                );

        this.tag(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.SINISTER_PUMPKIN.get(),
                        ModBlocks.SINISTER_JACK_O_LANTERN.get(),

                        ModBlocks.GENERIC_PUMPKIN.get(),
                        ModBlocks.GENERIC_JACK_O_LANTERN.get(),

                        ModBlocks.CREEPER_PUMPKIN.get(),
                        ModBlocks.CREEP_O_LANTERN.get(),

                        ModBlocks.ENDERMAN_PUMPKIN.get(),
                        ModBlocks.END_O_LANTERN.get(),

                        ModBlocks.SKELETON_PUMPKIN.get(),
                        ModBlocks.BONE_O_LANTERN.get(),

                        ModBlocks.ROTTEN_PUMPKIN.get(),
                        ModBlocks.ROT_O_LANTERN.get(),

                        ModBlocks.SYNTH_PUMPKIN.get(),
                        ModBlocks.SYNTH_O_LANTERN.get(),

                        ModBlocks.VILLAGER_PUMPKIN.get(),
                        ModBlocks.HMM_O_LANTERN.get(),

                        ModBlocks.UWU_PUMPKIN.get(),
                        ModBlocks.UWU_O_LANTERN.get(),

                        ModBlocks.PIG_PUMPKIN.get(),
                        ModBlocks.OINK_O_LANTERN.get(),

                        ModBlocks.SPIDER_PUMPKIN.get(),
                        ModBlocks.WEB_O_LANTERN.get(),

                        ModBlocks.GHAST_PUMPKIN.get(),
                        ModBlocks.SCREAM_O_LANTERN.get(),

                        ModBlocks.SLIME_PUMPKIN.get(),
                        ModBlocks.GOO_O_LANTERN.get(),

                        ModBlocks.NICE_PUMPKIN.get(),
                        ModBlocks.NICE_O_LANTERN.get(),

                        ModBlocks.EMOTE_PUMPKIN.get(),
                        ModBlocks.EMOTE_O_LANTERN.get(),

                        ModBlocks.DOG_PUMPKIN.get(),
                        ModBlocks.BARK_O_LANTERN.get(),

                        ModBlocks.CAT_PUMPKIN.get(),
                        ModBlocks.MEOW_O_LANTERN.get(),

                        ModBlocks.CHICKEN_PUMPKIN.get(),
                        ModBlocks.CLUCK_O_LANTERN.get(),

                        ModBlocks.DRAGON_PUMPKIN.get(),
                        ModBlocks.THE_END_O_LANTERN.get(),

                        ModBlocks.WITHER_PUMPKIN.get(),
                        ModBlocks.WITHERING_O_LANTERN.get(),

                        ModBlocks.PUMPKING.get(),
                        ModBlocks.ROYAL_O_LANTERN.get(),

                        ModBlocks.PLAYER_PUMPKIN.get(),
                        ModBlocks.UUH_O_LANTERN.get(),

                        ModBlocks.SHEEP_PUMPKIN.get(),
                        ModBlocks.BAH_O_LANTERN.get(),

                        ModBlocks.GHOST_PUMPKIN.get(),
                        ModBlocks.SPOOK_O_LANTERN.get(),

                        ModBlocks.SNOW_PUMPKIN.get(),
                        ModBlocks.FROST_O_LANTERN.get(),

                        ModBlocks.MELON_PUMPKIN.get(),
                        ModBlocks.MEL_O_LANTERN.get()
                );

        this.tag(BlockTags.ENDERMAN_HOLDABLE)
                .add(ModBlocks.SINISTER_PUMPKIN.get(),
                        ModBlocks.GENERIC_PUMPKIN.get(),
                        ModBlocks.CREEPER_PUMPKIN.get(),
                        ModBlocks.ENDERMAN_PUMPKIN.get(),
                        ModBlocks.SKELETON_PUMPKIN.get(),
                        ModBlocks.ROTTEN_PUMPKIN.get(),
                        ModBlocks.SYNTH_PUMPKIN.get(),
                        ModBlocks.VILLAGER_PUMPKIN.get(),
                        ModBlocks.UWU_PUMPKIN.get(),
                        ModBlocks.PIG_PUMPKIN.get(),
                        ModBlocks.SPIDER_PUMPKIN.get(),
                        ModBlocks.GHAST_PUMPKIN.get(),
                        ModBlocks.SLIME_PUMPKIN.get(),
                        ModBlocks.NICE_PUMPKIN.get(),
                        ModBlocks.EMOTE_PUMPKIN.get(),
                        ModBlocks.CHICKEN_PUMPKIN.get(),
                        ModBlocks.DRAGON_PUMPKIN.get(),
                        ModBlocks.WITHER_PUMPKIN.get(),
                        ModBlocks.PUMPKING.get(),
                        ModBlocks.PLAYER_PUMPKIN.get(),
                        ModBlocks.SHEEP_PUMPKIN.get(),
                        ModBlocks.GHOST_PUMPKIN.get(),
                        ModBlocks.SNOW_PUMPKIN.get(),
                        ModBlocks.MELON_PUMPKIN.get()
                );
    }
}