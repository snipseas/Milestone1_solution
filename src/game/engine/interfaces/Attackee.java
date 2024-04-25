package game.engine.interfaces;

public interface Attackee {
	
	int getCurrentHealth();
	void setCurrentHealth(int health);
	int getResourcesValue();
	
	
	public default boolean isDefeated() {
		if(getCurrentHealth() <= 0) {
			return true;
		} else {
			return false;
		}
		
	};

	 public default int takeDamage(int damage) {
		    int currentHealth = getCurrentHealth();
	    currentHealth -= damage;
	    this.setCurrentHealth(currentHealth);
	    if (isDefeated()) {
	    	return this.getResourcesValue();
	       
	    }
	    return 0;
	}



}
