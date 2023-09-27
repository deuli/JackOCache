package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import deuli.jackocache.items.JackOSlicer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
}
