package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> CARVED_PUMPKINS = create("carved_pumpkins");
    public static final TagKey<Item> JACK_O_LANTERNS = create("jack_o_lanterns");
    public static final TagKey<Item> PUMPKINS = create("pumpkins");

    private static TagKey<Item> create(String pName) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(JackOCache.MOD_ID, pName));
    }
}
