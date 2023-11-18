package deuli.jackocache.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import deuli.jackocache.JackOCache;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.items.jackoslicer.PumpkinDrop;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
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
        if (context.hasParam(LootContextParams.KILLER_ENTITY)) {
            LivingEntity killer = (LivingEntity) context.getParam(LootContextParams.KILLER_ENTITY);
            ItemStack tool = killer.getMainHandItem();
            if (tool.getItem() == ModItems.JACK_O_SLICER.get() && killer.getMainHandItem().is(ModItems.JACK_O_SLICER.get())) {
                ItemStack pumpkin = new ItemStack(Items.PUMPKIN);
                LivingEntity target = (LivingEntity) context.getParam(LootContextParams.THIS_ENTITY);

                if (killer instanceof Player player && player.getInventory().contains(pumpkin)) {
                    generatedLoot.add(new ItemStack(this.pumpkin));

                    int pumpkinSlot = player.getInventory().findSlotMatchingItem(pumpkin);
                    player.getInventory().removeItem(pumpkinSlot, 1);

                    player.level().playSound(null, target.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.75F, 0);
                }
            }
        }

        return generatedLoot;
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
