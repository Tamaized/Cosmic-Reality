package tamaized.cosmicreality.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;

public class CapabilityList {

	@CapabilityInject(ICosmicCapability.class)
	public static final Capability<ICosmicCapability> COSMIC;

	static {
		COSMIC = null;
	}

}
