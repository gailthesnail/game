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
public class GameConfig6 {

    @Bean
    @Scope("prototype")
    RequiredDice dice6() {
        return () -> new NonRandomDiceShaker( new int[]{12,12,12,9,8});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index6() {
        return NeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit6() {
        return StaysIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList6() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector6() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase6(RequiredDice dice6, RequiredIndex index6, RequiredHit hit6, RequiredPlayerList playerList6, RequiredPlayerSelector playerSelector6)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice6, index6, hit6, playerList6, playerSelector6);
    }
}
