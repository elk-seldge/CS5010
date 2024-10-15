package model;// model.Player
/*
FIELDS
 .this.firstName: String
 .this.lastName: String
 .this.dob: LocalDate
 .this.preferredPosition: Position
 .this.currentPosition: Position
 .this.skillLevel: int
 .this.jerseyNumber: int
 METHODS
 ..this.getLastName(): String
 ..this.getFirstName(): getFirstName
 ..this.getPrefferdPosition(): Position
 ..this.getSkillLevel(): int
 ..this.getJerseyNum(): int
 ..this.setPreferredPosition(Position pos): void
 ..this.setCurrentPosition(Position pos): void
 ..this.setSkillLevel(int newLevel): void
 ..this.setJerseyNum(int jerseyNum): void
 ..this.toString(): String
 METHODS OF FIELDS
 ..this.center.equals(Object another): boolean
 */
import java.time.LocalDate;

/**
 * The Player class represents a player in a team.
 */
public class Player {
  private String lastName;
  private String firstName;
  private LocalDate dob;
  private Position preferredPosition;
  private Position currentPosition;
  private int skillLevel;
  private int jerseyNumber;

  /**
   * Constructs a Player object and initializes it to the player's last name, first name, birth date, preferred position, and skill level.
   * @param lastName String object stands for the last name of the player
   * @param firstName  String object stands for the first name of the player
   * @param birthDate LocalDate object stands for the birthdate of the player
   * @param preferredPosition Enum object stands for the preferred position of the player
   * @param assignedPosition Enum object stands for the actual position of the player
   * @param skillLevel int object in [1, 5] stands for the skill level of the player
   */
  public Player(String firstName, String lastName, LocalDate birthDate,
                Position preferredPosition, Position assignedPosition, int skillLevel) throws IllegalArgumentException{
    if(lastName == null || firstName == null || lastName.isEmpty() || firstName.isEmpty() || birthDate == null || preferredPosition == null) {
      throw new IllegalArgumentException("No field can be null.");
    }
    if(preferredPosition.equals(Position.NotAssigned)){
      throw new IllegalArgumentException("You got to do something.");
    }
    if(skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be between 1 and 5.");
    }
    if(birthDate.isBefore(LocalDate.now().minusYears(10))) {
      throw new IllegalArgumentException("Player must be less than 10 years old.");
    }
    if(birthDate.isAfter(LocalDate.now())){
      throw new IllegalArgumentException("Player cannot be born in the future.");
    }
    this.lastName = lastName;
    this.firstName = firstName;
    this.dob = birthDate;
    this.preferredPosition = preferredPosition;
    this.currentPosition = assignedPosition;
    this.skillLevel = skillLevel;
  }

  /**
   * Get the last name of the player.
   * @return the last name of the player
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Get the first name of the player.
   * @return the first name of the player
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Get the birthdate of the player.
   * @return the birthdate of the player
   */
  public LocalDate getBirthDate() {
    return this.dob;
  }

  /**
   * Get the preferred position of the player.
   * @return the preferred position of the player
   */
  public Position getPreferredPosition() {
    return this.preferredPosition;
  }

  /**
   * Get the current position of the player.
   * @return the current position of the player
   */
  public Position getCurrentPosition() {
    return this.currentPosition;
  }

  /**
   * Get the skill level of the player.
   * @return the skill level of the player
   */
  public int getSkillLevel() {
    return this.skillLevel;
  }

  /**
   * Get the jersey number of the player.
   * @return the jersey number of the player
   */
  public int getJerseyNumber() {
    return this.jerseyNumber;
  }

  /**
   * Set the jersey number of the player.
   * @param jerseyNumber int type  represents the jersey number assigned to the player
   */
  public void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Set the current position of the player.
   * @param currentPosition Position type represents the current position of the player
   */
  public void setCurrentPosition(Position currentPosition) {
    this.currentPosition = currentPosition;
  }

  /**
   * Set the preferred position of the player.
   * @param preferredPosition Position type represents the preferred position of the player
   */
  public void setPreferredPosition(Position preferredPosition) {
    this.preferredPosition = preferredPosition;
  }

  /**
   * Set the skill level of the player.
   *
   * @param skillLevel int value representing the skill level of the player. Must be between 1 and 5 (inclusive).
   * @throws IllegalArgumentException if the skill level is not between 1 and 5.
   */
  public void setSkillLevel(int skillLevel) {
    if (skillLevel >= 1 && skillLevel <= 5) {
      this.skillLevel = skillLevel;
    } else {
      throw new IllegalArgumentException("Skill level must be between 1 and 5.");
    }
  }

  /**
   * toString method for the Player class
   * @return first name, last name, jersey number
   */
  public String toString() {
    //System.out.println("Player toString is called.");
    StringBuilder playerString = new StringBuilder();
    playerString.append("First name: ").append(this.firstName).append("  ");
    playerString.append("Last name: ").append(this.lastName).append("  ");
    playerString.append("Jersey Number: ").append(this.jerseyNumber).append("  ");
    playerString.append("Skill Level: ").append(this.skillLevel).append("  ");
    playerString.append("Preferred Position: ").append(this.preferredPosition).append("  ");
    playerString.append("Current Position: ").append(this.currentPosition);
    return playerString.toString();
  }

}
