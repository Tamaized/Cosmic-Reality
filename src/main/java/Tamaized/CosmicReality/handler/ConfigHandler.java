package Tamaized.CosmicReality.handler;

import java.io.IOException;

import Tamaized.CosmicReality.CosmicReality;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	private Configuration config;

	public ConfigHandler(Configuration c) {
		config = c;
		config.load();
		sync(true);
	}

	public Configuration getConfig() {
		return config;
	}

	public void sync(boolean firstLoad) {
		try {
			loadData(firstLoad);
			cleanupFile();
			config.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadData(boolean firstLoad) {

	}

	private void cleanupFile() throws IOException {
		CosmicReality.configFile.delete();
		CosmicReality.configFile.createNewFile();
		config = new Configuration(CosmicReality.configFile);
		// config.get(Configuration.CATEGORY_GENERAL, "Render First Person Particles", default_renderFirstPersonVadeMecumParticles).set(renderFirstPersonVadeMecumParticles);
	}

	@SubscribeEvent
	public void configChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(CosmicReality.modid)) sync(false);
	}

}
