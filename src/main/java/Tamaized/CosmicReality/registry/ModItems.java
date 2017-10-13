package Tamaized.CosmicReality.registry;

import java.util.ArrayList;

import Tamaized.CosmicReality.CosmicReality;
import Tamaized.CosmicReality.items.DebugTool;
import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import net.minecraftforge.common.model.Models;

public class ModItems implements ITamRegistry {

	private ArrayList<ITamModel> models = new ArrayList<ITamModel>();

	public static DebugTool debugTool;

	@Override
	public void preInit() {
		models.add(debugTool = new DebugTool());
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void clientPreInit() {

	}

	@Override
	public void clientInit() {

	}

	@Override
	public void clientPostInit() {

	}

	@Override
	public ArrayList<ITamModel> getModelList() {
		return models;
	}

	@Override
	public String getModID() {
		return CosmicReality.modid;
	}

}
