package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JackOCache.MOD_ID);

    public static final RegistryObject<Block> SINISTER_PUMPKIN = BLOCKS.register("sinister_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> SINISTER_JACK_O_LANTERN = BLOCKS.register("sinister_jack_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> GENERIC_PUMPKIN = BLOCKS.register("generic_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> GENERIC_JACK_O_LANTERN = BLOCKS.register("generic_jack_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> CREEPER_PUMPKIN = BLOCKS.register("creeper_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> CREEP_O_LANTERN = BLOCKS.register("creep_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> ENDERMAN_PUMPKIN = BLOCKS.register("enderman_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> END_O_LANTERN = BLOCKS.register("end_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SKELETON_PUMPKIN = BLOCKS.register("skeleton_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> BONE_O_LANTERN = BLOCKS.register("bone_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> ROTTEN_PUMPKIN = BLOCKS.register("rotten_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> ROT_O_LANTERN = BLOCKS.register("rot_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> VILLAGER_PUMPKIN = BLOCKS.register("villager_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> HMM_O_LANTERN = BLOCKS.register("hmm_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> UWU_PUMPKIN = BLOCKS.register("uwu_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> UWU_O_LANTERN = BLOCKS.register("uwu_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> PIG_PUMPKIN = BLOCKS.register("pig_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> OINK_O_LANTERN = BLOCKS.register("oink_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SPIDER_PUMPKIN = BLOCKS.register("spider_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> WEB_O_LANTERN = BLOCKS.register("web_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> GHAST_PUMPKIN = BLOCKS.register("ghast_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> SCREAM_O_LANTERN = BLOCKS.register("scream_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SLIME_PUMPKIN = BLOCKS.register("slime_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> GOO_O_LANTERN = BLOCKS.register("goo_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> NICE_PUMPKIN = BLOCKS.register("nice_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> NICE_O_LANTERN = BLOCKS.register("nice_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> EMOTE_PUMPKIN = BLOCKS.register("emote_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> EMOTE_O_LANTERN = BLOCKS.register("emote_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> DOG_PUMPKIN = BLOCKS.register("dog_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> BARK_O_LANTERN = BLOCKS.register("bark_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> CAT_PUMPKIN = BLOCKS.register("cat_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> MEOW_O_LANTERN = BLOCKS.register("meow_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> WITHER_PUMPKIN = BLOCKS.register("wither_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> WITHERING_O_LANTERN = BLOCKS.register("withering_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));
}