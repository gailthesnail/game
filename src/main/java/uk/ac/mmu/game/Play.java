package uk.ac.mmu.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Component
class Play implements org.springframework.boot.CommandLineRunner, Ordered {

    @Autowired
    private ApplicationContext context;

    public Play(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println("Game " + i );
            Provided usecase = context.getBean("playUseCase" + i, Provided.class);
            usecase.play();
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
