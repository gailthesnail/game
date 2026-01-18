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
public class GameConfig4 {

    @Bean
    @Scope("prototype")
    RequiredDice dice4() {
        return () -> new NonRandomDiceShaker( new int[]{12,12,7,11});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index4() {
        return DoesNotNeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit4() {
        return MovesIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList4() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector4() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase4(RequiredDice dice4, RequiredIndex index4, RequiredHit hit4, RequiredPlayerList playerList4, RequiredPlayerSelector playerSelector4)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice4, index4, hit4, playerList4, playerSelector4);
    }
}
