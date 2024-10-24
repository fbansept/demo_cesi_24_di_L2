package cassebrique;

import cassebrique.model.Balle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    private ArrayList<Balle> listeBalle = new ArrayList();

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

        fenetre.addKeyListener(this);

        JPanel conteneur = new JPanel();
        conteneur.add(this);
        fenetre.setContentPane(conteneur);

        fenetre.setVisible(true);

        createBufferStrategy(2);

        this.recommencer();
    }

    public void recommencer() throws InterruptedException {

        listeBalle.add(new Balle(LARGEUR / 2,HAUTEUR / 2, 3, 3));


        while(true) {

            Graphics2D dessin = (Graphics2D)getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

            for(Balle balle : listeBalle) {
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("gauche");
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("droite");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
