package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.level.Player;

import javax.swing.*;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Panel extends JPanel {


     //protected  Map<Player, ArrayList<JLabel>> labels;
    protected  Map<Player, JLabel> labels;

    public Panel(List<Player> players) {
        super();
        assert players != null;

        setLayout(new GridLayout(3, players.size()));

        for (int i = 1; i <= players.size(); i++) {
            add(new JLabel("Player " + i, JLabel.CENTER));
        }
        labels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel label = new JLabel("0", JLabel.CENTER);
            labels.put(player, label);
            add(label);
        }
    }


    protected abstract void refresh();


    public interface PanelFormatter {

        /**
         * Format the score of a given player.
         * @param player The player and its score
         * @return Formatted score.
         */
        String format(Player player);
    }

    public abstract void setPanelFormatter(Panel.PanelFormatter panelFormatter);
}
