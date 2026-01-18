package uk.ac.mmu.game.applicationcode.usecase.play;


import uk.ac.mmu.game.applicationcode.domainmodel.*;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.infrastructure.driven.GameObserver;

public class UseCase implements Provided {

    private final RequiredDice dice;
    private final RequiredIndex index;
    private final RequiredHit hit;
    private final RequiredPlayerList playerList;
    private final RequiredPlayerSelector playerSelector;

    public UseCase(RequiredDice dice, RequiredIndex index, RequiredHit hit, RequiredPlayerList playerList, RequiredPlayerSelector playerSelector) {
        this.dice = dice;
        this.index = index;
        this.hit = hit;
        this.playerList = playerList;
        this.playerSelector = playerSelector;
    }

    @Override
    public void play() {
        ObservedGame observedGame = new ObservedGame();
        GameObserver observer = new GameObserver();
        observedGame.attach(observer);
        observedGame.ObserveGame(dice.getDiceShaker(), index.getIndexStrategy(), hit.getHitStrategy(), playerList.getPlayerList(), playerSelector.getPlayerSelector());

    }
}
