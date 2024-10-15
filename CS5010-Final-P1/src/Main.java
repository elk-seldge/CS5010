import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Main class is the entry point of the application. It creates players, initializes a team, and performs various operations on the team.
 */
public class Main {
  /**
   * The main method is the entry point for the application.
   * It creates players, initializes a team, and performs operations on the team.
   * The team details are printed to the console.
   *
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    // Create ten players
    Player player1 = new Player("John", "Smith", LocalDate.of(1990, 1, 1), Position.Forward, Position.Forward, 4);
    Player player2 = new Player("Jane", "Doe", LocalDate.of(1992, 2, 2), Position.Midfielders, Position.Midfielders, 5);
    Player player3 = new Player("Emily", "Jones", LocalDate.of(1989, 3, 15), Position.Defenders, Position.Defenders, 3);
    Player player4 = new Player("Michael", "Brown", LocalDate.of(1991, 4, 20), Position.Goalie, Position.Goalie, 5);
    Player player5 = new Player("Chris", "Davis", LocalDate.of(1993, 5, 25), Position.Midfielders, Position.Midfielders, 4);
    Player player6 = new Player("Jessica", "Wilson", LocalDate.of(1988, 6, 30), Position.Forward, Position.Forward, 2);
    Player player7 = new Player("Matthew", "Martinez", LocalDate.of(1987, 7, 5), Position.Defenders, Position.Defenders, 3);
    Player player8 = new Player("Ashley", "Anderson", LocalDate.of(1994, 8, 10), Position.Midfielders, Position.Midfielders, 5);
    Player player9 = new Player("David", "Thomas", LocalDate.of(1995, 9, 15), Position.Defenders, Position.Defenders, 4);
    Player player10 = new Player("Sarah", "Jackson", LocalDate.of(1986, 10, 20), Position.Forward, Position.Forward, 3);
    Player player11 = new Player("Alex", "Taylor", LocalDate.of(1994, 11, 25), Position.Midfielders, Position.Midfielders, 4);
    Player player12 = new Player("Olivia", "Garcia", LocalDate.of(1993, 12, 5), Position.Defenders, Position.Defenders, 4);
    Player player13 = new Player("Ethan", "Lee", LocalDate.of(1992, 6, 18), Position.Forward, Position.Forward, 3);
    Player player14 = new Player("Sophia", "Martinez", LocalDate.of(1991, 7, 22), Position.Midfielders, Position.Midfielders, 5);
    Player player15 = new Player("Daniel", "Rodriguez", LocalDate.of(1989, 8, 30), Position.Goalie, Position.Goalie, 4);


    // Initialize an array with all players
    Player[] playersArray = {player1, player2, player3, player4, player5, player6, player7, player8, player9, player10};

    // Create a team and add players
    Team team = new Team(playersArray);

    // Assuming you have other operations to perform on the team, you can add them here

    // Print out the team details
    System.out.println("Team Roster:");
    System.out.println(team.teamToString());
    team.addPlayer(player11);
    System.out.println("\nNew Team Roster After add:");
    System.out.println(team.teamToString());
    team.removePlayer(player11);
    System.out.println("\nNew Team Roster After remove:");
    System.out.println(team.teamToString());

    System.out.println("\nAdd five more players to test lineup and onBench.");
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    System.out.println("\nFinal Team Roster:");
    System.out.println(team.teamToString());

    ArrayList<Player> lineup = team.selectLineUp(new ArrayList<>(Arrays.asList(playersArray)));
    System.out.println("\nLineup:");
    System.out.println(team.lineUpToString());
    System.out.println("\nCurrent Bench:");
    System.out.println(team.benchToString());

    team.replacePlayer(player11, player1);
    team.replacePlayer(player12, player2);
    System.out.println("\nLineup after replace:");
    System.out.println(team.lineUpToString());
    System.out.println("\nCurrent Bench after replace:");
    System.out.println(team.benchToString());

  }
}
