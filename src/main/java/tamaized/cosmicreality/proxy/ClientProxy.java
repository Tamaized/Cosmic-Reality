package tamaized.cosmicreality.proxy;

import tamaized.cosmicreality.client.render.RenderMirror;
import tamaized.cosmicreality.client.render.RenderPlayer;
import tamaized.cosmicreality.common.entity.EntityPortal;
import tamaized.cosmicreality.client.entity.render.RenderPortal;
import Tamaized.TamModized.proxy.AbstractProxy;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

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
		MinecraftForge.EVENT_BUS.register(new RenderMirror());

		RenderingRegistry.registerEntityRenderingHandler(EntityPortal.class, new IRenderFactory<EntityPortal>() {
			@Override
			public Render<? super EntityPortal> createRenderFor(RenderManager manager) {
				return new RenderPortal(manager);
			}
		});
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}