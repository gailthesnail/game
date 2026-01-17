package uk.ac.mmu.game.applicationcode.usecase.play;

public class ReadyState implements State {

    @Override
    public void next(Context context) {
        State next = new InPlayState();
        System.out.printf("Game state %s -> %s%n", this, next);
        context.setState(next);
    }

//    @Override
//    public void inPlay(Context context) {
//        //context.setState(new InPlayState());
//    }
//
//    @Override
//    public void gameOver(Context context) {
//        //context.setState(new GameOverState());
//    }

    @Override
    public String toString() {
        return "Ready";
    }
}
