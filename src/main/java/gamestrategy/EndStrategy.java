package gamestrategy;

import playergamepositions.PlayerContext;

public interface EndStrategy {
    void handle(PlayerContext context, int attemptedPosition);
}
