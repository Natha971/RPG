import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Personnage {
    //Développer une classe Personnage contenant comme propriétés de classe un String nom et trois int : pointsVieMax, pointsVie et attaque.
    private String nom;
    private int pointsVieMax;
    private int pointsVie;
    private int attaque;
    private int armure;
    private int nbSort;
    private Sort sort;
    private Arme arme;

    //Ajoutez à cette classe un constructeur initialisant ces variables. PointsVie étant égale à pointsVieMax sauf au cœur d’un combat.


    public Personnage(String nom, int pointsVieMax, int pointsVie, int attaque, int armure, int nbSort, Sort sort, Arme arme) {
        this.nom = nom;
        this.pointsVieMax = pointsVieMax;
        this.pointsVie = pointsVie;
        this.attaque = attaque;
        this.armure = armure;
        this.nbSort = nbSort;
        this.sort = sort;
        this.arme = arme;
    }


    public int choixAction() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Que voulez-vous faire " + nom + " ? Rentrez un chiffre");
        System.out.println("1 : attaquer");
        System.out.println("2 : fuir");
        int action = scan.nextInt();
        int resultat;
        if (action == 1) {
            resultat = 1;
        } else {
            double seed = ThreadLocalRandom.current().nextDouble(0, 1);
            if (seed < 0.5) {
                resultat = 0;
            } else {
                resultat = 1;
            }
        }
        return (resultat);
    }

    public static int useSort() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Voulez-vous utiliser un sort ?");
        System.out.println("1 : Oui");
        System.out.println("2 : Non");
        int sortOk = scan1.nextInt();
        return (sortOk);
    }

    public static int useMana() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Voulez-vous utiliser un mana ?");
        System.out.println("1 : Oui");
        System.out.println("2 : Non");
        int choix = scan1.nextInt();
        return choix;
    }

    // Attaque avec sort
    public void attaque(Heros attacked, int useSort, int useMana) throws InterruptedException {
        int puissanceSort = this.sort.getPuissance();
        int armeJoueur = this.arme.getCoup();
        int b = ThreadLocalRandom.current().nextInt(1, this.attaque);
        int total;
        // Si on décide d'utiliser un sort
        if (useSort == 1 || useSort == 3) {
            if (this.nbSort > 0) {
                total = b + puissanceSort + armeJoueur;
                this.nbSort--;
            } else {
                total = b + armeJoueur;
            }
        } else {
            total = b + armeJoueur;
        }

        System.out.println("ATTENTION " + nom + " attaque !!!");
        TimeUnit.SECONDS.sleep(3);
        if(useMana == 1 || useMana == 3){
            attacked.setPointsVie(attacked.getPointsVie() - total);
            this.getSort().setCoutMana(this.getSort().getCoutMana() - 5);
        }else{
            if (attacked.getArmure() >= total) {
                attacked.setArmure(attacked.getArmure() - total);
            } else if (attacked.getArmure() > 0) {
                attacked.setPointsVie(attacked.getPointsVie() - (total - attacked.getArmure()));
                attacked.setArmure(0);
            } else {
                attacked.setPointsVie(attacked.getPointsVie() - total);
            }
        }

        System.out.println("          _ ._  _ , _ ._           ");
        System.out.println("         (_ ' ( `  )_  .__)        ");
        System.out.println("       ( (  (    )   `)  ) _)      ");
        System.out.println("      (__ (_   (_ . _) _) ,__)     ");
        System.out.println("          `~~`\\ ' . /`~~`          ");
        System.out.println("               ;   ;               ");
        System.out.println("              /    \\               ");
        System.out.println(" ____________/__ __ \\_____________ ");

        System.out.println(attacked.getNom() + ", il vous reste " + attacked.getArmure() + " points d'armure et " + attacked.getPointsVie() + " points de vie.");
    }

    // Attaque sans sort
    public static void attaqueControle(Personnage attacker, Personnage attacked, int action) throws InterruptedException {
        if (action == 1) {
            int a = ThreadLocalRandom.current().nextInt(1, attacked.getAttaque());
            System.out.println("ATTENTION " + attacker.getNom() + " attaque !!!");
            TimeUnit.SECONDS.sleep(3);
            if (attacked.getArmure() >= a) {
                attacked.setArmure(attacked.getArmure() - a);
            } else if (attacked.getArmure() > 0) {
                attacked.setPointsVie(attacked.getPointsVie() - (a - attacked.getArmure()));
                attacked.setArmure(0);
            } else {
                attacked.setPointsVie(attacked.getPointsVie() - a);
            }
            System.out.println("          _ ._  _ , _ ._           ");
            System.out.println("         (_ ' ( `  )_  .__)        ");
            System.out.println("       ( (  (    )   `)  ) _)      ");
            System.out.println("      (__ (_   (_ . _) _) ,__)     ");
            System.out.println("          `~~`\\ ' . /`~~`          ");
            System.out.println("               ;   ;               ");
            System.out.println("              /    \\               ");
            System.out.println(" ____________/__ __ \\_____________ ");

            System.out.println("Il reste " + attacked.getArmure() + " points d'armure et " + attacked.getPointsVie() + " points de vie à " + attacked.getNom());
            if (attacked.getPointsVie() <= 0) {
                System.out.println(
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                                "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
                                "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                                "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
                                "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                                "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                                "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                                "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                                "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" +
                                "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
                System.out.println(attacked.getNom() + " a perdu !");
            }
        } else {
            System.out.println(attacked.getNom() + " a décidé de fuir (quel lâche!)");
        }
    }

    public String attaqueAvecSort(Heros attacked) throws InterruptedException {
        String lastPersonWhoAttacked;

        // Choix action : attaquer ou fuir
        int result = this.choixAction();
        if (result == 1) {
            System.out.println(nom + ", il vous reste " + this.nbSort + " sort(s).");
            int puissanceSort = 0;
            int sortOk = 0;
            int manaOk = 0;
            if (this.nbSort > 0) { // Choisir un sort si on en a
                sortOk = this.useSort();
                if (this.getSort().getCoutMana() > 0) {
                    manaOk = useMana();
                }
            }
            this.attaque(attacked, sortOk, manaOk);
            lastPersonWhoAttacked = nom;
        } else {
            lastPersonWhoAttacked = null;
        }
        System.out.println("------------------------------------------");

        return lastPersonWhoAttacked;
    }

    public void attaqueMonstre(Monstre attacked, int useSort) throws InterruptedException {
        int puissanceSort = this.sort.getPuissance();
        int armeJoueur = this.arme.getCoup();
        int b = ThreadLocalRandom.current().nextInt(1, this.attaque);
        int total;
        // Si on décide d'utiliser un sort
        if (useSort == 1 || useSort == 3) {
            if (this.nbSort > 0) {
                total = b + puissanceSort + armeJoueur;
                this.nbSort--;
            } else {
                total = b + armeJoueur;
            }
        } else {
            total = b + armeJoueur;
        }

        System.out.println("ATTENTION " + nom + " attaque !!!");
        TimeUnit.SECONDS.sleep(3);
        if (attacked.getArmure() >= total) {
            attacked.setArmure(attacked.getArmure() - total);
        } else if (attacked.getArmure() > 0) {
            attacked.setPointsVie(attacked.getPointsVie() - (total - attacked.getArmure()));
            attacked.setArmure(0);
        } else {
            attacked.setPointsVie(attacked.getPointsVie() - total);
        }
        System.out.println("          _ ._  _ , _ ._           ");
        System.out.println("         (_ ' ( `  )_  .__)        ");
        System.out.println("       ( (  (    )   `)  ) _)      ");
        System.out.println("      (__ (_   (_ . _) _) ,__)     ");
        System.out.println("          `~~`\\ ' . /`~~`          ");
        System.out.println("               ;   ;               ");
        System.out.println("              /    \\               ");
        System.out.println(" ____________/__ __ \\_____________ ");

        System.out.println(attacked.getNom() + ", il vous reste " + attacked.getArmure() + " points d'armure et " + attacked.getPointsVie() + " points de vie.");
    }

    public void recover() {
        this.nbSort = 3;
        this.pointsVie = this.pointsVieMax;
        this.armure = 100;

        // Récupération liste sort
        List<Sort> listSort = Combat.creationSort();

        // Pour chaque
        for (int i = 0; i < listSort.size(); i++) {
            if (listSort.get(i).getNom().equals(this.getSort().getNom())) {
                this.setSort(listSort.get(i));
            }

        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pointsVieMax=" + pointsVieMax +
                ", pointsVie=" + pointsVie +
                ", attaque=" + attaque +
                ", armure=" + armure +
                ", nbSort=" + nbSort +
                ", sort=" + sort +
                ", arme=" + arme +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsVieMax() {
        return pointsVieMax;
    }

    public void setPointsVieMax(int pointsVieMax) {
        this.pointsVieMax = pointsVieMax;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getNbSort() {
        return nbSort;
    }

    public void setNbSort(int nbSort) {
        this.nbSort = nbSort;
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
