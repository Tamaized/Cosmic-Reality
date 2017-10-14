package tamaized.cosmicreality.registry;


import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.cosmicreality.CosmicReality;
import tamaized.cosmicreality.common.items.DebugTool;
import tamaized.tammodized.registry.ITamRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = CosmicReality.modid)
public class ModItems {

	public static DebugTool debugTool;
	private static ArrayList<Item> list = new ArrayList<>();

	static {
		list.add(debugTool = new DebugTool());
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> e) {
		for (Item item : list)
			e.getRegistry().register(item);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void loadModels(ModelRegistryEvent e) {
		for (Item item : list)
			if (item instanceof ITamRegistry)
				((ITamRegistry) item).registerModel(e);
	}

}
