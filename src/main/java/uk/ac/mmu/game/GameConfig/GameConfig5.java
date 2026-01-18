package uk.ac.mmu.game.GameConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.TwoPlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.TwoPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.DoesNotNeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.MovesIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Configuration
public class GameConfig5 {

    @Bean
    @Scope("prototype")
    RequiredDice dice5() {
        return () -> new NonRandomDiceShaker( new int[]{6,6,6,6,3,4,3,4});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index5() {
        return DoesNotNeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit5() {
        return MovesIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList5() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector5() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase5(RequiredDice dice5, RequiredIndex index5, RequiredHit hit5, RequiredPlayerList playerList5, RequiredPlayerSelector playerSelector5)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice5, index5, hit5, playerList5, playerSelector5);
    }
}
