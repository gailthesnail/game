package uk.ac.mmu.game.temp;

public interface HitStrategy {
    int move(int shake, int currentIndex,int currentPosition,int playerNumber, int[] otherPlayerPositions, int endOfTailIndex);
    void outcome(String collidedPlayerName, int collidedPlayerPosition,Player player, int shake,IndexStrategy indexStrategy, String start);
}
