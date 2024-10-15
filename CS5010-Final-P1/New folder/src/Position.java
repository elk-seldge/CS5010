/**
 * The Position enum represents the different positions a player can have in a team.
 * It includes the positions Goalie, Defenders, Midfielders, Forward, and NotAssigned.
 */
public enum Position {
  /**
   * The Goalie class represents a goalie player in a team.
   * It is a specific position in the game of soccer.
   * This class is a part of the larger Position enum, which includes other player positions as well.
   */
  Goalie,
  /**
   * The Defenders class represents a group of defenders in a team.
   * It is used to group the players who play in the defenders position.
   */
  Defenders,
  /**
   * The Midfielders class represents a group of players who play in the midfield position.
   * It is a part of the Position enum and represents a specific category of players within a team.
   */
  Midfielders,
  /**
   * The Forward variable represents the position of a player in a team.
   * It is one of the possible positions defined by the Position enum.
   * The other possible positions are Goalie, Defenders, Midfielders, and NotAssigned.
   */
  Forward,
  /**
   * This is a constant representing a player position that is not assigned.
   * It is used in the Position enum to indicate that a player's position has not been assigned yet.
   * @see Position
   */
  NotAssigned
}
