package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import deuli.jackocache.items.JackOSlicer;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JackOCache.MOD_ID);

    public static final RegistryObject<Item> JACK_O_SLICER = ITEMS.register("jack_o_slicer", () -> new JackOSlicer());
}