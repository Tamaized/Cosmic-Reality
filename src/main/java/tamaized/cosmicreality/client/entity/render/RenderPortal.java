package tamaized.cosmicreality.client.entity.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import tamaized.cosmicreality.client.render.RenderMirror;
import tamaized.cosmicreality.common.entity.EntityPortal;

import javax.annotation.Nonnull;

public class RenderPortal<T extends EntityPortal> extends Render<T> {

	private static boolean rendering = false;

	public RenderPortal(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(@Nonnull T entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
if(true)return;
		int quality = 512;

		if (!RenderMirror.hasPortal(entity)) {
			int newTextureId = GL11.glGenTextures();
			GlStateManager.bindTexture(newTextureId);
			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, quality, quality * 2, 0, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, BufferUtils.createByteBuffer(3 * quality * quality));
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			RenderMirror.registerPortal(entity, newTextureId);
			return;
		}

		if (rendering)
			return;
		rendering = true;

		GlStateManager.pushMatrix();
		{
			GlStateManager.disableLighting();
			GlStateManager.bindTexture(RenderMirror.getTextureID(entity));
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(-90F * entity.prevRotationYaw + 180F, 0, 1, 0);
			GlStateManager.translate(-0.5F, 0, 0.35F);
			GlStateManager.glBegin(GL11.GL_QUADS);
			{
				GL11.glTexCoord2d(1, 0);
				GL11.glVertex3d(0, 0, 0);
				GL11.glTexCoord2d(0, 0);
				GL11.glVertex3d(1, 0, 0);
				GL11.glTexCoord2d(0, 1);
				GL11.glVertex3d(1, 2, 0);
				GL11.glTexCoord2d(1, 1);
				GL11.glVertex3d(0, 2, 0);
			}
			GlStateManager.glEnd();
			GlStateManager.enableLighting();
		}
		GlStateManager.popMatrix();
		GlStateManager.enableLighting();

		rendering = false;
	}

	@Override
	protected ResourceLocation getEntityTexture(@Nonnull T entity) {
		return null;
	}

}
