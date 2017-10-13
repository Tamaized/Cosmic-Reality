package Tamaized.CosmicReality.registry;

import java.util.ArrayList;

import Tamaized.CosmicReality.CosmicReality;
import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs implements ITamRegistry {

	public static CreativeTabs tab;

	@Override
	public void preInit() {
		tab = new CreativeTabs("tabCosmic") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Items.ENDER_EYE);
			}
		};
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
		return new ArrayList<ITamModel>();
	}

	@Override
	public String getModID() {
		return CosmicReality.modid;
	}

}
