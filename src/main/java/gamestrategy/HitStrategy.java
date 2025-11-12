package gamestrategy;

import playergamepositions.PlayerContext;

public interface HitStrategy {
    void handle(PlayerContext context, int attemptedPosition);

}
