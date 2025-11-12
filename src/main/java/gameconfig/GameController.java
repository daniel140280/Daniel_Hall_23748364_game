package gameconfig;

import board.GameBoard;
import dice.DiceShaker;
import gameobserver.GameListener;
import playergamepositions.Position;
import players.Player;

import java.util.ArrayList;
import java.util.List;

//Purpose of the GameController is to set up the board and players based on the variation selected.
//It acts as a Facade for future game variants.
public class GameController {
    //GameListener added to support an observer pattern to print out the Player activities during the game.
    private final Player[] players;
    private final DiceShaker diceShaker;
    private final GameBoard gameBoard;
    private final List<GameListener> listenerList;

    //Constructor that can accept listeners.
    public GameController(Player[] players, DiceShaker diceShaker, GameBoard gameBoard, List<GameListener> listenerList){
        this.players = players;
        this.diceShaker = diceShaker;
        this.gameBoard = gameBoard;
        this.listenerList = listenerList;
    }

    public void playGame() {
        boolean gameOver = false;                                   //Game will by default not be over, obviously.
        //Whilst game is not over, the game will loop through the players and perform a diceroll and possible move.
        while(!gameOver) {
            for(Player player:players) {
               int roll = diceShaker.shake();                       //Player in loop shakes the dice.
               int fromPosition = player.getPosition().getIndex();  //Get position object of current player.
               int toPosition = fromPosition + roll;                //Calculate proposed position on the board.

               //1. Observer will handle the output to the console highlighting the player (incl. colour) and what score they rolled.
                notifyMove(player, roll);

               //2. Check the player does not overshoot their board.
               if(toPosition >= gameBoard.getTotalBoardLength()) {
                   player.endMove(toPosition);                      //Check if the move validates the end strategy for this game.
                   notifyEnd(player, toPosition);                   //Observer records the relevant output.
                   continue;                                        //Move to next player without current player moving position.
               }

               //3. Check if another player is already on the target position place.
               boolean blocked = false;
               for(Player other:players) {
                   if(other != player && other.getPosition().equals(new Position(toPosition)) ) {
                       blocked = true;
                       break;
                   }
               }
               if(blocked) {
                   player.forfeitMove(toPosition);                  //Check if the player object hits another player object and apply game strategy.
                   notifyBlocked(player, toPosition);               //Observer outputs the outcome of the strategy applied.
                   continue;                                        //Move to next player without current player moving position.
               }

               //4. Move the player - does not overshoot not are they blocked by another player.
               player.performMove(roll);                            //Updates the players position on their board.
               int newPosition = player.getPosition().getIndex();   //Use the position object.
               notifyMove(player, roll);                            //Ongoing observer output.

               //5. Check if player has won?
                if(gameBoard.isEndPosition(newPosition)) {
                    System.out.println("\n🏆 " + player.getName() + " has reached position " + newPosition + " and wins the game! 🏆");
                    gameOver = true;
                    break;
                }
            }
            //Print the status of the board after every round. ADD TO LISTENER AND WINNING TEXT?
            printBoardStatus();
        }
        //Print the final game summary. UPDATE?
        printGameSummary();
    }
    //Method will print out the current state of play after a round.
    private void printBoardStatus() {
        System.out.println("\nBoard status:");
        for(Player player:players) {
            System.out.println(player.getColorCode() + player.getName() + " is at " + player.getPosition().getIndex() + "\u001B[0m");
        }
    }
    //Method will print out a summary for each player when the game ends.
    private void printGameSummary() {
        System.out.println("\nEnd of game status:");
        for(Player player:players) {
            System.out.println("\n" + player.getColorCode() + player.getName() + "\u001B[0m");
            System.out.println("Moves made:" + player.getMoveCount());
            System.out.println("Final position:" + player.getPosition().getIndex());
            System.out.println("Move history:" + player.getMoveHistory().getAllMoves());
        }
    }
    //Observer method notifications.
    private void notifyMove(Player player, int moves){
        for(GameListener listener: listenerList){
            listener.onMove(player, moves);
        }
    }
    private void notifyBlocked(Player player, int attemptedPosition){
        for(GameListener listener: listenerList){
            listener.blockedMove(player, attemptedPosition);
        }
    }
    private void notifyEnd(Player player, int attemptedPosition){
        for(GameListener listener: listenerList){
            listener.hitEnd(player, attemptedPosition);
        }
    }
}
