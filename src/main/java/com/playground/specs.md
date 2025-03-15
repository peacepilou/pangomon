# Combat de Pangomon

## Définir un Pangomon

- Name
- Level
- Types
- Stats : PV / ATQ / DEF / VIT / ATQ SPE / DEF SPE / ACCURACY / DODGE
- Skills

## Combat Rules

- [ ] Turn based combat
- [ ] ATQ Success = Skill Accuracy * (Attacker accuracy / defender accuracy)
- [x] PV = 0 > out of combat
- [ ] Can switch pangomon
- [ ] Table of types
- [x] End of each combat > XP calcul
- [ ] Fight holds what ?

## Xp rules

- [x] Next lvl = current Lvl * 100

## Maths

Base stat always between 1 and 255
HP = ((((2*base) + iv + (ev/4)) * level) / 100) + level + 10 + iv + (ev / 4)
Other stats = ((((((2*base) + iv + (ev/4)) * level) / 100) + 5) + iv + (ev / 4)) * nature

IV always between 0 and 31 for EACH stats
EV always between 0 and 510 on total (with max of 252 per stats)