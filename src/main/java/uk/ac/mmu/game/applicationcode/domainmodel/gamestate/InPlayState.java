package uk.ac.mmu.game.applicationcode.domainmodel.gamestate;

public class InPlayState implements State {
    @Override
    public void next(Context context) {
        //context.setState(new ReadyState());
        State next = new GameOverState();
        System.out.printf("Game state %s -> %s%n", this, next);
        context.setState(next);
    }

    @Override
    public String toString() {
        return "InPlay";
    }
}
