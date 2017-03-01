/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard

 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).

 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.

 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.

 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
package Ensembles;

import java.util.NoSuchElementException;

class EnsembleListe<T> implements Ensemble<T> {

    Maillon<T> tete;

    // Comportement par défaut de java :
    EnsembleListe() {
        tete = null;
    }

    @Override
    public void ajoute(T c) {
        Maillon<T> nouveau = new Maillon<>(c, tete);
        tete = nouveau;
    }

    @Override
    public void supprime(T c) {
        Maillon<T> prec, courant;

        prec = null;
        courant = tete;
        while ((courant != null) && (courant.element != c)) {
            prec = courant;
            courant = courant.suivant;
        }
        if (courant != null) {
            if (prec == null) {
                tete = tete.suivant;
            } else {
                prec.suivant = courant.suivant;
            }
        } else {
            throw new NoSuchElementException(c + " not found");
        }
    }

    @Override
    public Iterateur<T> iterateur() {
        return new IterateurEnsembleListe<>(this);
    }

    @Override
    public String toString() {
        String resultat = "{";
        Maillon<T> courant = tete;

        if (courant != null) {
            resultat += courant.element;
            courant = courant.suivant;
        }
        while (courant != null) {
            resultat += ", " + courant.element;
            courant = courant.suivant;
        }
        return resultat + "}";
    }
}
