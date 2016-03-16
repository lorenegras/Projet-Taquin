/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lorene
 */
public class Joueur {
    
    private String pseudo;
    private int score;
    private int classement;
    
    /*public Joueur(String pseudo, int score){
        this.pseudo=pseudo;
        this.score=score;
    }*/

    /**
     * @return the pseudo
     */
    
    
    public Joueur(String pso) {
        this.pseudo=pso;
        this.score=0;
        this.classement=0;
    }
    
    
    
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the classement
     */
    public int getClassement() {
        return classement;
    }

    /**
     * @param classement the classement to set
     */
    public void setClassement(int classement) {
        this.classement = classement;
    }
    
}
