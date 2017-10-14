package tamaized.cosmicreality;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import tamaized.cosmicreality.common.capabilities.AttachCapabilityEvent;
import tamaized.cosmicreality.common.capabilities.cosmic.CosmicCapabilityHandler;
import tamaized.cosmicreality.common.capabilities.cosmic.CosmicCapabilityStorage;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;
import tamaized.cosmicreality.common.entity.EntityPortal;
import tamaized.cosmicreality.common.event.PlayerTickEvent;
import tamaized.cosmicreality.network.GuiHandler;
import tamaized.cosmicreality.registry.ModCreativeTabs;
import tamaized.cosmicreality.registry.ModItems;
import tamaized.tammodized.TamModBase;
import tamaized.tammodized.TamModized;
import tamaized.tammodized.proxy.AbstractProxy;

@Mod(modid = CosmicReality.modid, name = "CosmicReality", version = CosmicReality.version, dependencies = "required-before:" + TamModized.modid + "@[${tamversion},)")
public class CosmicReality extends TamModBase {

	public static final String version = "${version}";
	public static final String modid = "cosmicreality";
	@Instance(modid)
	public static CosmicReality instance = new CosmicReality();
	@SidedProxy(clientSide = "tamaized.cosmicreality.proxy.ClientProxy", serverSide = "tamaized.cosmicreality.proxy.ServerProxy")
	public static AbstractProxy proxy;

	static {
		new ModItems();
		new ModCreativeTabs();
	}

	public static String getVersion() {
		return version;
	}

	@Override
	protected AbstractProxy getProxy() {
		return proxy;
	}

	@Override
	public String getModID() {
		return modid;
	}

	@Override
	@EventHandler
	public void FMLpreInit(FMLPreInitializationEvent event) {
		super.FMLpreInit(event);
	}

	@Override
	@EventHandler
	public void FMLinit(FMLInitializationEvent event) {
		super.FMLinit(event);
	}

	@Override
	@EventHandler
	public void FMLpostInit(FMLPostInitializationEvent event) {
		super.FMLpostInit(event);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		CapabilityManager.INSTANCE.register(ICosmicCapability.class, new CosmicCapabilityStorage(), CosmicCapabilityHandler.class);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		registerEntity(EntityPortal.class, "Portal", this, modid, 128, 1, true);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

	}

}
