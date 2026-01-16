package uk.ac.mmu.game.temp;

public class HitStayEvent {
    protected String collidedPlayerName;
    protected int collidedPlayerPosition;
    protected String playerName;
    protected String position;

    public HitStayEvent(String collidedPlayerName, int collidedPlayerPosition, String playerName, String position) {
        this.collidedPlayerName = collidedPlayerName;
        this.collidedPlayerPosition = collidedPlayerPosition;
        this.playerName = playerName;
        this.position = position;
    }
}
