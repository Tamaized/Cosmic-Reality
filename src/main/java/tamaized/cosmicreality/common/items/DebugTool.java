package tamaized.cosmicreality.common.items;

import tamaized.cosmicreality.common.capabilities.CapabilityList;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;
import tamaized.cosmicreality.registry.ModCreativeTabs;
import Tamaized.TamModized.items.TamItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class DebugTool extends TamItem {

	public DebugTool() {
		super(ModCreativeTabs.tab, "debugtool", 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
		if (cap != null) {
			cap.debug();
		}
		return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

}
