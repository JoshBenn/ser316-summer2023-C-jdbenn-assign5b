package org.rpgMain.Armor;

import org.rpgMain.Armor.Armor;

/**
 * Armor child class.
 * Weapon item.
 */
public class Weapon extends Armor {
    public Weapon(String[] gameState) {
        super(0.05, 0.01, gameState);
    }

    /**
     * Provides an image of the weapon received.
     * @return ascii image
     */
    @Override
    public String getImage() {
        if(super.getWeaponType().equals("Physical"))
            return "-|====>";
        else
            return "----*";
    }
}
