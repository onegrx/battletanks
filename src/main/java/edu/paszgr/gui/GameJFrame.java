package edu.paszgr.gui;

import edu.paszgr.gui.components.BoardVisualizationComponent;
import edu.paszgr.gui.components.NumberRangeChoiceComponent;
import edu.paszgr.gui.components.TankSummaryComponent;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    private final NumberRangeChoiceComponent roundNumberChoiceComponent = new NumberRangeChoiceComponent();
    private final NumberRangeChoiceComponent turnNumberChoiceComponent = new NumberRangeChoiceComponent();
    private final NumberRangeChoiceComponent tankTurnNumberChoiceComponent = new NumberRangeChoiceComponent();

    private final JLabel roundNumberChoiceLabel = new JLabel("Round");
    private final JLabel turnNumberChoiceLabel = new JLabel("Turn");
    private final JLabel tankTurnNumberChoiceLabel = new JLabel("Tank turn");

    private final JLabel roundNumberLabel = new JLabel("Current round");
    private final JLabel turnNumberLabel = new JLabel("Current turn");
    private final JLabel tankTurnNumberLabel = new JLabel("Current tank turn");

    private final JLabel currentRoundNumberLabel = new JLabel("");
    private final JLabel currentTurnNumberLabel = new JLabel("");
    private final JLabel currentTankTurnNumberLabel = new JLabel("");

    private final BoardVisualizationComponent boardVisualizationComponent = new BoardVisualizationComponent();
    private final JButton previousStateButton = new JButton("Previous state");
    private final JButton nextStateButton = new JButton("Next state");
    private final TankSummaryComponent currentTankSummaryComponent = new TankSummaryComponent();

    public GameJFrame() throws HeadlessException {
        super("Battle Tanks");
        // TODO - place components inside this JFrame
    }
}
