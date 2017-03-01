package Modele.Ensembles;

public interface Ensemble<T> {

    void ajoute(T c);

    void supprime(T c);

    Iterateur<T> iterateur();
}
