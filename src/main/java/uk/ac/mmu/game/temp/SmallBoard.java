package uk.ac.mmu.game.temp;

public class SmallBoard implements Board{
    final static int START_OF_TAIL_INDEX = 18; //private modifier?
    final static int END_OF_TAIL_INDEX = 20;

    final static int[] RED_POSITIONS = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3
    };

    static final int[] BLUE_POSITIONS = new int[]{
            10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3
    };

    @Override
    public String toString() {
        return "Small board for 2 players";
    }
}
