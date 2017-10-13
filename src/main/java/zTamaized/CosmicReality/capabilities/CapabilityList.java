package zTamaized.CosmicReality.capabilities;

import zTamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityList {
	
	@CapabilityInject(ICosmicCapability.class)
	public static final Capability<ICosmicCapability> COSMIC = null;

}
