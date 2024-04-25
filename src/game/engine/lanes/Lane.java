package game.engine.lanes;

import java.util.*;

import game.engine.base.Wall;
import game.engine.titans.Titan;
import game.engine.weapons.Weapon;

public class Lane implements Comparable<Lane> {

	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;
	private final Wall laneWall;
	private int dangerLevel;

	public Lane(Wall laneWall) {
		this.laneWall = laneWall;
		titans = new PriorityQueue<Titan>();
		weapons = new ArrayList<Weapon>();
		dangerLevel = 0;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public Wall getLaneWall() {
		return laneWall;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	@Override
	public int compareTo(Lane L) {

		return this.dangerLevel - L.dangerLevel;
	}

	
	
	public void addTitan(Titan titan) {
		titans.add(titan);
	}
	
	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
	}
	
	public void moveLaneTitans() {
		for (Titan titan : titans) {
            titan.move();
        }
    }
	
	public int performLaneTitansAttack() {
        int resourcesValue = 0 ;
		int totalDamage = getDamage();
		for(Titan titan : titans) {
			totalDamage += titan.attack(titan);
        	if (totalDamage == 0) {
        		break;//priorityqueue -> use any kind of loop
        }

		return resourcesValue;}
		return totalDamage;
    }	
	
	private int getDamage() {
		// TODO Auto-generated method stub
		return getDamage();
	}


	public int performLaneWeaponsAttacks() {
		return 0;
	}
	
	
	 public boolean isLaneLost() {
		 if (titans.isEmpty()) {
            return true;
        }else {
        	return false;
        }
	 }
	 
	 public boolean isLaneWon() {
         if (laneWall.getCurrentHealth() <= 0) {
            return true;
        }else {
        	return false;
        }
     }
	 
		public void updateLaneDangerLevel() {
			int dangerLevel = 0;
			for (Titan titan : titans) {
				dangerLevel += titan.getDangerLevel();
			}
			this.dangerLevel = dangerLevel;
		}
		public int performLaneTitansAttacks() {
			
			return dangerLevel;
			
		}

		public boolean isActive() {
			// TODO Auto-generated method stub
			return false;
		}
}
