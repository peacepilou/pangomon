package com.playground.domain.pangomon.statistics;

public enum Statistic {
    ATTACK,
    DEFENSE,
    SPECIAL_ATTACK,
    SPECIAL_DEFENSE,
    SPEED,
    NONE
}


// start for all stats at specific level
// When a level is gained > Stat = ((((2 x Base + IV + (EV/4)) x niveau) / 100) + 5) x Nature
// TODO: Rules to implement
// for PREC and DODGE
// PREC_Base -> 100% (peut etre modifiée)
// ESQ_Base -> 100% (peut etre modifiée)
// PREcapacité -> 1% à 100%
// % de réussite d'une attaque -> Préussite = PREcapacité x (PRECattaquant / ESQdéfenseur)
// Adapation rapport au niveau en combat ->
//    -6 à +6 niveau d'écarts
//    33% / 38% / 43% / 50% / 60% / 75% / 100% / 133% / 167% / 200% / 233% / 267% / 300%