package tamaized.cosmicreality.proxy;


import net.minecraftforge.fml.client.registry.RenderingRegistry;
import tamaized.cosmicreality.client.entity.render.RenderPortal;
import tamaized.cosmicreality.common.entity.EntityPortal;
import tamaized.tammodized.proxy.AbstractProxy;

public class ClientProxy extends AbstractProxy {

	public ClientProxy() {
		super(Side.CLIENT);
	}

	@Override
	public void preRegisters() {

	}

	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityPortal.class, RenderPortal::new);
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}
