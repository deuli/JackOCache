package deuli.jackocache.other;

import com.mojang.blaze3d.systems.RenderSystem;
import deuli.jackocache.JackOCache;
import deuli.jackocache.blocks.PumpkinBlur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PumpkinBlurOverlay implements IGuiOverlay {
    private final static ResourceLocation PUMPKIN_BLUR_LOCATION = new ResourceLocation(JackOCache.MOD_ID, "textures/pumpkin_blur/");

    @SubscribeEvent
    public static void initPumpkinBlur(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.SPYGLASS.id(), "pumpkin_blur_overlay", new PumpkinBlurOverlay());
    }

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        RenderSystem.enableBlend();

        Item helmet = player.getInventory().getArmor(3).getItem();
        if (Minecraft.getInstance().options.getCameraType().isFirstPerson() &&
                helmet instanceof BlockItem blockItem && blockItem.getBlock() instanceof PumpkinBlur pumpkinBlur) {
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
            guiGraphics.blit(PUMPKIN_BLUR_LOCATION.withSuffix(pumpkinBlur.getBlur()).withSuffix(".png"),
                    0, 0, -90, 0.0F, 0.0F,
                    screenWidth, screenHeight, screenWidth, screenHeight);
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

}
