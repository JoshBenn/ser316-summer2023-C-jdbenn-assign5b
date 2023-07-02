# ser316-summer2023-C-jdbenn-assign5
Assignment 5

- Primary DP to be used:
    State Pattern
    Builder
    Strategy

Screencast link:
- https://youtu.be/jVKW8mHFY8Y
    
Intended direction:
- Player Character:
    The player character will be from 3 races: cat (magic-based), human (physical-based) and elf (either)
    Cats have more base magic damage
    Humans have more base physical damage
    Elves have more exp gain
- Damage Types
    - Physical
        Stab (increased accuracy)
        Slash (increased strength)
    - Magical
        Fire (Increased damage)
        Ice (chance for the opponent to freeze for 1-3 turns)
        Wind (chance to have another turn)
- Equippables
    Weapon (staff or sword+shield)
    Helmet
    Chest
    Pants
    Feet
    Gloves
- Stats
    Accuracy (% chance to hit)
    Penetration (damage amplifier)
    Weapon Strength (base damage)
- When coming across an item, can choose to sell it or equip it
- Consumables
    Potions (health/strength/magic power/resource [mana/endurance])
    Scrolls (exp increase)
- Events
    Increased XP
    Increased/Decreased accuracy
    Extra money on kill
    Extra money loss on death
- Status Effects
    - Temporary
        Paralysis (random chance to lose a turn)
        Poison/Burn (depends on weapon type, reduces strength/magic power + small damage every turn)
        Sleep (lose between 1 and 3 turns)
    - Permanent
        Strengthened (increase base power)
        Quickened (increase chance to have 2 consecutive turns)
        Enlightened (HP regen per floor)
- Experience:
    Will use the design schema provided
    