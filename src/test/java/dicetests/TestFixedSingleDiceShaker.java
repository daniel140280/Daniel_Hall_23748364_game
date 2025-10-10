package dicetests;

import dice.DiceShaker;

public class TestFixedSingleDiceShaker implements DiceShaker {
    private final int[] shakes = new int[] {
            1,2,3,4,5,6
    };

    private int index = 0;

    @Override
    public int shake() {
        return shakes[index++];
    }
}
