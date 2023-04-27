package model.calendrier;

public abstract class Calendrier {
    protected final String[] nomMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre",
            "Octobre", "Novembre", "Décembre"};
    protected final int[] jourMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected int mois;
    protected int jour;

    public Calendrier(int jour, int mois) {
        if (mois <= 0 || jour <= 0 || mois > 12 ||jour > jourMois[mois-1]){
            throw new IllegalArgumentException("Date pas au bon format");
        }
        this.mois = mois - 1;
        this.jour = jour - 1;
    }

//    public abstract void jourSuivant();

    public String getDate() {
        return jour + 1 + " " + nomMois[mois];
    }
}
