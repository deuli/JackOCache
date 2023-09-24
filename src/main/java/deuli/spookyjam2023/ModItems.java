package deuli.spookyjam2023;

import deuli.spookyjam2023.items.JackOSlicer;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SpookyJam2023.MOD_ID);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> JACK_O_SLICER = ITEMS.register("jack_o_slicer", () -> new JackOSlicer());

}
