package tamaized.cosmicreality.common.event;

import tamaized.cosmicreality.common.capabilities.CapabilityList;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;
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
