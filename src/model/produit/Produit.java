package model.produit;

import model.calendrier.CalendrierStock;
import model.calendrier.CalendrierTransaction;
import model.transaction.Transaction;

public class Produit {

    private final String nom;
    private int stock;
    private int reapro = 0;
    private int stockInitial;
    private int nbrvente = 0;
    private int prix;
    private int nouveauxPrix;

    public final CalendrierStock calendrierStock;

    public final CalendrierTransaction calendrierTransaction;

    public Produit(String nom ,int stock, int prix) {
        this.nom = nom;
        this.stock = stock;
        this.stockInitial = stock;
        this.prix = prix;
        this.nouveauxPrix = prix;
        calendrierStock = new CalendrierStock(nom);
        calendrierTransaction = new CalendrierTransaction();
    }

    public int getStock() {
        return stock;
    }

    public void gainStock(int i) {
        stock += i;
        reapro += i;
    }

    public void  perteStock(int i) throws IllegalArgumentException {
        if (stock - i < 0) {
            throw new IllegalArgumentException("Stock negatif");
            }
        else{
            nbrvente += i;
            stock -=i;
        }
    }

    public Transaction venteProduit(int quantite,String nomClient){
        perteStock(quantite);
        Transaction transaction = new Transaction(prix, quantite, nom, nomClient);
        calendrierTransaction.ajouterTransaction(transaction);
        return transaction;
    }


    public int getPrix() {
        return prix;
    }

    public boolean disponible(){
        return stock > 0;
    }


//    Change le pris le jour suivant
    public void setPrix(int prix) throws IllegalArgumentException {
        if (prix < 0){
            throw new IllegalArgumentException("Prix négatif");
        }
        this.nouveauxPrix = prix;
    }

    public int calculerPrix(int quantiteProduit) {
        return prix * quantiteProduit;
    }

    public String getNom() {
        return nom;
    }

    public void changerDate() {
        calendrierStock.jourSuivant(nbrvente,stockInitial,stock,reapro,prix,calculerPrix(nbrvente));
        stockInitial = stock;
        reapro = 0;
        nbrvente = 0;
        prix = nouveauxPrix;
    }

}
