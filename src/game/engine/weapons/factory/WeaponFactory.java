package game.engine.weapons.factory;

import java.io.IOException;
import java.util.HashMap;

import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;

public class WeaponFactory {

	private final HashMap<Integer, WeaponRegistry> weaponShop;

	public WeaponFactory() throws IOException {
		weaponShop = DataLoader.readWeaponRegistry();
	}

	public HashMap<Integer, WeaponRegistry> getWeaponShop() {
		return weaponShop;
	}

	
	public FactoryResponse buyWeapon(int resources, int weaponCode) throws InsufficientResourcesException{
		WeaponRegistry weaponRegistry = weaponShop.get(weaponCode);
		if (weaponRegistry == null) {
			throw new IllegalArgumentException("Invalid Weapon Code");
		}
		if (resources < weaponRegistry.getPrice()) {
			throw new InsufficientResourcesException("Not enough resources", resources);
		}
		
		
		
		int remainingResources = resources - weaponRegistry.getPrice(); 
		Weapon weapon = weaponRegistry.buildWeapon();
		weaponRegistry.buildWeapon();
	
		
	
	return new FactoryResponse(weapon, remainingResources);
}
	
	
	public void addWeaponToShop(int code, int price) {
        weaponShop.put(code, new WeaponRegistry(code, price)); 
    }

	public void addWeaponToShop(int code, int price, int damage, String name) {
        weaponShop.put(code, new WeaponRegistry(code, price, damage, name)); 
    }

	 public void addWeaponToShop(int code, int price, int damage, String name, int minRange, int maxRange) {
	        //WeaponRegistry weapon = new WeaponRegistry(code, price, damage, name, minRange, maxRange);
	        weaponShop.put(code, (new WeaponRegistry(code, price, damage, name, minRange, maxRange)));
	    }
	
}
