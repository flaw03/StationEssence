package model.produit;

public class Lubrifiant extends Produit {

    int code;
    int poids;
    public Lubrifiant(String nom, int stock, int prix) {
        super(nom, stock, prix);
        this.poids = poids;
    }

    public int getCode() {
        return code;
    }

    public int getPoids(){
        return poids;
    }

    public void setCode(int numLubrifiant) {
        this.code = numLubrifiant;
    }
}
