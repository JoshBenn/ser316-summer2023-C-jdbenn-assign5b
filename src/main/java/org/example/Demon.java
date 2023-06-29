package org.example;

/**
 * Demon Character class.
 * Physical based damage.
 */
public class Demon extends Character {
    public Demon() {
        super(0.5, 0.5, 1, "Physical", "2");
    }

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    @Override
    public String getImage() {
        return  "    |__|\n" +
                "   ( o.o) \n" +
                "  Z(  >) ";
    }
}
