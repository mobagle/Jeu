package Vue;

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


import Modele.Jeu;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

public class InterfaceCanvasJavaFX extends Application {
    static Jeu jeu;
    
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
        
        jeu.init();
        jeu.accepte(new DessinateurCanvasJavaFX(c));
        primaryStage.show();
    }

    public static void creer(String[] args, Jeu j) {
        jeu = j;
        launch(args);
    }
}
