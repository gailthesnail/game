package uk.ac.mmu.game.GameConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.TwoPlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.TwoPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.DoesNotNeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.MovesIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Order(1)
@Configuration
public class GameConfig1 {

    @Bean
    @Scope("prototype")
    RequiredDice dice1() {
        return () -> new NonRandomDiceShaker( new int[]{12,12,7,8});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index1() {
        return DoesNotNeedToLandOnEndToWin :: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit1() {
        return MovesIfHitAnotherPlayer :: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList1() {
        return () -> new TwoPlayerList().getTwoPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector1() {
        return TwoPlayerSelector :: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase1(RequiredDice dice1, RequiredIndex index1, RequiredHit hit1, RequiredPlayerList playerList1, RequiredPlayerSelector playerSelector1)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice1, index1, hit1, playerList1, playerSelector1);
    }

}
