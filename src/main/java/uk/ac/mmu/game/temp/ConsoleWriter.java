package uk.ac.mmu.game.temp;

public class ConsoleWriter implements DiceShaker {

    private final DiceShaker component;

    ConsoleWriter(DiceShaker component) {
        this.component = component;
    }

    @Override
    public int shake() {
        int value = component.shake();
        System.out.format("Shake %d%n", value);
        return value;
    }
}
