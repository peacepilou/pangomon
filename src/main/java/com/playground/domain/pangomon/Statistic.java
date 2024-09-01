package com.playground.domain.pangomon;

enum Statistic {
    ATTACK,
    DEFENSE,
    SPECIAL_ATTACK,
    SPECIAL_DEFENSE,
    SPEED,
    NONE
}

// TODO: Rules to implement
// each level you gain -> each Stat increase = +(Base / 50) + (SUM (EV + IV) / 100)

record HealthPoint(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // PV_Base -> de 10 à 255
    // start for a specific level -> (((2 x Base + IV + (EV/4)) x niveau) / 100) + niveau + 10
}

// start for all stats at specific level
// ((((2 x Base + IV + (EV/4)) x niveau) / 100) + 5) x Nature
record Attack(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // ATK_Base -> de 5 à 190
}

record Defense(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // DEF_Base -> de 5 à 230
}

record SpecialAttack(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // ATK_SPE_Base -> de 10 à 194
}

record SpecialDefense(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // DEF_SPE_Base -> de 20 à 250
}

record Speed(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // VIT_Base -> de 5 à 200
}

// TODO: Rules to implement
// this is on the "creation" of the pangomon
record IndividualValue(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // de 0 à 31 repartis sur les 6 stats
    // 1 IV = 1 point de stat en plus
}

// TODO: Rules to implement
// this is in addition to the Experience gained after a fight
record EffortValue(int value) {
    // TODO: Add validation
    // TODO: Rules to implement
    // 510 max toute stats confondues // 252 max pour une seule stat
    // 4 EV = 1 point de stat en plus
}

// TODO: Rules to implement
// for PREC and DODGE
// PREC_Base -> 100% (peut etre modifiée)
// ESQ_Base -> 100% (peut etre modifiée)
// PREcapacité -> 1% à 100%
// % de réussite d'une attaque -> Préussite = PREcapacité x (PRECattaquant / ESQdéfenseur)
// Adapation rapport au niveau en combat ->
//    -6 à +6 niveau d'écarts
//    33% / 38% / 43% / 50% / 60% / 75% / 100% / 133% / 167% / 200% / 233% / 267% / 300%