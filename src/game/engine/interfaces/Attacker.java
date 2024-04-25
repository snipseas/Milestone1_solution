package game.engine.interfaces;

public interface Attacker {
	int getDamage();
	default int attack(Attackee target) {
  	  int d= this.getDamage();
  	  int r= target.takeDamage(d);
  	  return r;
    }

}
