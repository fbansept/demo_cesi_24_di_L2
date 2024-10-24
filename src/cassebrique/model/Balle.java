package cassebrique.model;

import cassebrique.CasseBrique;

import java.awt.*;

public class Balle extends Sprite{

    protected int vitesseX;
    protected int vitesseY;

    public Balle(int x, int y, int vitesseX, int vitesseY) {

        super(x, y , Color.RED);

        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
    }

    public void deplacement() {
        x += vitesseX;
        y += vitesseY;

        if(x >= CasseBrique.LARGEUR - 50 || x <= 0) {
            vitesseX = -vitesseX;
        }

        if(y >= CasseBrique.HAUTEUR - 50 || y <= 0) {
            vitesseY = -vitesseY;
        }
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y, 50,50);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
