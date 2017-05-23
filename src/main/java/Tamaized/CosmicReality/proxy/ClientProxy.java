package Tamaized.CosmicReality.proxy;

import Tamaized.CosmicReality.client.event.RenderPlayer;
import Tamaized.TamModized.proxy.AbstractProxy;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends AbstractProxy {

	public ClientProxy() {
		super(Side.CLIENT);
	}

	@Override
	public void preRegisters() {

	}

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new RenderPlayer());
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}
