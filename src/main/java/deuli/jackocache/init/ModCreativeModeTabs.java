package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JackOCache.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PUMPKIN_TAB = CREATIVE_MODE_TABS.register("pumpkin_tab", () -> CreativeModeTab.builder()
            .icon(() -> ModItems.SINISTER_PUMPKIN.get().getDefaultInstance())
            .title(Component.literal("Pumpkins"))
            .displayItems((parameters, output) -> {
                output.accept(Blocks.PUMPKIN);
                output.accept(Blocks.CARVED_PUMPKIN);
                output.accept(Blocks.JACK_O_LANTERN);

                output.accept(ModBlocks.SINISTER_PUMPKIN.get());
                output.accept(ModBlocks.SINISTER_JACK_O_LANTERN.get());

                output.accept(ModBlocks.GENERIC_PUMPKIN.get());
                output.accept(ModBlocks.GENERIC_JACK_O_LANTERN.get());

                output.accept(ModBlocks.CREEPER_PUMPKIN.get());
                output.accept(ModBlocks.CREEP_O_LANTERN.get());

                output.accept(ModBlocks.ENDERMAN_PUMPKIN.get());
                output.accept(ModBlocks.END_O_LANTERN.get());

                output.accept(ModBlocks.SKELETON_PUMPKIN.get());
                output.accept(ModBlocks.BONE_O_LANTERN.get());

                output.accept(ModBlocks.ROTTEN_PUMPKIN.get());
                output.accept(ModBlocks.ROT_O_LANTERN.get());

                output.accept(ModBlocks.VILLAGER_PUMPKIN.get());
                output.accept(ModBlocks.HMM_O_LANTERN.get());

                output.accept(ModBlocks.UWU_PUMPKIN.get());
                output.accept(ModBlocks.UWU_O_LANTERN.get());

                output.accept(ModBlocks.PIG_PUMPKIN.get());
                output.accept(ModBlocks.OINK_O_LANTERN.get());

                output.accept(ModBlocks.SPIDER_PUMPKIN.get());
                output.accept(ModBlocks.WEB_O_LANTERN.get());

                output.accept(ModBlocks.GHAST_PUMPKIN.get());
                output.accept(ModBlocks.SCREAM_O_LANTERN.get());
            }).build());
}
