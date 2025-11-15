package gamestrategy;

import playergamepositions.PlayerContext;

public interface MoveStrategy {
    void move(PlayerContext context, int moves);

}
