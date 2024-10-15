package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import view.*;
import javax.swing.*;

import model.Player;
import model.Position;
import model.Team;
import view.MainWindow;

/**
 * controller.TeamController is a class that manages the interaction between the data model (Team) and the user interface (MainWindow).
 * It controls the view and handles user actions.
 *
 * model The Team object that represents the data model.
 * view The MainWindow object that represents the user interface.
 */
public class TeamController {
    private Team model;
    private MainWindow view;

    ArrayList<Team> TeamList = new ArrayList<>();
    ArrayList<Player> PlayerList = new ArrayList<>();
    private static final int requiredNumberOfPlayers = 11, maximum = 20;  // Example requirement

    /**
     * controller.TeamController is a class that manages the interaction between the data model (Team) and the user interface (MainWindow).
     * It controls the view and handles user actions.
     *
     * @param model The Team object that represents the data model.
     * @param view The MainWindow object that represents the user interface.
     */
    public TeamController(Team model, MainWindow view) {
        this.model = model;
        this.view = view;
        initView();
    }

    /**
     * Initializes the view by setting up listeners for various buttons.
     * This method is called after the view is created.
     */
    public void initView() {
        this.view.getTeamTotalList().setModel(new DefaultListModel<>());
        this.view.getU10ManageButton().addActionListener(e -> U10ManageCreateButtonListener());
        this.view.getCreateButton().addActionListener((ActionEvent e) -> createButtonPlayer());
        this.view.getManagementBackButton().addActionListener((ActionEvent e) -> managementBackButtonListener());
        this.view.getSelectLineupButton().addActionListener((ActionEvent e) -> selectLineupButtonListener());
        this.view.getAddSingleButton().addActionListener((ActionEvent e) -> addSinglePlayerButtonListener());
        this.view.getAddToTeamButton().addActionListener((ActionEvent e) -> addToTeamButtonListener());
        this.view.getRemovePlayerButton().addActionListener((ActionEvent e) -> removePlayerButtonListener());
        this.view.getAddPlayerButton().addActionListener((ActionEvent e) -> addPlayerButtonListener());
    }

    /**
     * Creates a button player.
     * Retrieves the current U10 team ID input from the view and removes all components from the main panel.
     * Adds the add player panel to the main panel.
     * Repaints and revalidates the main panel.
     * Sets the add player label text to "U10 Team " + curID + " Add Player".
     */
    private void createButtonPlayer() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        for (Team team : TeamList) {
            if (team.getTeamID() == curID) {
                JOptionPane.showMessageDialog(this.view.getU10Panel(), "Cannot create teams with " +
                                "the same ID.", "Success ",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        System.out.println("Enter AddPlayer by Click management button");
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getAddPlayerPanel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
        this.view.getAddPlayerLabel().setText("U10 Team "+ curID + " Add Player");
    }

    /**
     * Adds a listener to the "Add Player" button.
     * When the button is clicked, the method retrieves the current ID from the U10TeamIDInputTextField of the view.
     * It then prints a message to the console indicating the team ID.
     * The method removes all components from the MainPanel, adds the AddPlayerPanel to the MainPanel, and updates the GUI.
     * Finally, it sets the text of the AddPlayerLabel to "U10 Team [teamID] Add Player".
     */
    private void addPlayerButtonListener() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        System.out.println("Enter from team " + curID + " Management by clicking AddPlayer");
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getAddPlayerPanel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
        this.view.getAddPlayerLabel().setText("U10 Team " + curID + " Add Player");
    }

    /**
     * Removes a player from the team and updates the UI.
     */
    private void removePlayerButtonListener() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        DefaultListModel<Player> model1 =
                (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();

        Player selected = this.view.getTeamTotalList().getSelectedValue();
        System.out.println(selected.toString());

        model1.removeElement(selected);

        for (Team team : TeamList) {
            if (team.getTeamID() == curID) {
                team.removePlayer(selected);
                System.out.println("Removed team: ");
                this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > requiredNumberOfPlayers);
            }
        }
        this.view.getSelectLineupButton().doClick();
    }

    /**
     * Finds a team in the TeamList based on the given ID.
     *
     * @param ID the ID of the team to find
     * @return true if the team with the given ID is found, false otherwise
     */ /*
    private static <T> boolean isContainsValue(ListModel<T> model, T value) {
        for (int i = 0; i < model.getSize(); i++) {
            if (value.equals(model.getElementAt(i))) {
                return true;
            }
        }
        return false;
    }
 */
    private boolean findTeam(int ID) {
        for (Team team1: TeamList){
            if (team1.getTeamID() == ID){
                return true;
            }
        }
        return false;
    }



    /**
     * Adds the players to a team when the "Add to Team" button is clicked.
     * This method is triggered by the addToTeamButtonListener event.
     */
    private void addToTeamButtonListener() {
        try {
            DefaultListModel<Player> model1 =
                    (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();
            if (this.view.getTeamListTextArea().getText().equals("No existed team")){this.view.getTeamListTextArea().setText("");}

            int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
            if (!this.TeamList.isEmpty()) {
                System.out.println("Try to find existed team with ID: " + curID);
                for (Team team : TeamList) {
                    if (team.getTeamID() == curID) {
                        System.out.println("find existed team " + curID);
                        System.out.println("Current PlayerList" + this.PlayerList);
                        for (Player player : PlayerList) {
                            team.addPlayer(player);
                        }
                        this.PlayerList.clear();
                        System.out.println("After addition PlayerList " + this.PlayerList);
                        this.view.getAddPlayerCurrentTextArea().setText("");

                        this.view.getMainPanel().removeAll();
                        this.view.getMainPanel().add(this.view.getTeamManagementPanel());
                        this.view.getMainPanel().repaint();
                        this.view.getMainPanel().revalidate();
                        this.view.getTeamManagementLabel().setText("U10 Team " + curID + " " +
                                "Management");
                        System.out.println("Enter through AddPlayer for existed team");
                        model1.clear();

                        this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > requiredNumberOfPlayers);
                        this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < maximum);

                        for (Player player : team.getPlayers()) { // fill TeamTotalList
                            model1.addElement(player);
                        }
                        return;
                    }
                }

            }
            if (this.TeamList.isEmpty() ||
                    !findTeam(Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim()))) {

                System.out.println("First team or New team");
                try {
                    Team tempTeam = new Team(curID, PlayerList);
                    System.out.println("Current PlayerList" + this.PlayerList);
                    this.PlayerList.clear();
                    System.out.println("PlayerList cleaned");
                    if (!TeamList.contains(tempTeam)) { // if the team does not exist
                        TeamList.add(tempTeam);

                        //System.out.println(tempTeam.teamToString());
                        JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Creation success!", "Success ",
                                JOptionPane.INFORMATION_MESSAGE);

                        this.view.getTeamListTextArea().append("Team " + curID + "\n");
                        this.view.getMainPanel().removeAll();
                        this.view.getMainPanel().add(this.view.getTeamManagementPanel());
                        this.view.getMainPanel().repaint();
                        this.view.getMainPanel().revalidate();
                        this.view.getTeamManagementLabel().setText("U10 Team " + curID + " " +
                                "Management");
                        model1.clear();


                        System.out.println("new Current ID: " + curID);
                        System.out.println("Enter through create a new team, team " + curID);

                        for (Team team : TeamList) {
                            if (team.getTeamID() == curID) {
                                this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > requiredNumberOfPlayers);
                                this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < maximum);

                                for (Player player : team.getPlayers()) { // fill TeamTotalList
                                    model1.addElement(player);
                                }
                                this.view.getAddPlayerCurrentTextArea().setText("");
                            }
                        }


                    }
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error" +
                    " ", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Adds a listener to the single player button in the view. When the button is pressed, this method retrieves input from
     * the text fields in the view and creates a new Player object with the provided information. If the player does not
     * already exist in the PlayerList, the player is added to the list. Otherwise, an exception is thrown. The player's
     * information is then displayed in the addPlayerCurrentTextArea in the view. The text fields are cleared after the player
     * is added or an error occurs.
     * If the date format is invalid, a DateTimeParseException is caught and an error message is displayed.
     * If the player already exists, an IllegalArgumentException is thrown and an error message is displayed.
     */
    private void addSinglePlayerButtonListener() {
        try {
            System.out.println("Add player button in AddPlayer is pressed");
            Player tempPlayer = new Player(this.view.getFNTextField().getText().trim(),
                    this.view.getLNTextField().getText().trim()
                    , LocalDate.parse(this.view.getDOBTextField().getText(), DateTimeFormatter.ofPattern("yyyy" +
                    "-MM-dd")), (Position) this.view.getPFComboBox().getSelectedItem(), Position.NotAssigned,
                    (Integer) this.view.getSKComboBox().getSelectedItem());
            if (!isContain(tempPlayer, PlayerList)) {
                PlayerList.add(tempPlayer);
            } else {
                throw new IllegalArgumentException("Player already existed.");
            }

            if (this.view.getAddPlayerCurrentTextArea().getText().equals("No players prepared to be added.")) {
                this.view.getAddPlayerCurrentTextArea().setText("");
            }
            this.view.getAddPlayerCurrentTextArea().append(tempPlayer + "\n");
            this.view.getFNTextField().setText("");
            this.view.getLNTextField().setText("");
            this.view.getDOBTextField().setText("");
        } catch (DateTimeParseException dtpe) {
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Invalid date format. Please use " +
                    "YYYY-MM-DD.", "Error ", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException iae) {
            System.out.println("Error in AddToTeam");
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), iae.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Determines whether a given player is contained in the provided list of players based on their attributes.
     *
     * @param player The player to check if it is contained in the list.
     * @param lst    The list of players to search for the given player.
     * @return true if the player is contained in the list, false otherwise.
     */
    public boolean isContain(Player player, @org.jetbrains.annotations.NotNull ArrayList<Player> lst){
        for (Player player1: lst){
            if (player.getJerseyNumber() == player1.getJerseyNumber() &&
                    player.getSkillLevel() == player1.getSkillLevel() &&
                    player.getFirstName().equals(player1.getFirstName()) &&
                    player.getLastName().equals(player1.getLastName()) &&
                    player.getPreferredPosition().equals(player1.getPreferredPosition()) &&
                    player.getBirthDate().equals(player1.getBirthDate()) &&
                    player.getCurrentPosition().equals(player1.getCurrentPosition())){
                return true;
            }
        }
        return false;
    }

    /*
    private void replacePlayerButtonListener() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();
        DefaultListModel<Player> model3 =
                (DefaultListModel<Player>) this.view.getOnBenchList().getModel();

        for (Team team : TeamList) {  // setup lineup/ onBench start
            if (team.getTeamID() == curID) {
                Player ReplacePlayer = this.view.getLineupList().getSelectedValue(), playerToBeReplaced =
                        this.view.getOnBenchList().getSelectedValue();
                ArrayList<Player> lineup = team.getLineup(), onbench = team.getOnBench();
                System.out.println("lineup contains player to be replaced: "
                        + lineup.contains(playerToBeReplaced) + "onBench contains replace player" +
                        onbench.contains(ReplacePlayer));
                team.replacePlayer(team.findPlayer(playerToBeReplaced), team.findPlayer(ReplacePlayer));
                playerToBeReplaced.setCurrentPosition(ReplacePlayer.getCurrentPosition());
                ReplacePlayer.setCurrentPosition(Position.NotAssigned);

                int selectedIndexA = this.view.getLineupList().getSelectedIndex();
                int selectedIndexB = this.view.getOnBenchList().getSelectedIndex();

                if (selectedIndexA != -1 && selectedIndexB != -1) {
                    // Get selected items
                    model.Player selectedItemA = model2.get(selectedIndexA);
                    model.Player selectedItemB = model3.get(selectedIndexB);

                    // Swap items
                    model2.set(selectedIndexA, selectedItemB);
                    model3.set(selectedIndexB, selectedItemA);
                    System.out.println("Replace Success");
                    this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > requiredNumberOfPlayers);
                    this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < maximum);
                }
            }
        }  // replace the player in TeamList and JList end
    }

    */

    /**
     * Listener for the select lineup button.
     * This method retrieves the team ID from the input text field and updates the lineup and on-bench lists accordingly.
     * It clears the existing lineup and on-bench lists and populates them with the player objects from the selected team's lineup and on-bench lists.
     */
    private void selectLineupButtonListener() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        System.out.println("Team " + curID + "selecting lineup");
        DefaultListModel<Player> model2 =
                (DefaultListModel<Player>) this.view.getLineupList().getModel();
        DefaultListModel<Player> model3 =
                (DefaultListModel<Player>) this.view.getOnBenchList().getModel();
        ArrayList <Player> lineupTemp = new ArrayList<>(), onBenchTemp = new ArrayList<>();

        System.out.println("Before clear: " + model2.getSize() + ", " + model3.getSize());
        model2.clear();
        model3.clear();
        System.out.println("After clear: " + model2.getSize() + ", " + model3.getSize());

        this.view.getLineupList().revalidate();
        this.view.getLineupList().repaint();
        this.view.getOnBenchList().revalidate();
        this.view.getOnBenchList().repaint();

        for (Team team : TeamList) {  // setup lineup/ onBench start
            if (team.getTeamID() == curID) {  // setup lineup and get lineup, onBench
                team.selectLineUp(null);
                lineupTemp = team.getLineup();
                onBenchTemp = team.getOnBench();
                System.out.println("After get lineupTemp size: " + lineupTemp.size() +
                        "OnBenchTemp size: " + onBenchTemp.size());
            }
        }  // setup lineup/ onBench end
        for (Player player : lineupTemp) { // fill LineupList
            System.out.println("Lineup: " + player);

            model2.addElement(player);
        }
        for (Player player : onBenchTemp) { // fill OnBenchList
            System.out.println("OnBench" + player);
            model3.addElement(player);
        }
        lineupTemp.clear();
        onBenchTemp.clear();
    }

    /**
     * Method to handle the back button click for team management.
     * Removes all components from the main panel, adds the U10 panel back in,
     * and repaints and revalidates the main panel to display the changes.
     */
    private void managementBackButtonListener() {
        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        DefaultListModel<Player> model1 =
                (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();
        model1.clear();
        System.out.println("Go back to main from management team " + curID);
        this.view.getMainPanel().removeAll();
        this.view.getMainPanel().add(this.view.getU10Panel());
        this.view.getMainPanel().repaint();
        this.view.getMainPanel().revalidate();
    }


    /**
     * Checks if the input in the U10TeamIDInputTextField is valid.
     *
     * @return {@code true} if the input is valid, {@code false} otherwise.
     */
    private boolean isValidInput(){
        String TextFieldTemp = this.view.getU10TeamIDInputTextField().getText().trim();
        if (TextFieldTemp.isEmpty()){
            //System.out.println("Error in AddToTeam");
            JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Team ID cannot be blank" +
                            ".", "Error ",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (int i = 0; i < TextFieldTemp.length(); i++) {
            //System.out.println(TextFieldTemp.charAt(i));
            if (!Character.isDigit(TextFieldTemp.charAt(i))) {
                JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "Team ID cannot be " +
                                "anything other than number", "Error ",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * U10ManageCreateButtonListener method is responsible for handling the action
     * performed when the "Create" button is clicked in the U10 team management panel.
     * It performs the following tasks:
     * - Checks for valid input in the team ID input text field.
     * - If the input is invalid, it displays an error message.
     * - Retrieves the team ID entered by the user.
     * - Searches for the team with the matching ID in the TeamList.
     * - If the team is found, it updates the UI to display the team management panel.
     * - Updates the team management label with the team ID.
     * - Enables or disables the remove player and add player buttons based on the
     *   number of players in the team.
     * - Fills the team total list with the players in the selected team.
     * - Displays an error message if the team is not found in the TeamList.
     */
    public void U10ManageCreateButtonListener(){
        // if there is an invalid input, then pop up the error dialog and clean the textField
        if (!isValidInput()){this.view.getU10TeamIDInputTextField().setText("");}

        int curID = Integer.parseInt(this.view.getU10TeamIDInputTextField().getText().trim());
        for (Team team : TeamList) {
            if (team.getTeamID() == curID) { // find the right team in TeamList
                // if the team member count reaches the minimum or maximum, disable the corresponding
                // button
                System.out.println("Enter team " + curID + "Management by clicking management button");
                this.view.getMainPanel().removeAll();
                this.view.getMainPanel().add(this.view.getTeamManagementPanel());
                this.view.getMainPanel().repaint();
                this.view.getMainPanel().revalidate();
                this.view.getTeamManagementLabel().setText("U10 Team " + curID + " Management");
                this.view.getRemovePlayerButton().setEnabled(team.getPlayersInArray().length > requiredNumberOfPlayers);
                this.view.getAddPlayerButton().setEnabled(team.getPlayersInArray().length < maximum);
                DefaultListModel<Player> model1 =
                        (DefaultListModel<Player>) this.view.getTeamTotalList().getModel();

                for (Player player : team.getPlayers()) { // fill TeamTotalList
                    model1.addElement(player);
                }
                return;
            }

        }
        JOptionPane.showMessageDialog(this.view.getAddPlayerPanel(), "No such team existed",
                "Error ",
                JOptionPane.ERROR_MESSAGE);

    }

    /*
    ListSelectionListener listener = e -> {  // ReplacePlayerButtonEnable listener start
        if (!e.getValueIsAdjusting()) {
            int selectedIndexA = this.view.getLineupList().getSelectedIndex();
            int selectedIndexB = this.view.getOnBenchList().getSelectedIndex();

            if (selectedIndexA != -1 && selectedIndexB != -1) {
                this.view.getReplacePlayerButton().setEnabled(true);
            }
        }
    };  // ReplacePlayerButtonEnable listener end

     */

}

