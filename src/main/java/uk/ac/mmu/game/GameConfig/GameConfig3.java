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
public class GameConfig3 {

    @Bean
    @Scope("prototype")
    RequiredDice dice3() {
        return () -> new NonRandomDiceShaker( new int[]{8,2,3,4,9});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index3() {
        return DoesNotNeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit3() {
        return MovesIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList3() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector3() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase3(RequiredDice dice3, RequiredIndex index3, RequiredHit hit3, RequiredPlayerList playerList3, RequiredPlayerSelector playerSelector3)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice3, index3, hit3, playerList3, playerSelector3);
    }
}
