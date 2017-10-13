package zTamaized.CosmicReality.capabilities.cosmic;

import java.util.List;

import net.minecraft.entity.Entity;

public interface ICosmicCapability {
	
	ICosmicCapability init();
	
	void update(Entity entity);
	
	List<CosmicCapabilityHandler.WingVector> getWingList();
	
	void debug();

}
