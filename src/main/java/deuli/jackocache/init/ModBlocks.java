package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import deuli.jackocache.blocks.*;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JackOCache.MOD_ID);

    public static final ArrayList<RegistryObject<Block>> PUMPKINS = new ArrayList<>();
    public static final ArrayList<RegistryObject<Block>> CARVED_PUMPKINS = new ArrayList<>();
    public static final ArrayList<RegistryObject<Block>> JACK_O_LANTERN = new ArrayList<>();

    public static final RegistryObject<Block> SINISTER_PUMPKIN = pumpkin("sinister_pumpkin");
    public static final RegistryObject<Block> SINISTER_JACK_O_LANTERN = jackOLantern("sinister_jack_o_lantern");

    public static final RegistryObject<Block> GENERIC_PUMPKIN = pumpkin("generic_pumpkin");
    public static final RegistryObject<Block> GENERIC_JACK_O_LANTERN = jackOLantern("generic_jack_o_lantern");

    public static final RegistryObject<Block> CREEPER_PUMPKIN = pumpkin("creeper_pumpkin");
    public static final RegistryObject<Block> CREEP_O_LANTERN = jackOLantern("creep_o_lantern");

    public static final RegistryObject<Block> ENDERMAN_PUMPKIN = pumpkin("enderman_pumpkin");
    public static final RegistryObject<Block> END_O_LANTERN = jackOLantern("end_o_lantern");

    public static final RegistryObject<Block> SKELETON_PUMPKIN = pumpkin("skeleton_pumpkin");
    public static final RegistryObject<Block> BONE_O_LANTERN = jackOLantern("bone_o_lantern");

    public static final RegistryObject<Block> ROTTEN_PUMPKIN = pumpkin("rotten_pumpkin");
    public static final RegistryObject<Block> ROT_O_LANTERN = jackOLantern("rot_o_lantern");

    public static final RegistryObject<Block> VILLAGER_PUMPKIN = pumpkin("villager_pumpkin");
    public static final RegistryObject<Block> HMM_O_LANTERN = jackOLantern("hmm_o_lantern");

    public static final RegistryObject<Block> UWU_PUMPKIN = pumpkin("uwu_pumpkin");
    public static final RegistryObject<Block> UWU_O_LANTERN = jackOLantern("uwu_o_lantern");

    public static final RegistryObject<Block> PIG_PUMPKIN = pumpkin("pig_pumpkin");
    public static final RegistryObject<Block> OINK_O_LANTERN = jackOLantern("oink_o_lantern");

    public static final RegistryObject<Block> SPIDER_PUMPKIN = pumpkin("spider_pumpkin");
    public static final RegistryObject<Block> WEB_O_LANTERN = jackOLantern("web_o_lantern");

    public static final RegistryObject<Block> GHAST_PUMPKIN = pumpkin("ghast_pumpkin");
    public static final RegistryObject<Block> SCREAM_O_LANTERN = jackOLantern("scream_o_lantern");

    public static final RegistryObject<Block> SLIME_PUMPKIN = pumpkin("slime_pumpkin");
    public static final RegistryObject<Block> GOO_O_LANTERN = jackOLantern("goo_o_lantern");

    public static final RegistryObject<Block> NICE_PUMPKIN = pumpkin("nice_pumpkin");
    public static final RegistryObject<Block> NICE_O_LANTERN = jackOLantern("nice_o_lantern");

    public static final RegistryObject<Block> EMOTE_PUMPKIN = pumpkin("emote_pumpkin");
    public static final RegistryObject<Block> EMOTE_O_LANTERN = jackOLantern("emote_o_lantern");

    public static final RegistryObject<Block> DOG_PUMPKIN = pumpkin("dog_pumpkin");
    public static final RegistryObject<Block> BARK_O_LANTERN = jackOLantern("bark_o_lantern");

    public static final RegistryObject<Block> CAT_PUMPKIN = pumpkin("cat_pumpkin");
    public static final RegistryObject<Block> MEOW_O_LANTERN = jackOLantern("meow_o_lantern");

    public static final RegistryObject<Block> CHICKEN_PUMPKIN = pumpkin("chicken_pumpkin",
            () -> new EquipableChickenPumpkinBlock());
    public static final RegistryObject<Block> CLUCK_O_LANTERN = jackOLantern("cluck_o_lantern",
            () -> new ChickenPumpkinBlock());

    public static final RegistryObject<Block> DRAGON_PUMPKIN = pumpkin("dragon_pumpkin",
            () -> new EquipableDragonPumpkinBlock());
    public static final RegistryObject<Block> THE_END_O_LANTERN = jackOLantern("the_end_o_lantern",
            () -> new DragonPumpkinBlock());

    public static final RegistryObject<Block> WITHER_PUMPKIN = pumpkin("wither_pumpkin",
            () -> new EquipableWitherPumpkinBlock());
    public static final RegistryObject<Block> WITHERING_O_LANTERN = jackOLantern("withering_o_lantern",
            () -> new WitherPumpkinBlock());

    public static final RegistryObject<Block> PUMPKING = pumpkin("pumpking");
    public static final RegistryObject<Block> ROYAL_O_LANTERN = jackOLantern("royal_o_lantern");

    public static final RegistryObject<Block> PLAYER_PUMPKIN = pumpkin("player_pumpkin");
    public static final RegistryObject<Block> UUH_O_LANTERN = jackOLantern("uuh_o_lantern");

    public static final RegistryObject<Block> SHEEP_PUMPKIN = pumpkin("sheep_pumpkin",
            () -> new EquipableSheepPumpkinBlock());
    public static final RegistryObject<Block> BAH_O_LANTERN = jackOLantern("bah_o_lantern",
            () -> new SheepPumpkinBlock());

    public static final RegistryObject<Block> GHOST_PUMPKIN = pumpkin("ghost_pumpkin",
            () -> new EquipablePumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).noOcclusion(), "ghost") {
                @Override
                public boolean skipRendering(BlockState pState, BlockState pAdjacentState, Direction pDirection) {
                    return pAdjacentState.is(this) || super.skipRendering(pState, pAdjacentState, pDirection);
                }
            });
    public static final RegistryObject<Block> SPOOK_O_LANTERN = jackOLantern("spook_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN).noOcclusion()) {
                @Override
                public boolean skipRendering(BlockState pState, BlockState pAdjacentState, Direction pDirection) {
                    return pAdjacentState.is(this) || super.skipRendering(pState, pAdjacentState, pDirection);
                }
            });

    public static final RegistryObject<Block> SNOW_PUMPKIN = pumpkin("snow_pumpkin");
    public static final RegistryObject<Block> FROST_O_LANTERN = jackOLantern("frost_o_lantern");

    public static final RegistryObject<Block> SYNTH_PUMPKIN = pumpkin("synth_pumpkin",
            () -> new EquipablePumpkinBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN)
                    .lightLevel((value -> 3)).emissiveRendering((s, l, p) -> true), "synth"));
    public static final RegistryObject<Block> SYNTH_O_LANTERN = jackOLantern("synth_o_lantern",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)
                    .emissiveRendering((s, l, p) -> true)));

    public static final RegistryObject<Block> MELON_PUMPKIN = pumpkin("melon_pumpkin");
    public static final RegistryObject<Block> MEL_O_LANTERN = jackOLantern("mel_o_lantern");

    public static final RegistryObject<Block> ALPHA_PUMPKIN = pumpkin("alpha_pumpkin");
    public static final RegistryObject<Block> ALPHA_JACK_O_LANTERN = jackOLantern("alpha_jack_o_lantern");

    public static final RegistryObject<Block> SPOOKYJAM_PUMPKIN = pumpkin("spookyjam_pumpkin");
    public static final RegistryObject<Block> SPOOKYJAM_JACK_O_LANTERN = jackOLantern("spookyjam_jack_o_lantern");

    public static final RegistryObject<Block> COOL_PUMPKIN = pumpkin("cool_pumpkin");
    public static final RegistryObject<Block> COOL_JACK_O_LANTERN = jackOLantern("cool_jack_o_lantern");

    public static final RegistryObject<Block> ANGRY_PUMPKIN = pumpkin("angry_pumpkin");
    public static final RegistryObject<Block> ANGRY_JACK_O_LANTERN = jackOLantern("angry_jack_o_lantern");

    public static final RegistryObject<Block> SNOW_GOLEM_PUMPKIN = pumpkin("snow_golem_pumpkin");
    public static final RegistryObject<Block> SNOWBALL_O_LANTERN = jackOLantern("snowball_o_lantern");

    public static final RegistryObject<Block> ILLAGER_PUMPKIN = pumpkin("illager_pumpkin");
    public static final RegistryObject<Block> HRNGH_O_LANTERN = jackOLantern("hrngh_o_lantern");

    public static final RegistryObject<Block> GUARDIAN_PUMPKIN = pumpkin("guardian_pumpkin");
    public static final RegistryObject<Block> LASER_O_LANTERN = jackOLantern("laser_o_lantern");

    public static final RegistryObject<Block> PUKING_PUMPKIN = pumpkin("puking_pumpkin");
    public static final RegistryObject<Block> PUKING_JACK_O_LANTERN = jackOLantern("puking_jack_o_lantern");

    public static final RegistryObject<Block> BAT_PUMPKIN = pumpkin("bat_pumpkin");
    public static final RegistryObject<Block> SQUEAK_O_LANTERN = jackOLantern("squeak_o_lantern");

    public static final RegistryObject<Block> ROTTEN_VILLAGER_PUMPKIN = pumpkin("rotten_villager_pumpkin");
    public static final RegistryObject<Block> ROTTEN_HMM_O_LANTERN = jackOLantern("rotten_hmm_o_lantern");

    public static final RegistryObject<Block> WITCH_PUMPKIN = pumpkin("witch_pumpkin");
    public static final RegistryObject<Block> HEEHEEHEE_O_LANTERN = jackOLantern("heeheehee_o_lantern");

    public static final RegistryObject<Block> NERD_PUMPKIN = pumpkin("nerd_pumpkin");
    public static final RegistryObject<Block> NERD_JACK_O_LANTERN = jackOLantern("nerd_jack_o_lantern");

    public static final RegistryObject<Block> NERD_CREEPER_PUMPKIN = pumpkin("nerd_creeper_pumpkin");
    public static final RegistryObject<Block> NERD_CREEP_O_LANTERN = jackOLantern("nerd_creep_o_lantern");

    public static final RegistryObject<Block> WARDEN_PUMPKIN = pumpkin("warden_pumpkin",
            () -> new EquipableWardenPumpkinBlock());
    public static final RegistryObject<Block> SCULK_O_LANTERN = jackOLantern("sculk_o_lantern",
            () -> new WardenPumpkinBlock());

    public static <T extends Block> RegistryObject<Block> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<Block> registryObject = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }

    private static RegistryObject<Block> pumpkin(String name) {
        return pumpkin(name, () -> new EquipablePumpkinBlock(name.replace("_pumpkin", "")));
    }

    private static RegistryObject<Block> pumpkin(String name, Supplier<Block> block) {
        RegistryObject<Block> registryObject = registerWithItem(name, block);
        PUMPKINS.add(registryObject);
        CARVED_PUMPKINS.add(registryObject);
        return registryObject;
    }

    private static RegistryObject<Block> jackOLantern(String name) {
        return jackOLantern(name, () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.JACK_O_LANTERN)));
    }

    private static RegistryObject<Block> jackOLantern(String name, Supplier<Block> block) {
        RegistryObject<Block> registryObject = registerWithItem(name, block);
        PUMPKINS.add(registryObject);
        JACK_O_LANTERN.add(registryObject);
        return registryObject;
    }
}