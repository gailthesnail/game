package uk.ac.mmu.game.temp;

public class RollEvent {
    protected String playerName;
    protected int turn;
    protected int shake;

    RollEvent( String playerName, int turn, int shake) {
        this.playerName = playerName;
        this.turn = turn;
        this.shake = shake;
    }
}

