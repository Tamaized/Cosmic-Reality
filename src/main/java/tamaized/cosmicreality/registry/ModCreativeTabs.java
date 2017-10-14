package tamaized.cosmicreality.registry;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs {

	public static CreativeTabs tab = new CreativeTabs("tabCosmic") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.ENDER_EYE);
		}
	};

}
