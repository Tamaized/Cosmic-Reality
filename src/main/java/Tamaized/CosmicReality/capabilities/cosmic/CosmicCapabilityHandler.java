package Tamaized.CosmicReality.capabilities.cosmic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tamaized.CosmicReality.CosmicReality;
import Tamaized.CosmicReality.entity.EntityPortal;
import Tamaized.TamModized.helper.RayTraceHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class CosmicCapabilityHandler implements ICosmicCapability {

	public static final ResourceLocation ID = new ResourceLocation(CosmicReality.modid, "CosmicCapabilityHandler");

	private final float length = 0.3F;
	private double speed = 0.00125;

	private int tick;
	private Animation animation = Animation.Idle;

	private enum Animation {
		Idle, Portal_Start, Portal_Open
	}

	private List<WingVector> wingList = new ArrayList<WingVector>();

	public ICosmicCapability init() {

		wingList.clear();

		double z = -0.641;

		Random rand = new Random();

		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.35F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-0.7F, 1.35F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.25F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-0.7F, 1.25F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.15F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-0.7F, 1.15F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.05F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-0.7F, 1.05F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(-0.3F, 0.95F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-0.7F, 0.95F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(this, WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		return this;
	}

	private int getRandColor(Random rand) {
		// TODO: allow range to be set
		int uniRand = rand.nextInt(0x22);
		int rangeRA = 0x00 + 1;// 0x00;
		int rangeRB = 0xFF;// 0xFFFFFF/2;
		int rangeGA = 0x00 + 1;
		int rangeGB = 0xA4;// 0xFFFFFF/2;
		int rangeBA = 0x00 + 1;
		int rangeBB = 0xEA;// 0xFFFFFF/2;
		return (MathHelper.clamp(rand.nextInt(rangeRA) + rangeRB + uniRand, 0x00, 0xFF) << 16) + (MathHelper.clamp(rand.nextInt(rangeGA) + rangeGB + uniRand, 0x00, 0xFF) << 8) + MathHelper.clamp(rand.nextInt(rangeBA) + rangeBB + uniRand, 0x00, 0xFF);
	}

	@Override
	public List<WingVector> getWingList() {
		return wingList;
	}

	@Override
	public void update(Entity entity) {
		switch (animation) {
			default:
			case Idle:
				speed = 0.00125;
				tick++;
				if (tick % 30 == 0) {
					if (entity.world.isRemote) for (WingVector vec : wingList)
						if (vec.getParent() != null && Math.floor(Math.random() * 2) == 0) {
							vec.setPoint(new Vec3d((Math.random() * (length * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1))), (Math.random() * (length)), (Math.random() * (-length))));
						}
					tick = 0;
				}
				break;
			case Portal_Start:
				speed = 0.005;
				tick--;
				if (tick <= 0) {
					tick = 20 * 10;
					animation = Animation.Portal_Open;
					if (!entity.world.isRemote) {
						EntityPortal portal = new EntityPortal(entity.world);
						Vec3d pos = new Vec3d(entity.posX, entity.posY, entity.posZ).add(new Vec3d(1, 0, 1).rotateYaw(entity.rotationYaw - 90));
						portal.setLocationAndAngles(pos.xCoord, pos.yCoord, pos.zCoord, entity.rotationYaw + 180, 0);
						entity.world.spawnEntity(portal);
					}
					if (entity.world.isRemote) for (WingVector vec : wingList)
						if (vec.getParent() != null) {
							if (vec.getParent().getParent() == null) {
								vec.setPoint(new Vec3d(0.3 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.3, 0.3));
							} else {
								vec.setPoint(new Vec3d(-0.25 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.0, 0.2));
							}
						}
				}
				break;
			case Portal_Open:
				speed = 0.00125;
				if (entity.world.isRemote) for (WingVector vec : wingList)
					if (vec.getParent() != null) {
						if (vec.getParent().getParent() == null) {
							vec.setPoint(new Vec3d(0.4 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.3, 0.3));
						} else {
							vec.setPoint(new Vec3d(0.25 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.0, 0.2));
						}
					}
				tick--;
				if (tick <= 0) {
					tick = 0;
					animation = Animation.Idle;
				}
				break;
		}
	}

	public static class WingVector {

		public enum Side {
			LEFT, RIGHT
		}

		private final WingVector parent;
		private final Side side;

		private Vec3d point;
		private Vec3d render;
		private int color;
		private final CosmicCapabilityHandler cap;

		public WingVector(CosmicCapabilityHandler cap, Side s, Vec3d vec, WingVector parent, int color) {
			this.cap = cap;
			side = s;
			render = point = vec;
			this.parent = parent;
			this.color = color;
			// System.out.println(Integer.toHexString(color));
		}

		public Side getSide() {
			return side;
		}

		public WingVector getParent() {
			return parent;
		}

		public int getColor() {
			return color;
		}

		public void setPoint(Vec3d vec) {
			point = vec;
		}

		public Vec3d getRenderVector() {
			return parent == null ? render : parent.getRenderVector().add(render);
		}

		public void update() {
			double dx = point.xCoord - render.xCoord;
			double dy = point.yCoord - render.yCoord;
			double dz = point.zCoord - render.zCoord;
			double speed = cap.speed;
			if (dx > speed) dx = speed;
			else if (dx < -speed) dx = -speed;

			if (dy > speed) dy = speed;
			else if (dy < -speed) dy = -speed;

			if (dz > speed) dz = speed;
			else if (dz < -speed) dz = -speed;

			render = render.addVector(dx, dy, dz);
			// render = point;
		}

	}

	@Override
	public void debug() {
		animation = Animation.Portal_Start;
		tick = 20 * 4;
		for (WingVector vec : wingList)
			if (vec.getParent() != null) {
				if (vec.getParent().getParent() == null) {
					vec.setPoint(new Vec3d(0.3 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.3, 0.3));
				} else {
					vec.setPoint(new Vec3d(-0.25 * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1), 0.0, 0.2));
				}
			}
	}

}
