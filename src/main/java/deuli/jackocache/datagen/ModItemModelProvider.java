package deuli.jackocache.datagen;

import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JackOCache.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.JACK_O_SLICER);

        blockItem(ModBlocks.SINISTER_PUMPKIN);
        blockItem(ModBlocks.SINISTER_JACK_O_LANTERN);

        blockItem(ModBlocks.GENERIC_PUMPKIN);
        blockItem(ModBlocks.GENERIC_JACK_O_LANTERN);

        blockItem(ModBlocks.CREEPER_PUMPKIN);
        blockItem(ModBlocks.CREEP_O_LANTERN);

        blockItem(ModBlocks.ENDERMAN_PUMPKIN);
        blockItem(ModBlocks.END_O_LANTERN);

        blockItem(ModBlocks.SKELETON_PUMPKIN);
        blockItem(ModBlocks.BONE_O_LANTERN);

        blockItem(ModBlocks.SYNTH_PUMPKIN);
        blockItem(ModBlocks.SYNTH_O_LANTERN);

        blockItem(ModBlocks.VILLAGER_PUMPKIN);
        blockItem(ModBlocks.HMM_O_LANTERN);

        blockItem(ModBlocks.UWU_PUMPKIN);
        blockItem(ModBlocks.UWU_O_LANTERN);

        blockItem(ModBlocks.PIG_PUMPKIN);
        blockItem(ModBlocks.OINK_O_LANTERN);

        blockItem(ModBlocks.SPIDER_PUMPKIN);
        blockItem(ModBlocks.WEB_O_LANTERN);

        blockItem(ModBlocks.GHAST_PUMPKIN);
        blockItem(ModBlocks.SCREAM_O_LANTERN);

        blockItem(ModBlocks.SLIME_PUMPKIN);
        blockItem(ModBlocks.GOO_O_LANTERN);

        blockItem(ModBlocks.NICE_PUMPKIN);
        blockItem(ModBlocks.NICE_O_LANTERN);

        blockItem(ModBlocks.EMOTE_PUMPKIN);
        blockItem(ModBlocks.EMOTE_O_LANTERN);

        blockItem(ModBlocks.DOG_PUMPKIN);
        blockItem(ModBlocks.BARK_O_LANTERN);

        blockItem(ModBlocks.CAT_PUMPKIN);
        blockItem(ModBlocks.MEOW_O_LANTERN);

        blockItem(ModBlocks.CHICKEN_PUMPKIN);
        blockItem(ModBlocks.CLUCK_O_LANTERN);

        blockItem(ModBlocks.DRAGON_PUMPKIN);
        blockItem(ModBlocks.THE_END_O_LANTERN);

        blockItem(ModBlocks.WITHER_PUMPKIN);
        blockItem(ModBlocks.WITHERING_O_LANTERN);

        blockItem(ModBlocks.PUMPKING);
        blockItem(ModBlocks.ROYAL_O_LANTERN);

        blockItem(ModBlocks.PLAYER_PUMPKIN);
        blockItem(ModBlocks.UUH_O_LANTERN);

        blockItem(ModBlocks.SHEEP_PUMPKIN);
        blockItem(ModBlocks.BAH_O_LANTERN);

        blockItem(ModBlocks.GHOST_PUMPKIN);
        blockItem(ModBlocks.SPOOK_O_LANTERN);

        blockItem(ModBlocks.SNOW_PUMPKIN);
        blockItem(ModBlocks.FROST_O_LANTERN);

        blockItem(ModBlocks.ROTTEN_PUMPKIN);
        blockItem(ModBlocks.ROT_O_LANTERN);

        blockItem(ModBlocks.MELON_PUMPKIN);
        blockItem(ModBlocks.MEL_O_LANTERN);
    }

    /**
     * Generates an handheld item model.
     *
     * @param item
     * @return ItemModelBuilder
     */
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(JackOCache.MOD_ID, "item/" + item.getId().getPath()));
    }

    /**
     * Generates a block item model.
     *
     * @param block
     */
    private void blockItem(RegistryObject<Block> block) {
        this.withExistingParent(JackOCache.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}