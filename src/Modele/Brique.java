package Modele;

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
public class Brique extends ComposantGraphique {

    int resistance;
    int couleur;
    float largeur, hauteur;
    static final float LARGEUR_DEFAUT = 2;
    static final float HAUTEUR_DEFAUT = 1;

    public int lisCouleur() {
        return couleur;
    }

    Brique(int r, int c) {
        this(r, c, 0, 0);
    }

    Brique(int r, int c, float x, float y) {
        super(x, y);
        resistance = r;
        couleur = c;
        largeur = LARGEUR_DEFAUT;
        hauteur = HAUTEUR_DEFAUT;
    }

    @Override
    public float l() {
        return largeur;
    }

    @Override
    public float h() {
        return hauteur;
    }

    public ComposantGraphique copieVers(float x, float y) {
        return new Brique(resistance, couleur, x, y);
    }

    @Override
    public boolean accepte(Visiteur v) {
        return v.visite(this);
    }

    public String toString() {
        return "Brique en (" + posX() + ", " + posY() + "), resistance " + resistance + ", couleur " + couleur;
    }
}
