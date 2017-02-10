package Tamaized.CosmicReality.capabilities.cosmic;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CosmicCapabilityStorage implements IStorage<ICosmicCapability> {

	@Override
	public NBTBase writeNBT(Capability<ICosmicCapability> capability, ICosmicCapability instance, EnumFacing side) {
		return new NBTTagCompound();
	}

	@Override
	public void readNBT(Capability<ICosmicCapability> capability, ICosmicCapability instance, EnumFacing side, NBTBase nbt) {

	}

}
