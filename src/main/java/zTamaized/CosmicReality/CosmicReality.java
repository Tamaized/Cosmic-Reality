package zTamaized.CosmicReality;

import java.io.File;

import zTamaized.CosmicReality.GUI.GuiHandler;
import zTamaized.CosmicReality.capabilities.AttachCapabilityEvent;
import zTamaized.CosmicReality.capabilities.cosmic.CosmicCapabilityHandler;
import zTamaized.CosmicReality.capabilities.cosmic.CosmicCapabilityStorage;
import zTamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import zTamaized.CosmicReality.entity.EntityPortal;
import zTamaized.CosmicReality.event.PlayerTickEvent;
import zTamaized.CosmicReality.handler.ConfigHandler;
import zTamaized.CosmicReality.network.ServerPacketHandler;
import zTamaized.CosmicReality.registry.ModCreativeTabs;
import zTamaized.CosmicReality.registry.ModItems;
import Tamaized.TamModized.TamModBase;
import Tamaized.TamModized.TamModized;
import Tamaized.TamModized.proxy.AbstractProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = CosmicReality.modid, name = "CosmicReality", guiFactory = "Tamaized.CosmicReality.GUI.client.GUIConfigFactory", version = CosmicReality.version, dependencies = "required-before:" + TamModized.modid + "@[${tamversion},)")
public class CosmicReality extends TamModBase {

	public static final boolean isDevBuild = true;

	public static final String version = "${version}";
	public static final String modid = "cosmicreality";

	public static String getVersion() {
		return version;
	}

	@Instance(modid)
	public static CosmicReality instance = new CosmicReality();

	public static File configFile;
	public static ConfigHandler config;

	public static FMLEventChannel channel;
	public static final String networkChannelName = "CosmicReality";

	@SidedProxy(clientSide = "Tamaized.CosmicReality.proxy.ClientProxy", serverSide = "Tamaized.CosmicReality.proxy.ServerProxy")
	public static AbstractProxy proxy;

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
		logger.info("Starting CosmicReality PreInit");

		configFile = event.getSuggestedConfigurationFile();
		config = new ConfigHandler(this, configFile, new Configuration(configFile));

		register(new ModItems());
		register(new ModCreativeTabs());

		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);

		CapabilityManager.INSTANCE.register(ICosmicCapability.class, new CosmicCapabilityStorage(), CosmicCapabilityHandler.class);
		MinecraftForge.EVENT_BUS.register(new AttachCapabilityEvent());

	}

	@Override
	public void init(FMLInitializationEvent event) {
		logger.info("Starting CosmicReality Init");

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		registerEntity(EntityPortal.class, "Portal", this, modid, 128, 1, true);

		MinecraftForge.EVENT_BUS.register(new PlayerTickEvent());

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		logger.info("Starting CosmicReality PostInit");

		channel.register(new ServerPacketHandler());
	}

}
