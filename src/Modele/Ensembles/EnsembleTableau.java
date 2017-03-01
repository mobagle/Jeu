package Modele.Ensembles;
import java.util.NoSuchElementException;

class EnsembleTableau<T> implements Ensemble<T> {

    Object[] contenu;
    int taille;

    EnsembleTableau() {
        this(16);
    }

    EnsembleTableau(int t) {
        taille = 0;
        contenu = new Object[t];
    }

    @Override
    public void ajoute(T c) {
        if (taille >= contenu.length) {
            Object[] nouveau = new Object[contenu.length * 2];
            System.arraycopy(contenu, 0, nouveau, 0, contenu.length);
            contenu = nouveau;
        }
        contenu[taille++] = c;
    }

    @Override
    public Iterateur<T> iterateur() {
        return new IterateurEnsembleTableau<>(this);
    }

    @Override
    public void supprime(T c) {
        for (int i = 0; i < taille; i++) {
            if (contenu[i] == c) {
                taille--;
                contenu[i] = contenu[taille];
                contenu[taille] = null;
                return;
            }
        }
        throw new NoSuchElementException(c + " not found");
    }

    @Override
    public String toString() {
        String resultat = "{";
        int i = 0;

        if (i < taille) {
            resultat += contenu[i++];
        }
        while (i < taille) {
            resultat += ", " + contenu[i++];
        }
        return resultat + "}";
    }
}
