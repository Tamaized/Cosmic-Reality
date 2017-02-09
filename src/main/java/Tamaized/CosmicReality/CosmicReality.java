package Tamaized.CosmicReality;

import java.io.File;

import org.apache.logging.log4j.LogManager;

import Tamaized.CosmicReality.GUI.GuiHandler;
import Tamaized.CosmicReality.handler.ConfigHandler;
import Tamaized.CosmicReality.network.ServerPacketHandler;
import Tamaized.TamModized.TamModBase;
import Tamaized.TamModized.TamModized;
import Tamaized.TamModized.proxy.AbstractProxy;
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

@Mod(modid = CosmicReality.modid, name = "CosmicReality", guiFactory = "Tamaized.CosmicReality.GUI.client.GUIConfigFactory", version = CosmicReality.version, dependencies = "required-before:" + TamModized.modid + "@[" + TamModized.version + ",)")
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
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("CosmicReality");

		logger.info("Starting CosmicReality PreInit");

		configFile = event.getSuggestedConfigurationFile();
		config = new ConfigHandler(new Configuration(configFile));

		// Initialize Network
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);

		// proxy.preRegisters();

		// yo dawg, Register the Registers... i'm sorry
		// register(particles = new VoidCraftParticles());

		// Register Sounds Events
		// VoidSoundEvents.register();

		// Super here to start register stuff
		super.preInit(event);

		// Register Capabilities
		// CapabilityManager.INSTANCE.register(IStarForgeCapability.class, new StarForgeCapabilityStorage(), StarForgeCapabilityHandler.class);
		// MinecraftForge.EVENT_BUS.register(new Tamaized.Voidcraft.capabilities.EventHandler());

		// Proxy Stuff
		proxy.preInit();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("Starting CosmicReality Init");

		super.init(event);

		// Tile Entities
		// GameRegistry.registerTileEntity(TileEntityStarForge.class, "tileEntityStarForge");

		// GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		// Register Events
		// MinecraftForge.EVENT_BUS.register(new LitStrikeEvent());

		// Register Projectiles and other misc entities
		// registerEntity(VoidChain.class, "VoidChain", this, modid, 128, 1, true);
		// registerEntity(EntitySpellImplosion.class, "EntitySpellImplosion", this, modid, 64, 1, true);

		// Register Dimensions
		// DimensionManager.registerDimension(config.getDimensionIDvoid(), DimensionType.register("The Void", "_void", config.getDimensionIDvoid(), WorldProviderVoid.class, false));
		// DimensionManager.registerDimension(config.getDimensionIDxia(), DimensionType.register("???", "_xia", config.getDimensionIDxia(), WorldProviderXia.class, false));

		// Register World Gen
		// GameRegistry.registerWorldGenerator(new WorldGeneratorVoid(), 0);

		// MapGenStructureIO.registerStructure(MapGenVoidFortress.Start.class, "VoidFortress");
		// StructureVoidFortressPieces.registerNetherFortressPieces();

		// Register Mobs
		// registerEntity(EntityCompanionFireElemental.class, "FireElemental", this, modid, 64, 1, true);

		// Register Biomes
		// Biome.getBiome(6).getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(EntityMobLich.class, 10, 0, 1));

		// if(thaumcraftIntegration != null) thaumcraftIntegration.init();

		// Proxy Stuff
		proxy.init();

	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		logger.info("Starting CosmicReality PostInit");

		super.postInit(e);

		// Register Network
		channel.register(new ServerPacketHandler());

		// Proxy Stuff
		proxy.postInit();
		// if(thaumcraftIntegration != null) thaumcraftIntegration.postInit();

	}

}
