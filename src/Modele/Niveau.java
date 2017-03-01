package Modele;


import Modele.Ensembles.FabriqueEnsemble;
import java.util.Arrays;

/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard
 * 
 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).
 * 
 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.
 * 
 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.
 * 
 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
public class Niveau extends ComposantGraphique {
    final static int BONUS=0;
    final static int OBJETS=1;
    final static int MESSAGES=2;

    FabriqueEnsemble f;
    Couche[] couches;
    String[] couleurs;
    float largeur, hauteur;
    Raquette raquette;

    Niveau(String n, int nb) {
        super(0,0);
        System.out.println("Niveau : " + n + ", composé de " + nb + " couches");
        couches = new Couche[nb];
        f = FabriqueEnsemble.grand();
        for (int i = 0; i < couches.length; i++) {
            couches[i] = new Couche(f);
        }
    }

    @Override
    public float l() {
        return largeur;
    }

    @Override
    public float h() {
        return hauteur;
    }

    void ajouteComposant(int h, Composant c) {
        couches[h].ajoute(c);
    }

    void fixerDimensionsMax(int l, int h) {
        System.out.println("Le niveau a une largeur de " + l + " et une hauteur de " + h);
        if (l > largeur) {
            largeur = l;
        }
        if (h > hauteur) {
            hauteur = h;
        }
    }

    void fixeCouleurs(String[] t, int nb) {
        System.out.println("Les couleurs utilisées dans ce niveau sont :");
        for (int i = 0; i < nb; i++) {
            System.out.println(i + " - " + t[i]);
        }
        couleurs = Arrays.copyOf(t, nb);
    }

    public String[] lisCouleurs() {
        return couleurs;
    }

    boolean accepte(Visiteur v) {
        boolean retour = v.visite(this);
        for (int i = 0; i < couches.length; i++) {
            retour = retour || couches[i].accepte(v);
        }
        return retour;
    }

    void nouvelleBalle() {
        System.out.println("Prêt à jouer, en attente de balle !");
        raquette = new Raquette((largeur - 4.0f) / 2.0f, hauteur - 0.75f);
        ajouteComposant(OBJETS, raquette);
        Balle b = new Balle((largeur - 0.5f) / 2.0f, raquette.posY() - 0.55f);
        ajouteComposant(OBJETS, b);

    }

    @Override
    ComposantGraphique copieVers(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
