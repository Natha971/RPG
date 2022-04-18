public class Monstre extends Personnage{
    private int niveau;

    public Monstre(String nom, int pointsVieMax, int pointsVie, int attaque, int armure, int nbSort, Sort sort, Arme arme, int niveau) {
        super(nom, pointsVieMax, pointsVie, attaque, armure, nbSort, sort, arme);
        this.niveau = niveau;
    }


    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
