package uk.ac.mmu.game.applicationcode.usecase.play;


import uk.ac.mmu.game.applicationcode.domainmodel.LargeBoard;
import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.SmallBoard;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.TwoPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.DoesNotNeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.MovesIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.NeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.StaysIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.Required;
import uk.ac.mmu.game.infrastructure.output.GameObserver;
import uk.ac.mmu.game.applicationcode.domainmodel.ObservedGame;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.FourPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;

public class UseCase implements Provided {

    private final Required required;

    public UseCase(Required required) {
        this.required = required;
    }

    @Override
    public void play() {

        Player[] FourPlayerList = new Player[]{
            new Player(LargeBoard.RED_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Red",0),
            new Player(LargeBoard.BLUE_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Blue",1),
            new Player(LargeBoard.GREEN_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Green",2),
            new Player(LargeBoard.YELLOW_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Yellow",3),
        };

        ObservedGame observedGame = new ObservedGame();
        GameObserver observer = new GameObserver();
        observedGame.attach(observer);
        DiceShaker nonrandom4 = new NonRandomDiceShaker( new int[]{11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
        observedGame.ObserveGame(nonrandom4, new NeedToLandOnEndToWin(), new StaysIfHitAnotherPlayer(),FourPlayerList, new FourPlayerSelector());

        Player[] twoPlayerList = new Player[]{
                new Player(SmallBoard.RED_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Red",0),
                new Player(SmallBoard.BLUE_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Blue",1),
        };

        DiceShaker nonRandomScenario3 = new NonRandomDiceShaker( new int[]{12,12,7,11});
        System.out.println("Basic Game Scenario 3 (12,12,7,11) ");
        observedGame.ObserveGame(nonRandomScenario3, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());

    }
}
