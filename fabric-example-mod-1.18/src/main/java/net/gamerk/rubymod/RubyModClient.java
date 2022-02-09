package net.gamerk.rubymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.gamerk.rubymod.item.init.ModelProviderinit;
import net.gamerk.rubymod.screen.ModScreenHandler;
import net.gamerk.rubymod.screen.PressureScreen;

@Environment(EnvType.CLIENT)
public class RubyModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        ModelProviderinit.init();
        ScreenRegistry.register(ModScreenHandler.PRESSURE_SCREEN_HANDLER, PressureScreen::new);
    }
}
