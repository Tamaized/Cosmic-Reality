package Tamaized.CosmicReality.client.event;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import Tamaized.TamModized.TamModized;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderPlayer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(TamModized.modid, "textures/particles/fluff.png");
	private static final Random rand = new Random();

	@SubscribeEvent
	public void render(RenderPlayerEvent.Pre e) {
		float partialTicks = e.getPartialRenderTick();
		EntityPlayer player = e.getEntityPlayer();
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();
		Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		// because of the way 3D rendering is done, all coordinates are relative to the camera. This "resets" the "0,0,0" position to the location that is (0,0,0) in the world.
		GlStateManager.rotate(-player.prevRenderYawOffset + 180, 0, 1, 0);
		GL11.glTranslated(-player.posX, -player.posY, -player.posZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		// you will need to supply your own position vectors

		float length = 0.3F;
		
		Vec3d pos1_1 = player.getPositionVector().addVector(-0.3F, 1.35F, -0.39);
		Vec3d pos1_2 = pos1_1.addVector(length, length, length);
		Vec3d pos1_3 = pos1_2.addVector(length, -length, 0);
		Vec3d pos1_4 = pos1_3.addVector(0, -length, 0);
		
		Vec3d pos2_1 = player.getPositionVector().addVector(-0.7F, 1.35F, -0.39);
		Vec3d pos2_2 = pos2_1.addVector(-length, length, length);
		Vec3d pos2_3 = pos2_2.addVector(-length, -length, 0);
		Vec3d pos2_4 = pos2_3.addVector(0, -length, 0);
		
		Vec3d pos3_1 = player.getPositionVector().addVector(-0.3F, 1.15F, -0.39);
		Vec3d pos3_2 = pos3_1.addVector(length, length, length);
		Vec3d pos3_3 = pos3_2.addVector(length, -length, 0);
		Vec3d pos3_4 = pos3_3.addVector(0, -length, 0);
		
		Vec3d pos4_1 = player.getPositionVector().addVector(-0.7F, 1.15F, -0.39);
		Vec3d pos4_2 = pos4_1.addVector(-length, length, length);
		Vec3d pos4_3 = pos4_2.addVector(-length, -length, 0);
		Vec3d pos4_4 = pos4_3.addVector(0, -length, 0);
		
		Vec3d pos5_1 = player.getPositionVector().addVector(-0.3F, 0.95F, -0.39);
		Vec3d pos5_2 = pos5_1.addVector(length, length, length);
		Vec3d pos5_3 = pos5_2.addVector(length, -length, 0);
		Vec3d pos5_4 = pos5_3.addVector(0, -length, 0);
		
		Vec3d pos6_1 = player.getPositionVector().addVector(-0.7F, 0.95F, -0.39);
		Vec3d pos6_2 = pos6_1.addVector(-length, length, length);
		Vec3d pos6_3 = pos6_2.addVector(-length, -length, 0);
		Vec3d pos6_4 = pos6_3.addVector(0, -length, 0);
		/*
		Vec3d pos7_1 = player.getPositionVector().addVector(-0.3F, 0.75F, -0.39);
		Vec3d pos7_2 = pos7_1.addVector(length, length, length);
		Vec3d pos7_3 = pos7_2.addVector(length, -length, 0);
		Vec3d pos7_4 = pos7_3.addVector(0, -length, 0);
		
		Vec3d pos8_1 = player.getPositionVector().addVector(-0.7F, 0.75F, -0.39);
		Vec3d pos8_2 = pos8_1.addVector(-length, length, length);
		Vec3d pos8_3 = pos8_2.addVector(-length, -length, 0);
		Vec3d pos8_4 = pos8_3.addVector(0, -length, 0);
		*/
		drawLineWithGL(pos1_1, pos1_2);
		drawLineWithGL(pos1_2, pos1_3);
		drawLineWithGL(pos1_3, pos1_4);
		
		drawLineWithGL(pos2_1, pos2_2);
		drawLineWithGL(pos2_2, pos2_3);
		drawLineWithGL(pos2_3, pos2_4);
		
		drawLineWithGL(pos3_1, pos3_2);
		drawLineWithGL(pos3_2, pos3_3);
		drawLineWithGL(pos3_3, pos3_4);
		
		drawLineWithGL(pos4_1, pos4_2);
		drawLineWithGL(pos4_2, pos4_3);
		drawLineWithGL(pos4_3, pos4_4);
		
		drawLineWithGL(pos5_1, pos5_2);
		drawLineWithGL(pos5_2, pos5_3);
		drawLineWithGL(pos5_3, pos5_4);
		
		drawLineWithGL(pos6_1, pos6_2);
		drawLineWithGL(pos6_2, pos6_3);
		drawLineWithGL(pos6_3, pos6_4);
		/*
		drawLineWithGL(pos7_1, pos7_2);
		drawLineWithGL(pos7_2, pos7_3);
		drawLineWithGL(pos7_3, pos7_4);
		
		drawLineWithGL(pos8_1, pos8_2);
		drawLineWithGL(pos8_2, pos8_3);
		drawLineWithGL(pos8_3, pos8_4);
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

		GL11.glColor3f(1, 0, 0);

		GL11.glVertex3d(blockA.xCoord + 0.5, blockA.yCoord - 0.01, blockA.zCoord + 0.5);
		GL11.glVertex3d(blockB.xCoord + 0.5, blockB.yCoord - 0.01, blockB.zCoord + 0.5);

		GL11.glEnd();
	}

	private int getBrightnessForRender(World world, double x, double y, double z, float p_70070_1_) {
		float f1 = 1.0f;

		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f1 > 1.0F) {
			f1 = 1.0F;
		}
		f1 = 1.0f;

		BlockPos blockpos = new BlockPos(x, y, z);
		int i = world == null ? 0 : world.isBlockLoaded(blockpos) ? world.getCombinedLight(blockpos, 0) : 0;
		int j = i & 255;
		int k = i >> 16 & 255;
		j += (int) (f1 * 15.0F * 16.0F);

		if (j > 240) {
			j = 240;
		}

		return j | k << 16;
	}

}
