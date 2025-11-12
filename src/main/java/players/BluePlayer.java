package players;

import gamestrategy.*;
import playergamepositions.MoveHistory;
import playergamepositions.PlayerContext;
import playergamepositions.Position;

public class BluePlayer implements Player {
    /*The board length for specific players will be fixed, and therefore final.
    The array will be type String to allow for integers and strings, with the index referencing a players position.
    */
    private final String name = "Blue";
    private final String colorCode = "\u001B[34m"; //Blue colour.

    private final PlayerContext context;
    private final MoveStrategy moveStrategy;
    private final HitStrategy hitStrategy;
    private final EndStrategy endStrategy;

    //TRIAL FOR NEW BLUE PLAYER WITH BASIC GAME STRATEGY - THIS WILL BECOME THE PLAYER FACTORY.
    public BluePlayer(){
        this.context = new PlayerContext(new Position(0), new MoveHistory());
        this.moveStrategy = new BasicMoveStrategy();
        this.hitStrategy = new BasicNoHitStrategy();
        this.endStrategy = new BasicEndOrBeyondStrategy();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getColorCode(){
        return colorCode;
    }
    @Override
    public Position getPosition(){
        return context.getPosition();
    }
    @Override
    public MoveHistory getMoveHistory(){
        return context.getHistory();
    }
    @Override
    public int getMoveCount(){
        return context.getMoveCount();
    };
    @Override
    public void performMove(int moves){
        moveStrategy.move(context, moves);
    };
    @Override
    public void forfeitMove(int attemptedPosition){
        hitStrategy.handle(context, attemptedPosition);
    };
    @Override
    public void endMove(int attemptedPosition){
        endStrategy.handle(context, attemptedPosition);
    };

//    private final String[] board = {"10 (Home)", "11", "12", "13", "14", "15", "16", "17", "18",
//            "1", "2", "3", "4", "5", "6", "7", "8", "9", "B1", "B2", "B3 (End)"};
    //Position will store what the index reference position against the relevant  players board.
//    private int position = 0;
//    //Move count will track how many moves (shakes) the player makes.
//    private int moveCount = 0;
    //A new array will capture the players moves throughout the game.
//    private final List<String> moveHistory = new ArrayList<>();
    //Declaring our players name. This could be set by user input in future variations.

//    public String[] getBoard() {
//        return board;
//    }
//    public int getPosition() {
//        return position;
//    }
//    @Override
//    public int getMoveCount() {
//        return moveCount;
//    }
//    public String getName() {
//        return  name;
//    }
//    @Override
//    public void move(int steps) {
//            position += steps;
//            moveCount++;
//            moveHistory.add("Moved to position " + position);
//    }
//    @Override
//    public void recordForfeitMove(int attemptedPosition) {
//        int overshotBy = attemptedPosition - position;
//        moveHistory.add("Overshot by " + overshotBy);
//    }
//    @Override
//    public void recordBlockedMove(int attemptedPosition) {
//        moveHistory.add("Blocked at " + attemptedPosition);
//    }
////    @Override
////    public boolean hasWon() {
////        return board[position].equals(board[board.length -1]);
////    }
//    @Override
//    public List<String> getMoveHistory() {
//        return moveHistory;
//    }
}