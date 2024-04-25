package game.engine.weapons;

import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.titans.Titan;

public class PiercingCannon extends Weapon {
	public final static int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);
	}
	
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGained = 0;
		ArrayList<Titan> titans = new ArrayList<Titan>(5);
		for(int i=0; i<5 ; i++) {
			if (laneTitans.isEmpty()) {
				break;
			}
			titans.add(laneTitans.poll());
		}
		return resourcesGained ;
	}

}
