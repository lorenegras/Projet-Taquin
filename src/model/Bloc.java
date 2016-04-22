/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javafx.scene.layout.Pane;

/**
 *
 * @author Lorene
 */
public class Bloc {

    private Pane pane;
    private int num;
    private int[] pos_act;
    private int[] pos_but;

    // Constructeur
    
    public Bloc(int num, int actx, int acty, int butx, int buty) {

        this.num = num;

        this.pos_act = new int[2];
        this.pos_act[0] = actx;
        this.pos_act[1] = acty;

        this.pos_but = new int[2];
        this.pos_but[0] = butx;
        this.pos_but[1] = buty;
    }

    // Getters et setters
    
    // Numéro
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // Position actuelle
    public int getLigne_act() {
        return this.getCoordonnees_act()[0];
    }

    public void setLigne_act(int x) {
        this.getCoordonnees_act()[0] = x;
    }

    public int getColonne_act() {
        return this.getCoordonnees_act()[1];
    }

    public void setColonne_act(int y) {
        this.getCoordonnees_act()[1] = y;
    }

    public int[] getCoordonnees_act() {
        return pos_act;
    }

    public void setCoordonnees_act(int x, int y) {
        this.pos_act[0] = x;
        this.pos_act[1] = y;
    }

    // Position but
    public int getLigne_but() {
        return this.getCoordonnees_but()[0];
    }

    public void setLigne_but(int x) {
        this.getCoordonnees_but()[0] = x;
    }

    public int getColonne_but() {
        return this.getCoordonnees_but()[1];
    }

    public void setColonne_but(int y) {
        this.getCoordonnees_but()[1] = y;
    }

    public int[] getCoordonnees_but() {
        return pos_but;
    }

    public void setCoordonnees_but(int x, int y) {
        this.pos_but[0] = x;
        this.pos_but[1] = y;

    }

    public Pane getPanel() {
        return pane;
    }

    public void setPanel(Pane p) {
        this.pane = p;
    }

    public void setPane(Pane pane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
