package uk.ac.mmu.game.infrastructure.events;

public class OvershootEvent {
    private final String playerName;

    public OvershootEvent(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerName() {
        return playerName;
    }
}
