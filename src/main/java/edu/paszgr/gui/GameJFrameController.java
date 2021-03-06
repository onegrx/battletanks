package edu.paszgr.gui;

import edu.paszgr.GameConstants;
import edu.paszgr.board.Field;
import edu.paszgr.gui.components.NumberRangeChoiceComponent;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.PersistanceManager;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class GameJFrameController {
    private final GameJFrame view;

    private int currentRoundNumber = GameConstants.STARTING_ROUND_NUMBER;
    private int currentTurnNumber = GameConstants.STARTING_TURN_NUMBER;
    private int currentTankTurnNumber = GameConstants.STARTING_TANK_TURN_NUMBER;

    private GameState previousGameState = null;
    private GameState currentGameState = null;
    private GameState nextGameState = null;

    private boolean updating = false;

    public GameJFrameController(GameJFrame view) {
        this.view = view;
        updateGameStates();
        initializeListeners();
        view.getRoundNumberChoiceComponent().setDomain(1, PersistanceManager.getRoundsNumber());
        setBoardFields(PersistanceManager.getFields());
        displayGameState();
    }

    public void setBoardFields(Field[][] fields) {
        view.getBoardVisualizationComponent().setFields(fields);
        view.pack();
    }

    private void initializeListeners() {
        view.getPreviousStateButton().addActionListener(
                e -> SwingUtilities.invokeLater(
                        () -> {
                            gameStatePrevious();
                            displayGameState();
                        }
                )
        );

        view.getNextStateButton().addActionListener(
                e -> SwingUtilities.invokeLater(
                        () -> {
                            gameStateNext();
                            displayGameState();
                        }
                )
        );

        view.getRoundNumberChoiceComponent().addActionListener(
                evt -> SwingUtilities.invokeLater(
                        () -> {
                            Integer newItem = extractNumberChoice(evt);
                            if (newItem == null) {
                                return;
                            }
                            if (newItem == currentRoundNumber) {
                                return;
                            }
                            roundNumberChosen(newItem);
                        }
                )
        );

        view.getTurnNumberChoiceComponent().addActionListener(
                evt -> SwingUtilities.invokeLater(
                        () -> {
                            Integer newItem = extractNumberChoice(evt);
                            if (newItem == null) {
                                return;
                            }
                            if (newItem == currentTurnNumber) {
                                return;
                            }
                            turnNumberChosen(newItem);
                        }
                )
        );

        view.getTankTurnNumberChoiceComponent().addActionListener(
                evt -> SwingUtilities.invokeLater(
                        () -> {
                            Integer newItem = extractNumberChoice(evt);
                            if (newItem == null) {
                                return;
                            }
                            if (newItem == currentTankTurnNumber) {
                                return;
                            }
                            tankTurnNumberChosen(newItem);
                        }
                )
        );
    }

    private Integer extractNumberChoice(ActionEvent evt) {
        if (updating) {
            return null;
        }
        if ("comboBoxChanged".equals(evt.getActionCommand())) {
            NumberRangeChoiceComponent choiceComponent = (NumberRangeChoiceComponent) evt.getSource();
            if (choiceComponent == null) {
                return null;
            }

            Object selectedItem = choiceComponent.getSelectedItem();
            if (selectedItem == null) {
                return null;
            }

            if (selectedItem instanceof String) {
                try {
                    selectedItem = Integer.parseInt((String) selectedItem);
                } catch (NumberFormatException e) { // invalid input
                    return null;
                }
            }

            int newItem = (int) selectedItem;

            if (newItem < choiceComponent.getMin() || newItem > choiceComponent.getMax()) {
                return null;
            }
            return newItem;
        }
        return null;
    }

    private void roundNumberChosen(int roundNumber) {
        currentRoundNumber = roundNumber;
        currentTurnNumber = 1;
        currentTankTurnNumber = 1;
        updateGameStates();
        displayGameState();
    }

    private void turnNumberChosen(int turnNumber) {
        currentTurnNumber = turnNumber;
        currentTankTurnNumber = 1;
        updateGameStates();
        displayGameState();
    }

    private void tankTurnNumberChosen(int tankTurnNumber) {
        currentTankTurnNumber = tankTurnNumber;
        updateGameStates();
        displayGameState();
    }

    private synchronized void displayGameState() {
        updating = true;
        updateButtons();
        updateBoardVisualization();
        updateGameStateChoice();
        updateTankSummary();
        updateLabels();
        updating = false;
    }

    private void updateLabels() {
        view.getCurrentRoundNumberLabel().setText(String.valueOf(currentRoundNumber));
        view.getCurrentTurnNumberLabel().setText(String.valueOf(currentTurnNumber));
        view.getCurrentTankTurnNumberLabel().setText(String.valueOf(currentTankTurnNumber));
    }

    private void updateTankSummary() {
        view.getCurrentTankSummaryComponent().setTank(
                currentGameState.getCurrentTank()
        );
    }

    private void updateGameStateChoice() {
        NumberRangeChoiceComponent roundChoice = view.getRoundNumberChoiceComponent();
        NumberRangeChoiceComponent turnChoice = view.getTurnNumberChoiceComponent();
        NumberRangeChoiceComponent tankTurnChoice = view.getTankTurnNumberChoiceComponent();

        turnChoice.setDomain(1, PersistanceManager.getTurnsNumber(currentRoundNumber));
        tankTurnChoice.setDomain(1, PersistanceManager.getTankTurnsNumber(currentRoundNumber, currentTurnNumber));

        roundChoice.setSelectedItem(currentRoundNumber);
        turnChoice.setSelectedItem(currentTurnNumber);
        tankTurnChoice.setSelectedItem(currentTankTurnNumber);
    }

    private void updateBoardVisualization() {
        view.getBoardVisualizationComponent().displayGameState(
                currentGameState
        );
    }

    private void updateButtons() {
        JButton prevButton = view.getPreviousStateButton();
        JButton nextButton = view.getNextStateButton();

        if (nextGameState == null) {
            nextButton.setEnabled(false);
        } else {
            nextButton.setEnabled(true);
        }
        if (previousGameState == null) {
            prevButton.setEnabled(false);
        } else {
            prevButton.setEnabled(true);
        }
    }

    private synchronized void gameStateNext() {
        previousGameState = currentGameState;

        if (nextGameState != null) {
            currentGameState = nextGameState;
        } else {
            currentGameState = getNextGameState();
        }
        currentRoundNumber = currentGameState.getRoundNumber();
        currentTurnNumber = currentGameState.getTurnNumber();
        currentTankTurnNumber = currentGameState.getTankTurnNumber();

        nextGameState = getNextGameState();
    }

    private synchronized void gameStatePrevious() {
        nextGameState = currentGameState;

        if (previousGameState != null) {
            currentGameState = previousGameState;
        } else {
            currentGameState = getPreviousGameState();
        }
        currentRoundNumber = currentGameState.getRoundNumber();
        currentTurnNumber = currentGameState.getTurnNumber();
        currentTankTurnNumber = currentGameState.getTankTurnNumber();

        previousGameState = getPreviousGameState();
    }

    private synchronized void updateGameStates() {
        previousGameState = getPreviousGameState();
        currentGameState = getCurrentGameState();
        nextGameState = getNextGameState();
    }

    private GameState getPreviousGameState() {
        return PersistanceManager.getPrevGameState(currentRoundNumber, currentTurnNumber, currentTankTurnNumber);
    }

    private GameState getCurrentGameState() {
        return PersistanceManager.getGameState(currentRoundNumber, currentTurnNumber, currentTankTurnNumber);
    }

    private GameState getNextGameState() {
        return PersistanceManager.getNextGameState(currentRoundNumber, currentTurnNumber, currentTankTurnNumber);
    }
}
