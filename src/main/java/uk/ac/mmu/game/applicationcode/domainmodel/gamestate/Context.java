package uk.ac.mmu.game.applicationcode.domainmodel.gamestate;

public interface Context {
    void next();
    void setState(State state);

}
