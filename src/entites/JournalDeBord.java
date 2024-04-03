package entites;

public class JournalDeBord implements Affichage {

    @Override
    public void afficherAvancement(Pirate pirate) {
        System.out.println("Avancement du pirate " + pirate.getNom() + " : " + pirate.getPosition());
    }

    @Override
    public void afficherResultatDe(Integer de1, Integer de2) {
        System.out.println("Résultat du lancer de dés : " + de1 + ", " + de2);
    }

    @Override
    public void afficherDepassement(Pirate pirate1, Pirate pirate2) {
        System.out.println(pirate1.getNom() + " a dépassé " + pirate2.getNom());
    }

    @Override
    public void afficherEffetEspoir(Pirate pirate) {
        System.out.println("Effet spécial 'Espoir' pour " + pirate.getNom());
    }

    @Override
    public void afficherEffetHopital(Pirate pirate) {
        System.out.println("Effet spécial 'Hopital' pour " + pirate.getNom());
    }

    @Override
    public void afficherBloquagePion(Pirate pirate) {
        System.out.println("Le pion du pirate " + pirate.getNom() + " est bloqué.");
    }

    @Override
    public void afficherPirateGagnant(Pirate pirateGagnant) {
        System.out.println("Le pirate " + pirateGagnant.getNom() + " est le gagnant !");
    }

    @Override
    public void afficherRetourDepart(Pirate pirate) {
        System.out.println("Le pirate " + pirate.getNom() + " retourne à la case de départ.");
    }

    @Override
    public void afficherEchangePions(Pirate pirate1, Pirate pirate2) {
        System.out.println("Les pirates " + pirate1.getNom() + " et " + pirate2.getNom() + " ont échangé leurs positions.");
    }

    @Override
    public void afficherCoupDeFeu(Pirate pirate1, Pirate pirate2) {
        System.out.println("Le pirate " + pirate1.getNom() + " a tiré sur le pirate " + pirate2.getNom() + " !");
    }
}
