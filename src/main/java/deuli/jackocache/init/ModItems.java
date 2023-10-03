package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import deuli.jackocache.items.JackOSlicer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JackOCache.MOD_ID);

    public static final RegistryObject<Item> JACK_O_SLICER = ITEMS.register("jack_o_slicer", () -> new JackOSlicer());

    public static final RegistryObject<Item> SINISTER_PUMPKIN = ITEMS.register("sinister_pumpkin",
            () -> new BlockItem(ModBlocks.SINISTER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SINISTER_JACK_O_LANTERN = ITEMS.register("sinister_jack_o_lantern",
            () -> new BlockItem(ModBlocks.SINISTER_JACK_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> GENERIC_PUMPKIN = ITEMS.register("generic_pumpkin",
            () -> new BlockItem(ModBlocks.GENERIC_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> GENERIC_JACK_O_LANTERN = ITEMS.register("generic_jack_o_lantern",
            () -> new BlockItem(ModBlocks.GENERIC_JACK_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> CREEPER_PUMPKIN = ITEMS.register("creeper_pumpkin",
            () -> new BlockItem(ModBlocks.CREEPER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> CREEP_O_LANTERN = ITEMS.register("creep_o_lantern",
            () -> new BlockItem(ModBlocks.CREEP_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> ENDERMAN_PUMPKIN = ITEMS.register("enderman_pumpkin",
            () -> new BlockItem(ModBlocks.ENDERMAN_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> END_O_LANTERN = ITEMS.register("end_o_lantern",
            () -> new BlockItem(ModBlocks.END_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> SKELETON_PUMPKIN = ITEMS.register("skeleton_pumpkin",
            () -> new BlockItem(ModBlocks.SKELETON_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BONE_O_LANTERN = ITEMS.register("bone_o_lantern",
            () -> new BlockItem(ModBlocks.BONE_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> ROTTEN_PUMPKIN = ITEMS.register("rotten_pumpkin",
            () -> new BlockItem(ModBlocks.ROTTEN_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> ROT_O_LANTERN = ITEMS.register("rot_o_lantern",
            () -> new BlockItem(ModBlocks.ROT_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> VILLAGER_PUMPKIN = ITEMS.register("villager_pumpkin",
            () -> new BlockItem(ModBlocks.VILLAGER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> HMM_O_LANTERN = ITEMS.register("hmm_o_lantern",
            () -> new BlockItem(ModBlocks.HMM_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> UWU_PUMPKIN = ITEMS.register("uwu_pumpkin",
            () -> new BlockItem(ModBlocks.UWU_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> UWU_O_LANTERN = ITEMS.register("uwu_o_lantern",
            () -> new BlockItem(ModBlocks.UWU_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> PIG_PUMPKIN = ITEMS.register("pig_pumpkin",
            () -> new BlockItem(ModBlocks.PIG_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> OINK_O_LANTERN = ITEMS.register("oink_o_lantern",
            () -> new BlockItem(ModBlocks.OINK_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> SPIDER_PUMPKIN = ITEMS.register("spider_pumpkin",
            () -> new BlockItem(ModBlocks.SPIDER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> WEB_O_LANTERN = ITEMS.register("web_o_lantern",
            () -> new BlockItem(ModBlocks.WEB_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> GHAST_PUMPKIN = ITEMS.register("ghast_pumpkin",
            () -> new BlockItem(ModBlocks.GHAST_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCREAM_O_LANTERN = ITEMS.register("scream_o_lantern",
            () -> new BlockItem(ModBlocks.SCREAM_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> SLIME_PUMPKIN = ITEMS.register("slime_pumpkin",
            () -> new BlockItem(ModBlocks.SLIME_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> GOO_O_LANTERN = ITEMS.register("goo_o_lantern",
            () -> new BlockItem(ModBlocks.GOO_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> NICE_PUMPKIN = ITEMS.register("nice_pumpkin",
            () -> new BlockItem(ModBlocks.NICE_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> NICE_O_LANTERN = ITEMS.register("nice_o_lantern",
            () -> new BlockItem(ModBlocks.NICE_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> EMOTE_PUMPKIN = ITEMS.register("emote_pumpkin",
            () -> new BlockItem(ModBlocks.EMOTE_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> EMOTE_O_LANTERN = ITEMS.register("emote_o_lantern",
            () -> new BlockItem(ModBlocks.EMOTE_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> DOG_PUMPKIN = ITEMS.register("dog_pumpkin",
            () -> new BlockItem(ModBlocks.DOG_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BARK_O_LANTERN = ITEMS.register("bark_o_lantern",
            () -> new BlockItem(ModBlocks.BARK_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> CAT_PUMPKIN = ITEMS.register("cat_pumpkin",
            () -> new BlockItem(ModBlocks.CAT_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> MEOW_O_LANTERN = ITEMS.register("meow_o_lantern",
            () -> new BlockItem(ModBlocks.MEOW_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> CHICKEN_PUMPKIN = ITEMS.register("chicken_pumpkin",
            () -> new BlockItem(ModBlocks.CHICKEN_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> CLUCK_O_LANTERN = ITEMS.register("cluck_o_lantern",
            () -> new BlockItem(ModBlocks.CLUCK_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> DRAGON_PUMPKIN = ITEMS.register("dragon_pumpkin",
            () -> new BlockItem(ModBlocks.DRAGON_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> THE_END_O_LANTERN = ITEMS.register("the_end_o_lantern",
            () -> new BlockItem(ModBlocks.THE_END_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> WITHER_PUMPKIN = ITEMS.register("wither_pumpkin",
            () -> new BlockItem(ModBlocks.WITHER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> WITHERING_O_LANTERN = ITEMS.register("withering_o_lantern",
            () -> new BlockItem(ModBlocks.WITHERING_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> PUMPKING = ITEMS.register("pumpking",
            () -> new BlockItem(ModBlocks.PUMPKING.get(), new Item.Properties()));
    public static final RegistryObject<Item> ROYAL_O_LANTERN = ITEMS.register("royal_o_lantern",
            () -> new BlockItem(ModBlocks.ROYAL_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> PLAYER_PUMPKIN = ITEMS.register("player_pumpkin",
            () -> new BlockItem(ModBlocks.PLAYER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> UUH_O_LANTERN = ITEMS.register("uuh_o_lantern",
            () -> new BlockItem(ModBlocks.UUH_O_LANTERN.get(), new Item.Properties()));

    public static final RegistryObject<Item> SHEEP_PUMPKIN = ITEMS.register("sheep_pumpkin",
            () -> new BlockItem(ModBlocks.SHEEP_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAH_O_LANTERN = ITEMS.register("bah_o_lantern",
            () -> new BlockItem(ModBlocks.BAH_O_LANTERN.get(), new Item.Properties()));
}