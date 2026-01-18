package uk.ac.mmu.game.applicationcode.domainmodel.playerSelection;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.board.SmallBoard;

public class TwoPlayerSelector implements PlayerSelector {
    private final Player[] playerList;
    private int currentPlayer = 0;

    public TwoPlayerSelector() {
        playerList = new Player[]{
                new Player(SmallBoard.RED_POSITIONS, SmallBoard.START_OF_TAIL_INDEX, SmallBoard.END_OF_TAIL_INDEX,"Red",0),
                new Player(SmallBoard.BLUE_POSITIONS, SmallBoard.START_OF_TAIL_INDEX, SmallBoard.END_OF_TAIL_INDEX,"Blue",1),
        };
    }


    @Override
    public Player next() {
        int playerToReturn = currentPlayer;
        currentPlayer = (currentPlayer == 0) ? 1 : 0;
        return playerList[playerToReturn];
    }

    @Override
    public Player current() {
        if (currentPlayer == 1)
            return playerList[0];
        return playerList[1];
    }

    @Override
    public String toString() {
        return "2 players and small board";
    }
}
