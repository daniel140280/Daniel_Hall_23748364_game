package gameobserver;

import helpers.ConsoleColor;
import players.Player;

public class ObserverConsoleLogger implements GameListener {

    private int lastFromPosition;       //Track the position before the move.
    private int lastRoll;               //Track the last dice roll of the current player.
    private String lastComment = "";    //Tracks any specific commentary based on game strategy, i.e. hit, overshot.

    /**
     * Method to track when a player rolls the dice and attempts to move.
     * It will store the roll and updates the move positions.
     */
    @Override
    public void onMove(Player player, int moves){
        lastRoll = moves;
        lastFromPosition = player.getPosition().getIndex();
        lastComment = "";
       // System.out.println(ConsoleColor.consoleColor(player.getName() + " rolls " + moves, player.getColorCode()));
    }
    /**
     * Method to output a 'hit' if a players move is blocked by another player.
     */
    @Override
    public void blockedMove(Player player, int attemptedPosition){
        lastComment =  "Blocked at position: " + attemptedPosition;
    }
    /**
     * Method to output when a player reaches or overshoots the end of the board.
     */
    @Override
    public void hitEnd(Player player, int attemptedPosition){
        int current = player.getPosition().getIndex();
        if(attemptedPosition == current){
            lastComment = "Landed exactly on the end";
        } else {
            lastComment = "Made end, but you did overshoot by " +(attemptedPosition - current);
        }
//        System.out.println(ConsoleColor.consoleColor("End reached or overshot by " + player.getName() + " at " + attemptedPosition, player.getColorCode()));
    }
    /**
     * Method prints a single-line summary to the console after each player's turn.
     * To be called after each player's turn in GameController.
     */
    public void printTurnSummary(Player player){
        String message = String.format(
                "%s rolled %d | from %d to %d | %s | total moves: %d",
                player.getName(),
                lastRoll,
                lastFromPosition,
                player.getPosition().getIndex(),
                lastComment.isEmpty()? "succesful move" : lastComment,
                player.getMoveCount()
        );
        // Wrap the entire message in the player's color
        System.out.println(ConsoleColor.consoleColor(message, player.getColorCode()));
    }

}