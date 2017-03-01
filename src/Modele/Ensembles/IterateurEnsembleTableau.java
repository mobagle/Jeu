package Modele.Ensembles;
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
