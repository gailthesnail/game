package uk.ac.mmu.game.temp;

public class HitMoveEvent {
    protected String collidedPlayerName;
    protected int collidedPlayerPosition;
    protected String playerName;
    protected String start;
    protected String position;

    public HitMoveEvent(String collidedPlayerName, int collidedPlayerPosition, String playerName,String start, String position) {
        this.collidedPlayerName = collidedPlayerName;
        this.collidedPlayerPosition = collidedPlayerPosition;
        this.playerName = playerName;
        this.start = start;
        this.position = position;
    }
}
