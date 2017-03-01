package Modele;

public class VisiteurDecompte extends Visiteur {

    int decompte;

    public VisiteurDecompte() {
        decompte = 0;
    }

    @Override
    public boolean visite(Composant c) {
        decompte++;
        return false;
    }

    public int decompte() {
        return decompte;
    }

    public void reinitialise() {
        decompte = 0;
    }
}
