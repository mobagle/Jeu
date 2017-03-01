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


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

public class ExempleJavaFX extends Application {
    void dessinRecursif(int p, GraphicsContext g, double x, double y, double l, double h) {
        if (p > 0) {
            final int nbLignes = 10;
            // Changement de couleur
            g.setStroke(Color.BLACK);
            // Tracé d'un rectangle
            g.strokeRect(x+l/4, y+h/4, l/2, h/2);
            // Construction d'une séquence de tracés (chemin)
            g.beginPath();
            for (int i = 0; i<=nbLignes; i++) {
                g.moveTo(x+l/2, y+h/2);
                g.lineTo(x+3*l/4, y+h/2+i*h/(4*nbLignes));
                g.moveTo(x+l/2, y+h/2);
                g.lineTo(x+l/2+i*l/(4*nbLignes), y+3*h/4);
            }
            g.closePath();
            // Changement de couleur
            g.setStroke(Color.RED);
            // Tracé du chemin construit
            g.stroke();
            dessinRecursif(p-1, g, x+l/8, y+h/8, l/4, h/4);
        }
    }
    
    void exempleDessin(Canvas c) {
        GraphicsContext g = c.getGraphicsContext2D();
        dessinRecursif(3, g, 0, 0, c.getWidth(), c.getHeight());
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        final boolean fullScreen = false;
        
        primaryStage.setTitle("Armoroides");
        Canvas c = new Canvas();
        
        // Composant de regroupement qui occupe toute la place disponible
        // Le noeud donné en paramètre est placé au centre du BorderPane
        BorderPane b = new BorderPane(c);
        
        // On redimensionne le composant quand son parent change de taille
        c.widthProperty().bind(b.widthProperty());
        c.heightProperty().bind(b.heightProperty());
        
        // Contenu de la fenêtre
        Scene s;
        if (fullScreen) {
            s = new Scene(b);
            primaryStage.setFullScreen(true);            
        } else {
            s = new Scene(b, 800, 600);
        }
        primaryStage.setScene(s);
        
        // Petit message dans la console quand la fenetre est fermée
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Fin du jeu");
            }
        });
        
        primaryStage.show();
        exempleDessin(c);
    }

    public static void creer(String[] args) {
        launch(args);
    }
    
    public static void main(String [] args) {
        creer(args);
    }
}
