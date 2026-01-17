package uk.ac.mmu.game.applicationcode.domainmodel.playerSelection;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;

public interface PlayerSelector {
    Player next();
    Player current();
}
