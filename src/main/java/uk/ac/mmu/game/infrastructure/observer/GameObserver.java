package uk.ac.mmu.game.infrastructure.observer;

import uk.ac.mmu.game.infrastructure.events.*;

public class GameObserver implements Observer {
    @Override
    public void onEvent(RollEvent event) {
        System.out.format("%s turn %d rolls %d%n", event.getPlayerName(), event.getTurn(), event.getShake());
    }

    @Override
    public void onEvent(MoveEvent event) {
        System.out.format("%s moves from %s to %s%n", event.getPlayerName(), event.getStart(), event.getPosition());
    }

    @Override
    public void onEvent(WinEvent event) {
        System.out.format("%s wins in %d moves%n", event.getPlayerName(), event.getTurns());
        System.out.format("Total plays %d%n", event.getTotalTurns());
    }

    @Override
    public void onEvent(OvershootEvent event) {
        System.out.format("%s overshoots!%n", event.getPlayerName());
    }

    @Override
    public void onEvent(OvershootStayEvent event) {
        System.out.format("%s remains at %s%n", event.getPlayerName(), event.getPosition());
    }

    @Override
    public void onEvent(HitStayEvent event) {
        System.out.format("%s Position %s hit! %n", event.getCollidedPlayerName(), event.getCollidedPlayerPosition());
        System.out.format("%s remains at %s%n", event.getPlayerName(), event.getPosition());
    }

    @Override
    public void onEvent(HitMoveEvent event) {
        System.out.format("%s Position %s hit! %n", event.getCollidedPlayerName(), event.getCollidedPlayerPosition());
        System.out.format("%s moves from %s to %s%n", event.getPlayerName(), event.getStart(), event.getPosition());
    }

    @Override
    public void onEvent(InitialiseEvent event) {
        System.out.println("Dice: " + event.getDice().toString());
        System.out.println("Number of players: " + event.getPlayer().toString());
        System.out.println("Hit condition: " + event.getHit().toString());
        System.out.println("Win condition: " + event.getOvershoot().toString());
    }


}
