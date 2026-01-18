package uk.ac.mmu.game.applicationcode.domainmodel;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShakerFactory;
import uk.ac.mmu.game.applicationcode.domainmodel.observer.Observer;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.PlayerIterable;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.PlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.HitStrategy;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.IndexStrategy;
import uk.ac.mmu.game.infrastructure.driven.events.InitialiseEvent;
import uk.ac.mmu.game.infrastructure.driven.events.MoveEvent;
import uk.ac.mmu.game.infrastructure.driven.events.RollEvent;
import uk.ac.mmu.game.infrastructure.driven.events.WinEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RandomObservedGame {

    final List<Observer> observers = new ArrayList<>();

    public void attach (Observer observer){
        observers.add(observer);
    }

    public void detach (Observer observer){
        observers.remove(observer);
    }

    public void update (Consumer<Observer> action) {
        observers.forEach(action);
    }

    public void onRoll (String playerName, int turns, int shake) {
        RollEvent event = new RollEvent(playerName,turns, shake);
        update(observer -> observer.onEvent(event));
    }

    private void onMove(String playerName, String start, String position) {
        MoveEvent event = new MoveEvent(playerName, start, position);
        update(observer -> observer.onEvent(event));
    }

    private void onWin(String playerName, int turns, int totalTurns) {
        WinEvent event = new WinEvent(playerName, turns, totalTurns);
        update(observer -> observer.onEvent(event));
    }

    private void init(DiceShaker dice, IndexStrategy indexStrategy, HitStrategy hitStrategy, PlayerSelector player) {
        InitialiseEvent event = new InitialiseEvent(dice, player, hitStrategy, indexStrategy);
        update(observer -> observer.onEvent(event));
    }



    public void RandomObserveGame(DiceShakerFactory diceFactory, IndexStrategy indexStrategy, HitStrategy hitStrategy, Player[] playerList, PlayerSelector players) {
        DiceShaker dice = diceFactory.create();

        init(dice, indexStrategy, hitStrategy, players);

        int turns = 0;
        int totalTurns = 0;

        Iterable<Player> iterableSelector = new PlayerIterable(players);
        int[] currentPlayerPositions = new int[playerList.length];
        for (int i = 0; i < playerList.length; i++) {
            currentPlayerPositions[i] = playerList[i].getPosition();
        }
        for (Player player : iterableSelector) {
            int shake = dice.shake();

            if (player.getPlayerNumber() == 0) {
                turns++;
            }

            totalTurns++;

            onRoll(player.getName(),turns, shake);

            String start = player.getPositionAsString();

            int collidedPlayer = player.hitStrategyCheck(hitStrategy, shake, player.getPosition(), player.getPlayerNumber(), currentPlayerPositions);

            if (collidedPlayer != player.getPlayerNumber()) {
                player.hitStrategyOutcome(hitStrategy, playerList[collidedPlayer].getName(), currentPlayerPositions[collidedPlayer], shake, indexStrategy, start);
            } else {
                player.advance(shake, indexStrategy);
                if (player.getPositionAsString().equals(start)) {
                    player.indexStrategyOutcome(indexStrategy);
                } else {
                    onMove(player.getName(), start, player.getPositionAsString());
                }
            }
            currentPlayerPositions[player.getPlayerNumber()] = player.getPosition();
            if (player.isAtEnd()) {
                onWin(player.getName(), turns, totalTurns);
            }
        }
    }
}
