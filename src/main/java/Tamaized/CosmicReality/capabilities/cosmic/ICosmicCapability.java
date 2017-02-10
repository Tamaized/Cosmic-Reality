package Tamaized.CosmicReality.capabilities.cosmic;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface ICosmicCapability {
	
	ICosmicCapability init();
	
	void update();
	
	List<CosmicCapabilityHandler.WingVector> getWingList();

}
