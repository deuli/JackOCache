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

        this.dropSelf(ModBlocks.CREEPER_PUMPKIN.get());
        this.dropSelf(ModBlocks.CREEP_O_LANTERN.get());

        this.dropSelf(ModBlocks.ENDERMAN_PUMPKIN.get());
        this.dropSelf(ModBlocks.END_O_LANTERN.get());

        this.dropSelf(ModBlocks.SKELETON_PUMPKIN.get());
        this.dropSelf(ModBlocks.BONE_O_LANTERN.get());

        this.dropSelf(ModBlocks.ROTTEN_PUMPKIN.get());
        this.dropSelf(ModBlocks.ROT_O_LANTERN.get());

        this.dropSelf(ModBlocks.VILLAGER_PUMPKIN.get());
        this.dropSelf(ModBlocks.HMM_O_LANTERN.get());

        this.dropSelf(ModBlocks.UWU_PUMPKIN.get());
        this.dropSelf(ModBlocks.UWU_O_LANTERN.get());

        this.dropSelf(ModBlocks.PIG_PUMPKIN.get());
        this.dropSelf(ModBlocks.OINK_O_LANTERN.get());

        this.dropSelf(ModBlocks.SPIDER_PUMPKIN.get());
        this.dropSelf(ModBlocks.WEB_O_LANTERN.get());

        this.dropSelf(ModBlocks.GHAST_PUMPKIN.get());
        this.dropSelf(ModBlocks.SCREAM_O_LANTERN.get());

        this.dropSelf(ModBlocks.SLIME_PUMPKIN.get());
        this.dropSelf(ModBlocks.GOO_O_LANTERN.get());

        this.dropSelf(ModBlocks.NICE_PUMPKIN.get());
        this.dropSelf(ModBlocks.NICE_O_LANTERN.get());

        this.dropSelf(ModBlocks.EMOTE_PUMPKIN.get());
        this.dropSelf(ModBlocks.EMOTE_O_LANTERN.get());

        this.dropSelf(ModBlocks.DOG_PUMPKIN.get());
        this.dropSelf(ModBlocks.BARK_O_LANTERN.get());

        this.dropSelf(ModBlocks.CAT_PUMPKIN.get());
        this.dropSelf(ModBlocks.MEOW_O_LANTERN.get());

        this.dropSelf(ModBlocks.CHICKEN_PUMPKIN.get());
        this.dropSelf(ModBlocks.CLUCK_O_LANTERN.get());

        this.dropSelf(ModBlocks.DRAGON_PUMPKIN.get());
        this.dropSelf(ModBlocks.THE_END_O_LANTERN.get());

        this.dropSelf(ModBlocks.WITHER_PUMPKIN.get());
        this.dropSelf(ModBlocks.WITHERING_O_LANTERN.get());

        this.dropSelf(ModBlocks.PUMPKING.get());
        this.dropSelf(ModBlocks.ROYAL_O_LANTERN.get());

        this.dropSelf(ModBlocks.PLAYER_PUMPKIN.get());
        this.dropSelf(ModBlocks.UUH_O_LANTERN.get());

        this.dropSelf(ModBlocks.SHEEP_PUMPKIN.get());
        this.dropSelf(ModBlocks.BAH_O_LANTERN.get());

        this.dropSelf(ModBlocks.GHOST_PUMPKIN.get());
        this.dropSelf(ModBlocks.SPOOK_O_LANTERN.get());

        this.dropSelf(ModBlocks.SNOW_PUMPKIN.get());
        this.dropSelf(ModBlocks.FROST_O_LANTERN.get());

        this.dropSelf(ModBlocks.SYNTH_PUMPKIN.get());
        this.dropSelf(ModBlocks.SYNTH_O_LANTERN.get());

        this.dropSelf(ModBlocks.MELON_PUMPKIN.get());
        this.dropSelf(ModBlocks.MEL_O_LANTERN.get());

        this.dropSelf(ModBlocks.ALPHA_PUMPKIN.get());
        this.dropSelf(ModBlocks.ALPHA_JACK_O_LANTERN.get());

        this.dropSelf(ModBlocks.SPOOKYJAM_PUMPKIN.get());
        this.dropSelf(ModBlocks.SPOOKYJAM_JACK_O_LANTERN.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}