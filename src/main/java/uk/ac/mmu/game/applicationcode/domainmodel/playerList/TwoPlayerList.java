package uk.ac.mmu.game.applicationcode.domainmodel.playerList;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.board.SmallBoard;

public class TwoPlayerList implements PlayerList {
    Player[] twoPlayerList = new Player[]{
            new Player(SmallBoard.RED_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Red",0),
            new Player(SmallBoard.BLUE_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Blue",1),
    };

    public Player[] getTwoPlayerList() {
        return twoPlayerList;
    }
}
