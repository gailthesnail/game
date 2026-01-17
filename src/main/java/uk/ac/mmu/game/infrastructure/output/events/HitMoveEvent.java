package uk.ac.mmu.game.infrastructure.output.events;

public class HitMoveEvent {
    private final String collidedPlayerName;
    private final int collidedPlayerPosition;
    private final String playerName;
    private final String start;
    private final String position;

    public HitMoveEvent(String collidedPlayerName, int collidedPlayerPosition, String playerName,String start, String position) {
        this.collidedPlayerName = collidedPlayerName;
        this.collidedPlayerPosition = collidedPlayerPosition;
        this.playerName = playerName;
        this.start = start;
        this.position = position;
    }

    public String getCollidedPlayerName() {
        return collidedPlayerName;
    }

    public int getCollidedPlayerPosition() {
        return collidedPlayerPosition;
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
