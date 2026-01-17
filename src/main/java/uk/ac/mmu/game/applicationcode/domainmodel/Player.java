package uk.ac.mmu.game.applicationcode.domainmodel;

import uk.ac.mmu.game.infrastructure.strategy.HitStrategy;
import uk.ac.mmu.game.infrastructure.strategy.IndexStrategy;

public class Player {

    private final int[] positions;

    private final int START_OF_TAIL_INDEX;
    private final int END_OF_TAIL_INDEX;

    private final String name;
    private final int playerNumber;

    public Player(int[] positions, int startOfTailIndex, int endOfTailIndex, String name, int playerNumber) {
        this.positions = positions;
        this.START_OF_TAIL_INDEX = startOfTailIndex;
        this.END_OF_TAIL_INDEX = endOfTailIndex;

        this.name = name;
        this.playerNumber = playerNumber;
    }

    private int currentIndex = 0;

    public boolean isInBody() {
        return !isInTail();
    }

    public boolean isHome() {
        return currentIndex == 0;
    }

    public boolean isInTail() {
        return currentIndex >= START_OF_TAIL_INDEX;
    }

    public boolean isAtEnd() {
        return currentIndex == END_OF_TAIL_INDEX;
    }

    public int getPosition() {
        return positions[currentIndex];
    }


    public String getName() { return name;}

    public int getPlayerNumber() {return playerNumber;}

    public String getPositionAsString() {
        if (isHome())
            return String.format("HOME (Position %d)", getPosition());
        if (isAtEnd())
            return String.format("END (Tail Position %d)", getPosition());
        if (isInTail())
            return String.format("TAIL (Tail Position %d)", getPosition());
        else
            return String.format("Position %d", getPosition());
    }

//    public void advance(int positions) {
//        currentIndex = currentIndex + positions;
//        if (currentIndex > Board.END_OF_TAIL_INDEX) {
//            currentIndex = Board.END_OF_TAIL_INDEX;
//        }
//    }

    public int hitStrategyCheck(HitStrategy hitStrategy, int shake, int currentPosition, int playerNumber, int[] otherPlayerPositions) {
        return hitStrategy.move(shake, currentIndex,currentPosition,playerNumber, otherPlayerPositions, START_OF_TAIL_INDEX);
    }

    public void hitStrategyOutcome(HitStrategy hitStrategy, String collidedPlayerName, int collidedPlayerPosition, int shake, IndexStrategy indexStrategy, String start) {
        hitStrategy.outcome(collidedPlayerName, collidedPlayerPosition, this, shake, indexStrategy,start);
        //System.out.format("%s Position %s hit! %n",playerList[collidedPlayer].getName(), currentPlayerPositions[collidedPlayer]);
    }

    public void indexStrategyOutcome(IndexStrategy indexStrategy) {
        indexStrategy.outcome(this);
    }

    public void advance(int shake, IndexStrategy indexStrategy) {
        currentIndex =  indexStrategy.calculateIndex(currentIndex, shake, END_OF_TAIL_INDEX,this);

    }
}
