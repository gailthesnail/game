package uk.ac.mmu.game.applicationcode.domainmodel.rules;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.infrastructure.events.OvershootEvent;
import uk.ac.mmu.game.infrastructure.events.OvershootStayEvent;
import uk.ac.mmu.game.infrastructure.observer.GameObserver;
import uk.ac.mmu.game.infrastructure.observer.Observer;
import uk.ac.mmu.game.infrastructure.strategy.IndexStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NeedToLandOnEndToWin implements IndexStrategy {

    final List<Observer> observers = new ArrayList<>();

    public NeedToLandOnEndToWin(){
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
            currentIndex = currentIndex - shake;
        }
        return currentIndex;
    }

    @Override
    public void outcome(Player player) {
        onOvershoot(player.getName());
        onOvershootStay(player.getName(),  player.getPositionAsString());
    }

    public void onOvershoot(String playerName ){
        OvershootEvent event = new OvershootEvent(playerName);
        update(observer -> observer.onEvent(event));
    }

    public void onOvershootStay(String playerName, String position ){
        OvershootStayEvent event = new OvershootStayEvent(playerName, position);
        update(observer -> observer.onEvent(event));
    }

    @Override
    public String toString() {
        return "Player must land exactly on the END position to win else the turn is forfeited";
    }
}
