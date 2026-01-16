package uk.ac.mmu.game.temp;

public class MoveEvent {
    protected String playerName;
    protected String start;
    protected String position;

    public MoveEvent(String playerName, String start, String position) {
        this.playerName = playerName;
        this.start = start;
        this.position = position;
    }
}
