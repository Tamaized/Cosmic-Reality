package Tamaized.CosmicReality.client.event;

import org.lwjgl.opengl.GL11;

import Tamaized.CosmicReality.capabilities.CapabilityList;
import Tamaized.CosmicReality.capabilities.cosmic.CosmicCapabilityHandler;
import Tamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderPlayer {

	@SubscribeEvent
	public void render(RenderPlayerEvent.Pre e) {
		float partialTicks = e.getPartialRenderTick();
		EntityPlayer player = e.getEntityPlayer();
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();

		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);

		GlStateManager.rotate(-player.prevRenderYawOffset, 0, 1, 0);
		GL11.glTranslated(-player.posX, -player.posY, -player.posZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);

		ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
		if (cap != null) {
			/*
			 * Vec3d pos7_1 = player.getPositionVector().addVector(-0.3F, 0.75F, -0.39); Vec3d pos7_2 = pos7_1.addVector(length, length, length); Vec3d pos7_3 = pos7_2.addVector(length, -length, 0); Vec3d pos7_4 = pos7_3.addVector(0, -length, 0); Vec3d pos8_1 = player.getPositionVector().addVector(-0.7F, 0.75F, -0.39); Vec3d pos8_2 = pos8_1.addVector(-length, length, length); Vec3d pos8_3 = pos8_2.addVector(-length, -length, 0); Vec3d pos8_4 = pos8_3.addVector(0, -length, 0);
			 */

			for (CosmicCapabilityHandler.WingVector vec : cap.getWingList()) {
				vec.update();
				if (vec.getParent() != null){
					
					drawLineWithGL(player.getPositionVector().add(vec.getParent().getRenderVector()), player.getPositionVector().add(vec.getRenderVector()));
				}
			}

		}
		/*
		 * drawLineWithGL(pos7_1, pos7_2); drawLineWithGL(pos7_2, pos7_3); drawLineWithGL(pos7_3, pos7_4); drawLineWithGL(pos8_1, pos8_2); drawLineWithGL(pos8_2, pos8_3); drawLineWithGL(pos8_3, pos8_4);
		 */
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	@SubscribeEvent
	public void render(RenderPlayerEvent.Post e) {

	}

	private void drawLineWithGL(Vec3d blockA, Vec3d blockB) {
		int d = Math.round((float) blockA.distanceTo(blockB) + 0.2f);
		float oz = (blockA.xCoord - blockB.xCoord == 0 ? 0 : -1f / 16f);
		float ox = (blockA.zCoord - blockB.zCoord == 0 ? 0 : 1f / 16f);
		GL11.glBegin(GL11.GL_LINE_STRIP);

		GlStateManager.color(1, 0, 0, 1);
		GL11.glVertex3d(blockA.xCoord + 0.5, blockA.yCoord - 0.01, blockA.zCoord + 0.5);
		GlStateManager.color(0, 0, 1, 1);
		GL11.glVertex3d(blockB.xCoord + 0.5, blockB.yCoord - 0.01, blockB.zCoord + 0.5);

		GL11.glEnd();
	}

}
