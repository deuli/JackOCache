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

    public static final RegistryObject<Item> ENDERMAN_PUMPKIN = ITEMS.register("enderman_pumpkin",
            () -> new BlockItem(ModBlocks.ENDERMAN_PUMPKIN.get(), new Item.Properties()));

    public static final RegistryObject<Item> SKELETON_PUMPKIN = ITEMS.register("skeleton_pumpkin",
            () -> new BlockItem(ModBlocks.SKELETON_PUMPKIN.get(), new Item.Properties()));

    public static final RegistryObject<Item> ROTTEN_PUMPKIN = ITEMS.register("rotten_pumpkin",
            () -> new BlockItem(ModBlocks.ROTTEN_PUMPKIN.get(), new Item.Properties()));
}
