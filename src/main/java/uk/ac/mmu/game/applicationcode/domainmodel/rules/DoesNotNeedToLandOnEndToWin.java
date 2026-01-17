package uk.ac.mmu.game.applicationcode.domainmodel.rules;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.infrastructure.observer.GameObserver;
import uk.ac.mmu.game.infrastructure.strategy.IndexStrategy;
import uk.ac.mmu.game.infrastructure.observer.Observer;
import uk.ac.mmu.game.infrastructure.events.OvershootEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoesNotNeedToLandOnEndToWin implements IndexStrategy {
    final List<Observer> observers = new ArrayList<>();

    DoesNotNeedToLandOnEndToWin(){
        observers.add(new GameObserver());
    }

    public void update (Consumer<Observer> action) {
        observers.forEach(action);
    }

    @Override
    public int calculateIndex(int currentIndex, int shake, int endOfTailIndex, Player player) {
        currentIndex = currentIndex + shake;
        if (currentIndex == endOfTailIndex) {
            currentIndex = endOfTailIndex;
        } else if (currentIndex > endOfTailIndex) {
            //Overshoot
            outcome(player);
            currentIndex = endOfTailIndex;
        }
        return currentIndex;
    }

    @Override
    public void outcome(Player player) {
        onOvershoot(player.getName());
    }

    public void onOvershoot(String playerName ){
        OvershootEvent event = new OvershootEvent(playerName);
        update(observer -> observer.onEvent(event));
    }

    @Override
    public String toString() {
        return "Player can land on or beyond the END position to win";
    }

}
