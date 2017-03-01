package Modele.Ensembles;

public interface Iterateur<T> {

    boolean aProchain();

    T prochain();

    void supprime();

    Iterateur<T> clone();
}
