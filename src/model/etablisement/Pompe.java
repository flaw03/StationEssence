package model.etablisement;

import model.produit.Cuve;

public class Pompe <T extends Cuve>{

    private final T cuve;

    public Pompe(T cuve) {
        this.cuve = cuve;
    }


}
