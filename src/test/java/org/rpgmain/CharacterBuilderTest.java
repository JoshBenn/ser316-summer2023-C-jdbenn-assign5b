package org.rpgmain;

import org.junit.Assert;
import org.junit.Test;
import org.rpgmain.character.Character;

/**
 * Tests the character builder class and the three character type classes.
 */
public class CharacterBuilderTest {
    /**
     * Test random character generation.
     */
    @Test
    public void testRandomCharacterGeneration() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter();
        Assert.assertTrue(
                testCharacter.getCharacterNumber().equals("1")
                || testCharacter.getCharacterNumber().equals("2")
                || testCharacter.getCharacterNumber().equals("3"));
    }

    /**
     * Test specific character generation -- Cat.
     */
    @Test
    public void testCatGeneration() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter(1);
        Assert.assertEquals("1", testCharacter.getCharacterNumber());
    }

    /**
     * Test specific character generation -- Demon.
     */
    @Test
    public void testDemonGeneration() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter(2);
        Assert.assertEquals("2", testCharacter.getCharacterNumber());
    }

    /**
     * Test specific character generation -- Human.
     */
    @Test
    public void testHumanGeneration() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter(3);
        Assert.assertEquals("3", testCharacter.getCharacterNumber());
    }

    /**
     * Tests the lower bounds of character generation.
     */
    @Test
    public void testLowerBounds() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter(0);
        Assert.assertNull(testCharacter);
    }

    /**
     * Tests the upper bounds of character generation.
     */
    @Test
    public void testUpperBounds() {
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character testCharacter = characterBuilder.generateCharacter(4);
        Assert.assertNull(testCharacter);
    }
}
