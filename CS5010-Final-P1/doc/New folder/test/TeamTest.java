import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * The class containing the JUnit tests for the Team class.
 */
public class TeamTest {
    private Team team;
    private Player player1, player2, player3;

    /**
     * Set up the team object before each test.
     */
    @Before
    public void setUp() {
        // Initialize the team with the minimum number of players required plus one.
        Player[] players = new Player[12];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("First" + i, "Last" + i, LocalDate.of(2000 - i, 1, 1), Position.Forward, Position.Forward, 3);
        }
        this.team = new Team(players);

        // Initialize some extra players for testing addition and removal
        player1 = players[0]; // Use one of the initialized players for removal test
        player2 = new Player("Jim", "Beam", LocalDate.of(1992, 3, 1), Position.Midfielders, Position.Midfielders, 5);
        player3 = new Player("Jill", "Valentine", LocalDate.of(1993, 4, 1), Position.Forward, Position.Forward, 2);
    }

    /**
     * Test adding a player to the team.
     */
    @Test
    public void testAddPlayer() {
        Player newPlayer = new Player("New", "Player", LocalDate.of(1994, 5, 1), Position.NotAssigned, Position.NotAssigned, 3);
        team.addPlayer(newPlayer);
        assertTrue(team.teamToString().contains(newPlayer.toString()));
    }

    /**
     * Test adding a player to the team when the skill level is invalid.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerException() {
        Player invalidPlayer = new Player("Invalid", "Player", LocalDate.of(1994, 5, 1), Position.NotAssigned, Position.NotAssigned, 6);
        team.addPlayer(invalidPlayer);
    }

    /**
     * Test removing a player from the team.
     */
    @Test
    public void testRemovePlayer() {
        // Ensure player1 is in the team before removal
        assertTrue("The player should initially be in the team.",
                team.teamToString().contains(player1.getFirstName())); // Adjust if necessary

        // Remove a player
        team.removePlayer(player1);

        // Verify the player was removed by checking they no longer appear in the team's string representation
        assertFalse("The player should no longer be listed in the team after removal.",
                team.teamToString().contains(player1.getFirstName())); // Adjust as necessary
    }

    /**
     * Test removing a player from the team when the team would be reduced below the minimum size.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerException() {
        // Attempt to remove a player when it would reduce the team below the minimum size
        // Direct removal from team assuming a method to do so or player1 is not part of the starting lineup
        for (int i = 0; i < 2; i++) { // Attempting to remove more players than the team can safely remove
            team.removePlayer(player1);
        }
    }

    /**
     * Test replacing a player in the lineup.
     */
    @Test
    public void testReplacePlayer() {
            team.addPlayer(player2);
            team.addPlayer(player3);

            ArrayList<Player> initialLineUp = new ArrayList<>(Collections.singletonList(player2)); // player3 starts on the ground
            team.selectLineUp(initialLineUp); // This setup should put player3 on the ground and the rest on the bench
            team.replacePlayer(player3, player2); // Swap player4 into onGround and player3 to onBench

            // Verify player4 is now on the ground by checking lineUpToString
            assertTrue("Player4 should now be on the ground.", team.lineUpToString().contains(player3.toString()));
            // Verify player3 is now on the bench by checking benchToString
            assertTrue("Player3 should now be on the bench.", team.benchToString().contains(player2.toString()));
    }

    /**
     * Test replacing a player in the lineup when the players to be replaced do not exist in the team.
     */
    @Test
    public void testSelectLineUp() {
        team.selectLineUp(null); // Let the method automatically select the lineup
        // Verify by checking the string representations contain expected changes
        assertNotNull(team.lineUpToString());
        assertFalse(team.lineUpToString().isEmpty());
    }

    /**
     * Test all the toString method.
     */
    @Test
    public void testToStringMethods() {
        assertNotNull(team.teamToString());
        assertFalse(team.teamToString().isEmpty());

        assertNotNull(team.lineUpToString());
        assertFalse(team.lineUpToString().isEmpty());

        assertNotNull(team.benchToString());
        assertFalse(team.benchToString().isEmpty());
    }
}
