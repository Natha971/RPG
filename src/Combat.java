import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Combat {

    public static List<Objet> creationObjet() {
        List<Objet> objetList = new ArrayList<>();
        Objet potion1 = new Objet("Potion regénère pointsVieMax", 0, 50);
        Objet potion2 = new Objet("Potion regénère armure", 0, 50);
        Objet potion3 = new Objet("Récupérer 50% de pointsVie", 0, 25);
        Objet potion4 = new Objet("Récupère 50% armure", 0, 25);
        objetList.add(potion1);
        objetList.add(potion2);
        objetList.add(potion3);
        objetList.add(potion4);
        return objetList;
    }

    public static List<Sort> creationSort() {
        List<Sort> sortList = new ArrayList<>();
        Sort premierMouvement = new Sort("Entaille de l'Eau Calme", 20, ThreadLocalRandom.current().nextInt(1, 20));
        Sort deuxiemeMouvement = new Sort("La roue", 20, ThreadLocalRandom.current().nextInt(1, 20));
        Sort troisiemeMouvement = new Sort("Danse des Courants", 20, ThreadLocalRandom.current().nextInt(1, 20));
        Sort quatriemeMouvement = new Sort("Averse Providentielle", 20, ThreadLocalRandom.current().nextInt(1, 20));
        sortList.add(premierMouvement);
        sortList.add(deuxiemeMouvement);
        sortList.add(troisiemeMouvement);
        sortList.add(quatriemeMouvement);
        return sortList;
    }

    public static List<Arme> creationArme() {
        List<Arme> armeList = new ArrayList<>();
        Arme couteau = new Arme("couteau", 5);
        Arme hache = new Arme("hache", 10);
        Arme epee = new Arme("épée", 20);
        Arme sable = new Arme("sable", 30);
        armeList.add(couteau);
        armeList.add(hache);
        armeList.add(epee);
        armeList.add(sable);
        return armeList;
    }

    public static List<Personnage> creationPersonnage() {
        List<Personnage> herosList = new ArrayList<>();
        int nbSort = 3;
        Personnage eren = new Personnage("Eren", 200, 200, 50, 100, nbSort, null, null);
        Personnage tanjiro = new Personnage("Tanjiro", 200, 200, 50, 100, nbSort, null, null);
        Personnage mikasa = new Personnage("mikasa", 200, 200, 50, 100, nbSort, null, null);
        Personnage muzan = new Personnage("Muzan Kibutsuji", 200, 200, 50, 100, nbSort, null, null);
        herosList.add(eren);
        herosList.add(tanjiro);
        herosList.add(mikasa);
        herosList.add(muzan);
        return herosList;
    }

    public static Sort sortHasard() {
        List<Sort> sortList = Combat.creationSort();
        int longueur = sortList.size();
        int alea = ThreadLocalRandom.current().nextInt(0, longueur);
        return (sortList.get(alea));
    }

    public static Arme armeHasard() {
        List<Arme> armeList = Combat.creationArme();
        int longueur = armeList.size();
        int alea = ThreadLocalRandom.current().nextInt(0, longueur);
        return (armeList.get(alea));
    }

    public static List<Monstre> creationMonstre() {
        List<Monstre> monstreList = new ArrayList<>();
        int nbSort = 3;
        Monstre ryuk = new Monstre("Ryuk", 200, 200, 50, 100, nbSort, sortHasard(), armeHasard(), 5);
        Monstre titan = new Monstre("Titan Colossal", 200, 200, 50, 100, nbSort, sortHasard(), armeHasard(), 15);
        Monstre koro = new Monstre("Koro-Sensei", 200, 200, 50, 100, nbSort, sortHasard(), armeHasard(), 20);
        Monstre shenron = new Monstre("Shenron", 200, 200, 50, 100, nbSort, sortHasard(), armeHasard(), 25);
        monstreList.add(ryuk);
        monstreList.add(titan);
        monstreList.add(koro);
        monstreList.add(shenron);
        return monstreList;
    }

    public static int menu1() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Choisissez votre mode");
        System.out.println("1 : Mode solo");
        System.out.println("2 : Multijoueur");
        System.out.println("3 : Aide");
        System.out.println("4 : Quitter le jeu");

        int modeDeJeu = scan1.nextInt();
        return modeDeJeu;
    }

    public static int menu2() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("A quoi voulez vous jouer ?");
        System.out.println("1 : Combat automatique");
        System.out.println("2 : Tournois de combat contrôlé");
        System.out.println("3 : Revenir au menu précédent");
        System.out.println("4 : Quitter le jeu");
        int modeDeJeu = scan1.nextInt();

        if(modeDeJeu == 4){
            System.exit(0);
        }
        return modeDeJeu;
    }

    public static Arme askArme(int numJoueur) {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Joueur " + numJoueur + ", choisissez une arme");
        List<Arme> listArme = Combat.creationArme();
        int longueurListArme = listArme.size();
        for (int i = 0; i < longueurListArme; i++) {
            System.out.println(i + " : " + listArme.get(i).getNom());
        }
        int index = scan4.nextInt();
        Arme armeJoueur1 = listArme.get(index);
        return (armeJoueur1);
    }

    public static Heros askPersonnage(int numJoueur) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Joueur " + numJoueur + ", choisissez un personnage");
        List<Personnage> listPersonnage = Combat.creationPersonnage();
        int longueurListPersonnage = listPersonnage.size();
        for (int i = 0; i < longueurListPersonnage; i++) {
            System.out.println(i + " : " + listPersonnage.get(i).getNom());
        }
        int index = scan2.nextInt();
        Personnage j = listPersonnage.get(index);
        Heros joueur = new Heros(j.getNom(), j.getPointsVieMax(), j.getPointsVie(), j.getAttaque(),
                j.getArmure(), j.getNbSort(), j.getSort(), j.getArme());
        return (joueur);
    }

    public static Sort askSort(int numJoueur) {
        Scanner scan6 = new Scanner(System.in);
        System.out.println("Joueur " + numJoueur + ", choisissez un sort. (ATTENTION, VOUS POURREZ UTILISER CE SORT QUE 3 FOIS LORS D'UN COMBAT)");
        List<Sort> listSort = Combat.creationSort();
        int longueurListSort = listSort.size();
        for (int i = 0; i < longueurListSort; i++) {
            System.out.println(i + " : " + listSort.get(i).getNom());
        }
        int index = scan6.nextInt();
        Sort sortJoueur1 = listSort.get(index);
        return (sortJoueur1);
    }



    public static int askObjet(Heros joueur) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println(joueur.getNom() + " voulez-vous acheter une potion ?");
        System.out.println("1 : Oui");
        System.out.println("2 : Non");
        if (joueur.getInventaire() != null && joueur.getInventaire().size() > 0) {
            System.out.println("3 : Sélectionner un objet dans mon inventaire");
        }
        int choix = scan1.nextInt();
        return choix;
    }

    public static Objet choixObjet(int choix, Heros joueur) {
        if (choix == 1) {
            Scanner scan6 = new Scanner(System.in);
            System.out.println(joueur.getNom() + " choisissez une potion");
            List<Objet> objetList = Combat.creationObjet();
            int longueurListObjet = objetList.size();
            for (int i = 0; i < longueurListObjet; i++) {
                System.out.println(i + " : " + objetList.get(i).getPotion());
            }
            int index = scan6.nextInt();
            Objet objetJoueur = objetList.get(index);
            joueur.getInventaire().add(objetJoueur);
            choixObjet(askObjet(joueur), joueur);
        } else if(choix == 3) {
            Scanner scan6 = new Scanner(System.in);
            System.out.println(joueur.getNom() + " choisissez une potion");
            int longueurListObjet = joueur.getInventaire().size();
            for (int i = 0; i < longueurListObjet; i++) {
                System.out.println(i + " : " + joueur.getInventaire().get(i).getPotion());
            }
            int index = scan6.nextInt();
            Objet objetJoueur = joueur.getInventaire().get(index);
            return (objetJoueur);
        }
        return null;
    }

    public static void swapPlayer(Heros attacker, Heros attacked) {
        Heros swapper;
        swapper = attacked;
        attacked = attacker;
        attacker = swapper;
    }

    public static Monstre monstreAléa() {
        List<Monstre> monstreList = Combat.creationMonstre();
        int longueur = monstreList.size();
        int alea = ThreadLocalRandom.current().nextInt(0, longueur);
        return (monstreList.get(alea));
    }

    public static void addPoints(Heros joueur) {
        joueur.setExperience(joueur.getExperience() + 10);
        joueur.setOr(joueur.getOr() + 5);
    }

    public static void modeDeJeu1(int choix, Heros joueur, Monstre monstre) throws InterruptedException {
        Heros attacker;
        Monstre attacked;
        if (choix == 1) {
            // Initialisation du nombre de tour
            int tour = 0;

            while (joueur.getPointsVie() > 0 && monstre.getPointsVie() > 0) {
                // Tour suivant
                tour++;

                // Début tour
                System.out.println("-------ATTAQUE " + tour + "-------------");

                System.out.println(joueur.getNom() + ", il vous reste " + joueur.getNbSort() + " sort(s).");

                // on récupèrer aléatoirement s'il utilise un sort ou pas
                int sortOk = ThreadLocalRandom.current().nextInt(3, 5);
                int manaOk = ThreadLocalRandom.current().nextInt(3, 5);

                // Si il utilise alors on ajoute le coup du sort à l'attaque
                if (tour % 2 == 0) {
                    joueur.attaqueMonstre(monstre, sortOk);
                } else {
                    monstre.attaque(joueur, sortOk, manaOk);
                }
                System.out.println("------------------------------------------");
            }

            if (tour % 2 == 0) {
                AsciiArt.gameOver();
                System.out.println(joueur.getNom() + " a perdu !");
            } else {
                AsciiArt.winner();
                System.out.println(monstre.getNom() + " a perdu !");
                joueur.setExperience(20 * monstre.getNiveau());
                joueur.setOr(ThreadLocalRandom.current().nextInt(1, 10 + monstre.getNiveau()));
            }
            System.out.println(display(joueur));
            joueur.recover();
        } else if (choix == 3) {
            menu1();
        }
    }

    public static String display(Heros joueur) {
        return (joueur.toString());
    }

    public static void modeDeJeu2(int choix, Heros joueur1, Heros joueur2) throws InterruptedException {
        Heros attacker;
        Heros attacked;

        // Lance aléatoire pour savoir quel joueur commence à jouer
        double seed = ThreadLocalRandom.current().nextDouble(0, 1);
        if (seed < 0.5) {
            attacker = joueur1;
            attacked = joueur2;
        } else {
            attacker = joueur2;
            attacked = joueur1;
        }

        // Initialisation d'un personnage swipper qui permmettra d'inverser l'attacker / attacked
        Heros swapper = null;

        if (choix == 1) { // Combat automatique
            // Initialisation du nombre de tour
            int tour = 0;

            while (attacker.getPointsVie() > 0 && attacked.getPointsVie() > 0) {
                // Tour suivant
                tour++;

                // Début tour
                System.out.println("-------ATTAQUE " + tour + "-------------");

                System.out.println(attacker.getNom() + ", il vous reste " + attacker.getNbSort() + " sort(s).");

                if (attacker.getPointsVie() <= (attacker.getPointsVieMax() / 2)) {
                    int choixObjet = Combat.askObjet(attacker);
                    Objet o = Combat.choixObjet(choixObjet, attacker);
                    if (o != null) {
                        attacker.getInventaire().add(o);
                    }
                }
                int sortOk = 4; // on utilise pas
                int manaOk = 4; // on utilise pas
                // on récupèrer aléatoirement s'il utilise un sort ou pas
                if(attacker.getNbSort() > 0){
                    sortOk = ThreadLocalRandom.current().nextInt(3, 5);
                }
                if(attacker.getSort().getCoutMana() > 0){
                    manaOk = ThreadLocalRandom.current().nextInt(3, 5);
                }

                System.out.println("sortOk " + sortOk);

                // Si il utilise alors on ajoute le coup du sort à l'attaque
                attacker.attaque(attacked, sortOk, manaOk);

                // Changement d'attacker / attacked
                swapper = attacked;
                attacked = attacker;
                attacker = swapper;
                System.out.println("------------------------------------------");
            }

            AsciiArt.gameOver();

            System.out.println(attacked.getNom() + " a perdu !");

        } else if (choix == 3) {
            Combat.menu1();
        } else {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("En combien de combat voulez vous que se déroule ce tournois ?");
            int nbrCombat = scan1.nextInt();

            System.out.println("Ce tournois se déroulera en " + nbrCombat + " combats");

            deroulementTournois(nbrCombat, attacked, attacker, joueur1, joueur2);

        }
    }

    public static void deroulementTournois(int nbrCombat, Heros attacked, Heros attacker, Heros joueur1, Heros joueur2) throws InterruptedException {
        // Initialisation d'un personnage swipper qui permmettra d'inverser l'attacker / attacked
        Heros swapper = null;

        // Initialisation du 1er combat
        int combat = 1;

        // Nombre de combat gagner par joueur
        int winCombatJoueur1 = 0;
        int winCombatJoueur2 = 0;

        while (combat <= nbrCombat) {
            // On affiche d'abord les scores
            System.out.println("RESULTAT :");
            System.out.println(attacker.getNom() + " : " + winCombatJoueur1 + "    |     " + attacked.getNom() + " : " + winCombatJoueur2);

            // Début du combat
            System.out.println("---------COMBAT " + combat + "---------");

            // Initialisation du nombre de tour
            int tour = 0;

            // Initialisation
            String winner = null;

            while (attacker.getPointsVie() > 0 && attacked.getPointsVie() > 0) {

                winner = attacker.attaqueAvecSort(attacked);

                // System.out.println(attacked.getNom());
                // System.out.println(attacker.getNom());
                // winner = attacker.attaqueAvecSort(attacked);
                //Combat.swapPlayer(attacker, attacked);
                //Changement d'attacker / attacked
                swapper = attacked;
                attacked = attacker;
                attacker = swapper;
                // System.out.println(attacked.getNom());
                // System.out.println(attacker.getNom());

                if (winner == null) {
                    break;
                }
            }
            if (attacked.getPointsVie() <= 0) {
                AsciiArt.gameOver();
                System.out.println(attacked.getNom() + " a perdu !");
            }

            System.out.println("Le gagnant de cette manche est " + winner);

            if (winner != null && winner.equals(joueur1.getNom())) {
                winCombatJoueur1++;
                joueur1.setExperience(joueur1.getExperience() + 20);
                joueur1.setOr(joueur1.getOr() + 15);
            } else if (winner != null && winner.equals(joueur2.getNom())) {
                winCombatJoueur2++;
                joueur2.setExperience(joueur2.getExperience() + 20);
                joueur2.setOr(joueur2.getOr() + 15);
            }


            if(combat != nbrCombat){
                System.out.println("COMBAT " + combat + " est terminé. Le prochain combat commencera dans quelque instant.");
            }else{
                System.out.println("COMBAT " + combat + " est terminé.");
            }
            TimeUnit.SECONDS.sleep(5);
            combat++;

            attacked.recover();
            attacker.recover();

            // Lance aléatoire pour savoir quel joueur commence à jouer
            double seed = ThreadLocalRandom.current().nextDouble(0, 1);
            if (seed < 0.5) {
                attacker = joueur1;
                attacked = joueur2;
            } else {
                attacker = joueur2;
                attacked = joueur1;
            }
        }

        if (winCombatJoueur1 > winCombatJoueur2) {
            Combat.addPoints(joueur1);
            AsciiArt.winner();
            System.out.println(joueur1.getNom() + " a gagné ce tournois");
        } else {
            Combat.addPoints(joueur2);
            AsciiArt.winner();
            System.out.println(joueur2.getNom() + " a gagné ce tournois");
        }

        System.out.println(joueur1.toString());
        System.out.println(joueur2.toString());

    }

}
