package uk.ac.mmu.game.infrastructure.strategy;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;

public interface HitStrategy {
    int move(int shake, int currentIndex,int currentPosition,int playerNumber, int[] otherPlayerPositions, int endOfTailIndex);
    void outcome(String collidedPlayerName, int collidedPlayerPosition, Player player, int shake, IndexStrategy indexStrategy, String start);
}
