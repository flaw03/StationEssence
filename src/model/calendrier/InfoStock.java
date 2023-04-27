package model.calendrier;

public class InfoStock {

    private String mois;
    private int jour;
    private int nbrVente;
    private int stockInitial;
    private int stockFinal;
    private int reaProvisionnement;
    private int prix;
    private int prixTotal;

    private String nom;

    public InfoStock(String mois , int jour , String nom) {
        this.nom = nom;
        this.mois = mois;
        this.jour = jour;
    }


    public void init(int nbrVente, int stockInitial, int stockFinal,
                     int reaProvisionnement, int prix, int prixTotal) {
        this.nbrVente = nbrVente;
        this.stockInitial = stockInitial;
        this.stockFinal = stockFinal;
        this.reaProvisionnement = reaProvisionnement;
        this.prix = prix;
        this.prixTotal = prixTotal;
    }

    public int getNbrVente() {
        return nbrVente;
    }

    public int getStockInitial() {
        return stockInitial;
    }

    public int getStockFinal() {
        return stockFinal;
    }

    public int getReaProvisionnement() {
        return reaProvisionnement;
    }

    public int getPrix() {
        return prix;
    }

    public int getPrixTotal() {
        return prixTotal;
    }


    @Override
    public String toString() {
        String chaine =  "Stock de " + nom + " du " + jour + " " + mois + "\n";
        chaine += "prix : " + prix + "\n";
        chaine += "stock initial : " + stockInitial +"\n";
        chaine += "stock final : " + stockFinal + "\n";
        chaine += "réapprovisionnement : " + reaProvisionnement + "\n";
        chaine += "nombre de vente : " + nbrVente + "\n";
        chaine += "prix Total : " + prixTotal + "\n";
        return chaine;

    }
}
