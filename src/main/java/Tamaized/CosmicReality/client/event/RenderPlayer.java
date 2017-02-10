package Tamaized.CosmicReality.client.event;

import org.lwjgl.opengl.GL11;

import Tamaized.CosmicReality.CosmicReality;
import Tamaized.CosmicReality.capabilities.CapabilityList;
import Tamaized.CosmicReality.capabilities.cosmic.CosmicCapabilityHandler;
import Tamaized.CosmicReality.capabilities.cosmic.ICosmicCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderPlayer {
	
	private static ResourceLocation TEXTURE = new ResourceLocation(CosmicReality.modid, "textures/fx/ray.png");

	@SubscribeEvent
	public void render(RenderPlayerEvent.Pre e) {
		float partialTicks = e.getPartialRenderTick();
		EntityPlayer player = e.getEntityPlayer();
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();

//		Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
		
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);

		GlStateManager.rotate(-player.renderYawOffset, 0, 1, 0);
		GL11.glTranslated(-player.posX, -player.posY, -player.posZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
//		player.sendMessage(new TextComponentString(""+(0x000000 >> 16 & 0xFF)));

		ICosmicCapability cap = player.getCapability(CapabilityList.COSMIC, null);
		if (cap != null) {
			for (CosmicCapabilityHandler.WingVector vec : cap.getWingList()) {
				vec.update();
				if (vec.getParent() != null) {
//					player.sendMessage(new TextComponentString(Integer.toHexString(vec.getColor() >> 16 & 0xFF)));
//					GlStateManager.color(((vec.getColor() << 0) & 0xFF) / 255F, ((vec.getColor() << 8) & 0xFF) / 255F, (vec.getColor() & 0xFF) / 255F, 1);
					GlStateManager.color((vec.getColor() >> 16 & 0xFF) / 255F, (vec.getColor() >> 8 & 0xFF) / 255F, (vec.getColor() & 0xFF) / 255F, 1);
					drawLineWithGL(tessellator, vertexbuffer, player.getPositionVector().add(vec.getParent().getRenderVector()), player.getPositionVector().add(vec.getRenderVector()));
				}
			}

		}
		GlStateManager.color(1, 1, 1, 1);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	@SubscribeEvent
	public void render(RenderPlayerEvent.Post e) {

	}

	private void drawLineWithGL(Tessellator tessellator, VertexBuffer vertexbuffer, Vec3d blockA, Vec3d blockB) {
		int d = Math.round((float) blockA.distanceTo(blockB) + 0.2f);
		float oz = (blockA.xCoord - blockB.xCoord == 0 ? 0 : -1f / 16f);
		float ox = (blockA.zCoord - blockB.zCoord == 0 ? 0 : 1f / 16f);
		float size = 0.01F;
		
		GlStateManager.glBegin(3);
		GL11.glVertex3d(blockA.xCoord + 0.5F, blockA.yCoord - 0.01F, blockA.zCoord + 0.5F);
		GL11.glVertex3d(blockB.xCoord + 0.5F, blockB.yCoord - 0.01F, blockB.zCoord + 0.5F);
		GlStateManager.glEnd();

	}

}
