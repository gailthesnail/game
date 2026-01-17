Clean architecture introduces the idea of splitting what we called the application code into a Domain Model and Use Cases.
We will define the Domain Model as being the Entities, Value Objects and Domain Services that model the business domain (problem).

A Game is an Entities (have an identity, we save and retrieve a Game)
Dice Rolls are Value Objects (just a value)
Rest of the code will be stateful or stateless Services (Hit rules for example) and other stateful objects that belong to the Game

To implement the functional variations, the strategy pattern was used for the win and hit conditions. The algorithm on the next decision if a player is hit or overshoots the end is the thing that is varying. Hence it is extracted from the main game code, and each different outcome is encapsulated in its own class with a common interface. This pattern supports the Open/Closed principle (OCP) as it allows extension, in this case another variation, by writing a new implementation of the IndexStrategy or HitStrategy interface without changing the original code and supplying that concrete class at runtime. 

For the hit conditions, the function “move” to check if another player has been hit is the same. After checking that the player is not moving beyond the start of the tail, a loop checks through all the other players and if another player occupies the position the current player would land on, that player’s number is return instead of the current player. If the player collided with another player, the “outcome” method contains the difference between advancing or staying whilst still updating the observer the event. 

If there is no collision, the player advances with the index strategy.For the “DoesNotNeedToLandOnEndToWin” condition, if a player overshoots the message is sent to the console and their current index is set end of tail to satisfy that the player is at the end for the game to end. For the “NeedToLandOnEndToWin” condition, the current index is set back to before the roll was added if the player overshoots. Then in the main game, the position will be the same as the start, therefore calling “indexStrategyOutcome” with the message output to say the player overshoots but remains in the same place. Otherwise, observers are notified with “onMove”. 

```mermaid

```


```mermaid
classDiagram
%% Context
    class Player {
        hitStrategy : HitStrategy
        hitStrategyCheck()
        hitStrategyOutcome()
        indexStrategyOutcome(IndexStrategy)
        advance()
    }

%% Strategy interface
    class HitStrategy {
        <<interface>>
        move()
        outcome()
    }

%% Concrete strategies
    class StaysIfHitAnotherPlayer {
        observers : List~Observer~
        move()
        outcome()
        onHitStay()
    }

    class MovesIfHitAnotherPlayer {
        observers : List~Observer~
        move()
        outcome()
        onHitMove()
    }

%% Game orchestrator (optional, like client)
    class ObservedGame {
        observers : List~Observer~
        ObserveGame()
    }

%% Relationships
    Player --> HitStrategy : uses
    StaysIfHitAnotherPlayer ..|> HitStrategy
    MovesIfHitAnotherPlayer ..|> HitStrategy
    ObservedGame ..> HitStrategy : configures
```