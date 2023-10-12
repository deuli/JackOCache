package deuli.jackocache.init;

import deuli.jackocache.JackOCache;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JackOCache.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PUMPKIN_TAB = CREATIVE_MODE_TABS.register("pumpkin_tab", () -> CreativeModeTab.builder()
            .icon(() -> ModBlocks.SINISTER_PUMPKIN.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.pumpkins").append(" (" + JackOCache.MOD_NAME + ")"))
            .displayItems((parameters, output) -> {
                output.accept(Blocks.PUMPKIN);
                output.accept(Blocks.CARVED_PUMPKIN);
                output.accept(Blocks.JACK_O_LANTERN);

                ModBlocks.PUMPKINS.forEach(registryObject -> output.accept(registryObject.get()));
            }).build());
}