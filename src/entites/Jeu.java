package entites;

import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private Pirate[] pirates;
    private Plateau plateau;
    private boolean estTermine;
    private int pirateCourantIndex;
    private Depassement depassement;
    private CaseEffetHP caseEffetHP3;

    public Jeu(Pirate pirate1, Pirate pirate2) {
        this.pirates = new Pirate[]{pirate1, pirate2};
        this.plateau = new Plateau();
        this.estTermine = false;
        this.pirateCourantIndex = 0; 
        this.depassement = new Depassement(); 
        this.caseEffetHP3 = new CaseEffetHP(this);

    }

    public void tourPirate(int totalDe) {
        Pirate pirateCourant = getPirateCourant();
        Pion pion = pirateCourant.getPion();
        Case positionActuelle = pion.getPosition();
        int nouvellePosition = positionActuelle.getNumCase() + totalDe;

        if (nouvellePosition == 30) {
            System.out.println("Vous êtes arrivé à la case 30, félicitations ! Vous avez gagné !");
            estTermine = true;
            return;
        }

        if (nouvellePosition > 30) {
            System.out.println("La position doit être comprise entre 1 et 30 inclusivement. Vous devez rejouer !");
            return;
        }

        Case nouvelleCase = plateau.getCase(nouvellePosition);
        pion.setPosition(nouvelleCase);

        // Appliquer l'effet de dépassement après le déplacement du pirate
        if (depassement.appliquerEffetDepassement(pirates[0], pirates[1])) {
            // Afficher les points de vie des pirates après le dépassement
            System.out.println("Points de vie après le dépassement :");
            System.out.println("Pirate 1 : " + pirates[0].getPointsDeVie());
            System.out.println("Pirate 2 : " + pirates[1].getPointsDeVie());
            
            // Appliquer l'effet spécial de la case 29
            CaseEffetPosition.FauxEspoir(pirateCourant);

            // Vérifier si le pirate doit reculer au prochain tour
            if (pirateCourant.doitReculerPourProchainTour()) {
                System.out.println("Le pirate reculera au prochain tour !");
                pirateCourant.setReculePourProchainTour(true);
            }
            
            // Appliquer l'effet spécial de la case 15
            caseEffetHP3.hopital(pirateCourant);
            
            if (nouvellePosition == 3) {
                Pirate pirateAdverse = getPirateAdverse(pirateCourant);
                if (pirateAdverse != null) {
                    caseEffetHP3.coupDeFeu(pirateAdverse);
                } else {
                    System.out.println("Aucun pirate adverse n'a été trouvé.");
                }
            }
        }
    }



    public void lancerPartie() {
        // Logique du lancement de la partie
    }

    public void initialiserJeu() {
        // Logique de l'initialisation du jeu
    }

    public void changerPirate() {
        pirateCourantIndex = (pirateCourantIndex + 1) % pirates.length;
    }

    public Pirate getPirateCourant() {
        return pirates[pirateCourantIndex];
    }

    public Pirate getPirateAdverse() {
        return pirates[(pirateCourantIndex + 1) % pirates.length];
    }

    public boolean estTermine() {
        for (Pirate pirate : pirates) {
            if (pirate.getPointsDeVie() <= 0) {
                estTermine = true;
                break;
            }
        }
        return estTermine;
    }
    
    public Pirate getPirateAdverse(Pirate pirate) {
        for (Pirate p : pirates) {
            if (p != pirate) {
                return p;
            }
        }
        return null; // Gestion du cas où aucun pirate adverse n'est trouvé
    }
}