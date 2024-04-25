package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class SniperCannon extends Weapon {
	public final static int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGained = 0;
		Titan titan = laneTitans.poll();
		if (titan != null) {
			titan.takeDamage(getDamage());
			if (titan.isDefeated()) {
				resourcesGained = titan.getResourcesValue();
			}
		}
		return resourcesGained;
	}
}
