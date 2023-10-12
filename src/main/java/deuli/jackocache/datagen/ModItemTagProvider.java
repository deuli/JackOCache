package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlockTags;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItemTags;
import deuli.jackocache.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
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

        this.tag(ModItemTags.CARVED_PUMPKINS)
                .add(ModBlocks.SINISTER_PUMPKIN.get().asItem(),
                        ModBlocks.GENERIC_PUMPKIN.get().asItem(),
                        ModBlocks.CREEPER_PUMPKIN.get().asItem(),
                        ModBlocks.ENDERMAN_PUMPKIN.get().asItem(),
                        ModBlocks.SKELETON_PUMPKIN.get().asItem(),
                        ModBlocks.ROTTEN_PUMPKIN.get().asItem(),
                        ModBlocks.VILLAGER_PUMPKIN.get().asItem(),
                        ModBlocks.UWU_PUMPKIN.get().asItem(),
                        ModBlocks.PIG_PUMPKIN.get().asItem(),
                        ModBlocks.SPIDER_PUMPKIN.get().asItem(),
                        ModBlocks.GHAST_PUMPKIN.get().asItem(),
                        ModBlocks.SLIME_PUMPKIN.get().asItem(),
                        ModBlocks.NICE_PUMPKIN.get().asItem(),
                        ModBlocks.EMOTE_PUMPKIN.get().asItem(),
                        ModBlocks.DOG_PUMPKIN.get().asItem(),
                        ModBlocks.CAT_PUMPKIN.get().asItem(),
                        ModBlocks.CHICKEN_PUMPKIN.get().asItem(),
                        ModBlocks.DRAGON_PUMPKIN.get().asItem(),
                        ModBlocks.WITHER_PUMPKIN.get().asItem(),
                        ModBlocks.PUMPKING.get().asItem(),
                        ModBlocks.PLAYER_PUMPKIN.get().asItem(),
                        ModBlocks.SHEEP_PUMPKIN.get().asItem(),
                        ModBlocks.GHOST_PUMPKIN.get().asItem(),
                        ModBlocks.SNOW_PUMPKIN.get().asItem(),
                        ModBlocks.SYNTH_PUMPKIN.get().asItem(),
                        ModBlocks.MELON_PUMPKIN.get().asItem(),
                        ModBlocks.ALPHA_PUMPKIN.get().asItem(),
                        ModBlocks.SPOOKYJAM_PUMPKIN.get().asItem()
                );

        this.tag(ModItemTags.JACK_O_LANTERNS)
                .add(ModBlocks.SINISTER_JACK_O_LANTERN.get().asItem(),
                        ModBlocks.GENERIC_JACK_O_LANTERN.get().asItem(),
                        ModBlocks.CREEP_O_LANTERN.get().asItem(),
                        ModBlocks.END_O_LANTERN.get().asItem(),
                        ModBlocks.BONE_O_LANTERN.get().asItem(),
                        ModBlocks.ROT_O_LANTERN.get().asItem(),
                        ModBlocks.HMM_O_LANTERN.get().asItem(),
                        ModBlocks.UWU_O_LANTERN.get().asItem(),
                        ModBlocks.OINK_O_LANTERN.get().asItem(),
                        ModBlocks.WEB_O_LANTERN.get().asItem(),
                        ModBlocks.SCREAM_O_LANTERN.get().asItem(),
                        ModBlocks.GOO_O_LANTERN.get().asItem(),
                        ModBlocks.NICE_O_LANTERN.get().asItem(),
                        ModBlocks.EMOTE_O_LANTERN.get().asItem(),
                        ModBlocks.BARK_O_LANTERN.get().asItem(),
                        ModBlocks.MEOW_O_LANTERN.get().asItem(),
                        ModBlocks.CLUCK_O_LANTERN.get().asItem(),
                        ModBlocks.THE_END_O_LANTERN.get().asItem(),
                        ModBlocks.WITHERING_O_LANTERN.get().asItem(),
                        ModBlocks.ROYAL_O_LANTERN.get().asItem(),
                        ModBlocks.UUH_O_LANTERN.get().asItem(),
                        ModBlocks.BAH_O_LANTERN.get().asItem(),
                        ModBlocks.SPOOK_O_LANTERN.get().asItem(),
                        ModBlocks.FROST_O_LANTERN.get().asItem(),
                        ModBlocks.SYNTH_O_LANTERN.get().asItem(),
                        ModBlocks.MEL_O_LANTERN.get().asItem(),
                        ModBlocks.ALPHA_JACK_O_LANTERN.get().asItem(),
                        ModBlocks.SPOOKYJAM_JACK_O_LANTERN.get().asItem()
                );

        this.tag(ModItemTags.PUMPKINS).addTags(ModItemTags.CARVED_PUMPKINS, ModItemTags.JACK_O_LANTERNS);
    }
}