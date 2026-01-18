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

//@Order(2)
@Configuration
public class GameConfig2 {

    @Bean
    @Scope("prototype")
    RequiredDice dice2() {
        return () -> new NonRandomDiceShaker( new int[]{12,12,6,6,2});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index2() {
        return DoesNotNeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit2() {
        return MovesIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList2() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector2() {
        return TwoPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase2(RequiredDice dice2, RequiredIndex index2, RequiredHit hit2, RequiredPlayerList playerList2, RequiredPlayerSelector playerSelector2)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice2, index2, hit2, playerList2, playerSelector2);
    }
}
