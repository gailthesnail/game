package uk.ac.mmu.game.temp;

public interface IndexStrategy {
    int calculateIndex(int currentIndex, int positions, int endOfTailIndex, Player player);
    void outcome(Player player);
}
