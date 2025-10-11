package players;

import java.util.ArrayList;
import java.util.List;

public class RedPlayer implements Player {
    /*The board length for specific players will be fixed, and therefore final.
    The array will be type String to allow for integers and strings, with the index referencing a players position.
    */
     private final String[] board = {"1 (Home)", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "R1", "R2", "R3 (End)"};
     //Position will store what the index reference position against the relevant  players board.
    private int position = 0;
    //Move count will track how many moves (shakes) the player makes.
    private int moveCount = 0;
    //A new array will capture the players moves throughout the game.
    private final List<String> moveHistory = new ArrayList<>();
    //Declaring our players name. This could be set by user input in future variations.
    private final String name = "Red";
    public String getColorCode() {
        return "\u001B[31m"; //Red colour.
    }
    public String[] getBoard() {
        return board;
    }
    public int getPosition() {
        return position;
    }
    @Override
    public int getMoveCount() {
        return moveCount;
    }
    public String getName() {
        return  name;
    }
    @Override
    public void move(int steps) {
            position += steps;
            moveCount++;
            moveHistory.add(board[position]);
    }
    @Override
    public void recordForfeitMove(int attemptedPosition) {
        int overshotBy = attemptedPosition - board.length +1;
        moveHistory.add("Overshot by " + overshotBy);
    }
    @Override
    public void recordBlockedMove(int attemptedPosition) {
        moveHistory.add("Blocked at " + board[attemptedPosition]);
    }
    @Override
    public boolean hasWon() {
        return board[position].equals(board[board.length -1]);
    }
    @Override
    public List<String> getMoveHistory() {
        return moveHistory;
    }
}
