package uk.ac.mmu.game.infrastructure.dice;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;

public interface DiceShakerFactory {
    DiceShaker create();
}
