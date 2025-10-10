package players;

import java.util.ArrayList;
import java.util.List;

public class BluePlayer implements Player {
    /*The board length for specific players will be fixed, and therefore final.
    The array will be type String to allow for integers and strings, with the index referencing a players position.
    */
    private final String[] board = {"10 (Home)", "11", "12", "13", "14", "15", "16", "17", "18",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "B1", "B2", "B3 (End)"};
    //Position will store what the index reference position against the relevant  players board.
    private int position = 0;
    //Move count will track how many moves (shakes) the player makes.
    private int moveCount = 0;
    //A new array will capture the players moves throughout the game.
    private final List<String> moveHistory = new ArrayList<>();
    //Declaring our players name. This could be set by user input in future variations.
    private final String name = "Blue";
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
        if (position + steps < board.length) {
            position += steps;
            moveHistory.add(board[position]);
        } else {
            System.out.println("That roll was too great, you overshot. You must land on B3 (End)");
            moveHistory.add("Overshot!"); //adding a reference to the overall game performance.
        }
    }
    @Override
    public void recordForfeitMove(int attemptedPosition) {
        moveHistory.add("Blocked at " + board[attemptedPosition]);
    }
    @Override
    public boolean hasWon() {
        return board[position].equals("B3 (End)"); //AMEND THESE TO SOMETHING LIKE board[board.length] SO VALUE NOT HARDCODED
    }
    @Override
    public List<String> getMoveHistory() {
        return moveHistory;
    }
}