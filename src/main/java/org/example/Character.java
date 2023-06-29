package org.example;

import java.util.Random;

public class Character {
    //Damage is calculated as potency*(potency+penetration) with an accuracy(100)% chance of hitting
    private double accuracy, penetration, potency;
    private int health, experience, level;
    private final String damageType, characterNumber;

    public Character(double accuracy, double penetration, double potency, String damageType, String characterNumber) {
        this.accuracy = accuracy;
        this.penetration = penetration;
        this.potency = potency;
        this.level = 1;
        this.experience = 0;
        setHealth();
        this.damageType = damageType;
        this.characterNumber = characterNumber;
    }

    /**
     * getAccuracy returns accuracy of character class.
     * @return accuracy
     */
    public double getAccuracy() {return this.accuracy;}

    /**
     * getPenetration returns penetration of character class.
     * @return penetration
     */
    public double getPenetration() {return this.penetration;}

    /**
     * getPotency returns the potency of character class.
     * @return potency
     */
    public double getPotency() {return this.potency;}

    /**
     * setHealth sets the health value based on the current level.
     */
    public void setHealth() {this.health = 10*this.level;}

    /**
     * Changes the health value based on input.
     * @param modifier either damage done or health received
     */
    public void setHealth(int modifier) {this.health += modifier;}

    public void setEnemyHealth(int floorValue) {this.health = 2*floorValue;}

    public void setEnemyAccuracy(int floorNumber) {this.accuracy = floorNumber/100;}

    /**
     * Gets the health value of the character.
     * @return int health
     */
    public int getHealth() {return this.health;}

    public void gainExperience(int experience) {this.experience += experience;}

    public int getExperience() {return this.experience;}

    public void setLevel() {
        while(this.experience > 100*this.level) {
            this.experience -= 100*this.level;
            this.level++;
        }
    }

    public int doDamage(String[] gameState) {
        //initiate the main calculations
        double accuracy = this.accuracy;
        double penetration = this.penetration;
        //get the info from the current state of the game
        for(int i = 9; i < gameState.length-1; i++) {
            String[] armorStats = gameState[i].split("|");
            accuracy += Double.valueOf(armorStats[0]);
            penetration += Double.valueOf(armorStats[2]);
        }
        //Accuracy check
        Random random = new Random();
        accuracy = 100-accuracy*100;
        int chance = random.nextInt(100)+1;
        //Return 0 if missed
        if(chance < accuracy)
            return 0;

        return (int) Math.ceil(penetration*this.potency);
    }

    public int getLevel() {return this.level;}


    /**
     * getCharacterNumber returns the id number of the character class.
     * @return 1 for cat
     */
    public String getCharacterNumber() {return characterNumber;}


    /**
     * getDamageType returns the damage type of the character class.
     * @return damageType
     */
    public String getDamageType() {return this.damageType;}

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    public String getImage() {  return null;  }
    public String getEnemyImage() {return null;}
}
