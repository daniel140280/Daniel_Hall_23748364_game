package gamestrategy;

import playergamepositions.PlayerContext;

public class BasicEndOrBeyondStrategy implements EndStrategy{
    //In this method the game can end with an exact landing on the end or by overshooting.
    @Override
    public void handle(PlayerContext context, int attemptedPosition){
        if(attemptedPosition == context.getPosition().getIndex()){
            context.getHistory().add("Landed exactly on end position " + attemptedPosition);
        } else {
            int overshotBy = attemptedPosition - context.getPosition().getIndex();
            context.getHistory().add("Overshot by " + overshotBy);
        }
    }
}
