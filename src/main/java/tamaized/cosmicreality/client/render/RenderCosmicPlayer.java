package tamaized.cosmicreality.client.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;
import tamaized.cosmicreality.CosmicReality;
import tamaized.cosmicreality.common.capabilities.CapabilityList;
import tamaized.cosmicreality.common.capabilities.cosmic.ICosmicCapability;

@Mod.EventBusSubscriber(modid = CosmicReality.modid, value = Side.CLIENT)
public class RenderCosmicPlayer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(CosmicReality.modid, "textures/fx/ray.png");

	@SubscribeEvent
	public static void render(RenderPlayerEvent.Pre e) {
		float partialTicks = e.getPartialRenderTick();
		EntityPlayer player = e.getEntityPlayer();
		if (!player.hasCapability(CapabilityList.COSMIC, null))
			return;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();

		// Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

		GlStateManager.pushMatrix();

		//		GlStateManager.rotate(-player.renderYawOffset, 0, 1, 0);
		GlStateManager.translate(-player.posX, -player.posY, -player.posZ);
		//		GL11.glDisable(GL11.GL_LIGHTING);
		//		GL11.glDisable(GL11.GL_TEXTURE_2D);


		ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
		if (cap != null) {
			player.sendStatusMessage(new TextComponentString(cap.getTest(0)+" : "+cap.getTest(1)+" : "+cap.getTest(2)+" : "+cap.getTest(3)), true);
			/*for (CosmicCapabilityHandler.WingVector vec : cap.getWingList()) {
				if (!Minecraft.getMinecraft().isGamePaused())
					vec.update();
				if (vec.getParent() != null) {
					// player.sendMessage(new TextComponentString(Integer.toHexString(vec.getColor() >> 16 & 0xFF)));
					// GlStateManager.color(((vec.getColor() << 0) & 0xFF) / 255F, ((vec.getColor() << 8) & 0xFF) / 255F, (vec.getColor() & 0xFF) / 255F, 1);
					GlStateManager.color((vec.getColor() >> 16 & 0xFF) / 255F, (vec.getColor() >> 8 & 0xFF) / 255F, (vec.getColor() & 0xFF) / 255F, 1);
					drawLineWithGL(tessellator, vertexbuffer, player.getPositionVector().add(vec.getParent().getRenderVector()), player.getPositionVector().add(vec.getRenderVector()));
				}
			}*/

		}
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.popMatrix();
	}

	@SubscribeEvent
	public static void render(RenderPlayerEvent.Post e) {

	}

	private static void drawLineWithGL(Tessellator tessellator, BufferBuilder vertexbuffer, Vec3d blockA, Vec3d blockB) {
		int d = Math.round((float) blockA.distanceTo(blockB) + 0.2f);
		float oz = (blockA.x - blockB.x == 0 ? 0 : -1f / 16f);
		float ox = (blockA.z - blockB.z == 0 ? 0 : 1f / 16f);
		float size = 0.01F;

		GlStateManager.glBegin(3);
		GL11.glVertex3d(blockA.x + 0.5F, blockA.y - 0.01F, blockA.z + 0.5F);
		GL11.glVertex3d(blockB.x + 0.5F, blockB.y - 0.01F, blockB.z + 0.5F);
		GlStateManager.glEnd();

	}

}
