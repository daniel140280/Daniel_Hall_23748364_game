package playergamepositions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Value Object to keep abreast of a Players game moves.
public class MoveHistory {
    private final List<String> history = new ArrayList<>();

    //Method to add a Player moves to an overall move history array.
    public void add(String move){
        history.add(move);
    }

    //Method to return the move history array.
    public List<String> getAllMoves(){
        return Collections.unmodifiableList(history);
    }
}
