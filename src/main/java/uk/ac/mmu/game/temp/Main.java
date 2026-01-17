//import DiceShakerFactory;
//import SingleDiceShakerFactory;
package uk.ac.mmu.game.temp;

import uk.ac.mmu.game.applicationcode.domainmodel.LargeBoard;
import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.NeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.StaysIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.infrastructure.output.GameObserver;
import uk.ac.mmu.game.applicationcode.domainmodel.ObservedGame;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.FourPlayerSelector;

public class Main {
    public static void main(String[] args) {
        //DiceShakerFactory factory = new SingleDiceShakerFactory();

        //check method win for other hit conditions. all strategy pattern
        //Use observers to observe game events instead week05 ?

//        Game game = new Game();
//        System.out.println("SINGLE DICE");
//        game.BasicGame(new SingleDiceShakerFactory(), new DoesNotNeedToLandOnEndToWin());
//
//        //factory = new DoubleDiceShakerFactory();
//        System.out.println("DOUBLE DICE");
//        game.BasicGame(new DoubleDiceShakerFactory(), new DoesNotNeedToLandOnEndToWin());

//        System.out.println("{6,6,6,6,3,4,3,4}; Basic game rules, single die");

//        Player[] twoPlayerList = new Player[]{
//            new Player(SmallBoard.RED_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Red",0),
//            new Player(SmallBoard.BLUE_POSITIONS,SmallBoard.START_OF_TAIL_INDEX,SmallBoard.END_OF_TAIL_INDEX, "Blue",1),
//        };

//        DiceShaker nonRandomScenario1 = new NonRandomDiceShaker( new int[]{12,12,7,8});
//        System.out.println("Basic Game Scenario 1 (12,12,7,8) ");
//        game.BasicGame(nonRandomScenario1, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());
//
//        DiceShaker nonRandomScenario1Anothereg = new NonRandomDiceShaker( new int[]{12,12,6,6,2});
//        System.out.println("Basic Game Scenario 1 Another example (12,12,6,6,2) ");
//        game.BasicGame(nonRandomScenario1Anothereg, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());

//        DiceShaker nonRandomScenario2 = new NonRandomDiceShaker( new int[]{8,2,3,4,9});
//        System.out.println("Basic Game Scenario 2 (8,2,3,4,9) ");
//        game.BasicGame(nonRandomScenario2, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());
//
//        DiceShaker nonRandomScenario3 = new NonRandomDiceShaker( new int[]{12,12,7,11});
//        System.out.println("Basic Game Scenario 3 (12,12,7,11) ");
//        game.BasicGame(nonRandomScenario3, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());


        //Player must land exactly on the END position to win works
//        System.out.println("Player must land exactly on the END position to win, dice rolls (12,12,12,9,8) ");
        //DiceShaker nonrandom1 = new NonRandomDiceShaker(new int[]{12,12,12,9,8});
        //game.BasicGame(nonrandom1, new NeedToLandOnEndToWin(), new StaysIfHitAnotherPlayer(),twoPlayerList, new TwoPlayerSelector());

//        DiceShaker nonrandom2 = new NonRandomDiceShaker( new int[]{8,2,3,12,9,6});
//        System.out.println("Player stays in place on HIT dice rolls (8,2,3,12,9,6) ");
//        game.BasicGame(nonrandom2, new NeedToLandOnEndToWin(), new StaysIfHitAnotherPlayer(), twoPlayerList, new TwoPlayerSelector());

        Player[] FourPlayerList = new Player[]{
                new Player(LargeBoard.RED_POSITIONS,LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX, "Red",0),
                new Player(LargeBoard.BLUE_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Blue",1),
                new Player(LargeBoard.GREEN_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Green",2),
                new Player(LargeBoard.YELLOW_POSITIONS, LargeBoard.START_OF_TAIL_INDEX, LargeBoard.END_OF_TAIL_INDEX,"Yellow",3),
        };

//        DiceShaker nonrandom3 = new NonRandomDiceShaker( new int[]{7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9});
//        System.out.println("4 Players, large board, basic rules ({7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9) ");
//        game.BasicGame(nonrandom3, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(),FourPlayerList, new FourPlayerSelector());

//        DiceShaker nonrandom4 = new NonRandomDiceShaker( new int[]{11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
//        System.out.println("4 Players, large board, variation  rules ({11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7) ");
//        game.BasicGame(nonrandom4, new NeedToLandOnEndToWin(), new StaysIfHitAnotherPlayer(),FourPlayerList, new FourPlayerSelector());

       ObservedGame observedGame = new ObservedGame();
       GameObserver observer = new GameObserver();
       observedGame.attach(observer);
       DiceShaker nonrandom4 = new NonRandomDiceShaker( new int[]{11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
       observedGame.ObserveGame(nonrandom4, new NeedToLandOnEndToWin(), new StaysIfHitAnotherPlayer(),FourPlayerList, new FourPlayerSelector());

        DiceShaker nonrandom3 = new NonRandomDiceShaker( new int[]{7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9});
        System.out.println("4 Players, large board, basic rules ({7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9) ");
        //observedGame.ObserveGame(nonrandom3, new DoesNotNeedToLandOnEndToWin(), new MovesIfHitAnotherPlayer(),FourPlayerList, new FourPlayerSelector());

//
//        StateMachine stateMachine = new StateMachine();
//        System.out.format("User is %s%n",stateMachine.getState());
//        stateMachine.next();
//        System.out.format("User is %s%n",stateMachine.getState());
//        stateMachine.next();
//        System.out.format("User is %s%n",stateMachine.getState());

    }
}
