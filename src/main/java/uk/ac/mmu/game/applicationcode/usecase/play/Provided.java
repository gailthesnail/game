package uk.ac.mmu.game.applicationcode.usecase.play;

import uk.ac.mmu.game.applicationcode.usecase.*;

public interface Provided {
    void play(); //Play the game and output to console

    static Provided getInstance(RequiredDice dice, RequiredIndex index, RequiredHit hit,RequiredPlayerList playerList, RequiredPlayerSelector playerSelector) {
        return new UseCase(dice, index, hit, playerList, playerSelector);
    }
}
