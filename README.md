
## Overview
Lots of games pit one player against another either in the arena or on the field of battle. The winners of these battles tend to depend upon the abilities of the players, the gear that they have at their disposal, and, a little bit, on their luck. This is exemplified in role-playing games (Links to an external site.) in which players battle using a turn-based system.

Turn-based battles generally start by pitting two players against one another. The battle begins by determining which player will go first and then proceeds as follows:

- Player 1 attacks using the weapon that they have in-hand by taking a swing at player 2 who tries to avoid the attack. If player 1 hits player 2, then player 2 potentially takes damage.
- Player 2 attacks using the weapon that they have in-hand by taking a swing at player 1 who tries to avoid the attack. If player 2 hits player 1, then player 1 potentially takes damage.
Turns continue back and forth until one of the players has taken a total damage that is greater than or equal to their health.
- The player who did not take a total damage greater than or equal to their health is declared the victor. It is possible for a battle to end in a draw.

Jumptastic Games has contracted you to design and implement a model for their new role-playing game (Links to an external site.) that will allow gamers to build players that can then be entered into an arena for one-on-one combat following this turn-based battle strategy. They have provided the following information.

## Features
The model should use the player information to create a battle between two players who enter the arena. To do this the model should support operations that allow:
- players to enter the arena with only their basic abilities and their bare hands.
- players to equip themselves from a bag of equipment that contains a minimum of 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions. When players equip themselves from the bag, they are randomly assigned 20 items from the bag. Any item that is randomly assigned must be used unless it cannot be combined with what the player is already using. 25% of the items that are in the bag will diminish the player's ability rather than enhance it.
- players to request a weapon from the armory. Requests for a weapon are satisfied by randomly selecting one of the many weapons that are available (at least 1 of each type of weapon).
- provide a complete description of players that will enter the arena including the player's temporary ability values (based on the affects of the potions that they may have consumed) along with any and all the gear they are wearing, and what weapon they are using. Gear should be printed in order of top to bottom, then alphabetically: thus any headgear should come before potions which come before any belts which should come before any footwear.
- two players to battle in the arena. As players enter the arena, the player with the higher charisma dazzles their opponent and gets in the first strike.

**`Battle Interface` has the following functions:**

Assign gears to players.
```sh
void assignGears()
```
Assign weapons to players.
```sh
void assignWeapons()
```
 Current player's turn to attack.
```sh
void attack()
```
Switch player.
```sh
void switchPlayer()
```
Get description of current battle.
```sh
getBattleStatus()
```
Get information of current round.
```sh
String getRoundInfo()
```

## How to Use the Program
See the run example in Driver class ```example_player1won.txt```




