package Modele.Ensembles;

class Maillon<T> {
    T element;
    Maillon<T> suivant;
    
    Maillon(T c, Maillon<T> s) {
        element = c;
        suivant = s;
    }
}
