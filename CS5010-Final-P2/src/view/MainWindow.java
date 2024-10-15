package view;

import java.awt.*;
import java.util.Locale;
import model.Position;
import model.Player;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;


/**
 * Class representing the main window of the application.
 */
public class MainWindow extends JFrame {
  /**
   * Represents the main panel of the application.
   */
  private JPanel MainPanel;
  /**
   * JPanel representing the team management panel of the application.
   */
  private JPanel TeamManagementPanel;
  /**
   * Private variable representing a JLabel component for team management.
   */
  private JLabel TeamManagementLabel;
  /**
   * Represents a JPanel used for team management in the MainWindow class.
   */
  private JPanel TeamManagementSubPanel;
  /**
   * Represents the add player button in the MainWindow class.
   */
  private JButton AddPlayerButton;
  /**
   * This private variable represents the JButton used to remove a player.
   */
  private JButton RemovePlayerButton;
  /**
   * Represents a button used for replacing a player.
   */
  private JButton ReplacePlayerButton;
  /**
   * The TeamInfoPanel variable represents a JPanel within the MainWindow class that contains information about a team.
   * This panel is used for displaying and managing the team's information.
   */
  private JPanel TeamInfoPanel;
  /**
   * Private variable that represents the U10 panel of the MainWindow class.
   */
  private JPanel U10Panel;
  /**
   * Represents a JList object that displays the total list of players in a team.
   */
  private JList<Player> TeamTotalList;
  /**
   * Private JLabel variable representing the TeamTotalLabel.
   *
   * This label is used to display the total number of teams.
   */
  private JLabel TeamTotalLabel;
  /**
   * Represents a JScrollPane object used for scrolling the total list of players in a team.
   */
  private JScrollPane TeamTotalScroll;
  /**
   * Represents a JLabel component used for displaying lineup information.
   */
  private JLabel LineupLabel;
  /**
   * Represents a JScrollPane used for scrolling the lineup list in the MainWindow class.
   */
  private JScrollPane LineupScroll;
  /**
   * Represents a JList object that holds Player objects for the lineup.
   */
  private JList<Player> LineupList;
  /**
   * Represents a JLabel component used for displaying the "On Bench" label in the application.
   */
  private JLabel OnBenchLabel;
  /**
   * Private variable representing a JScrollPane component for the "On Bench" list.
   */
  private JScrollPane OnBenchScroll;
  /**
   * Represents a JList of Player objects for the players on the bench.
   */
  private JList<Player> OnBenchList;
  /**
   * Represents a panel for management actions in the application.
   */
  private JPanel ManagementActionPanel;
  /**
   * Represents the add player panel containing player information and controls.
   */
  private JPanel AddPlayerPanel;
  /**
   * Represents a private JPanel variable named AddPlayerTopPanel.
   * This variable is a member of the MainWindow class.
   */
  private JPanel AddPlayerTopPanel;
  /**
   * Represents a JPanel component for adding player action.
   */
  private JPanel AddPlayerActionPanel;
  /**
   * Represents a JLabel component used for adding players.
   * It is a private variable that belongs to the MainWindow class.
   */
  private JLabel AddPlayerLabel;
  /**
   * Represents a private JPanel variable named AddSinglePanel.
   * This variable is a part of the MainWindow class.
   */
  private JPanel AddSinglePanel;
  /**
   * Private variable representing a JTextField for the first name.
   */
  private JTextField FNTextField;
  /**
   * Represents a private JTextField variable in the MainWindow class. This variable is used to enter the last name of a player.
   */
  private JTextField LNTextField;
  /**
   * The DOBTextField variable represents a JTextField component used for inputting a player's date of birth (DOB).
   */
  private JTextField DOBTextField;
  /**
   * The PFComboBox variable is a private JComboBox object representing
   * the position selection for a player in a team. It is used in the MainWindow class.
   *
   * Example usage:
   * ```java
   * Position selectedPosition = (Position) PFComboBox.getSelectedItem();
   * ```
   * return The PFComboBox object.
   * @see MainWindow
   */
  private JComboBox<Position> PFComboBox;
  /**
   * Represents a label for the first name field.
   */
  private JLabel FirstNameLabel;
  /**
   * The label used to display the last name in a graphical user interface.
   */
  private JLabel LastNameLabel;
  /**
   * Represents a JLabel component for displaying the date of birth (DOB).
   * This label is used in the MainWindow class.
   */
  private JLabel DOBLabel;
  /**
   * JLabel object representing the preferred position label.
   */
  private JLabel PreferredPositionLabel;
  /**
   * This variable represents a JLabel component for displaying the skill level.
   */
  private JLabel SkillLevelLabel;
  /**
   * Represents a JComboBox object used in the MainWindow class.
   * This JComboBox is of type Integer and is used for selecting a skill level.
   */
  private JComboBox<Integer> SKComboBox;
  /**
   * Represents a JButton object used for adding a single player.
   */
  private JButton AddSingleButton;
  /**
   * Represents a JTextArea component used for displaying welcome messages in the U10 panel of the MainWindow class.
   */
  private JTextArea U10WelcomeTextArea;
  /**
   * JComboBox representing the teams in the U10 category.
   */
  private JComboBox<Integer> U10TeamsComboBox;
  /**
   * This private variable represents the manage button for the U10 panel.
   * It allows the user to perform management actions on the U10 team, such as adding or removing players.
   */
  private JButton U10Managebutton;
  /**
   * The U10Title variable represents a JLabel component used to display the title in the U10 panel of the MainWindow class.
   */
  private JLabel U10Title;
  /**
   * JLabel representing the label for the U10 Teams.
   */
  private JLabel U10TeamsLabel;
  /**
   * A private JPanel variable representing the team management panel for U10 teams.
   */
  private JPanel U10TeamMangePanel;
  /**
   * Represents the JTextArea component used to display the current player's information
   * in the "Add Player" panel.
   */
  private JTextArea AddPlayerCurrentTextArea;
  /**
   * Private variable representing a JLabel component for adding a current player.
   */
  private JLabel AddPlayerCurrentLabel;
  /**
   * Private variable representing a JScrollPane for the "Add Player" panel's current player information display.
   */
  private JScrollPane AddPlayerCurrentScroll;
  /**
   * Represents the add to team button in the user interface.
   */
  private JButton AddToTeamButton;
  /**
   * Represents the management back button in the MainWindow class.
   */
  private JButton ManagementBackButton;
  /**
   * Represents a button that can be used to select a lineup.
   */
  private JButton SelectLineupButton;
  /**
   * Private variable representing a JButton object for creating a button.
   */
  private JButton CreateButton;
  /**
   * Represents the input text field for the U10 team ID.
   */
  private JTextField U10TeamIDInputTextField;
  /**
   * The JTextArea component used to display the team list.
   */
  private JTextArea TeamListTextArea;
  /**
   * Represents a JLabel component used to display the current team list.
   */
  private JLabel CurrentTeamListLabel;
  /**
   * Represents a JButton used for creating something.
   */
  private JButton createButton;


  /**
   * Class representing the main window of the application.
   */
  public MainWindow() {


    // set model for three JLists starts
    TeamTotalList.setModel(new DefaultListModel<>());

    LineupList.setModel(new DefaultListModel<>());

    OnBenchList.setModel(new DefaultListModel<>());
    // set model for three JLists ends

    PFComboBox.addItem(Position.Forward); // Initialize Preferred Position combo box
    PFComboBox.addItem(Position.Defenders);
    PFComboBox.addItem(Position.Goalie);
    PFComboBox.addItem(Position.Midfielders);

    SKComboBox.addItem(1); // Initialize skill level combo box
    SKComboBox.addItem(2);
    SKComboBox.addItem(3);
    SKComboBox.addItem(4);
    SKComboBox.addItem(5);


  }

  /**
   * Returns the main panel of the application.
   *
   * @return the main panel of the application
   */
  // JPanel getter start
  public JPanel getMainPanel() {
    return this.MainPanel;
  }

  /**
   * Returns the U10 panel of the MainWindow class.
   *
   * @return the U10 panel
   */
  public JPanel getU10Panel() {
    return this.U10Panel;
  }

  /**
   * Retrieves the panel for managing teams.
   *
   * @return The team management panel.
   */
  public JPanel getTeamManagementPanel() {
    return this.TeamManagementPanel;
  }

  /**
   * Retrieves the add player panel.
   *
   * @return The add player panel containing player information and controls.
   */
  public JPanel getAddPlayerPanel() {
    return this.AddPlayerPanel;
  }
  // JPanel getter end

  // JComboBox getter start

  /**
   * Retrieves the PFComboBox object, which is a JComboBox of type Position.
   * The PFComboBox represents the position selection for a player in a team.
   *
   * @return the PFComboBox object
   */
  public JComboBox<Position> getPFComboBox() {
    return this.PFComboBox;
  }

  /**
   * Retrieves the SKComboBox object used in the MainWindow class.
   *
   * @return The SKComboBox object.
   */
  public JComboBox<Integer> getSKComboBox() {
    return this.SKComboBox;
  }

  // JComboBox getter end

  /**
   * Returns the JList object that represents the total list of players in a team.
   *
   * @return the JList object representing the total list of players in a team.
   */
  // JList getter start
  public JList<Player> getTeamTotalList() {
    return this.TeamTotalList;
  }

  /**
   * Retrieves the lineup list.
   *
   * @return A JListobject representing the lineup list.
   */
  public JList<Player> getLineupList() {
    return this.LineupList;
  }

  /**
   * Retrieves the list of players on the bench.
   *
   * @return The list of players on the bench.
   */
  public JList<Player> getOnBenchList() {
    return this.OnBenchList;
  }

  // JList getter end

  /**
   * Returns the TeamManagementLabel component.
   *
   * @return the TeamManagementLabel component
   */
  // JLabel getter start
  public JLabel getTeamManagementLabel() {
    return this.TeamManagementLabel;
  }

  /**
   * Retrieves the AddPlayerLabel from the MainWindow object.
   *
   * @return the AddPlayerLabel object.
   */
  public JLabel getAddPlayerLabel() {
    return this.AddPlayerLabel;
  }
  // JKLabel getter end


  /**
   * Returns the U10ManageButton.
   *
   * @return the U10ManageButton
   */
  // JButton getter start
  public JButton getU10ManageButton() {
    return this.U10Managebutton;
  }

  /**
   * Retrieves the create button from the MainWindow class.
   *
   * @return the create button.
   */
  public JButton getCreateButton() {
    return this.createButton;
  }

  /**
   * Retrieves the management back button.
   *
   * @return the management back button
   */
  public JButton getManagementBackButton() {
    return this.ManagementBackButton;
  }

  /**
   * Retrieves the select lineup button from the MainWindow class.
   *
   * @return The select lineup button.
   */
  public JButton getSelectLineupButton() {
    return this.SelectLineupButton;
  }

  /**
   * Retrieves the replace player button.
   *
   * @return JButton object representing the replace player button
   */
  public JButton getReplacePlayerButton() {
    return this.ReplacePlayerButton;
  }

  /**
   * Retrieves the JButton for adding a single player.
   *
   * @return The JButton for adding a single player.
   */
  public JButton getAddSingleButton() {
    return this.AddSingleButton;
  }

  /**
   * Retrieves the AddToTeamButton.
   *
   * @return The AddToTeamButton.
   */
  public JButton getAddToTeamButton() {
    return this.AddToTeamButton;
  }

  /**
   * Retrieves the add player button from the MainWindow class.
   *
   * @return The add player button.
   */
  public JButton getAddPlayerButton() {
    return this.AddPlayerButton;
  }

  /**
   * Retrieves the remove player button.
   *
   * @return the remove player button
   */
  public JButton getRemovePlayerButton() {
    return this.RemovePlayerButton;
  }
  // JButton getter end

  /**
   * Retrieves the first name text field from the view.
   *
   * @return The JTextField object representing the first name text field.
   */
  // JTextField getter start
  public JTextField getFNTextField() {
    return this.FNTextField;
  }

  /**
   * Retrieves the LNTextField from the MainWindow class.
   *
   * @return the LNTextField JTextField object
   */
  public JTextField getLNTextField() {
    return this.LNTextField;
  }

  /**
   * Retrieves the DOBTextField.
   *
   * @return The DOBTextField.
   */
  public JTextField getDOBTextField() {
    return this.DOBTextField;
  }

  /**
   * Retrieves the U10 Team ID input text field from the view.
   *
   * @return the U10 Team ID input text field
   */
  public JTextField getU10TeamIDInputTextField() {
    return this.U10TeamIDInputTextField;
  }
  // JTextField getter end

  /**
   * Retrieves the JTextArea component used to display the current player's information in the "Add Player" panel.
   *
   * @return The JTextArea component used to display the current player's information.
   */
  // JTextArea getter start
  public JTextArea getAddPlayerCurrentTextArea() {
    return this.AddPlayerCurrentTextArea;
  }

  /**
   * Retrieves the JTextArea associated with the team list.
   *
   * @return The JTextArea object representing the team list.
   */
  public JTextArea getTeamListTextArea() {
    return this.TeamListTextArea;
  }
  // JTextArea getter end


  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    MainPanel = new JPanel();
    MainPanel.setLayout(new CardLayout(0, 0));
    U10Panel = new JPanel();
    U10Panel.setLayout(new BorderLayout(0, 0));
    U10Panel.setMaximumSize(new Dimension(2147483647, 10));
    U10Panel.setMinimumSize(new Dimension(938, 10));
    MainPanel.add(U10Panel, "MainWindow");
    U10Title = new JLabel();
    Font U10TitleFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, U10Title.getFont());
    if (U10TitleFont != null) U10Title.setFont(U10TitleFont);
    U10Title.setHorizontalAlignment(0);
    U10Title.setHorizontalTextPosition(0);
    U10Title.setText("U10 Team Management APP");
    U10Panel.add(U10Title, BorderLayout.NORTH);
    U10WelcomeTextArea = new JTextArea();
    U10WelcomeTextArea.setEditable(false);
    Font U10WelcomeTextAreaFont = this.$$$getFont$$$("Courier New", Font.BOLD | Font.ITALIC, 16, U10WelcomeTextArea.getFont());
    if (U10WelcomeTextAreaFont != null) U10WelcomeTextArea.setFont(U10WelcomeTextAreaFont);
    U10WelcomeTextArea.setLineWrap(true);
    U10WelcomeTextArea.setText("Welcome to U10 Team Management APP. \n\nPlease enter the team ID you want to manage from the right textField;\n\nTeam ID is a single integer.");
    U10Panel.add(U10WelcomeTextArea, BorderLayout.CENTER);
    U10TeamMangePanel = new JPanel();
    U10TeamMangePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1));
    U10Panel.add(U10TeamMangePanel, BorderLayout.EAST);
    U10TeamsLabel = new JLabel();
    Font U10TeamsLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, U10TeamsLabel.getFont());
    if (U10TeamsLabelFont != null) U10TeamsLabel.setFont(U10TeamsLabelFont);
    U10TeamsLabel.setText("Team(s): ");
    U10TeamMangePanel.add(U10TeamsLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    U10Managebutton = new JButton();
    U10Managebutton.setActionCommand("");
    Font U10ManagebuttonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, U10Managebutton.getFont());
    if (U10ManagebuttonFont != null) U10Managebutton.setFont(U10ManagebuttonFont);
    U10Managebutton.setLabel("Manage");
    U10Managebutton.setText("Manage");
    U10TeamMangePanel.add(U10Managebutton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    U10TeamIDInputTextField = new JTextField();
    Font U10TeamIDInputTextFieldFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, U10TeamIDInputTextField.getFont());
    if (U10TeamIDInputTextFieldFont != null)
      U10TeamIDInputTextField.setFont(U10TeamIDInputTextFieldFont);
    U10TeamIDInputTextField.setMaximumSize(new Dimension(60, 30));
    U10TeamIDInputTextField.setMinimumSize(new Dimension(60, 30));
    U10TeamIDInputTextField.setPreferredSize(new Dimension(60, 30));
    U10TeamMangePanel.add(U10TeamIDInputTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(100, -1), new Dimension(200, -1), new Dimension(200, -1), 0, false));
    CurrentTeamListLabel = new JLabel();
    Font CurrentTeamListLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, CurrentTeamListLabel.getFont());
    if (CurrentTeamListLabelFont != null) CurrentTeamListLabel.setFont(CurrentTeamListLabelFont);
    CurrentTeamListLabel.setText("Current Team:");
    U10TeamMangePanel.add(CurrentTeamListLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final JScrollPane scrollPane1 = new JScrollPane();
    U10TeamMangePanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    TeamListTextArea = new JTextArea();
    TeamListTextArea.setEditable(false);
    Font TeamListTextAreaFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, TeamListTextArea.getFont());
    if (TeamListTextAreaFont != null) TeamListTextArea.setFont(TeamListTextAreaFont);
    TeamListTextArea.setMaximumSize(new Dimension(2147483647, 200));
    TeamListTextArea.setPreferredSize(new Dimension(145, 200));
    TeamListTextArea.setText("No existed team");
    scrollPane1.setViewportView(TeamListTextArea);
    final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
    U10TeamMangePanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
    U10TeamMangePanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
    U10TeamMangePanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    createButton = new JButton();
    Font createButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, createButton.getFont());
    if (createButtonFont != null) createButton.setFont(createButtonFont);
    createButton.setText("Create");
    U10TeamMangePanel.add(createButton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    TeamManagementPanel = new JPanel();
    TeamManagementPanel.setLayout(new BorderLayout(0, 0));
    MainPanel.add(TeamManagementPanel, "PlayerWindow");
    TeamManagementLabel = new JLabel();
    Font TeamManagementLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, TeamManagementLabel.getFont());
    if (TeamManagementLabelFont != null) TeamManagementLabel.setFont(TeamManagementLabelFont);
    TeamManagementLabel.setHorizontalAlignment(0);
    TeamManagementLabel.setText("U10: Management");
    TeamManagementPanel.add(TeamManagementLabel, BorderLayout.NORTH);
    TeamManagementSubPanel = new JPanel();
    TeamManagementSubPanel.setLayout(new BorderLayout(0, 0));
    TeamManagementPanel.add(TeamManagementSubPanel, BorderLayout.CENTER);
    TeamInfoPanel = new JPanel();
    TeamInfoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
    TeamManagementSubPanel.add(TeamInfoPanel, BorderLayout.CENTER);
    TeamInfoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
    TeamTotalScroll = new JScrollPane();
    TeamInfoPanel.add(TeamTotalScroll, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    TeamTotalList = new JList();
    Font TeamTotalListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, TeamTotalList.getFont());
    if (TeamTotalListFont != null) TeamTotalList.setFont(TeamTotalListFont);
    TeamTotalList.setSelectionMode(0);
    TeamTotalList.setValueIsAdjusting(false);
    TeamTotalScroll.setViewportView(TeamTotalList);
    TeamTotalLabel = new JLabel();
    Font TeamTotalLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, TeamTotalLabel.getFont());
    if (TeamTotalLabelFont != null) TeamTotalLabel.setFont(TeamTotalLabelFont);
    TeamTotalLabel.setText("Total Team Info:");
    TeamInfoPanel.add(TeamTotalLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LineupLabel = new JLabel();
    Font LineupLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, LineupLabel.getFont());
    if (LineupLabelFont != null) LineupLabel.setFont(LineupLabelFont);
    LineupLabel.setText("Lineup Info:");
    TeamInfoPanel.add(LineupLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LineupScroll = new JScrollPane();
    TeamInfoPanel.add(LineupScroll, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    LineupList = new JList();
    Font LineupListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, LineupList.getFont());
    if (LineupListFont != null) LineupList.setFont(LineupListFont);
    LineupScroll.setViewportView(LineupList);
    OnBenchLabel = new JLabel();
    Font OnBenchLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, OnBenchLabel.getFont());
    if (OnBenchLabelFont != null) OnBenchLabel.setFont(OnBenchLabelFont);
    OnBenchLabel.setText("OnBench Info:");
    TeamInfoPanel.add(OnBenchLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    OnBenchScroll = new JScrollPane();
    TeamInfoPanel.add(OnBenchScroll, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    OnBenchList = new JList();
    Font OnBenchListFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, OnBenchList.getFont());
    if (OnBenchListFont != null) OnBenchList.setFont(OnBenchListFont);
    OnBenchScroll.setViewportView(OnBenchList);
    ManagementActionPanel = new JPanel();
    ManagementActionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    TeamManagementSubPanel.add(ManagementActionPanel, BorderLayout.SOUTH);
    ManagementBackButton = new JButton();
    Font ManagementBackButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, ManagementBackButton.getFont());
    if (ManagementBackButtonFont != null) ManagementBackButton.setFont(ManagementBackButtonFont);
    ManagementBackButton.setText("Back");
    ManagementActionPanel.add(ManagementBackButton);
    AddPlayerButton = new JButton();
    Font AddPlayerButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddPlayerButton.getFont());
    if (AddPlayerButtonFont != null) AddPlayerButton.setFont(AddPlayerButtonFont);
    AddPlayerButton.setLabel("Add Player");
    AddPlayerButton.setText("Add Player");
    ManagementActionPanel.add(AddPlayerButton);
    RemovePlayerButton = new JButton();
    Font RemovePlayerButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, RemovePlayerButton.getFont());
    if (RemovePlayerButtonFont != null) RemovePlayerButton.setFont(RemovePlayerButtonFont);
    RemovePlayerButton.setLabel("Remove Player");
    RemovePlayerButton.setText("Remove Player");
    ManagementActionPanel.add(RemovePlayerButton);
    SelectLineupButton = new JButton();
    Font SelectLineupButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, SelectLineupButton.getFont());
    if (SelectLineupButtonFont != null) SelectLineupButton.setFont(SelectLineupButtonFont);
    SelectLineupButton.setLabel("Select Lineup");
    SelectLineupButton.setText("Select Lineup");
    ManagementActionPanel.add(SelectLineupButton);
    AddPlayerPanel = new JPanel();
    AddPlayerPanel.setLayout(new BorderLayout(0, 0));
    MainPanel.add(AddPlayerPanel, "Card3");
    AddPlayerTopPanel = new JPanel();
    AddPlayerTopPanel.setLayout(new GridBagLayout());
    AddPlayerTopPanel.setAlignmentX(0.3f);
    AddPlayerPanel.add(AddPlayerTopPanel, BorderLayout.NORTH);
    AddPlayerLabel = new JLabel();
    Font AddPlayerLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 20, AddPlayerLabel.getFont());
    if (AddPlayerLabelFont != null) AddPlayerLabel.setFont(AddPlayerLabelFont);
    AddPlayerLabel.setHorizontalAlignment(0);
    AddPlayerLabel.setHorizontalTextPosition(0);
    AddPlayerLabel.setText("U10: Add player");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    AddPlayerTopPanel.add(AddPlayerLabel, gbc);
    AddPlayerActionPanel = new JPanel();
    AddPlayerActionPanel.setLayout(new CardLayout(0, 0));
    AddPlayerPanel.add(AddPlayerActionPanel, BorderLayout.CENTER);
    AddSinglePanel = new JPanel();
    AddSinglePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 3, new Insets(0, 0, 0, 0), -1, -1));
    AddPlayerActionPanel.add(AddSinglePanel, "Card1");
    FirstNameLabel = new JLabel();
    Font FirstNameLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, FirstNameLabel.getFont());
    if (FirstNameLabelFont != null) FirstNameLabel.setFont(FirstNameLabelFont);
    FirstNameLabel.setText("First Name: ");
    AddSinglePanel.add(FirstNameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    LastNameLabel = new JLabel();
    Font LastNameLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, LastNameLabel.getFont());
    if (LastNameLabelFont != null) LastNameLabel.setFont(LastNameLabelFont);
    LastNameLabel.setText("Last Name: ");
    AddSinglePanel.add(LastNameLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    DOBLabel = new JLabel();
    Font DOBLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, DOBLabel.getFont());
    if (DOBLabelFont != null) DOBLabel.setFont(DOBLabelFont);
    DOBLabel.setText("Date of Birth (YYYY-MM-DD): ");
    AddSinglePanel.add(DOBLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    PreferredPositionLabel = new JLabel();
    Font PreferredPositionLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, PreferredPositionLabel.getFont());
    if (PreferredPositionLabelFont != null)
      PreferredPositionLabel.setFont(PreferredPositionLabelFont);
    PreferredPositionLabel.setText("Preferred model.Position: ");
    AddSinglePanel.add(PreferredPositionLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    SkillLevelLabel = new JLabel();
    Font SkillLevelLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, SkillLevelLabel.getFont());
    if (SkillLevelLabelFont != null) SkillLevelLabel.setFont(SkillLevelLabelFont);
    SkillLevelLabel.setText("Skill Level: ");
    AddSinglePanel.add(SkillLevelLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    FNTextField = new JTextField();
    Font FNTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, FNTextField.getFont());
    if (FNTextFieldFont != null) FNTextField.setFont(FNTextFieldFont);
    AddSinglePanel.add(FNTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    LNTextField = new JTextField();
    Font LNTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, LNTextField.getFont());
    if (LNTextFieldFont != null) LNTextField.setFont(LNTextFieldFont);
    AddSinglePanel.add(LNTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    DOBTextField = new JTextField();
    Font DOBTextFieldFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 16, DOBTextField.getFont());
    if (DOBTextFieldFont != null) DOBTextField.setFont(DOBTextFieldFont);
    AddSinglePanel.add(DOBTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
    PFComboBox = new JComboBox();
    AddSinglePanel.add(PFComboBox, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    SKComboBox = new JComboBox();
    AddSinglePanel.add(SKComboBox, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    AddSingleButton = new JButton();
    Font AddSingleButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddSingleButton.getFont());
    if (AddSingleButtonFont != null) AddSingleButton.setFont(AddSingleButtonFont);
    AddSingleButton.setLabel("Add Player");
    AddSingleButton.setText("Add Player");
    AddSinglePanel.add(AddSingleButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(130, 82), null, 0, false));
    AddPlayerCurrentScroll = new JScrollPane();
    AddSinglePanel.add(AddPlayerCurrentScroll, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    AddPlayerCurrentTextArea = new JTextArea();
    AddPlayerCurrentTextArea.setEditable(false);
    Font AddPlayerCurrentTextAreaFont = this.$$$getFont$$$("Courier New", Font.BOLD | Font.ITALIC, 16, AddPlayerCurrentTextArea.getFont());
    if (AddPlayerCurrentTextAreaFont != null)
      AddPlayerCurrentTextArea.setFont(AddPlayerCurrentTextAreaFont);
    AddPlayerCurrentTextArea.setText("No players prepared to be added.");
    AddPlayerCurrentScroll.setViewportView(AddPlayerCurrentTextArea);
    AddToTeamButton = new JButton();
    Font AddToTeamButtonFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddToTeamButton.getFont());
    if (AddToTeamButtonFont != null) AddToTeamButton.setFont(AddToTeamButtonFont);
    AddToTeamButton.setText("Add To Team");
    AddSinglePanel.add(AddToTeamButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
    AddSinglePanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    AddPlayerCurrentLabel = new JLabel();
    Font AddPlayerCurrentLabelFont = this.$$$getFont$$$("Courier New", Font.BOLD, 16, AddPlayerCurrentLabel.getFont());
    if (AddPlayerCurrentLabelFont != null) AddPlayerCurrentLabel.setFont(AddPlayerCurrentLabelFont);
    AddPlayerCurrentLabel.setText("Current Player List:  ");
    AddSinglePanel.add(AddPlayerCurrentLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
    AddSinglePanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
    if (currentFont == null) return null;
    String resultName;
    if (fontName == null) {
      resultName = currentFont.getName();
    } else {
      Font testFont = new Font(fontName, Font.PLAIN, 10);
      if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
        resultName = fontName;
      } else {
        resultName = currentFont.getName();
      }
    }
    Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
    Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
    return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
  }

  /**
   * return MainPanel
   */
  public JComponent $$$getRootComponent$$$() {
    return MainPanel;
  }

}
