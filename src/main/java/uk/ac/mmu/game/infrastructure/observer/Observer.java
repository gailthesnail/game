package uk.ac.mmu.game.infrastructure.observer;

import uk.ac.mmu.game.infrastructure.events.*;

public interface Observer {
    void onEvent(RollEvent event);
    void onEvent(MoveEvent event);
    void onEvent(WinEvent event);
    void onEvent(OvershootEvent event);
    void onEvent(OvershootStayEvent event);
    void onEvent(HitStayEvent event);
    void onEvent(HitMoveEvent event);
    void onEvent(InitialiseEvent event);
}
