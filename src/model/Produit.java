package model;

public class Produit {

    int stock;

    public Produit(int stock) {
        this.stock = stock;
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
}
