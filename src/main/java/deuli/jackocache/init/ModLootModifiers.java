package deuli.jackocache.init;

import com.mojang.serialization.Codec;
import deuli.jackocache.JackOCache;
import deuli.jackocache.loot.AddPlayerPumpkinLootModifier;
import deuli.jackocache.loot.AddPumpkinLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, JackOCache.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_PUMPKIN = LOOT_MODIFIER_SERIALIZERS.register("add_pumpkin", AddPumpkinLootModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_PLAYER_PUMPKIN = LOOT_MODIFIER_SERIALIZERS.register("add_player_pumpkin", AddPlayerPumpkinLootModifier.CODEC);
}