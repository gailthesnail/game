package uk.ac.mmu.game.infrastructure.events;

public class RollEvent {
    private final String playerName;
    private final int turn;
    private final int shake;

    public RollEvent( String playerName, int turn, int shake) {
        this.playerName = playerName;
        this.turn = turn;
        this.shake = shake;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTurn() {
        return turn;
    }

    public int getShake() {
        return shake;
    }
}

