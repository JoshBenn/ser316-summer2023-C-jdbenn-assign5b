package org.example;

public class Character {
    //Damage is calculated as potency*(potency+penetration) with an accuracy(100)% chance of hitting
    private final double accuracy, penetration, potency;
    private final String damageType, characterNumber;

    public Character(double accuracy, double penetration, double potency, String damageType, String characterNumber) {
        this.accuracy = accuracy;
        this.penetration = penetration;
        this.potency = potency;
        this.damageType = damageType;
        this.characterNumber = characterNumber;
    }

    /**
     * getCharacterNumber returns the id number of the character class.
     * @return 1 for cat
     */
    public String getCharacterNumber() {return characterNumber;}

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
     * getDamageType returns the damage type of the character class.
     * @return damageType
     */
    public String getDamageType() {return this.damageType;}

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    public String getImage() {  return null;  }
}
