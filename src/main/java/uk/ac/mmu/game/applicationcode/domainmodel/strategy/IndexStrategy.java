package uk.ac.mmu.game.applicationcode.domainmodel.strategy;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;

public interface IndexStrategy {
    int calculateIndex(int currentIndex, int positions, int endOfTailIndex, Player player);
    void outcome(Player player);
}
