package uk.ac.mmu.game.temp;

import uk.ac.mmu.game.applicationcode.domainmodel.Player;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.PlayerIterable;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.PlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.HitStrategy;
import uk.ac.mmu.game.applicationcode.domainmodel.strategy.IndexStrategy;

public class Game {
//    public static void run() {
//        DiceShakerFactory factory = new SingleDiceShakerFactory();
//        show(factory);
//
//        factory = new DoubleDiceShakerFactory();
//        show(factory);
//
//    }

//    private static void show(DiceShakerFactory factory) {
//        DiceShaker shaker = new ConsoleWriter(factory.create());
//        shaker.shake();
//        shaker.shake();
//        shaker.shake();
//    }


    public void BasicGame(DiceShaker dice, IndexStrategy indexStrategy, HitStrategy hitStrategy, Player[] playerList, PlayerSelector players) {
        //run();

//        final int[] shakes = Dice.shakes;
//        final int[] shakes = new int[]{12,12,6,6,2};

//        int turns = 0;
//        int redTurns = 0;
//        int blueTurns = 0;
//        Player red = new Player(Board.RED_POSITIONS,"RED");
//        Player blue = new Player(Board.BLUE_POSITIONS,"BLUE");
//
//        System.out.format("Red:%s Blue:%s %n", red.getPositionAsString(), blue.getPositionAsString());
//        while (!red.isAtEnd() & !blue.isAtEnd()) {
//            int shake = shakes[turns++];
//            //int shake = shaker.shake();
//            //turns++;
//            if (turns % 2 == 1) {
//                redTurns++;
//                System.out.format("Red turn %d rolls %d%n", redTurns, shake);
//                String start = red.getPositionAsString();
//
//                if(!red.hitStrategyCheck(hitStrategy, shake,red.getPosition(), blue.getPosition())){ //advance with index strategy
//                    System.out.format("Blue %s hit! %nRed remains at %s%n",blue.getPositionAsString(), red.getPositionAsString());
//
//                }else {
//                    red.advance(shake, indexStrategy);
//                    if( red.getPositionAsString().equals(start)) { //red.isInTail() &&
//                        System.out.format("Red overshoots! %nRed remains at %s%n", red.getPositionAsString());
//                    } else {
//                        System.out.format("Red moves from %s to %s%n", start, red.getPositionAsString());
//                    }
//                }
//            } else {
//                blueTurns++;
//                System.out.format("Blue turn %d rolls %d%n", blueTurns, shake);
//                String start = blue.getPositionAsString();
//                if(!blue.hitStrategyCheck(hitStrategy, shake,blue.getPosition(), red.getPosition())){ //advance with index strategy
//                    System.out.format("Red %s hit! %nBlue remains at %s%n",red.getPositionAsString(), blue.getPositionAsString());
//                }else {
//                    blue.advance(shake, indexStrategy);
//                    if (blue.getPositionAsString().equals(start)) { //blue.isInTail() &&
//                        System.out.format("Blue overshoots! %nBlue remains at %s%n", blue.getPositionAsString());
//                    } else {
//                        System.out.format("Blue moves from %s to %s%n", start, blue.getPositionAsString());
//                    }
//                }
//            }
//        }
//        if (red.isAtEnd()) {
//            System.out.format("Red wins in %d moves%n", redTurns);
//        } else {
//            System.out.format("BLue wins in %d moves%n", blueTurns);
//        }
//        System.out.format("Total plays %d%n", turns);



        int turns = 0;
        int totalTurns = 0;

        Iterable<Player> iterableSelector = new PlayerIterable(players);
        int[] currentPlayerPositions = new int[playerList.length];
        for (int i = 0; i < playerList.length; i++) {
            currentPlayerPositions[i] = playerList[i].getPosition();
        }
        for (Player player : iterableSelector) {
                int shake = dice.shake();

                if (player.getPlayerNumber() == 0){
                    turns++;
                }

                totalTurns++;

                System.out.format("%s turn %d rolls %d%n",player.getName(), turns, shake);
                String start = player.getPositionAsString();

                int collidedPlayer = player.hitStrategyCheck(hitStrategy, shake, player.getPosition(), player.getPlayerNumber(), currentPlayerPositions);

                if(player.hitStrategyCheck(hitStrategy, shake, player.getPosition(), player.getPlayerNumber(), currentPlayerPositions) != player.getPlayerNumber() ){
                    player.hitStrategyOutcome(hitStrategy, playerList[collidedPlayer].getName(), currentPlayerPositions[collidedPlayer], shake, indexStrategy,start);
                }else {
                    player.advance(shake, indexStrategy);
                    if( player.getPositionAsString().equals(start)) {
                        player.indexStrategyOutcome(indexStrategy);
                    } else {
                        System.out.format("%s moves from %s to %s%n",player.getName(), start, player.getPositionAsString());
                    }
                }
                currentPlayerPositions[player.getPlayerNumber()] = player.getPosition();
            if (player.isAtEnd()) {
                System.out.format("%s wins in %d moves%n", player.getName(), turns);
                System.out.format("Total plays %d%n", totalTurns);
            }


        }
    }
}
