package gamestrategy;

import playergamepositions.PlayerContext;

public class BasicNoHitStrategy implements HitStrategy{
    @Override
    public void handle(PlayerContext context, int attemptedPosition){
        context.getHistory().add("Moved to position " + context.getPosition());
    }
}
