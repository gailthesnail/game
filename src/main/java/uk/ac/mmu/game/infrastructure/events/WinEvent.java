package uk.ac.mmu.game.infrastructure.events;

public class WinEvent {
    private final String playerName;
    private final int turns;
    private final int totalTurns;

    public WinEvent(String playerName, int turns, int totalTurns) {
        this.playerName = playerName;
        this.turns = turns;
        this.totalTurns = totalTurns;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTurns() {
        return turns;
    }

    public int getTotalTurns() {
        return totalTurns;
    }
}
