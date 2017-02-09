package Tamaized.CosmicReality.proxy;

import Tamaized.CosmicReality.client.event.RenderPlayer;
import Tamaized.TamModized.proxy.AbstractProxy;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends AbstractProxy {

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new RenderPlayer());
	}

}
