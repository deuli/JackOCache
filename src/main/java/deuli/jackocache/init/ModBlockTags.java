package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> CARVED_PUMPKINS = create("carved_pumpkins");
    public static final TagKey<Block> JACK_O_LANTERNS = create("jack_o_lanterns");
    public static final TagKey<Block> PUMPKINS = create("pumpkins");

    private static TagKey<Block> create(String pName) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(JackOCache.MOD_ID, pName));
    }
}
