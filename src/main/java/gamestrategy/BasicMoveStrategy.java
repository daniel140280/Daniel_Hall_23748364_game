package gamestrategy;

import playergamepositions.PlayerContext;

public class BasicMoveStrategy implements MoveStrategy{
    @Override
    public void move(PlayerContext context, int moves){
        context.getPosition().advance(moves);
        context.increaseMoveCount();
        context.getHistory().add("Moved to position " + context.getPosition().getIndex()); //BREAK THIS OUT AGAIN?
    };

}
