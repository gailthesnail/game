package uk.ac.mmu.game.infrastructure.driving;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.PlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.PlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.HitStrategy;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.IndexStrategy;
import uk.ac.mmu.game.applicationcode.usecase.*;

public class RequiredGame implements RequiredDice, RequiredIndex, RequiredHit, RequiredPlayerList, RequiredPlayerSelector {

    private final DiceShaker dice;
    private final IndexStrategy index;
    private final HitStrategy hit;
    private final PlayerList playerList;
    private final PlayerSelector playerSelector;

    public RequiredGame(DiceShaker dice, IndexStrategy index, HitStrategy hit, PlayerList playerList, PlayerSelector playerSelector) {
        this.dice = dice;
        this.index = index;
        this.hit = hit;
        this.playerList = playerList;
        this.playerSelector = playerSelector;
    }

    @Override
    public DiceShaker getDiceShaker() {
        return dice;
    }

    @Override
    public HitStrategy getHitStrategy() {
        return hit;
    }

    @Override
    public IndexStrategy getIndexStrategy() {
        return index;
    }

    @Override
    public Player[] getPlayerList() {
        return new Player[0];
    }

    @Override
    public PlayerSelector getPlayerSelector() {
        return playerSelector;
    }


}
