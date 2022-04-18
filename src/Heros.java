import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Heros extends Personnage{
    private int experience;
    private int or;
    private List<Objet> inventaire;

    public Heros(String nom, int pointsVieMax, int pointsVie, int attaque, int armure, int nbSort, Sort sort, Arme arme) {
        super(nom, pointsVieMax, pointsVie, attaque, armure, nbSort, sort, arme);
        this.experience = 0;
        this.or = 0;
        this.inventaire = new ArrayList<>();

    }

    public static void recompense(Heros hero, Monstre monstre){
         hero.setExperience(20 * monstre.getNiveau());
         hero.setOr(ThreadLocalRandom.current().nextInt(1, (10+monstre.getNiveau()^2)));
    }

    public String attaqueAvecSort(Heros attacked) throws InterruptedException {
        String lastPersonWhoAttacked;
        if(this.getPointsVie() <= (this.getPointsVieMax() /2) && this.getOr() >= 25){

            // Choix action : attaquer ou fuir
            int result = this.choixAction();
            if (result == 1) {
                System.out.println(this.getNom() + ", il vous reste " + this.getNbSort() + " sort(s).");
                System.out.println(this.getNom() + ", vous n'avez plus de points d'armure et " + this.getPointsVie() + " point(s) de vie.");

                // Demande si potion
                int choixObjet = Combat.askObjet(this);
                // Choix de la potion et utilisation ou pas
                Objet o = Combat.choixObjet(choixObjet, this);
                // Si choix potion et utilisation, regénération
                if(o != null){
                    if(o.getPotion().equals("Potion regénère pointsVieMax")){
                        this.setPointsVie(this.getPointsVieMax());
                        this.setOr(this.getOr() -  o.getPrix());
                    }else if(o.getPotion().equals("Potion regénère armure")){
                        this.setArmure(100);
                        this.setOr(this.getOr() -  o.getPrix());
                    }else if(o.getPotion().equals("Récupérer 50% de pointsVie")){
                        this.setArmure(this.getPointsVie() + this.getPointsVieMax()/2);
                        this.setOr(this.getOr() -  o.getPrix());
                    }else if(o.getPotion().equals("Récupère 50% armure")){
                        this.setArmure(100/2);
                        this.setOr(this.getOr() -  o.getPrix());
                    }
                }
                int puissanceSort = 0;
                int sortOk = 0;
                int manaOk = 0;
                if (this.getNbSort() > 0) { // Choisir un sort si on en a
                    sortOk = this.useSort();
                    if (this.getSort().getCoutMana() > 0) {
                        manaOk = useMana();
                    }
                }

                this.attaque(attacked, sortOk, manaOk);
                lastPersonWhoAttacked = this.getNom();
            } else {
                lastPersonWhoAttacked = null;
            }
            System.out.println("------------------------------------------");

            return lastPersonWhoAttacked;
        }else{
            lastPersonWhoAttacked = super.attaqueAvecSort(attacked);
        }
        return lastPersonWhoAttacked;
    }

    public String toString(Heros joueur) {
        String s = super.toString();
        s += "\n Heros{" +
                "experience=" + experience +
                ", or=" + or +
                '}';
        return s;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public List<Objet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(List<Objet> inventaire) {
        this.inventaire = inventaire;
    }
}
