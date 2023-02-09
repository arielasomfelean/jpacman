package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.level.Player;

import javax.swing.*;

import java.awt.GridLayout;
import java.util.*;

public class PlayerInfoPanel extends JPanel {


    protected  Map<Player, ArrayList<JLabel>> labels;
    //protected  Map<Player, JLabel> labels;

    public static final PlayerInfoPanel.PanelFormatter DEFAULT_SCORE_FORMATTER =
        (Player player) -> String.format("Score: %3d", player.getScore());

    public static final PlayerInfoPanel.PanelFormatter DEFAULT_LIVES_FORMATTER =
        (Player player) -> String.format("Lives: %3d", player.getNbLives());

    /**
     * The way to format the score information.
     */
    private PlayerInfoPanel.PanelFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;
    private PlayerInfoPanel.PanelFormatter livesFormatter = DEFAULT_LIVES_FORMATTER;

    public PlayerInfoPanel(List<Player> players) {
        super();
        assert players != null;

        setLayout(new GridLayout(3, players.size()));

        for (int i = 1; i <= players.size(); i++) {
            add(new JLabel("Player " + i, JLabel.CENTER));
        }
        labels = new HashMap<Player ,ArrayList<JLabel>>();
        for (Player player : players) {

            JLabel scoreLabel = new JLabel("0", JLabel.CENTER);
            JLabel lifeLabel = new JLabel("3", JLabel.CENTER);
            labels.put(player, new ArrayList<JLabel>());
            labels.get(player).add(scoreLabel);
            labels.get(player).add(lifeLabel);
            add(scoreLabel);
            add(lifeLabel);
        }
    }


    public void refresh() {
        for (Map.Entry<Player, ArrayList<JLabel>> entry : labels.entrySet()) {
            Player player = entry.getKey();
            ArrayList<JLabel> labels = entry.getValue();
            String score = "";
            String lives= "";
            if (!player.isAlive()) {
                score = "You died. ";
            }
            score += scoreFormatter.format(player);
            lives += livesFormatter.format(player);
            labels.get(0).setText(score);
            labels.get(1).setText(lives);
        }
    }


    public interface PanelFormatter {

        /**
         * Format the score of a given player.
         * @param player The player and its score
         * @return Formatted score.
         */
        String format(Player player);
    }

    public void setPanelFormatter(PanelFormatter scoreFormatter,PanelFormatter livesFormatter){
        assert scoreFormatter != null;
        assert livesFormatter != null;
        this.scoreFormatter = scoreFormatter;
        this.livesFormatter = livesFormatter;
    }
}
