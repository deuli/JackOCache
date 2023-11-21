package deuli.jackocache;

import deuli.jackocache.init.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue ALWAYS_HALLOWEEN;
    private static final ForgeConfigSpec.DoubleValue REPLACE_CHANCE;

    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_MOB_CHANCE_HARD;
    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_MOB_CHANCE;
    private static final ForgeConfigSpec.DoubleValue JACK_O_SLICER_DROP_CHANCE;
    private static final ForgeConfigSpec.ConfigValue<String> JACK_O_SLICER_REPAIR_ITEM;

    private static final ForgeConfigSpec.BooleanValue UWU_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue NICE_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue EMOTE_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue PUMPKING_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue GHOST_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue SNOW_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue MELON_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue ALPHA_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue SPOOKYJAM_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue COOL_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue ANGRY_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue PUKING_TRANSFORMATION;
    private static final ForgeConfigSpec.BooleanValue NERD_TRANSFORMATION;

    static {
        BUILDER.push("Pumpkin Heads");

        ALWAYS_HALLOWEEN = BUILDER
                .comment("Allow Halloween mobs to spawn with pumpkins outside of Halloween\n" +
                        "Default: false")
                .define("alwaysHalloween", false);

        REPLACE_CHANCE = BUILDER
                .comment("The chance of a pumpkin on a Halloween mob's head to be replaced with one of Jack o'Cache's\n" +
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

        BUILDER.pop();


        BUILDER.push("Transformations");

        UWU_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the uwu Pumpkin\n" +
                        "Default: true")
                .define("uwuTransformation", true);

        NICE_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the nice Pumpkin\n" +
                        "Default: true")
                .define("niceTransformation", true);

        EMOTE_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the :^) Pumpkin\n" +
                        "Default: true")
                .define("emoteTransformation", true);

        PUMPKING_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Pumpking\n" +
                        "Default: true")
                .define("pumpkingTransformation", true);

        GHOST_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Ghost Pumpkin\n" +
                        "Default: true")
                .define("ghostTransformation", true);

        SNOW_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Snow Pumpkin\n" +
                        "Default: true")
                .define("snowTransformation", true);

        MELON_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Melon Pumpkin\n" +
                        "Default: true")
                .define("melonTransformation", true);

        ALPHA_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Alpha Pumpkin\n" +
                        "Default: true")
                .define("alphaTransformation", true);

        SPOOKYJAM_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the SpookyJam Pumpkin\n" +
                        "Default: true")
                .define("spookyJamTransformation", true);

        COOL_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Cool Pumpkin\n" +
                        "Default: true")
                .define("coolTransformation", true);

        ANGRY_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Angry Pumpkin\n" +
                        "Default: true")
                .define("angryTransformation", true);

        PUKING_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Puking Pumpkin\n" +
                        "Default: true")
                .define("pukingTransformation", true);

        NERD_TRANSFORMATION = BUILDER
                .comment("Enable the transformation for the Nerd Pumpkin\n" +
                        "Default: true")
                .define("nerdTransformation", true);

        BUILDER.pop();
    }

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean alwaysHalloween;
    public static double replaceChance;

    public static double jackOSlicerMobChanceHard;
    public static double jackOSlicerMobChance;
    public static float jackOSlicerDropChance;
    public static Item jackOSlicerRepairItem;

    public static Map<Block, Boolean> transformations = new HashMap<>();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        alwaysHalloween = ALWAYS_HALLOWEEN.get();
        replaceChance = REPLACE_CHANCE.get();

        jackOSlicerMobChanceHard = JACK_O_SLICER_MOB_CHANCE_HARD.get();
        jackOSlicerMobChance = JACK_O_SLICER_MOB_CHANCE.get();
        jackOSlicerDropChance = JACK_O_SLICER_DROP_CHANCE.get().floatValue();

        transformations.clear();
        transformations.put(ModBlocks.UWU_PUMPKIN.get(), UWU_TRANSFORMATION.get());
        transformations.put(ModBlocks.NICE_PUMPKIN.get(), NICE_TRANSFORMATION.get());
        transformations.put(ModBlocks.EMOTE_PUMPKIN.get(), EMOTE_TRANSFORMATION.get());
        transformations.put(ModBlocks.PUMPKING.get(), PUMPKING_TRANSFORMATION.get());
        transformations.put(ModBlocks.GHOST_PUMPKIN.get(), GHOST_TRANSFORMATION.get());
        transformations.put(ModBlocks.SNOW_PUMPKIN.get(), SNOW_TRANSFORMATION.get());
        transformations.put(ModBlocks.MELON_PUMPKIN.get(), MELON_TRANSFORMATION.get());
        transformations.put(ModBlocks.ALPHA_PUMPKIN.get(), ALPHA_TRANSFORMATION.get());
        transformations.put(ModBlocks.SPOOKYJAM_PUMPKIN.get(), SPOOKYJAM_TRANSFORMATION.get());
        transformations.put(ModBlocks.COOL_PUMPKIN.get(), COOL_TRANSFORMATION.get());
        transformations.put(ModBlocks.ANGRY_PUMPKIN.get(), ANGRY_TRANSFORMATION.get());
        transformations.put(ModBlocks.PUKING_PUMPKIN.get(), PUKING_TRANSFORMATION.get());
        transformations.put(ModBlocks.NERD_PUMPKIN.get(), NERD_TRANSFORMATION.get());
    }

    @SubscribeEvent
    public static void loading(final ModConfigEvent.Loading event) {
        jackOSlicerRepairItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JACK_O_SLICER_REPAIR_ITEM.get()));
        if (jackOSlicerRepairItem == Items.AIR && !JACK_O_SLICER_REPAIR_ITEM.get().equals("minecraft:air"))
            JackOCache.LOGGER.warn("Unknown Jack o'Slicer repair item ({}), Jack o'Slicer is unrepairable ", JACK_O_SLICER_REPAIR_ITEM.get());
    }
}
