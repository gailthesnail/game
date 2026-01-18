package uk.ac.mmu.game.GameConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.FourPlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.FourPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.DoesNotNeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.MovesIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Configuration
public class GameConfig8 {

    @Bean
    @Scope("prototype")
    RequiredDice dice8() {
        return () -> new NonRandomDiceShaker( new int[]{7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index8() {
        return DoesNotNeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit8() {
        return MovesIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList8() {
        return () -> new FourPlayerList().getFourPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector8() {
        return FourPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase8(RequiredDice dice8, RequiredIndex index8, RequiredHit hit8, RequiredPlayerList playerList8, RequiredPlayerSelector playerSelector8)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice8, index8, hit8, playerList8, playerSelector8);
    }
}
