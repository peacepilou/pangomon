package com.playground.domain.pangomon.statistics;

import com.playground.domain.pangomon.Pangomon;

import static com.playground.utils.Preconditions.require;

// TODO: Rules to implement
// this is on the "creation" of the pangomon
public record IndividualValue(int value) {

    public IndividualValue {
        require(value >= 0 && value <= 31, "IV must be between 0 and 31");
    }
    // TODO: Add validation
    // TODO: Rules to implement
    // de 0 à 31 repartis sur les 6 stats
    // 1 IV = 1 point de stat en plus

    // > Scenaris avec full IV / 0 IV / moitié IV / Math.random IV
    // Les IV / EV = doivent être dans la class Pangomon non ?
    // Si j'ai par exemple j'ai 5 IVs = 5 en attack, alors je dois faire +5 en attck
    // A quel moment je fais ça ? IV = à la naissance/création = quand je fais mon pango
    // Ok mais je mets où ce calcul, ici ? A la naissance = je crée un pango, je lui donne IV mais comment j'agis sur les stats ?
    // Comment j'extrais le 5 IV = 5 attack de cette méthode IndividualValue ?
    // Je peux return un ne Pangomon, avec la value des stats améliorée
    // Mais en gros cette méthode "generateIvs()" doit me sortir un map genre {ATTACK: 3, DEF: 6} --->
    // ou + simple : elle prend le pangomon en entreé, lui attribue ces valeurs et en retourne une nouvelle instance
    // value = 31
    //

}
