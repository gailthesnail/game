package uk.ac.mmu.game.applicationcode.usecase.play;

import uk.ac.mmu.game.applicationcode.usecase.Required;

public interface Provided {
    void play(); //Play the game and output to console

    static Provided getInstance(Required required)
    {
        return new UseCase(required);
    }

}
