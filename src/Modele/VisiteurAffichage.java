package Modele;

public class VisiteurAffichage extends Visiteur {

    @Override
    public boolean visite(Composant c) {
        System.out.println("Autre composant :");
        System.out.println(c);
        return false;
    }

    @Override
    public boolean visite(Brique b) {
        System.out.println("C'est une brique :");
        System.out.println(b);
        return false;
    }

    @Override
    public boolean visite(Bonus b) {
        System.out.println("C'est un bonus :");
        System.out.println(b);
        return false;
    }
}
