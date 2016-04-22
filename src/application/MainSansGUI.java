/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Bloc;
import model.Joueur;
import model.Taquin;

/**
 *
 * @author Lorene
 */
public class MainSansGUI {

    public static void main(String[] args) {
//        
//        System.out.println("Voulez-vous jouer en console ? Si oui, tapez [Y], sinon, tapez [n]");
//        Scanner sc1 = new Scanner(System.in);
//        String s1 = sc1.nextLine();
//        

        System.out.println("Rentrer votre pseudo :-)");
        Scanner sc2 = new Scanner(System.in);
        String s2 = sc2.nextLine();
        Joueur j = new Joueur(s2);
        Taquin jeu = new Taquin(j, 4);

//        if (args.length==0) {
//            Main.main(args);
//        } else {
//            System.out.println("Lancement du programme sans GUI");
//            System.out.println(jeu);
//        }
        System.out.println("Voici le tableau initial :");
        jeu.remplirTableau();
        jeu.afficherTableau();
        System.out.println("eh pouf ! Le tableau est mélangé !");
        jeu.melanger();
        jeu.afficherTableau();

        while (!jeu.verifSolTaquin()) {

            ArrayList<Bloc> mvt = new ArrayList<Bloc>();
            mvt = jeu.mouvementsPossibles();
            boolean b = false;
            while (!b) {
                System.out.println("Quels blocs souhaitez-vous déplacer ?");
                Scanner sc3 = new Scanner(System.in);
                String s3 = sc3.nextLine();
                for (int i = 0; i < mvt.size(); i++) {
                    String numBloc = Integer.toString(mvt.get(i).getNum());
                    if (numBloc.equals(s3)) {
                        jeu.deplacerBloc(mvt.get(i));
                        jeu.afficherTableau();
                        b = true;
                        j.setScore(j.getScore()+1);
                    }
                }
                if(!b){
                    System.out.println("Vous ne pouvez pas déplacer ce bloc là. Choisisez un bloc accessible.");
                }
            }
        }
        System.out.println("Vous avez gagné !! :-) hihii");
        System.out.println("Votre score est de : " + j.getScore());

    }

}
