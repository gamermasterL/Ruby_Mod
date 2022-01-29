package net.gamerk.rubymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.gamerk.rubymod.item.init.ModelProviderinit;

@Environment(EnvType.CLIENT)
public class RubyModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        ModelProviderinit.init();
    }
}
