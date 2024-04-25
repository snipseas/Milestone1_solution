package game.engine.weapons;

import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class VolleySpreadCannon extends Weapon {
	public final static int WEAPON_CODE = 3;
	private final int minRange;
	private final int maxRange;

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public VolleySpreadCannon(int baseDamage, int minRange, int maxRange) {
		super(baseDamage);
		this.maxRange = maxRange;
		this.minRange = minRange;
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGained = 0;
		ArrayList<Titan> defeatedTitans = new ArrayList<Titan>();
		for (Titan titan : laneTitans) {
			if (titan.getDistance() >= minRange && titan.getDistance() <= maxRange) {
				resourcesGained += titan.takeDamage(getDamage());
				if (titan.isDefeated()) {
					defeatedTitans.add(titan);
				}
			}
		}
		laneTitans.removeAll(defeatedTitans);
		return resourcesGained;
	}
}
