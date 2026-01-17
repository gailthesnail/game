package uk.ac.mmu.game.applicationcode.domainmodel;

public class SmallBoard implements Board {
    public final static int START_OF_TAIL_INDEX = 18;
    public final static int END_OF_TAIL_INDEX = 20;

    public final static int[] RED_POSITIONS = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3
    };

    public static final int[] BLUE_POSITIONS = new int[]{
            10, 11, 12, 13, 14, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3
    };

    @Override
    public String toString() {
        return "Small board for 2 players";
    }
}
