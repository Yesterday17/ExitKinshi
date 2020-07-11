package moe.mmf.exitkinshi;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@Mod("exitkinshi")
public class ExitKinshi
{
    public ExitKinshi() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        long window = Minecraft.getInstance().getMainWindow().getHandle();
        GLFW.glfwSetWindowCloseCallback(window, w -> {
            if (w == window) GLFW.glfwSetWindowShouldClose(w, false);
        });
    }
}
