package zTamaized.CosmicReality.event;

import zTamaized.CosmicReality.capabilities.CapabilityList;
import zTamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class PlayerTickEvent {

	@SubscribeEvent
	public void tick(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent e) {

		if (e.phase == Phase.END) {
			EntityPlayer player = e.player;
			ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
			if (cap != null) cap.update(player);
		}

	}

}
