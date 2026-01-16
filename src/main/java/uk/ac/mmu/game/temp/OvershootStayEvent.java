package uk.ac.mmu.game.temp;

public class OvershootStayEvent {
    protected String playerName;
    protected String position;

    public OvershootStayEvent(String playerName, String position) {
        this.playerName = playerName;
        this.position = position;
    }
}
