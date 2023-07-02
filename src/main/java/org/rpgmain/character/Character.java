package org.rpgmain.character;

import java.util.Random;

/**
 * General parent character class.
 */
public class Character {
    //Damage is calculated as potency*(potency+penetration) with an accuracy(100)% chance of hitting
    private double accuracy;
    private double penetration;
    private double potency;
    private int health;
    private int experience;
    private int level;
    private final String damageType;
    private final String characterNumber;

    /**
     * General constructor for the character class.
     * @param accuracy double base accuracy
     * @param penetration double base penetration
     * @param potency double base potency
     * @param damageType String "Physical", "Magic", "Either"
     * @param characterNumber (1) Cat, (2) Demon, (3) Human
     */
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
    public double getAccuracy() {
        return this.accuracy;
    }

    /**
     * getPenetration returns penetration of character class.
     * @return penetration
     */
    public double getPenetration() {
        return this.penetration;
    }

    /**
     * getPotency returns the potency of character class.
     * @return potency
     */
    public double getPotency() {
        return this.potency;
    }

    /**
     * setHealth sets the health value based on the current level.
     */
    public void setHealth() {
        this.health = 10 * this.level;
    }

    /**
     * Changes the health value based on input.
     * @param modifier either damage done or health received
     */
    public void setHealth(int modifier) {
        this.health += modifier;
    }

    /**
     * Sets the health value based on the floor for enemies.
     * @param floorValue int floorType*floorNumber
     */
    public void setEnemyHealth(int floorValue) {
        this.health = 2 * floorValue;
    }

    /**
     * Sets the accuracy value based on the floor for enemies.
     * @param floorNumber level of floor in the tower
     */
    public void setEnemyAccuracy(int floorNumber) {
        this.accuracy = floorNumber / 100;
    }

    /**
     * Gets the health value of the character.
     * @return int health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Increases the experience value by some amount.
     * @param experience experience value to increase
     */
    public void gainExperience(int experience) {
        this.experience += experience;
    }

    /**
     * Provies the current experience value the character has.
     * @return int experience
     */
    public int getExperience() {
        return this.experience;
    }

    /**
     * Changes the level of the character based on the experience gained.
     */
    public void setLevel() {
        while (this.experience > 100 * this.level) {
            this.experience -= 100 * this.level;
            this.level++;
        }
    }

    /**
     * Calculates the damage output from the character.
     * @param gameState state of the game
     * @return int damage
     */
    public int doDamage(String[] gameState) {
        //initiate the main calculations
        double accuracy = this.accuracy;
        double penetration = this.penetration;
        //get the info from the current state of the game
        for (int i = 9; i < gameState.length - 1; i++) {
            String[] armorStats = gameState[i].split("|");
            accuracy += Double.valueOf(armorStats[0]);
            penetration += Double.valueOf(armorStats[2]);
        }
        //Accuracy check
        Random random = new Random();
        accuracy = 100 - accuracy * 100;
        int chance = random.nextInt(100) + 1;
        //Return 0 if missed
        if (chance < accuracy)
            return 0;

        return (int) Math.ceil(penetration * this.potency);
    }

    /**
     * Provides the level of the character.
     * @return character level
     */
    public int getLevel() {
        return this.level;
    }


    /**
     * getCharacterNumber returns the id number of the character class.
     * @return 1 for cat
     */
    public String getCharacterNumber() {
        return characterNumber;
    }


    /**
     * getDamageType returns the damage type of the character class.
     * @return damageType
     */
    public String getDamageType() {
        return this.damageType;
    }

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    public String getImage() {
        return null;
    }

    /**
     * Provies the enemy image for the display.
     * @return ascii image
     */
    public String getEnemyImage() {
        return null;
    }
}
