package uk.ac.mmu.game.temp;

public class WinEvent {
    protected String playerName;
    protected int turns;
    protected int totalTurns;

    public WinEvent(String playerName, int turns, int totalTurns) {
        this.playerName = playerName;
        this.turns = turns;
        this.totalTurns = totalTurns;
    }
}
