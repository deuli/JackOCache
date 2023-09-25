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
    public static final RegistryObject<Item> LIT_SINISTER_PUMPKIN = ITEMS.register("lit_sinister_pumpkin",
            () -> new BlockItem(ModBlocks.LIT_SINISTER_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> GENERIC_PUMPKIN = ITEMS.register("generic_pumpkin",
            () -> new BlockItem(ModBlocks.GENERIC_PUMPKIN.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIT_GENERIC_PUMPKIN = ITEMS.register("lit_generic_pumpkin",
            () -> new BlockItem(ModBlocks.LIT_GENERIC_PUMPKIN.get(), new Item.Properties()));
}
