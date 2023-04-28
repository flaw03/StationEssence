package model.calendrier;

public abstract class Calendrier {
    protected final String[] nomMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre",
            "Octobre", "Novembre", "Décembre"};
    protected static final int[] jourMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected static int mois = 0;
    protected static int jour = 0;

    public Calendrier() {

    }

    public static void setDate(int jour ,int mois) {
        if (mois <= 0 || jour <= 0 || mois > 12 || jour > jourMois[mois - 1]) {
            throw new IllegalArgumentException("Date pas au bon format");
        }
        Calendrier.jour = jour -1 ;
        Calendrier.mois = mois - 1;

    }

    public static void jourSuivant(){
        if (jour + 1 >= jourMois[mois] ){
            mois = (mois + 1 ) % 12;
            jour = 0;
        }
        else{
            jour ++;
        }
    }


    public String getDate() {
        return jour + 1 + " " + nomMois[mois];
    }
}
