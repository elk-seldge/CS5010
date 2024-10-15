import java.util.ArrayList;

/**
 * The teamInterface interface defines the operations that can be performed on a team of players.
 */
public interface teamInterface {
  /**
   * Adds a player to the team.
   *
   * @param player the player to be added to the team
   * @throws IllegalArgumentException if the player is null or if any of the player's fields are null
   * @throws IllegalArgumentException if the player's skill level is not between 1 and 5 (inclusive)
   * @throws IllegalArgumentException if the player is younger than 10 years old or if the player's birth date is in the future
   */
  public void addPlayer(Player player);

  /**
   * Removes the specified player from the team.
   *
   * @param player the player to be removed from the team
   */
  public void removePlayer(Player player);


  /**
   * Replaces the player on the bench with the player on the ground.
   *
   * @param playerOnBench the player on the bench to be replaced
   * @param playerOnGround the player on the ground to replace with
   * @throws IllegalArgumentException if playerOnBench or playerOnGround is null
   * @throws IllegalArgumentException if any of the fields of playerOnBench or playerOnGround are null
   * @throws IllegalStateException if playerOnBench or playerOnGround is not part of the team
   */
  public void replacePlayer(Player playerOnBench, Player playerOnGround);

  /**
   * Selects the line-up of players from the given ArrayList playerArrayList.
   * The line-up is determined by the implementation of this method.
   *
   * @param playerArrayList the ArrayList object containing the players to choose from
   * @return an ArrayList object representing the selected line-up
   */
  public ArrayList<Player> selectLineUp(ArrayList<Player> playerArrayList);

  /**
   * Converts the team object to its string representation.
   * The string representation includes the details of all the players in the team.
   *
   * @return the string representation of the team
   */
  public String teamToString();

  /**
   * Retrieves the string representation of the player's name, jersey number, and current position.
   *
   * @return The string representation of the player's name, jersey number, and current position.
   */
  public String lineUpToString();

  /**
   * Retrieves the string representation of the players on the bench.
   *
   * @return the string representation of the players on the bench
   */
  public String benchToString();
}
