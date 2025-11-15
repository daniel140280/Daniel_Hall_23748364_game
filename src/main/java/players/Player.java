package players;

import playergamepositions.MoveHistory;
import playergamepositions.Position;

/**
 * Declaring Player as an interface (abstract type) to support any future Player requirements that require shared actions.
 * Each implementation of Player will provide which concrete implementation to apply (instantiate).
 */
public interface Player {
    //REMEMBER TO CONSIDER ENCAPSULATION - PUBLIC, PRIVATE ETC
    String getName();                               //Player name.
    String getColorCode();                          //ANSI colour code used for console output and improved visibility of player.
    Position getPosition();
    MoveHistory getMoveHistory();
    int getMoveCount();

    //METHOD BEHAVIOURS ON PLAYER
    void performMove(int moves);
    void forfeitMove(int attemptedPosition);
    void endMove(int attemptedPosition);

    //String[] getBoard();                            //The players board layout.
//    int getPosition();                              //Current index on the board.
//    void move(int steps);                           //Move forward by dice roll.
//    int getMoveCount();                             //Total successful moves,
//    void recordForfeitMove(int attemptedPosition);  //Log overshoots.
//    void recordBlockedMove(int attemptedPosition);  // Lof blocked moves when hitting another player.
//    //boolean hasWon();                               //Check win condition.
//    List<String> getMoveHistory();                  //Full move history.
}
