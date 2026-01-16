package uk.ac.mmu.game.temp;

import java.util.Random;

public class SingleDiceShaker implements DiceShaker {

    private final Random random = new Random();

    @Override
    public int shake() {
        //generate number between 1 and 6
        return random.nextInt(6) + 1;
    }

    @Override
    public String toString() {
        return "Single Dice Shaker";
    }
}
