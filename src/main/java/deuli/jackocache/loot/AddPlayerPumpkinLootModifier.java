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

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddPlayerPumpkinLootModifier extends LootModifier {
    public static final Supplier<Codec<AddPlayerPumpkinLootModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(inst.group(
            ForgeRegistries.ITEMS.getCodec().fieldOf("pumpkin").forGetter(m -> m.pumpkin),
            Codec.STRING.fieldOf("playerName").forGetter(m -> m.playerName))
    ).apply(inst, AddPlayerPumpkinLootModifier::new)));

    private final Item pumpkin;
    private final String playerName;
    public static final HashMap<String, Item> PLAYER_PUMPKIN_DROPS = new HashMap<>();

    public AddPlayerPumpkinLootModifier(LootItemCondition[] conditionsIn, Item pumpkin, String playerName) {
        super(conditionsIn);
        this.pumpkin = pumpkin;
        this.playerName = playerName;

        PLAYER_PUMPKIN_DROPS.put(playerName, pumpkin);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.hasParam(LootContextParams.THIS_ENTITY) && context.hasParam(LootContextParams.KILLER_ENTITY)) {
            LivingEntity target = (LivingEntity) context.getParam(LootContextParams.THIS_ENTITY);
            LivingEntity killer = (LivingEntity) context.getParam(LootContextParams.KILLER_ENTITY);
            ItemStack tool = killer.getMainHandItem();
            if (target instanceof Player && target.getDisplayName().getString().equals(playerName) &&
                    tool.getItem() == ModItems.JACK_O_SLICER.get() && killer.getMainHandItem().is(ModItems.JACK_O_SLICER.get())) {
                ItemStack pumpkin = new ItemStack(Items.PUMPKIN);

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
            syncPlayerDrops();
    }

    @SubscribeEvent
    public static void onServerStart(ServerStartingEvent event) {
        syncPlayerDrops();
    }

    private static void syncPlayerDrops() {
        PumpkinDrop.PLAYER_PUMPKIN_DROPS.clear();
        PumpkinDrop.PLAYER_PUMPKIN_DROPS.putAll(PLAYER_PUMPKIN_DROPS);
        PLAYER_PUMPKIN_DROPS.clear();
    }
}
