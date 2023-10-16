package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTags {
    public static final TagKey<EntityType<?>> HALLOWEEN_MOBS = create("halloween_mobs");
    public static final TagKey<EntityType<?>> JACK_O_SLICER_MOBS = create("jack_o_slicer_mobs");

    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(JackOCache.MOD_ID, pName));
    }
}
