package uk.ac.mmu.game.infrastructure.events;

import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.infrastructure.strategy.HitStrategy;
import uk.ac.mmu.game.infrastructure.strategy.IndexStrategy;
import uk.ac.mmu.game.infrastructure.playerSelection.PlayerSelector;

public class InitialiseEvent {
    private final DiceShaker dice;
    private final PlayerSelector player;
    private final HitStrategy hit;
    private final IndexStrategy overshoot;

    public InitialiseEvent(DiceShaker dice, PlayerSelector player, HitStrategy hit, IndexStrategy overshoot) {
        this.dice = dice;
        this.player = player;
        this.hit = hit;
        this.overshoot = overshoot;
    }

    public DiceShaker getDice() {
        return dice;
    }

    public PlayerSelector getPlayer() {
        return player;
    }

    public HitStrategy getHit() {
        return hit;
    }

    public IndexStrategy getOvershoot() {
        return overshoot;
    }
}
