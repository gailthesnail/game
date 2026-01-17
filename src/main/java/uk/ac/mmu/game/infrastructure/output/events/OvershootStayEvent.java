package uk.ac.mmu.game.infrastructure.output.events;

public class OvershootStayEvent {
    private final String playerName;
    private final String position;

    public OvershootStayEvent(String playerName, String position) {
        this.playerName = playerName;
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPosition() {
        return position;
    }
}
