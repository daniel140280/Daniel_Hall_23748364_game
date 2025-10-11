package gameconfig;

import dice.DiceShaker;
import players.Player;

//Purpose of the GameController is to set up the board and players based on the variation selected.
public class GameController {
    private final Player[] players;
    private final DiceShaker diceShaker;

    public GameController(Player[] players, DiceShaker diceShaker) {
        this.players = players;
        this.diceShaker = diceShaker;
    }

    public void playGame() {
        boolean gameOver = false; //Game will by default not be over, obviously.
        //Whilst game is not over, the game will loop through the players and perform a diceroll and possible move.
        while(!gameOver) {
            for(Player player:players) {
               int roll = diceShaker.shake(); //Player in loop shakes the dice.
               int fromPosition = player.getPosition(); //Get position on board of current player.
               int toPosition = fromPosition + roll; //Calculate proposed position on the board.

               //1. Output to the console highlighting the player (incl. colour) and what score they rolled.
               System.out.println(player.getColorCode() + "\n🎲 " + player.getName() + " rolls: " + roll + "\u001B[0m");

               //2. Check the player does not overshoot their board.
               if(toPosition >= player.getBoard().length) {
                   System.out.println("Overshot! Must land exactly on " + player.getBoard()[player.getBoard().length - 1]);
                   player.recordForfeitMove(toPosition); //Log the failed move.
                   continue; //Move to next player without current player moving position.
               }

               //3. Check if another player is already on the target position place.
               boolean blocked = false;
               for(Player other:players) {
                   if(other != player && other.getPosition() == toPosition) {
                       blocked = true;
                       break;
                   }
               }
               if(blocked) {
                   System.out.println("Blocked " + player.getName() + " would land on " + player.getBoard()[toPosition] + ", but it's already occupied. Move forfeited, stay at position " + player.getBoard()[fromPosition]);
                   player.recordBlockedMove(toPosition); //Log the blocked move.
                   continue; //Move to next player without current player moving position.
               }

               //4. Move the player - does not overshoot not are they blocked by another player.
               player.move(roll); //Updates the players position on their board.
               int newPosition = player.getPosition();
               System.out.println(player.getName() + " moves from " + player.getBoard()[fromPosition] + " to " + player.getBoard()[newPosition]);

               //5. Check if player has won?
                if(player.hasWon()) {
                    System.out.println("\n🏆 " + player.getName() + " has reached " + player.getBoard()[newPosition] + " and wins the game!");
                    gameOver = true;
                    break;
                }
            }
            //Print the status of the board after every round.
            printBoardStatus();
        }
        //Print the final game summary.
        printGameSummary();
    }
    //Method will print out the current state of play after a round.
    private void printBoardStatus() {
        System.out.println("\n Board status:");
        for(Player player:players) {
            System.out.println(player.getName() + " is at " + player.getBoard()[player.getPosition()]);
        }
    }
    //Method will print out a summary for each player when the game ends.
    private void printGameSummary() {
        System.out.println("\n End of game status:");
        for(Player player:players) {
            System.out.println("\n" + player.getName());
            System.out.println("Moves made:" + player.getMoveCount());
            System.out.println("Final position:" + player.getBoard()[player.getPosition()]);
            System.out.println("Move history:" + player.getMoveHistory());
        }
    }
}
