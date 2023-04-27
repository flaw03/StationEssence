package model.transaction;

public class Transaction {

    private static int nbrTransation = 0;
    private final int prix;
    private final int quantitee;
    private final int numTransaction;
    private final String nomProduit;
    private final String nonClient;


    public Transaction(int prix, int quantitee, String nomProduit, String nonClient) {
        this.prix = prix;
        this.quantitee = quantitee;
        this.numTransaction = ++nbrTransation;
        this.nomProduit = nomProduit;
        this.nonClient = nonClient;
    }

    public int getPrix() {
        return prix;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getNonClient() {
        return nonClient;
    }

    public int getQuantitee() {
        return quantitee;
    }

    public int getNumTransaction() {
        return numTransaction;
    }
}
