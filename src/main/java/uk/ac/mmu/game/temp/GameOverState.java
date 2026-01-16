package uk.ac.mmu.game.temp;

public class GameOverState implements State {
    @Override
    public void next(Context context) {
        //context.getState(new ReadyState());
    }

    @Override
    public String toString() {
        return "GameOver";
    }
}
