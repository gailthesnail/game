package uk.ac.mmu.game.temp;

import java.util.Arrays;

public class NonRandomDiceShaker  implements DiceShaker {
    private int current;
    private final int[] rolls;

    public NonRandomDiceShaker(int [] rolls) {
        current = 0;
        this.rolls = rolls;
    }

    @Override
    public int shake() {
        int toRoll = current;
        current++;
        return rolls[toRoll];
    }

    @Override
    public String toString() {
        return "Fixed dice rolls " + Arrays.toString(rolls);
    }
}
