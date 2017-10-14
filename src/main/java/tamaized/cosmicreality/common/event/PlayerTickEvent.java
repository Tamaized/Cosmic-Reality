package tamaized.cosmicreality.common.event;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import tamaized.cosmicreality.CosmicReality;
import tamaized.cosmicreality.common.capabilities.CapabilityList;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;

@Mod.EventBusSubscriber(modid = CosmicReality.modid)
public class PlayerTickEvent {

	@SubscribeEvent
	public static void tick(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent e) {
		if (e.phase == TickEvent.Phase.START)
			return;
		EntityPlayer player = e.player;
		if (!player.hasCapability(CapabilityList.COSMIC, null))
			return;
		ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
		if (cap != null)
			cap.update(player);
	}

}
