package uk.ac.mmu.game.temp;

public class InitialiseEvent {
    protected  DiceShaker dice;
    protected  PlayerSelector player;
    protected  HitStrategy hit;
    protected  IndexStrategy overshoot;

    public InitialiseEvent(DiceShaker dice, PlayerSelector player, HitStrategy hit, IndexStrategy overshoot) {
        this.dice = dice;
        this.player = player;
        this.hit = hit;
        this.overshoot = overshoot;
    }
}
