package uk.ac.mmu.game.infrastructure.dice;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;

public class DiceShakerDecorator implements DiceShaker {
    private final DiceShaker component;
    private final DiceShaker shaker = new SingleDiceShaker();
    DiceShakerDecorator(DiceShaker component) {
        this.component = component;
    }

    @Override
    public int shake() {
        return shaker.shake() + component.shake();
    }
}
