package deuli.jackocache.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import deuli.jackocache.JackOCache;
import deuli.jackocache.items.jackoslicer.PumpkinDrop;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * Global loot modifier that adds a pumpkin to a slain player if they were killed by a Jack o'Slicer
 */
@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddPlayerPumpkinLootModifier extends LootModifier {
    public static final Supplier<Codec<AddPlayerPumpkinLootModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(inst.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf("pumpkin").forGetter(m -> m.pumpkin),
            Codec.STRING.fieldOf("playerName").forGetter(m -> m.playerName))
    ).apply(inst, AddPlayerPumpkinLootModifier::new)));

    private final Item pumpkin;
    private final String playerName;

    /**
     * Used to update {@code PLAYER_PUMPKIN_DROPS} inside of {@code PumpkinDrop}.
     *
     * @see AddPlayerPumpkinLootModifier#syncPlayerDrops()
     * @see PumpkinDrop#PLAYER_PUMPKIN_DROPS
     */
    private static final HashMap<String, Item> PLAYER_PUMPKIN_DROPS = new HashMap<>();

    public AddPlayerPumpkinLootModifier(LootItemCondition[] conditionsIn, Item pumpkin, String playerName) {
        super(conditionsIn);
        this.pumpkin = pumpkin;
        this.playerName = playerName;

        PLAYER_PUMPKIN_DROPS.put(playerName, pumpkin);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return PumpkinDrop.doApply(generatedLoot, context, pumpkin, playerName);
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    /**
     * Make sure that the drops are synced whenever the {@code reload} command is used.
     */
    @SubscribeEvent
    public static void onReload(OnDatapackSyncEvent event) {
        if (event.getPlayer() == null)
            syncPlayerDrops();
    }

    /**
     * Make sure that the drops are synced whenever the server is started.
     */
    @SubscribeEvent
    public static void onServerStart(ServerStartingEvent event) {
        syncPlayerDrops();
    }

    /**
     * Adds all the registered pumpkins to {@code PLAYER_PUMPKIN_DROPS} inside of {@code PumpkinDrop}.
     *
     * @see AddPlayerPumpkinLootModifier#AddPlayerPumpkinLootModifier(LootItemCondition[], Item, String)
     * @see AddPlayerPumpkinLootModifier#PLAYER_PUMPKIN_DROPS
     * @see PumpkinDrop#PLAYER_PUMPKIN_DROPS
     */
    private static void syncPlayerDrops() {
        PumpkinDrop.PLAYER_PUMPKIN_DROPS.clear();
        PumpkinDrop.PLAYER_PUMPKIN_DROPS.putAll(PLAYER_PUMPKIN_DROPS);
        PLAYER_PUMPKIN_DROPS.clear();
    }
}
