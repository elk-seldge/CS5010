import java.time.LocalDate;

/**
 * The playerInterface interface represents a player in a team.
 * It provides methods to get and set various player attributes.
 */
public interface playerInterface {
  /**
   * Returns the last name of the player.
   *
   * @return the last name of the player.
   */
  public String getLastName();

  /**
   * Returns the first name of the player.
   *
   * @return the first name of the player.
   */
  public String getFirstName();

  /**
   * Returns the date of birth of the player.
   *
   * @return the date of birth of the player.
   */
  public LocalDate getDoB();

  /**
   * Returns the preferred position of the player.
   *
   * @return the preferred position of the player.
   */
  public Position getPrefferdPosition();

  /**
   * Retrieves the skill level of the player.
   *
   * @return the skill level of the player as an integer value.
   */
  public int getSkillLevel();

  /**
   * Returns the jersey number of the player.
   *
   * @return the jersey number of the player as an integer value.
   */
  public int getJerseyNum();

  /**
   * Sets the preferred position of the player.
   *
   * @param pos the preferred position of the player.
   */
  public void setPreferredPosition(Position pos);

  /**
   * Sets the current position of the player.
   *
   * @param pos the position to set for the player.
   */
  public void setCurrentPosition(Position pos);

  /**
   * Sets the skill level of the player to the specified new level.
   *
   * @param newLevel the new skill level of the player
   */
  public void setSkillLevel(int newLevel);

  /**
   * Sets the jersey number of the player.
   *
   * @param jerseyNum the new jersey number of the player as an integer value.
   */
  public void setJerseyNum(int jerseyNum);

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  public String toString();
}
