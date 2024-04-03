package entites;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Création des instances
        Plateau plateau = new Plateau();
        Pirate pirate1 = new Pirate(new Pion(plateau.getCase(1), Couleur.ROUGE), "Pirate 1 (Rouge)", 5, Couleur.ROUGE);
        Pirate pirate2 = new Pirate(new Pion(plateau.getCase(1), Couleur.BLEU), "Pirate 2 (Bleu)", 5, Couleur.BLEU);

        Jeu jeu = new Jeu(pirate1, pirate2);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenue dans le jeu des pirates !\n");
        System.out.println("Règles des cases spéciales:");
        System.out.println("3 : Si un pirate tombe sur cette case, l'adversaire perd 1 HP.");
        System.out.println("15 : Si un pirate tombe sur cette case, il gagne 1 HP.");
        System.out.println("18 : Si un pirate tombe sur cette case, il retourne à la case de départ.");
        System.out.println("21 : Si un pirate tombe sur cette case, il est bloqué pendant un tour.");
        System.out.println("29 : Si un pirate tombe sur cette case, il reculera au prochain tour.\n");

        while (!jeu.estTermine()) {
            System.out.println("Tour de " + jeu.getPirateCourant().getNom() + " (points de vie: " +
                    jeu.getPirateCourant().getPointsDeVie() + ")\n");

            System.out.println("Veuillez appuyer sur Entrée pour lancer les dés.");
            scanner.nextLine();

            // Lancer des dés
            int de = De.lancerDe(); // Utilisation de la classe De pour lancer le dé
            int totalDe = de; // Initialisation du total des dés avec le résultat du dé lancé
            System.out.println("Vous avez lancé " + de + ". Avancez de " + totalDe + " cases.\n");

            // Déplacer le pion du pirate
            jeu.tourPirate(totalDe);

            // Afficher le plateau après avoir déplacé le pion
            plateau.afficherPlateau(jeu.getPirateCourant(), jeu.getPirateAdverse());

            // Vérifier si le pirate a gagné ou perdu des points de vie
            if (jeu.getPirateCourant().getPointsDeVie() <= 0) {
                System.out.println(jeu.getPirateAdverse().getNom() + " a gagné !");
                break;
            }

            // Changer de pirate
            jeu.changerPirate();
        }



        scanner.close();
    }
}
