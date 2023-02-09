//package nl.tudelft.jpacman.ui;
//
//import java.awt.GridLayout;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.swing.JLabel;
//
//import nl.tudelft.jpacman.level.Player;
//
///**
// * A panel consisting of a column for each player, with the numbered players on
// * top and their respective scores underneath.
// *
// * @author Jeroen Roosen
// *
// */
//public class ScorePanel extends Panel {
//
//    /**
//     * Default serialisation ID.
//     */
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * The map of players and the labels their scores are on.
//     */
//
//
//    /**
//     * The default way in which the score is shown.
//     */
//    public static final PanelFormatter DEFAULT_SCORE_FORMATTER =
//        (Player player) -> String.format("Score: %3d", player.getScore());
//
//    /**
//     * The way to format the score information.
//     */
//    //private PanelFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;
//
//    /**
//     * Creates a new score panel with a column for each player.
//     *
//     * @param players
//     *            The players to display the scores of.
//     */
////    public ScorePanel(List<Player> players) {
////        super(players);
////        labels = new LinkedHashMap<>();
////        for (Player player : players) {
////            JLabel label = new JLabel("0", JLabel.CENTER);
////            labels.put(player, label);
////            add(label);
////        }
////
////    }
////
////    /**
////     * Refreshes the scores of the players.
////     */
////    protected void refresh() {
////        for (Map.Entry<Player, JLabel> entry : this.labels.entrySet()) {
////            Player player = entry.getKey();
////            String score = "";
////            if (!player.isAlive()) {
////                score = "You died. ";
////            }
////            score += scoreFormatter.format(player);
////            entry.getValue().setText(score);
////        }
////    }
////
////    /**
////     * Provide means to format the score for a given player.
////     */
//////    public interface ScoreFormatter {
//////
//////        /**
//////         * Format the score of a given player.
//////         * @param player The player and its score
//////         * @return Formatted score.
//////         */
//////        String format(Player player);
//////    }
////
////    /**
////     * Let the score panel use a dedicated score formatter.
////     * @param scoreFormatter Score formatter to be used.
////     */
////    public void setPanelFormatter(PanelFormatter scoreFormatter) {
////        assert scoreFormatter != null;
////        this.scoreFormatter = scoreFormatter;
////    }
//}
