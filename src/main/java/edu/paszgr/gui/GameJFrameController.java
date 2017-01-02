package edu.paszgr.gui;

import edu.paszgr.board.Field;
import edu.paszgr.persistence.GameState;
import edu.paszgr.persistence.PersistanceManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameJFrameController {
    private final GameJFrame view;

    private final PersistanceManager persistanceManager = new PersistanceManager();
    private Field[][] fields = null;

    private int currentRoundNumber = 1;
    private int currentTurnNumber = 1;
    private int currentTankTurnNumber = 1;

    private GameState previousGameState = null;
    private GameState currentGameState = null;
    private GameState nextGameState = null;


    public GameJFrameController(GameJFrame view) {
        this.view = view;
        updateGameStates();
        initializeListeners();
    }

    public void setBoardFields(Field[][] fields) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.getBoardVisualizationComponent().setFields(fields);
                view.getBoardVisualizationComponent().repaint();
            }
        });
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

    }


    private void roundNumberChosen(int roundNumber) {

    }

    private void turnNumberChosen(int turnNumber) {

    }

    private void tankTurnNumberChosen(int currentTankTurnNumber) {

    }

    private void displayGameState() {
        updateButtons();
        updateBoardVisualization();
        updateGameStateChoice();
        updateTankSummary();
        updateLabels();
    }

    private void updateLabels() {
        // TODO
    }

    private void updateTankSummary() {
        // TODO
    }

    private void updateGameStateChoice() {
        // TODO
    }

    private void updateBoardVisualization() {
        // TODO
    }

    private void updateButtons() {
        // TODO
    }

    private void gameStateNext() {
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

    private void gameStatePrevious() {
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

    private void updateGameStates() {
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
