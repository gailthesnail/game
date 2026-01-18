package uk.ac.mmu.game.GameConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.ac.mmu.game.applicationcode.domainmodel.dice.NonRandomDiceShaker;
import uk.ac.mmu.game.applicationcode.domainmodel.playerList.FourPlayerList;
import uk.ac.mmu.game.applicationcode.domainmodel.playerSelection.FourPlayerSelector;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.NeedToLandOnEndToWin;
import uk.ac.mmu.game.applicationcode.domainmodel.rules.StaysIfHitAnotherPlayer;
import uk.ac.mmu.game.applicationcode.usecase.*;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Configuration
public class GameConfig9 {

    @Bean
    @Scope("prototype")
    RequiredDice dice9() {
        return () -> new NonRandomDiceShaker( new int[]{11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
    }

    @Bean
    @Scope("prototype")
    RequiredIndex index9() {
        return NeedToLandOnEndToWin:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredHit hit9() {
        return StaysIfHitAnotherPlayer:: new;
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerList playerList9() {
        return () -> new FourPlayerList().getFourPlayerList();
    }

    @Bean
    @Scope("prototype")
    RequiredPlayerSelector playerSelector9() {
        return FourPlayerSelector:: new;
    }

    @Bean
    @Scope("prototype")
    Provided playUseCase9(RequiredDice dice9, RequiredIndex index9, RequiredHit hit9, RequiredPlayerList playerList9, RequiredPlayerSelector playerSelector9)
    {
        return new uk.ac.mmu.game.applicationcode.usecase.play.UseCase(dice9, index9, hit9, playerList9, playerSelector9);
    }
}
