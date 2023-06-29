package org.example;

/**
 * Cat character class.
 * Magic based damage.
 */
public class Cat extends Character {

    public Cat() {
        super(0.5, 0.5, 1, "Magic", "1");
    }

    /**
     * getImage returns an image of the character class.
     * @return ascii image
     */
    @Override
    public String getImage() {
        return  "    /\\/\\\n" +
                "   ( o.o) \n" +
                "  \\(  >) ";
    }
}