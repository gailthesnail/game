package uk.ac.mmu.game.infrastructure.playerSelection;

import uk.ac.mmu.game.applicationcode.domainmodel.LargeBoard;
import uk.ac.mmu.game.applicationcode.domainmodel.Player;

public class FourPlayerSelector implements PlayerSelector {
    private final Player[] playerList;
    private int currentPlayer = 0;

    public FourPlayerSelector() {
        playerList = new Player[]{
                new Player(LargeBoard.RED_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Red",0),
                new Player(LargeBoard.BLUE_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Blue",1),
                new Player(LargeBoard.GREEN_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Green",2),
                new Player(LargeBoard.YELLOW_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Yellow",3),
        };
    }

    @Override
    public Player next() {
        int playerToReturn = currentPlayer;
        currentPlayer = (currentPlayer + 1) % 4;
        return playerList[playerToReturn];
    }

    @Override
    public Player current() {
        if (currentPlayer == 1)
            return playerList[0];
        else if (currentPlayer == 2) {
            return playerList[1];
        } else if (currentPlayer == 3) {
            return playerList[2];
        }
        return playerList[3];
    }

    @Override
    public String toString() {
        return "4 players and large board";
    }
}
