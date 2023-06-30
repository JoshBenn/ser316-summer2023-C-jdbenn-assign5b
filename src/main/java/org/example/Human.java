package org.example;

/**
 * Human Character class.
 * Damage can be either magic- or physical-based.
 */
public class Human extends Character {
    public Human() {
        super(0.5, 0.5, 3, "Either", "1");
    }

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    @Override
    public String getImage() {
        return  "    ,,,,\n" +
                "   ( o.o) \n" +
                "   (  >) ";
    }

    /**
     * getEnemyImage returns an image of the enemy.
     * @return ascii image
     */
    @Override
    public String getEnemyImage() {
        return  "                        ,,,,\n" +
                "                       (o.o ) \n" +
                "                        (<  ) ";
    }
}
