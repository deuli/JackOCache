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

import java.util.ArrayList;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddPumpkinLootModifier extends LootModifier {
    public static final Supplier<Codec<AddPumpkinLootModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(inst.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf("pumpkin").forGetter(m -> m.pumpkin),
            Codec.STRING.fieldOf("entity").forGetter(m -> m.entityID))
    ).apply(inst, AddPumpkinLootModifier::new)));

    private final Item pumpkin;
    private final String entityID;
    public static final ArrayList<String> PUMPKIN_DROPS = new ArrayList<>();

    public AddPumpkinLootModifier(LootItemCondition[] conditionsIn, Item pumpkin, String entityID) {
        super(conditionsIn);
        this.pumpkin = pumpkin;
        this.entityID = entityID;

        PUMPKIN_DROPS.add(entityID);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return PumpkinDrop.doApply(generatedLoot, context, pumpkin);
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    @SubscribeEvent
    public static void onReload(OnDatapackSyncEvent event) {
        if (event.getPlayer() == null)
            syncDrops();
    }

    @SubscribeEvent
    public static void onServerStart(ServerStartingEvent event) {
        syncDrops();
    }

    private static void syncDrops() {
        PumpkinDrop.PUMPKIN_DROPS.clear();
        PumpkinDrop.PUMPKIN_DROPS.addAll(PUMPKIN_DROPS);
        PUMPKIN_DROPS.clear();
    }
}
