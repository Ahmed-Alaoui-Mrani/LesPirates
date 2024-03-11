package entites;

import java.util.Random;
import java.util.Scanner;

public class Main {
	  public static void main(String[] args) {
        // Création des instances
        Plateau plateau = new Plateau();
        Joueur joueur1 = new Joueur(new Pion(plateau.getCase(1), Couleur.ROUGE), "Joueur 1 (Rouge)", 5);
        Joueur joueur2 = new Joueur(new Pion(plateau.getCase(1), Couleur.BLEU), "Joueur 2 (Bleu)", 5);
        Jeu jeu = new Jeu(joueur1, joueur2);
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenue dans le jeu des pirates !\n");

        while (!jeu.estTermine()) {
            System.out.println("Tour de " + jeu.getJoueurCourant().getNom() + " (points de vie: " +
                    jeu.getJoueurCourant().getPointsDeVie() + ")\n");

            System.out.println("Veuillez appuyez sur Entrée pour lancer les dés.");
            scanner.nextLine();

            // Lancer des dés
            int de1 = random.nextInt(6) + 1;
            int de2 = random.nextInt(6) + 1;
            int totalDe = de1 + de2;
            System.out.println("Vous avez lancé " + de1 + " et " + de2 + ". Avancez de " + totalDe + " cases.\n");

            // Déplacer le pion du joueur
            jeu.tourJoueur(totalDe);

            // Afficher le plateau
            plateau.afficherPlateau(joueur1, joueur2);

            // Vérifier si le joueur a gagné ou perdu des points de vie
            if (jeu.getJoueurCourant().getPointsDeVie() <= 0) {
                System.out.println(jeu.getJoueurAdverse().getNom() + " a gagné !");
                break;
            }

            // Changer de joueur
            jeu.changerJoueur();
        }

        scanner.close();
	  }
}
