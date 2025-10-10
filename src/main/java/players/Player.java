package players;

import java.util.List;

/**
 * Declaring Player as an interface (abstract type) to support any future Player requirements that require shared actions.
 * Each implementation of Player will provide which concrete implementation to apply (instantiate).
 */
public interface Player {
    //REMEMBER TO CONSIDER ENCAPSULATION - PUBLIC, PRIVATE ETC
    String[] getBoard();
    int getPosition();
    void move(int steps);
    int getMoveCount();
    void recordForfeitMove(int attemptedPosition);
    boolean hasWon();
    String getName();
    List<String> getMoveHistory();
}
