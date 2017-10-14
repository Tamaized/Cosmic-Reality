package tamaized.cosmicreality.common.capabilities;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tamaized.cosmicreality.CosmicReality;
import tamaized.cosmicreality.common.capabilities.cosmic.CosmicCapabilityHandler;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = CosmicReality.modid)
public class CapabilityAttachment {

	@SubscribeEvent
	public static void attach(AttachCapabilitiesEvent<Entity> e) {
		if (!(e.getObject() instanceof EntityPlayer))
			return;
		e.addCapability(CosmicCapabilityHandler.ID, new ICapabilitySerializable<NBTTagCompound>() {

			ICosmicCapability inst = CapabilityList.COSMIC.getDefaultInstance();

			@Override
			public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
				return capability == CapabilityList.COSMIC;
			}

			@Override
			public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
				return capability == CapabilityList.COSMIC ? CapabilityList.COSMIC.<T>cast(inst) : null;
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
