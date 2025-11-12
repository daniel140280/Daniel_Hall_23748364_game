package playergamepositions;

import java.util.Objects;

//Value Object to manage a Players board position.
public class Position {
    private int index;

    //Constructor determines what index position a Player begins the game at.
    public Position(int startIndex){
        this.index = startIndex;
    }

    //Method to manage the Players moves and updating of Board index.
    public void advance(int moves){
        index += moves;
    }

    public int getIndex(){
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index;
    }
    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
