package uk.ac.mmu.game.applicationcode.domainmodel.playerList;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.board.LargeBoard;

public class FourPlayerList implements PlayerList {
    Player[] fourPlayerList = new Player[]{
    new Player(LargeBoard.RED_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Red",0),
    new Player(LargeBoard.BLUE_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Blue",1),
    new Player(LargeBoard.GREEN_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Green",2),
    new Player(LargeBoard.YELLOW_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Yellow",3),
    };

    public Player[] getFourPlayerList() {
        return fourPlayerList;
    }
}
