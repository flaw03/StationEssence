package model;

public class Produit {

    int stock;
    int prix;

    public Produit(int stock, int prix) {
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
}
