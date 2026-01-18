package uk.ac.mmu.game.applicationcode.domainmodel.gamestate;

public class StateMachine implements Context {

    private State currentState = new ReadyState();

    @Override
    public void next() {
        currentState.next(this);
    }

    @Override
    public void setState(State state) {
        currentState = state;
    }

    public String getState() {
        return currentState.toString();
    }
}
