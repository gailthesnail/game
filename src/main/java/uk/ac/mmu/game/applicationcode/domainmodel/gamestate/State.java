package uk.ac.mmu.game.applicationcode.domainmodel.gamestate;

public interface State {
    void next(Context context);
//    void inPlay(Context context);
//    void gameOver(Context context);
}
