package cassebrique;

import cassebrique.model.Balle;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    public CasseBrique() throws InterruptedException {
        System.out.println("debut du jeu");

        JFrame fenetre = new JFrame();

        setSize(LARGEUR, HAUTEUR);
        setBounds(0,0, LARGEUR, HAUTEUR);
        fenetre.setSize(LARGEUR, HAUTEUR);

        setFocusable(false);
        fenetre.requestFocus();
        fenetre.setResizable(false);
        fenetre.setIgnoreRepaint(true);

        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel conteneur = new JPanel();
        conteneur.add(this);
        fenetre.setContentPane(conteneur);

        fenetre.setVisible(true);

        createBufferStrategy(2);

        this.recommencer();
    }

    public void recommencer() throws InterruptedException {

        Balle[] balles = new Balle[1000];

        for(int i = 0; i < 1000; i++) {
            balles[i] = new Balle(
                    aleatoire(50, LARGEUR - 50),
                    aleatoire(50, HAUTEUR - 50),
                    aleatoire(1,10),
                    aleatoire(1,10),
                    true);
        }

        while(true) {

            Graphics2D dessin = (Graphics2D)getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

            for(Balle balle : balles) {
                balle.deplacement();
                balle.dessiner(dessin);
            }

            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);

        }

    }

    public int aleatoire(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }

}
