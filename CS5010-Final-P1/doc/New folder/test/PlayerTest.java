import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

/**
 * The class containing the JUnit tests for the Player class.
 */
public class PlayerTest {
    private Player player;
    private final LocalDate birthDate = LocalDate.of(2000, 1, 1);

    /**
     * Set up the player object before each test.
     */
    @Before
    public void setUp() {
        // Initialize your player here
        player = new Player("John", "Doe", birthDate, Position.Forward, Position.Forward, 3);
    }

    /**
     * Test the constructor of the Player class.
     */
    @Test
    public void testPlayerConstructor() {
        // Assert that the player has been initialized with the correct values
        assertEquals("John", player.getFirstName());
        assertEquals("Doe", player.getLastName());
        assertEquals(birthDate, player.getBirthDate());
        assertEquals(Position.Forward, player.getPreferredPosition());
        assertEquals(Position.Forward, player.getCurrentPosition());
        assertEquals(3, player.getSkillLevel());
    }

    /**
     * Test the constructor of the Player class with invalid skill level.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithInvalidSkillLevel() {
        // Should throw IllegalArgumentException because of invalid skill level
        new Player("Jane", "Doe", birthDate, Position.Midfielders, Position.Midfielders, 6);
    }

    /**
     * Test the constructor of the Player class with invalid skill level.
     */
    @Test
    public void testSetAndGetMethods() {
        // Test set and get methods for jerseyNumber, currentPosition, preferredPosition, skillLevel
        // Test get methods for firstName, lastName, birthDate
        player.setJerseyNumber(10);
        assertEquals(10, player.getJerseyNumber());

        player.setCurrentPosition(Position.Defenders);
        assertEquals(Position.Defenders, player.getCurrentPosition());

        player.setPreferredPosition(Position.NotAssigned);
        assertEquals(Position.NotAssigned, player.getPreferredPosition());

        player.setSkillLevel(4);
        assertEquals(4, player.getSkillLevel());

        assertEquals("John", player.getFirstName());
        assertEquals("Doe", player.getLastName());
        assertEquals(birthDate, player.getBirthDate());
    }

    /**
     * Test the toString method of the Player class.
     */
    @Test
    public void testToString() {
        player.setJerseyNumber(10);
        player.setCurrentPosition(Position.Midfielders);
        // Expected format: FirstName LastName JerseyNumber CurrentPosition
        String expected = "John Doe 10 Midfielders";
        assertEquals(expected, player.toString());
    }

    /**
     * Test the constructor of the Player class with future birth date.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithFutureBirthDate() {
        // Should throw IllegalArgumentException because of future birth date
        LocalDate futureBirthDate = LocalDate.now().plusDays(1);
        new Player("Future", "Kid", futureBirthDate, Position.Forward, Position.Forward, 3);
    }

    /**
     * Test the constructor of the Player class with null firstName.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithNullFirstName() {
        // Should throw IllegalArgumentException because of null arguments
        new Player(null, "Doe", birthDate, Position.Midfielders, Position.Midfielders, 3);
    }

    /**
     * Test the constructor of the Player class with null lastName.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithNullLastName() {
        // Should throw IllegalArgumentException because of null arguments
        new Player("John", null, birthDate, Position.Midfielders, Position.Midfielders, 3);
    }

    /**
     * Test the constructor of the Player class with null birthDate.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithNullBirthDate() {
        // Should throw IllegalArgumentException because of null arguments
        new Player("John", "Doe", null, Position.Midfielders, Position.Midfielders, 3);
    }

    /**
     * Test the constructor of the Player class with null preferredPosition.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerConstructorWithNullPreferredPosition() {
        // Should throw IllegalArgumentException because of null arguments
        new Player("John", "Doe", birthDate, null, Position.Midfielders, 3);
    }
}
