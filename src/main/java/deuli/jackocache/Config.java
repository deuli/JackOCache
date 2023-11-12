package deuli.jackocache;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue ALWAYS_HALLOWEEN;
    private static final ForgeConfigSpec.DoubleValue REPLACE_CHANCE;

    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_MOB_CHANCE_HARD;
    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_MOB_CHANCE;
    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_DROP_CHANCE;
    private static final ForgeConfigSpec.ConfigValue<String> JACK_O_SLICER_REPAIR_ITEM;

    static {
        BUILDER.push("Pumpkin Heads");

        ALWAYS_HALLOWEEN = BUILDER
                .comment("Allow Halloween mobs to spawn with pumpkins outside of Halloween\n" +
                        "Default: false")
                .define("alwaysHalloween", false);

        REPLACE_CHANCE = BUILDER
                .comment("The chance of a pumpkin on an Halloween mob's head to be replaced with one of Jack o'Cache's\n" +
                        "Default: " + (1 - (1.0 / (ModBlocks.PUMPKINS.size() + 1))))
                .defineInRange("replaceChance", 1 - (1.0 / (ModBlocks.PUMPKINS.size() + 1)), 0, 1);

        BUILDER.pop();


        BUILDER.push("Jack o'Slicer");

        JACK_O_SLICER_MOB_CHANCE_HARD = BUILDER
                .comment("The chance of a mob to spawn with a Jack o'Slicer in Hard difficulty\n" +
                        "Default: 0.05")
                .defineInRange("jackOSlicerMobChanceHard", 0.05, 0, 1);

        JACK_O_SLICER_MOB_CHANCE = BUILDER
                .comment("The chance of a mob to spawn with a Jack o'Slicer in Easy and Normal difficulty\n" +
                        "Default: 0.01")
                .defineInRange("jackOSlicerMobChance", 0.01, 0, 1);

        JACK_O_SLICER_DROP_CHANCE = BUILDER
                .comment("The chance of a mob with a Jack o'Slicer to drop it\n" +
                        "Default: 0.1")
                .defineInRange("jackOSlicerDropChance", 0.1, 0, 1);

        JACK_O_SLICER_REPAIR_ITEM = BUILDER
                .comment("The item used to repair the Jack o'Slicer\n" +
                        "Default: minecraft:pumpkin")
                .define("jackOSlicerRepairItem", "minecraft:pumpkin");

        BUILDER.pop(0);
    }

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean alwaysHalloween;
    public static double replaceChance;
    public static double jackOSlicerMobChanceHard;
    public static double jackOSlicerMobChance;
    public static float jackOSlicerDropChance;
    public static Item jackOSlicerRepairItem;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        alwaysHalloween = ALWAYS_HALLOWEEN.get();
        replaceChance = REPLACE_CHANCE.get();

        jackOSlicerMobChanceHard = JACK_O_SLICER_MOB_CHANCE_HARD.get();
        jackOSlicerMobChance = JACK_O_SLICER_MOB_CHANCE.get();
        jackOSlicerDropChance = JACK_O_SLICER_DROP_CHANCE.get().floatValue();
    }

    @SubscribeEvent
    public static void loading(final ModConfigEvent.Loading event) {
        jackOSlicerRepairItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JACK_O_SLICER_REPAIR_ITEM.get()));
        if (jackOSlicerRepairItem == Items.AIR && !JACK_O_SLICER_REPAIR_ITEM.get().equals("minecraft:air"))
            JackOCache.LOGGER.warn("Unknown Jack o'Slicer repair item ({}), Jack o'Slicer is unrepairable ", JACK_O_SLICER_REPAIR_ITEM.get());
    }
}
