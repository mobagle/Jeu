package Modele.Ensembles;

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
