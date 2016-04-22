/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lorene
 */
public class Taquin {

    private Bloc plateau[][];
    private Joueur joueur;
    private boolean melange;
    private int nbDeplacement;
    private long chrono;
    private int taille;

    public Taquin(Joueur j, int t) {
        this.joueur = j;
        this.melange = false;
        this.nbDeplacement = 0;
        this.chrono = 0;
        this.taille=t;
        this.plateau = new Bloc[t][t];
    }

    public void init() {

    }

    // Getters et setters
    // Plateau
    public Bloc[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Bloc[][] plateau) {
        this.plateau = plateau;
    }

    // Joueur
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    // Mélangé ?
    // A enlever si jamais on retourne un booléen dans verifSolTaquin() !
    public boolean isMelange() {
        return melange;
    }

    public void setMelange(boolean melange) {
        this.melange = melange;
    }

    // Nombre de déplacements
    public int getNbDeplacement() {
        return nbDeplacement;
    }

    public void setNbDeplacement(int nbDeplacement) {
        this.nbDeplacement = nbDeplacement;
    }

    // Chrono
    public long getChrono() {
        return chrono;
    }

    public void setChrono(long chrono) {
        this.chrono = chrono;
    }

    // Taille
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    // Fonctions
    // Insertion des blocs dans le tableau
    public void remplirTableau() { // correspond à init()

        int i = 0;
        int j = 0;
        int num = 1;

        while (i < taille) {
            while (j < taille) {
                if (i != taille - 1 || j != taille - 1) {
                    Bloc b = new Bloc(num, i, j, i, j);
                    plateau[i][j] = b;
                    num += 1;
                    j += 1;
                } else {
                    Bloc b = new Bloc(0, i, j, i, j);
                    plateau[i][j] = b;
                    j += 1;
                }
            }
            i += 1;
            j = 0;
        }

    }

    public void afficherTableau() {
        int[][] tab = new int[this.taille][this.taille];
        int i = 0;
        int j = 0;
        while (i < taille) {
            while (j < taille) {
                tab[i][j] = plateau[i][j].getNum();
                j += 1;
            }
            i += 1;
            j = 0;
        }
        i = 0;
        j = 0;
        while (i < taille) {
            while (j < taille) {
                System.out.print(" | " + tab[i][j] + " | ");
                j += 1;
            }
            System.out.println("");
            i += 1;
            j = 0;
        }
    }

// Connaître les mouvements possibles
    public ArrayList<Bloc> mouvementsPossibles() {

        int i = 0;
        int j = 0;
        ArrayList<Bloc> listeBloc = new ArrayList<>();
        while (i < taille) {
            while (j < taille) {
                if (plateau[i][j].getNum() == 0) {
                    if (i - 1 >= 0) {
                        listeBloc.add(plateau[i - 1][j]);
                    }
                    if (j - 1 >= 0) {
                        listeBloc.add(plateau[i][j - 1]);
                    }
                    if (i + 1 < taille) {
                        listeBloc.add(plateau[i + 1][j]);
                    }
                    if (j + 1 < taille) {
                        listeBloc.add(plateau[i][j + 1]);
                    }
                }
                j += 1;

            }
            i += 1;
            j = 0;
        }

        return listeBloc;

    }

    // Mélanger les blocs
    public void deplacerBloc(Bloc b) {

        ArrayList<Bloc> listeBloc = new ArrayList<>();
        listeBloc = mouvementsPossibles();

        int x = b.getLigne_act();
        int y = b.getColonne_act();
        for (int i = 0; i < listeBloc.size(); i++) {
            if (listeBloc.get(i).equals(b)) {
                if (x - 1 >= 0 && plateau[x - 1][y].getNum() == 0) {
                    plateau[x][y] = plateau[x - 1][y];
                    plateau[x - 1][y] = b;
                    b.setLigne_act(x - 1);
                    plateau[x][y].setLigne_act(x);
                } else if (y - 1 >= 0 && plateau[x][y - 1].getNum() == 0) {
                    plateau[x][y] = plateau[x][y - 1];
                    plateau[x][y - 1] = b;
                    b.setColonne_act(y - 1);
                    plateau[x][y].setColonne_act(y);
                } else if (x + 1 < taille && plateau[x + 1][y].getNum() == 0) {
                    plateau[x][y] = plateau[x + 1][y];
                    plateau[x + 1][y] = b;
                    b.setLigne_act(x + 1);
                    plateau[x][y].setLigne_act(x);
                } else if (y + 1 < taille && plateau[x][y + 1].getNum() == 0) {
                    plateau[x][y] = plateau[x][y + 1];
                    plateau[x][y + 1] = b;
                    b.setColonne_act(y + 1);
                    plateau[x][y].setColonne_act(y);
                }
            }
        }

    }

    public void melanger() {

        ArrayList<Bloc> listeBloc = new ArrayList<>();
        int i = 0;

        while (i < 100) {
            listeBloc = mouvementsPossibles();
            Random rand = new Random();
            int nbAleatoire = rand.nextInt(listeBloc.size() - 1 + 1);
            Bloc b = listeBloc.get(nbAleatoire);
            deplacerBloc(b);
            i++;
        }
    }

    public boolean verifSolTaquin() {

        boolean solution = true;

        int i = 0;
        int j = 0;

        while (i < taille) {
            while (j < taille) {
                if (i != plateau[i][j].getLigne_but() || j != plateau[i][j].getColonne_but()) {
                    solution = false;
                }
                j++;
            }
            i++;
            j = 0;
        }

        return solution;

    }

}
