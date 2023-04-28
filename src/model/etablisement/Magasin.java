package model.etablisement;

import model.produit.Lubrifiant;

public class Magasin {

    private final Lubrifiant[] lubrifiants ;
    private int nbLubrifiant = 0;

    public Magasin(int nbrLubrifiantMax) {
        lubrifiants = new Lubrifiant[nbrLubrifiantMax];
    }

    public void ajouterLubrifiant(Lubrifiant lubrifiant) throws ArrayIndexOutOfBoundsException{
        if (lubrifiants.length <= nbLubrifiant){
            throw new ArrayIndexOutOfBoundsException("Le magasin est rempli");
        }
        else {
            lubrifiants[nbLubrifiant] = lubrifiant;
            lubrifiant.setCode(nbLubrifiant);
            nbLubrifiant ++;
        }

    }

    public void jourSuivant(){
        for (int i = 0; i < nbLubrifiant; i++) {
            lubrifiants[i].changerDate();
        }
    }


    public int trouverProduit(String nomProduit) {
        for(int i = 0; i < nbLubrifiant;i++){
            if(lubrifiants[i].getNom().equals(nomProduit)){
                return i;
            }
        }
        return -1;
    }

    public String listerLubrifiantDisponible (){
        StringBuilder chaine = new StringBuilder("Produit disponilbe :\n");
        for(int i = 0 ; i<nbLubrifiant ; i++){
            if(lubrifiants[i].disponible()){
                chaine.append(lubrifiants[i].toString()).append("\n");
            }
        }
        return chaine.toString();
    }


}
