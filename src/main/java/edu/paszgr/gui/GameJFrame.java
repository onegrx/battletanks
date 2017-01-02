package edu.paszgr.gui;

import edu.paszgr.gui.components.BoardVisualizationComponent;
import edu.paszgr.gui.components.NumberRangeChoiceComponent;
import edu.paszgr.gui.components.TankSummaryComponent;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    private final JPanel contentPane;

    private final NumberRangeChoiceComponent roundNumberChoiceComponent = new NumberRangeChoiceComponent();
    private final NumberRangeChoiceComponent turnNumberChoiceComponent = new NumberRangeChoiceComponent();
    private final NumberRangeChoiceComponent tankTurnNumberChoiceComponent = new NumberRangeChoiceComponent();

    private final JLabel roundNumberChoiceLabel = new JLabel("Round");
    private final JLabel turnNumberChoiceLabel = new JLabel("Turn");
    private final JLabel tankTurnNumberChoiceLabel = new JLabel("Tank turn");

    private final JLabel roundNumberLabel = new JLabel("Current round");
    private final JLabel turnNumberLabel = new JLabel("Current turn");
    private final JLabel tankTurnNumberLabel = new JLabel("Current tank turn");

    private final JLabel currentRoundNumberLabel = new JLabel("-");
    private final JLabel currentTurnNumberLabel = new JLabel("-");
    private final JLabel currentTankTurnNumberLabel = new JLabel("-");

    private final BoardVisualizationComponent boardVisualizationComponent = new BoardVisualizationComponent();
    private final JButton previousStateButton = new JButton("Previous state");
    private final JButton nextStateButton = new JButton("Next state");
    private final TankSummaryComponent currentTankSummaryComponent = new TankSummaryComponent();

    public GameJFrame() throws HeadlessException {
        super("Battle Tanks");

        contentPane = new JPanel(new GridBagLayout());
        setContentPane(contentPane);

        addComponentGridBag(roundNumberChoiceLabel, 0, 0, 1, 1);
        addComponentGridBag(turnNumberChoiceLabel, 1, 0, 1, 1);
        addComponentGridBag(tankTurnNumberChoiceLabel, 2, 0, 1, 1);
        addComponentGridBag(roundNumberLabel, 3, 0, 1, 1);
        addComponentGridBag(turnNumberLabel, 4, 0, 1, 1);
        addComponentGridBag(tankTurnNumberLabel, 5, 0, 1, 1);

        addComponentGridBag(roundNumberChoiceComponent, 0, 1, 1, 1);
        addComponentGridBag(turnNumberChoiceComponent, 1, 1, 1, 1);
        addComponentGridBag(tankTurnNumberChoiceComponent, 2, 1, 1, 1);
        addComponentGridBag(currentRoundNumberLabel, 3, 1, 1, 1);
        addComponentGridBag(currentTurnNumberLabel, 4, 1, 1, 1);
        addComponentGridBag(currentTankTurnNumberLabel, 5, 1, 1, 1);

        addComponentGridBag(boardVisualizationComponent, 0, 2, 6, 1);

        addComponentGridBag(previousStateButton, 0, 3, 1, 1);
        addComponentGridBag(currentTankSummaryComponent, 1, 3, 4, 1);
        addComponentGridBag(nextStateButton, 5, 3, 1, 1);

        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setEnabled(true);
    }

    private void addComponentGridBag(JComponent component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.insets = new Insets(3, 3, 3, 3);
        contentPane.add(component, c);
    }

    public BoardVisualizationComponent getBoardVisualizationComponent() {
        return boardVisualizationComponent;
    }

    public JLabel getCurrentRoundNumberLabel() {
        return currentRoundNumberLabel;
    }

    public TankSummaryComponent getCurrentTankSummaryComponent() {
        return currentTankSummaryComponent;
    }

    public JLabel getCurrentTankTurnNumberLabel() {
        return currentTankTurnNumberLabel;
    }

    public JLabel getCurrentTurnNumberLabel() {
        return currentTurnNumberLabel;
    }

    public JButton getNextStateButton() {
        return nextStateButton;
    }

    public JButton getPreviousStateButton() {
        return previousStateButton;
    }

    public NumberRangeChoiceComponent getRoundNumberChoiceComponent() {
        return roundNumberChoiceComponent;
    }

    public JLabel getRoundNumberChoiceLabel() {
        return roundNumberChoiceLabel;
    }

    public JLabel getRoundNumberLabel() {
        return roundNumberLabel;
    }

    public NumberRangeChoiceComponent getTankTurnNumberChoiceComponent() {
        return tankTurnNumberChoiceComponent;
    }

    public JLabel getTankTurnNumberChoiceLabel() {
        return tankTurnNumberChoiceLabel;
    }

    public JLabel getTankTurnNumberLabel() {
        return tankTurnNumberLabel;
    }

    public NumberRangeChoiceComponent getTurnNumberChoiceComponent() {
        return turnNumberChoiceComponent;
    }

    public JLabel getTurnNumberChoiceLabel() {
        return turnNumberChoiceLabel;
    }

    public JLabel getTurnNumberLabel() {
        return turnNumberLabel;
    }
}














