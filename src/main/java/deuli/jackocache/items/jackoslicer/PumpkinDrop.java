package deuli.jackocache.items.jackoslicer;

import deuli.jackocache.init.ModBlocks;
import deuli.jackocache.init.ModItems;
import deuli.jackocache.items.JackOSlicer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class used to determine what pumpkins are dropped by mobs and the chance.
 */
public class PumpkinDrop {
    /**
     * All the mobs that have their own pumpkin. <br>
     * Used to determine which mobs drop the Sinister Pumpkin.
     *
     * @see JackOSlicer#livingEntityDeath(LivingDeathEvent)
     */
    public static final ArrayList<String> PUMPKIN_DROPS = new ArrayList<>();

    /**
     * All the players that have their own pumpkin. <br>
     * Used to determine which players drop the Player Pumpkin, as well as converting the pumpkin on another player's
     * head to the correct one.
     *
     * @see JackOSlicer#livingEntityDeath(LivingDeathEvent)
     * @see JackOSlicer#interactLivingEntity(ItemStack, Player, LivingEntity, InteractionHand)
     */
    public static final HashMap<String, Item> PLAYER_PUMPKIN_DROPS = new HashMap<>();

    /**
     * All pumpkins that can be dropped from the Halloween mobs and their drop chance.
     */
    public final static HashMap<Item, Float> PUMPKIN_DROP_CHANCES = new HashMap<>() {{
        put(ModBlocks.PLAYER_PUMPKIN.get().asItem(), 0.5F);
        put(ModBlocks.UUH_O_LANTERN.get().asItem(), 0.5F);
        put(ModBlocks.SYNTH_PUMPKIN.get().asItem(), 0.2F);
        put(ModBlocks.SYNTH_O_LANTERN.get().asItem(), 0.2F);
    }};

    /**
     * The dropped pumpkin.
     */
    private final Block pumpkin;

    /**
     * The chance for the pumpkin to drop.
     *
     * @default 0.5
     */
    private float chance = 0.5F;

    public PumpkinDrop(Block pumpkin, float chance) {
        this.pumpkin = pumpkin;
        this.chance = chance;
    }

    public PumpkinDrop(Block pumpkin) {
        this.pumpkin = pumpkin;
    }

    public Block getPumpkin() {
        return pumpkin;
    }

    public float getChance() {
        return chance;
    }

    /**
     * Add a pumpkin to a mob when they die through a Jack o'Slicer. Used in {@code AddPumpkinLootModifier} &
     * {@code AddPlayerPumpkinLootModifier}.
     *
     * @param generatedLoot the list of ItemStacks that will be dropped, generated by loot tables
     * @param context       the LootContext, identical to what is passed to loot tables
     * @param pumpkin       the pumpkin
     * @return modified loot drops
     * @see deuli.jackocache.loot.AddPumpkinLootModifier
     * @see deuli.jackocache.loot.AddPlayerPumpkinLootModifier
     */
    public static ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context, Item pumpkin) {
        return doApply(generatedLoot, context, pumpkin, null);
    }

    /**
     * Add a pumpkin to a mob when they die through a Jack o'Slicer. Used in {@code AddPumpkinLootModifier} &
     * {@code AddPlayerPumpkinLootModifier}.
     *
     * @param generatedLoot the list of ItemStacks that will be dropped, generated by loot tables
     * @param context       the LootContext, identical to what is passed to loot tables
     * @param pumpkin       the pumpkin
     * @param playerName    the slain player's name
     * @return modified loot drops
     * @see deuli.jackocache.loot.AddPumpkinLootModifier
     * @see deuli.jackocache.loot.AddPlayerPumpkinLootModifier
     */
    public static ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context, Item pumpkin, String playerName) {
        if (context.hasParam(LootContextParams.THIS_ENTITY) && context.hasParam(LootContextParams.KILLER_ENTITY)) {
            LivingEntity target = (LivingEntity) context.getParam(LootContextParams.THIS_ENTITY);
            LivingEntity killer = (LivingEntity) context.getParam(LootContextParams.KILLER_ENTITY);
            ItemStack tool = killer.getMainHandItem();
            if ((playerName == null || (target instanceof Player && target.getDisplayName().getString().equals(playerName))) &&
                    tool.getItem() == ModItems.JACK_O_SLICER.get() && killer.getMainHandItem().is(ModItems.JACK_O_SLICER.get())) {
                if (killer instanceof Player player && player.getInventory().contains(new ItemStack(Items.PUMPKIN))) {
                    generatedLoot.add(new ItemStack(pumpkin));

                    JackOSlicer.pumpkinDropEffects(player, target);
                }
            }
        }

        return generatedLoot;
    }
}