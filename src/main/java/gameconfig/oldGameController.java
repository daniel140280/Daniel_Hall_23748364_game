//package gameconfig;
//
//import board.GameBoard;
//import dice.DiceShaker;
//import players.Player;
//
//public class oldGameController {
//}
//package gameconfig;
//
//import board.GameBoard;
//import dice.DiceShaker;
//import players.Player;
//
////Purpose of the GameController is to set up the board and players based on the variation selected.
////THE GAME CONTROLLER IS THE FACADE
//public class GameController {
//    private final Player[] players;
//    private final DiceShaker diceShaker;
//    private final GameBoard board;
//
//    public GameController(Player[] players, DiceShaker diceShaker, GameBoard board) {
//        this.players = players;
//        this.diceShaker = diceShaker;
//        this.board = board;
//    }
//
//    public void playGame() {
//        boolean gameOver = false; //Game will by default not be over, obviously.
//        //Whilst game is not over, the game will loop through the players and perform a diceroll and possible move.
//        while(!gameOver) {
//            for(Player player:players) {
//                int roll = diceShaker.shake(); //Player in loop shakes the dice.
//                int fromPosition = player.getPosition(); //Get position on board of current player.
//                int toPosition = fromPosition + roll; //Calculate proposed position on the board.
//
//                //1. Output to the console highlighting the player (incl. colour) and what score they rolled.
//                System.out.println(player.getColorCode() + "\n🎲 " + player.getName() + " rolls: " + roll + "\u001B[0m");
//
//                //2. Check the player does not overshoot their board.
//                if(toPosition >= board.getTotalBoardLength()) {
//                    System.out.println("Overshot! Must land exactly on position " + (board.getTotalBoardLength() - 1));
//                    player.recordForfeitMove(toPosition); //Log the failed move.
//                    continue; //Move to next player without current player moving position.
//                }
//
//                //3. Check if another player is already on the target position place.
//                boolean blocked = false;
//                for(Player other:players) {
//                    if(other != player && other.getPosition() == toPosition) {
//                        blocked = true;
//                        break;
//                    }
//                }
//                if(blocked) {
//                    System.out.println("Blocked " + player.getName() + " would land on position " + toPosition + ", but it's already occupied. Move forfeited, stay at position " + fromPosition);
//                    player.recordBlockedMove(toPosition); //Log the blocked move.
//                    continue; //Move to next player without current player moving position.
//                }
//
//                //4. Move the player - does not overshoot not are they blocked by another player.
//                player.move(roll); //Updates the players position on their board.
//                int newPosition = player.getPosition();
//                System.out.println(player.getName() + " moves from position " + fromPosition + " to position " + newPosition);
//
//                //5. Check if player has won?
//                if(board.isEndPosition(newPosition)) {
//                    System.out.println("\n🏆 " + player.getName() + " has reached position " + newPosition + " and wins the game! 🏆");
//                    gameOver = true;
//                    break;
//                }
//            }
//            //Print the status of the board after every round.
//            printBoardStatus();
//        }
//        //Print the final game summary.
//        printGameSummary();
//    }
//    //Method will print out the current state of play after a round.
//    private void printBoardStatus() {
//        System.out.println("\nBoard status:");
//        for(Player player:players) {
//            System.out.println(player.getColorCode() + player.getName() + " is at " + player.getPosition() + "\u001B[0m");
//        }
//    }
//    //Method will print out a summary for each player when the game ends.
//    private void printGameSummary() {
//        System.out.println("\nEnd of game status:");
//        for(Player player:players) {
//            System.out.println("\n" + player.getColorCode() + player.getName() + "\u001B[0m");
//            System.out.println("Moves made:" + player.getMoveCount());
//            System.out.println("Final position:" + player.getPosition());
//            System.out.println("Move history:" + player.getMoveHistory());
//        }
//    }
//}
