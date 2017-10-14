package tamaized.cosmicreality.client.render;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;
import tamaized.cosmicreality.CosmicReality;
import tamaized.cosmicreality.common.entity.EntityPortal;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Mod.EventBusSubscriber(modid = CosmicReality.modid, value = Side.CLIENT)
public class RenderMirror {

	private static Minecraft mc;
	private static Map<EntityPortal, Integer> portals = Maps.newHashMap();
	private static List<EntityPortal> remove = Lists.newArrayList();
	private static RenderGlobal globalRenderer;

	public static void registerPortal(EntityPortal portal, int newTextureId) {
		portals.put(portal, newTextureId);
	}

	public static void remove(EntityPortal portal) {
		remove.add(portal);
	}

	public static boolean hasPortal(EntityPortal entity) {
		return portals.containsKey(entity);
	}

	public static int getTextureID(EntityPortal portal) {
		return portals.get(portal);
	}

	@SubscribeEvent
	public static void onTick(TickEvent.RenderTickEvent event) {
		if (mc == null)
			mc = Minecraft.getMinecraft();
		if (globalRenderer == null)
			globalRenderer = new RenderGlobal(mc);
		if (event.phase.equals(TickEvent.Phase.END))
			return;

		if (!remove.isEmpty()) {
			for (EntityPortal portal : remove) {
				if (!portals.containsKey(portal))
					continue;
				GlStateManager.deleteTexture(portals.get(portal));
				portals.remove(portal);
			}
			remove.clear();
		}

		if (mc.inGameHasFocus) {
			for (Entry<EntityPortal, Integer> entry : portals.entrySet()) {
				EntityPortal entity = entry.getKey();
				int textureID = entry.getValue();

				if (entity.isDead) {
					remove(entity);
					continue;
				}

				// if (!entity.rendering) continue;

				if (!mc.player.canEntityBeSeen(entity))
					continue;

				if (entity.getDistanceToEntity(mc.player) < 25) {
					GameSettings settings = mc.gameSettings;
					//					RenderGlobal renderBackup = mc.renderGlobal;
					Entity entityBackup = mc.getRenderViewEntity();
					int thirdPersonBackup = settings.thirdPersonView;
					boolean hideGuiBackup = settings.hideGUI;
					int mipmapBackup = settings.mipmapLevels;
					float fovBackup = settings.fovSetting;
					int widthBackup = mc.displayWidth;
					int heightBackup = mc.displayHeight;
					int quality = 512;

					//					 globalRenderer.setWorldAndLoadRenderers(mc.world);
					//					mc.renderGlobal = globalRenderer;
					mc.setRenderViewEntity(entity);
					settings.thirdPersonView = 0;
					settings.hideGUI = true;
					settings.mipmapLevels = 0;
					mc.displayWidth = quality;
					mc.displayHeight = quality * 2;

					int fps = Math.max(30, settings.limitFramerate);
					EntityRenderer entityRenderer = mc.entityRenderer;
					entityRenderer.renderWorld(event.renderTickTime, System.nanoTime() + (1000000000 / fps));

					GlStateManager.bindTexture(textureID);
					GL11.glCopyTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, 0, 0, quality, quality * 2, 0);

					//					mc.renderGlobal = renderBackup;
					//noinspection ConstantConditions
					mc.setRenderViewEntity(entityBackup);
					settings.fovSetting = fovBackup;
					settings.thirdPersonView = thirdPersonBackup;
					settings.hideGUI = hideGuiBackup;
					settings.mipmapLevels = mipmapBackup;
					mc.displayWidth = widthBackup;
					mc.displayHeight = heightBackup;
				}

			}
		}
	}

}
