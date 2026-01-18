package uk.ac.mmu.game.GameConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.TwoPlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.TwoPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.NeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.StaysIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Configuration
public class GameConfig7 {

    @Bean
    @Scope("prototype")
    RequiredDice dice7() {
        return () -> new NonRandomDiceShaker( new int[]{8,2,3,12,9,6});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index7() {
        return NeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit7() {
        return StaysIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList7() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector7() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase7(RequiredDice dice7, RequiredIndex index7, RequiredHit hit7, RequiredPlayerList playerList7, RequiredPlayerSelector playerSelector7)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice7, index7, hit7, playerList7, playerSelector7);
    }
}

