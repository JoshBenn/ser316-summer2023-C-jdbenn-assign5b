package org.example;

import java.util.Random;

/**
 * Parent class for Armor items.
 */
public class Armor {
    private final double accuracy, penetration;
    private final String weaponType;

    /**
     * General constructor.
     * @param accuracy double accuracy value
     * @param penetration double penetration value
     * @param gameState String[] containing the state of hte game
     */
    public Armor(double accuracy, double penetration, String[] gameState) {
        int floorNumber = Integer.parseInt(gameState[5]);
        this.accuracy = floorNumber/5 + accuracy;
        this.penetration = floorNumber/5 + penetration;
        //set weapon type
        if(gameState[0].equals("3")) {
            Random random = new Random();
            int choice = random.nextInt(2);
            this.weaponType = (choice < 1) ? "Physical" : "Magic";
        }
        else
            this.weaponType = gameState[1];
    }

    /**
     * For getting the accuracy of the item.
     * @return double accuracy value
     */
    public double getAccuracy() { return this.accuracy; }

    /**
     * For getting the penetration value of the item.
     * @return double penetration value
     */
    public double getPenetration() { return this.penetration; }

    /**
     * For getting the weapon type of the item.
     * @return String type of the weapon
     */
    public String getWeaponType() { return this.weaponType; }

    /**
     * Prints an image of the item (weapon).
     * @return String of characters
     */
    public String getImage() { return null; }
}
