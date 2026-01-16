package uk.ac.mmu.game.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObservedGame {

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



    public void ObserveGame(DiceShaker dice, IndexStrategy indexStrategy, HitStrategy hitStrategy, Player[] playerList, PlayerSelector players) {
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

            if (player.hitStrategyCheck(hitStrategy, shake, player.getPosition(), player.getPlayerNumber(), currentPlayerPositions) != player.getPlayerNumber()) {
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
