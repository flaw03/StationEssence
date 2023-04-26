package model;

public class Produit {

    String nom;
    int stock;
    int prix;

    public Produit(String nom ,int stock, int prix) {
        this.nom = nom;
        this.stock = stock;
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void gainStock(int i) {
        stock += i;
    }

    public void perteStock(int i) throws IllegalArgumentException {
        if (stock - i < 0) {
            throw new IllegalArgumentException("Stock negatif");
            }
        else
            stock -=i;
        }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) throws IllegalArgumentException {
        if (prix < 0){
            throw new IllegalArgumentException("Prix negatif");
        }
        this.prix = prix;
    }

    public int calculerPrix(int quantiiteProduit) {
        return prix * quantiiteProduit;
    }

    public String getNom() {
        return nom;
    }
}
