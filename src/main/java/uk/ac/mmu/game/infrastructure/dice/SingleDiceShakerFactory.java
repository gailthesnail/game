package uk.ac.mmu.game.infrastructure.dice;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;

public class SingleDiceShakerFactory implements DiceShakerFactory {
    @Override
    public DiceShaker create() {
        return new SingleDiceShaker();
    }

    @Override
    public String toString() {
        return "Single Dice Shaker";
    }
}
