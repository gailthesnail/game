package uk.ac.mmu.game.applicationcode.domainmodel.rules;
import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.infrastructure.driven.events.HitMoveEvent;
import uk.ac.mmu.game.infrastructure.driven.GameObserver;
import uk.ac.mmu.game.applicationcode.domainmodel.observer.Observer;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.HitStrategy;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.IndexStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MovesIfHitAnotherPlayer implements HitStrategy {
    final List<Observer> observers = new ArrayList<>();

    public MovesIfHitAnotherPlayer(){
        observers.add(new GameObserver());
    }

    public void update (Consumer<Observer> action) {
        observers.forEach(action);
    }

    @Override
    public int move(int shake, int currentIndex,int currentPosition,int playerNumber, int[] otherPlayerPositions,int startOfTailIndex) {
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
        player.advance(shake,indexStrategy);
        onHitMove(collidedPlayerName, collidedPlayerPosition, player.getName(), start, player.getPositionAsString());
    }

    public void onHitMove(String collidedPlayerName, int collidedPlayerPosition, String playerName,String start, String position){
        HitMoveEvent event = new HitMoveEvent(collidedPlayerName, collidedPlayerPosition, playerName, start, position);
        update(observer -> observer.onEvent(event));
    }

    @Override
    public String toString() {
        return "HITS are ignored, multiple players can occupy the same position";
    }
}
