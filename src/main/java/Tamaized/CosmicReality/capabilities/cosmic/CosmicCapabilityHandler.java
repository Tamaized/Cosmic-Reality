package Tamaized.CosmicReality.capabilities.cosmic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tamaized.CosmicReality.CosmicReality;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class CosmicCapabilityHandler implements ICosmicCapability {

	public static final ResourceLocation ID = new ResourceLocation(CosmicReality.modid, "CosmicCapabilityHandler");

	private final float length = 0.3F;

	private int tick;

	private List<WingVector> wingList = new ArrayList<WingVector>();

	public ICosmicCapability init() {

		wingList.clear();

		double z = -0.641;

		Random rand = new Random();
		
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.35F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-0.7F, 1.35F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.25F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-0.7F, 1.25F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.15F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-0.7F, 1.15F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(-0.3F, 1.05F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-0.7F, 1.05F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(-0.3F, 0.95F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.RIGHT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-0.7F, 0.95F, z), null, getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, length, -length), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(-length, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));
		wingList.add(new WingVector(WingVector.Side.LEFT, new Vec3d(0, -length, 0), wingList.get(wingList.size() - 1), getRandColor(rand)));

		return this;
	}

	private int getRandColor(Random rand) {
		//TODO: allow range to be set
		int rangeRA = 0x00 + 1;// 0x00;
		int rangeRB = 0x00;// 0xFFFFFF/2;
		int rangeGA = 0xFF + 1;
		int rangeGB = 0x00;// 0xFFFFFF/2;
		int rangeBA = 0x00 + 1;
		int rangeBB = 0xFF;// 0xFFFFFF/2;
		return ((rand.nextInt(rangeRA) + rangeRB) << 16) + ((rand.nextInt(rangeGA) + rangeGB) << 8) + (rand.nextInt(rangeBA) + rangeBB);
	}

	@Override
	public List<WingVector> getWingList() {
		return wingList;
	}

	@Override
	public void update() {
		tick++;
		if (tick % 30 == 0) {
			for (WingVector vec : wingList)
				if (vec.getParent() != null && Math.floor(Math.random() * 2) == 0) {
					vec.setPoint(new Vec3d((Math.random() * (length * (vec.getSide() == WingVector.Side.LEFT ? -1 : 1))), (Math.random() * (length)), (Math.random() * (-length))));
				}
			tick = 0;
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

		public WingVector(Side s, Vec3d vec, WingVector parent, int color) {
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

			double maxDist = 0.00125;

			if (dx > maxDist) dx = maxDist;
			else if (dx < -maxDist) dx = -maxDist;

			if (dy > maxDist) dy = maxDist;
			else if (dy < -maxDist) dy = -maxDist;

			if (dz > maxDist) dz = maxDist;
			else if (dz < -maxDist) dz = -maxDist;

			render = render.addVector(dx, dy, dz);
			// render = point;
		}

	}

}
