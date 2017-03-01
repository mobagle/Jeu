package Modele;

/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard

 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).

 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.

 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.

 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
public class Bonus extends ComposantGraphique {

    public static String[] natures = {
        "Elargit",
        "Retrecit",
        "Multiballes",
        "Laser"
    };
    int nature;
    float diametre;
    static final float DIAMETRE_DEFAUT = 1;

    public String nom() {
        return natures[nature].substring(0, 1);
    }

    static int findType(String name) {
        for (int i = 0; i < natures.length; i++) {
            if (name.equals(natures[i])) {
                return i;
            }
        }
        return -1;
    }

    Bonus(int t, float x, float y) {
        super(x, y);
        nature = t;
        diametre = DIAMETRE_DEFAUT;
    }

    Bonus(int t) {
        this(t, 0, 0);
    }

    @Override
    public float l() {
        return diametre;
    }

    @Override
    public float h() {
        return diametre;
    }

    public ComposantGraphique copieVers(float x, float y) {
        return new Bonus(nature, x, y);
    }

    @Override
    public boolean accepte(Visiteur v) {
        return v.visite(this);
    }

    public String toString() {
        return "Bonus en (" + posX() + ", " + posY() + "), nature " + natures[nature];
    }
}
