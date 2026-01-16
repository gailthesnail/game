package uk.ac.mmu.game.temp;

public class GameObserver implements Observer {
    @Override
    public void onEvent(RollEvent event) {
        System.out.format("%s turn %d rolls %d%n",event.playerName, event.turn, event.shake);
    }

    @Override
    public void onEvent(MoveEvent event) {
        System.out.format("%s moves from %s to %s%n", event.playerName, event.start, event.position);
    }

    @Override
    public void onEvent(WinEvent event) {
        System.out.format("%s wins in %d moves%n", event.playerName, event.turns);
        System.out.format("Total plays %d%n", event.totalTurns);
    }

    @Override
    public void onEvent(OvershootEvent event) {
        System.out.format("%s overshoots!%n", event.playerName);
    }

    @Override
    public void onEvent(OvershootStayEvent event) {
        System.out.format("%s remains at %s%n", event.playerName, event.position);
    }

    @Override
    public void onEvent(HitStayEvent event) {
        System.out.format("%s Position %s hit! %n",event.collidedPlayerName, event.collidedPlayerPosition);
        System.out.format("%s remains at %s%n", event.playerName, event.position);
    }

    @Override
    public void onEvent(HitMoveEvent event) {
        System.out.format("%s Position %s hit! %n",event.collidedPlayerName, event.collidedPlayerPosition);
        System.out.format("%s moves from %s to %s%n",event.playerName, event.start, event.position);
    }

    @Override
    public void onEvent(InitialiseEvent event) {
        System.out.println("Dice: " + event.dice.toString());
        System.out.println("Number of players: " + event.player.toString());
        System.out.println("Hit condition: " + event.hit.toString());
        System.out.println("Win condition: " + event.overshoot.toString());
    }


}
