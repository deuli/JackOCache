package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import deuli.jackocache.blocks.*;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JackOCache.MOD_ID);

    public static final RegistryObject<Block> SINISTER_PUMPKIN = registerWithItem("sinister_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> SINISTER_JACK_O_LANTERN = registerWithItem("sinister_jack_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> GENERIC_PUMPKIN = registerWithItem("generic_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> GENERIC_JACK_O_LANTERN = registerWithItem("generic_jack_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> CREEPER_PUMPKIN = registerWithItem("creeper_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> CREEP_O_LANTERN = registerWithItem("creep_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> ENDERMAN_PUMPKIN = registerWithItem("enderman_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> END_O_LANTERN = registerWithItem("end_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SKELETON_PUMPKIN = registerWithItem("skeleton_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> BONE_O_LANTERN = registerWithItem("bone_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> ROTTEN_PUMPKIN = registerWithItem("rotten_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> ROT_O_LANTERN = registerWithItem("rot_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> VILLAGER_PUMPKIN = registerWithItem("villager_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> HMM_O_LANTERN = registerWithItem("hmm_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> UWU_PUMPKIN = registerWithItem("uwu_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> UWU_O_LANTERN = registerWithItem("uwu_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> PIG_PUMPKIN = registerWithItem("pig_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> OINK_O_LANTERN = registerWithItem("oink_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SPIDER_PUMPKIN = registerWithItem("spider_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> WEB_O_LANTERN = registerWithItem("web_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> GHAST_PUMPKIN = registerWithItem("ghast_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> SCREAM_O_LANTERN = registerWithItem("scream_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SLIME_PUMPKIN = registerWithItem("slime_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> GOO_O_LANTERN = registerWithItem("goo_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> NICE_PUMPKIN = registerWithItem("nice_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> NICE_O_LANTERN = registerWithItem("nice_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> EMOTE_PUMPKIN = registerWithItem("emote_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> EMOTE_O_LANTERN = registerWithItem("emote_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> DOG_PUMPKIN = registerWithItem("dog_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> BARK_O_LANTERN = registerWithItem("bark_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> CAT_PUMPKIN = registerWithItem("cat_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> MEOW_O_LANTERN = registerWithItem("meow_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> CHICKEN_PUMPKIN = registerWithItem("chicken_pumpkin",
            () -> new EquipableChickenPumpkinBlock());
    public static final RegistryObject<Block> CLUCK_O_LANTERN = registerWithItem("cluck_o_lantern",
            () -> new ChickenPumpkinBlock());

    public static final RegistryObject<Block> DRAGON_PUMPKIN = registerWithItem("dragon_pumpkin",
            () -> new EquipableDragonPumpkinBlock());
    public static final RegistryObject<Block> THE_END_O_LANTERN = registerWithItem("the_end_o_lantern",
            () -> new DragonPumpkinBlock());

    public static final RegistryObject<Block> WITHER_PUMPKIN = registerWithItem("wither_pumpkin",
            () -> new EquipableWitherPumpkinBlock());
    public static final RegistryObject<Block> WITHERING_O_LANTERN = registerWithItem("withering_o_lantern",
            () -> new WitherPumpkinBlock());

    public static final RegistryObject<Block> PUMPKING = registerWithItem("pumpking",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> ROYAL_O_LANTERN = registerWithItem("royal_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> PLAYER_PUMPKIN = registerWithItem("player_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> UUH_O_LANTERN = registerWithItem("uuh_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static final RegistryObject<Block> SHEEP_PUMPKIN = registerWithItem("sheep_pumpkin",
            () -> new EquipableSheepPumpkinBlock());
    public static final RegistryObject<Block> BAH_O_LANTERN = registerWithItem("bah_o_lantern",
            () -> new SheepPumpkinBlock());

    public static final RegistryObject<Block> GHOST_PUMPKIN = registerWithItem("ghost_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).noOcclusion()) {
                @Override
                public boolean skipRendering(BlockState pState, BlockState pAdjacentState, Direction pDirection) {
                    return pAdjacentState.is(this) ? true : super.skipRendering(pState, pAdjacentState, pDirection);
                }
            });
    public static final RegistryObject<Block> SPOOK_O_LANTERN = registerWithItem("spook_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN).noOcclusion()) {
                @Override
                public boolean skipRendering(BlockState pState, BlockState pAdjacentState, Direction pDirection) {
                    return pAdjacentState.is(this) ? true : super.skipRendering(pState, pAdjacentState, pDirection);
                }
            });

    public static final RegistryObject<Block> SNOW_PUMPKIN = registerWithItem("snow_pumpkin",
            () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)));
    public static final RegistryObject<Block> FROST_O_LANTERN = registerWithItem("frost_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));

    public static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }

}