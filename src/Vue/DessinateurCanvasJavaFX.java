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
package Vue;

import Modele.Etendeur;
import Modele.Balle;
import Modele.Bonus;
import Modele.Brique;
import Modele.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import Modele.Visiteur;
import Modele.Niveau;

public class DessinateurCanvasJavaFX extends Visiteur {

    Canvas can;
    GraphicsContext gc;
    Color[] couleurs;
    Niveau niv;
    Etendeur e;

    public DessinateurCanvasJavaFX(Canvas c) {
        can = c;
        e = new Etendeur();
    }

    @Override
    public boolean visite(Niveau n) {
        niv = n;
        if (couleurs == null) {
            String[] tab = n.lisCouleurs();
            if (tab != null) {
                couleurs = new Color[tab.length];
                for (int i = 0; i < couleurs.length; i++) {
                    couleurs[i] = Color.web(tab[i]);
                }
            }
        }
        e.fixeEchelle((float) can.getWidth() / n.l(), (float) can.getHeight() / n.h());
        if (gc == null)
            gc = can.getGraphicsContext2D();
        return false;
    }

    @Override
    public boolean visite(Brique b) {
        e.fixeComposant(b);
        gc.setStroke(couleurs[b.lisCouleur()]);
        gc.strokeRect(e.posX(), e.posY(), e.l(), e.h());
        return false;
    }

    @Override
    public boolean visite(Raquette r) {
        e.fixeComposant(r);
        float canonX = .2f * e.factX();
        float canonY = .2f * e.factY();
        float rayon = e.h() / 2;
        gc.beginPath();
        gc.rect(e.posX() + rayon, e.posY(), e.l() - e.h(), e.h());
        gc.arc(e.posX() + rayon, e.posY() + rayon, rayon, rayon, 90, 180);
        gc.moveTo(e.posX() - rayon + e.l(), e.posY() + e.h());
        gc.arc(e.posX() - rayon + e.l(), e.posY() + rayon, rayon, rayon, 270, 180);
        gc.closePath();
        gc.setStroke(Color.web("rgb(50%,50%,50%)"));
        gc.stroke();
        return false;
    }

    @Override
    public boolean visite(Balle b) {
        e.fixeComposant(b);
        gc.setStroke(Color.web("rgb(50%,50%,50%)"));
        gc.strokeOval(e.posX(), e.posY(), e.l(), e.h());
        return false;
    }

    @Override
    public boolean visite(Bonus b) {
        e.fixeComposant(b);
        gc.setStroke(Color.web("rgb(50%,50%,50%)"));
        gc.strokeText(b.nom(), e.posX() + e.l() / 3, e.posY() + 17 * e.h() / 24, e.l() / 3);
        gc.strokeOval(e.posX(), e.posY(), e.l(), e.h());
        return false;
    }
}
