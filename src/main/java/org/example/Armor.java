package org.example;

import java.util.Random;

public class Armor {
    private final double accuracy, penetration;
    private final String weaponType;


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

    public double getAccuracy() {return this.accuracy;}

    public double getPenetration() {return this.penetration;}

    public String getWeaponType() {return this.weaponType;}

    public String getImage() { return null; }
}
