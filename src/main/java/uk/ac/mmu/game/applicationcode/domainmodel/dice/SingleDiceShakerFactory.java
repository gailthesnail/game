package uk.ac.mmu.game.applicationcode.domainmodel.dice;

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
