package uk.ac.mmu.game.temp;

import java.util.Iterator;

public class PlayerIterable implements Iterable<Player> {
    private final PlayerSelector playerSelector;

    public PlayerIterable(PlayerSelector playerSelector) {
        this.playerSelector = playerSelector;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        @Override
        public boolean hasNext() {
            boolean hasNext =  (!playerSelector.current().isAtEnd());
            return hasNext;
        } //checks player is at end before iterating to next player

        @Override
        public Player next() {
            //The compiler infers Integer.valueOf(playerToReturn) to box the integer
            return playerSelector.next();

        }
    }
}
