package playergamepositions;

//PlayerContext will be used to hold players state from strategy access.
public class PlayerContext {
    private final Position position;
    private final MoveHistory history;
    private int moveCount;

    //Constructor holding specifics on a Players board position and move history.
    public PlayerContext(Position position, MoveHistory history){
        this.position = position;
        this.history = history;
    }

    public Position getPosition(){
        return position;
    }

    public MoveHistory getHistory(){
        return history;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public void increaseMoveCount(){
        moveCount++;
    }
}
