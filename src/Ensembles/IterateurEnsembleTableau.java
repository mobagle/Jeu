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

class IterateurEnsembleTableau<T> implements Iterateur<T> {

    EnsembleTableau<T> e;
    int position;
    int last;

    IterateurEnsembleTableau(EnsembleTableau<T> e) {
        this.e = e;
        position = 0;
        last = -1;
    }

    @Override
    public boolean aProchain() {
        return position < e.taille;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T prochain() {
        if (aProchain()) {
            last = position;
            return (T) e.contenu[position++];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void supprime() {
        if (last != -1) {
            e.taille--;
            e.contenu[last] = e.contenu[e.taille];
            e.contenu[e.taille] = null;
            last = -1;
            position--;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Iterateur<T> clone() {
        IterateurEnsembleTableau<T> clone = new IterateurEnsembleTableau<>(e);
        clone.position = position;
        clone.last = last;
        return clone;
    }
}
