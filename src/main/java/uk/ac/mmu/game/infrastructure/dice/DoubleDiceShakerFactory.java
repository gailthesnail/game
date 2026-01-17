package uk.ac.mmu.game.infrastructure.dice;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;

public class DoubleDiceShakerFactory implements DiceShakerFactory {
    private final DiceShakerFactory factory = new SingleDiceShakerFactory();
    @Override
    public DiceShaker create() {
        return new DiceShakerDecorator(factory.create());
    }

    @Override
    public String toString() {
        return "Double Dice Shaker";
    }
}
