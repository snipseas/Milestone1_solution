package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class WallTrap extends Weapon {
	public final static int WEAPON_CODE = 4;

	public WallTrap(int baseDamage) {
		super(baseDamage);
	}
	
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGained=0;
		if (laneTitans.peek().hasReachedTarget()) {
			resourcesGained = laneTitans.peek().takeDamage(getDamage());
			laneTitans.removeIf(Titan->Titan.isDefeated());
		}
		return resourcesGained;
	}

}
