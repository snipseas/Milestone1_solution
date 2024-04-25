package game.engine.titans;

public class ColossalTitan extends Titan {
	public final static int TITAN_CODE = 4;

	public ColossalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}

	
	public void setDistance(int distance) {
        super.setDistance(distance);
        super.setSpeed(getSpeed() + 1);
   }
	
	public boolean move() {
		return super.move();
	}
}
