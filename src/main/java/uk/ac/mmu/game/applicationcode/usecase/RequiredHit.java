package uk.ac.mmu.game.applicationcode.usecase;

import uk.ac.mmu.game.applicationcode.domainmodel.strategy.HitStrategy;

public interface RequiredHit {
    HitStrategy getHitStrategy();
}
