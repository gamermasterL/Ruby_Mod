package net.gamerk.rubymod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static ScreenHandlerType<PressureScreenHandler> PRESSURE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(RubyMod.MOD_ID, "pressure"),
                    PressureScreenHandler::new);
}
