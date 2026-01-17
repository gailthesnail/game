package uk.ac.mmu.game.applicationcode.domainmodel.rules;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.infrastructure.events.HitStayEvent;
import uk.ac.mmu.game.infrastructure.observer.GameObserver;
import uk.ac.mmu.game.infrastructure.observer.Observer;
import uk.ac.mmu.game.infrastructure.strategy.HitStrategy;
import uk.ac.mmu.game.infrastructure.strategy.IndexStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StaysIfHitAnotherPlayer implements HitStrategy {
    final List<Observer> observers = new ArrayList<>();

    public StaysIfHitAnotherPlayer(){
        observers.add(new GameObserver());
    }

    public void update (Consumer<Observer> action) {
        observers.forEach(action);
    }

    @Override
    public int move(int shake, int currentIndex, int currentPosition,int playerNumber, int[] otherPlayerPositions, int startOfTailIndex) {//change move to checkHit and boolean
        if (!(currentIndex + shake > startOfTailIndex )) {
            for (int i = 0; i < otherPlayerPositions.length; i++) {
                if ((playerNumber != i)&&(currentPosition + shake == otherPlayerPositions[i])) {
                    return i;
                }
            }
        }
        return playerNumber;
    }

    @Override
    public void outcome(String collidedPlayerName, int collidedPlayerPosition, Player player, int shake, IndexStrategy indexStrategy, String start) {
        onHitStay(collidedPlayerName, collidedPlayerPosition, player.getName(), player.getPositionAsString());
    }

    public void onHitStay(String collidedPlayerName, int collidedPlayerPosition, String playerName, String position){
        HitStayEvent event = new HitStayEvent(collidedPlayerName, collidedPlayerPosition, playerName, position);
        update(observer -> observer.onEvent(event));
    }

    @Override
    public String toString() {
        return "Player's turn is forfeit if the player would HIT another player";
    }
}
