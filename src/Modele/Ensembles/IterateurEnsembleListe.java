package Modele.Ensembles;

import java.util.NoSuchElementException;

class IterateurEnsembleListe<T> implements Iterateur<T> {

    EnsembleListe<T> e;
    Maillon<T> pprec, prec, courant;
    boolean last;

    IterateurEnsembleListe(EnsembleListe<T> e) {
        this.e = e;
        pprec = prec = null;
        courant = e.tete;
        last = false;
    }

    @Override
    public boolean aProchain() {
        return courant != null;
    }

    @Override
    public T prochain() {
        if (aProchain()) {
            pprec = prec;
            prec = courant;
            courant = courant.suivant;
            last = true;
            return prec.element;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void supprime() {
        if (last) {
            if (pprec == null) {
                e.tete = courant;
            } else {
                pprec.suivant = courant;
            }
            prec = pprec;
            last = false;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Iterateur<T> clone() {
        IterateurEnsembleListe<T> clone = new IterateurEnsembleListe<>(e);
        clone.pprec = pprec;
        clone.prec = prec;
        clone.courant = courant;
        clone.last = last;
        return clone;
    }
}
