package uk.ac.mmu.game.infrastructure.events;

public class MoveEvent {
    private final String playerName;
    private final String start;
    private final String position;

    public MoveEvent(String playerName, String start, String position) {
        this.playerName = playerName;
        this.start = start;
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getStart() {
        return start;
    }

    public String getPosition() {
        return position;
    }
}
