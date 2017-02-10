package Tamaized.CosmicReality.capabilities;

import Tamaized.CosmicReality.capabilities.cosmic.CosmicCapabilityHandler;
import Tamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AttachCapabilityEvent {

	@SubscribeEvent
	public void attach(AttachCapabilitiesEvent.Entity e) {
		if(e.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) e.getEntity();
			e.addCapability(CosmicCapabilityHandler.ID, new ICapabilitySerializable<NBTTagCompound>() {

				ICosmicCapability inst = CapabilityList.COSMIC.getDefaultInstance().init();

				@Override
				public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
					return capability == CapabilityList.COSMIC;
				}

				@Override
				public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
					return capability == CapabilityList.COSMIC ? CapabilityList.COSMIC.<T> cast(inst) : null;
				}

				@Override
				public NBTTagCompound serializeNBT() {
					return (NBTTagCompound) CapabilityList.COSMIC.getStorage().writeNBT(CapabilityList.COSMIC, inst, null);
				}

				@Override
				public void deserializeNBT(NBTTagCompound nbt) {
					CapabilityList.COSMIC.getStorage().readNBT(CapabilityList.COSMIC, inst, null, nbt);
				}
				
			});
		}
		
	}

}
