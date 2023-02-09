package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.level.Player;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LivesPanel extends Panel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The map of players and the labels their scores are on.
     */


    /**
     * The default way in which the score is shown.
     */
    public static final Panel.PanelFormatter DEFAULT_SCORE_FORMATTER =
        (Player player) -> String.format("Lives: %3d", player.getNbLives());

    /**
     * The way to format the score information.
     */
    private Panel.PanelFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;

    /**
     * Creates a new score panel with a column for each player.
     *
     * @param players
     *            The players to display the scores of.
     */
    public LivesPanel(List<Player> players) {
        super(players);
        labels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel label = new JLabel(String.valueOf(player.getNbLives()), JLabel.CENTER);
            labels.put(player, label);
            add(label);
        }

    }

    /**
     * Refreshes the scores of the players.
     */
    protected void refresh() {
        for (Map.Entry<Player, JLabel> entry : labels.entrySet()) {
            Player player = entry.getKey();
            String lives= "";
            lives += scoreFormatter.format(player);
            entry.getValue().setText(lives);
        }
    }

    /**
     * Provide means to format the score for a given player.
     */
//    public interface ScoreFormatter {
//
//        /**
//         * Format the score of a given player.
//         * @param player The player and its score
//         * @return Formatted score.
//         */
//        String format(Player player);
//    }

    /**
     * Let the score panel use a dedicated score formatter.
     * @param scoreFormatter Score formatter to be used.
     */
    public void setPanelFormatter(Panel.PanelFormatter scoreFormatter) {
        assert scoreFormatter != null;
        this.scoreFormatter = scoreFormatter;
    }
}

