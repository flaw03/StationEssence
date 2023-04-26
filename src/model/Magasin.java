package model;

public class Magasin {

    private final Lubrifiant [] lubrifiants ;
    private int nbLubrifiant = 0;

    public Magasin(int nbrLubrifiantMax) {
        lubrifiants = new Lubrifiant[nbrLubrifiantMax];
    }

    public void ajouterLubrifiant(Lubrifiant lubrifiant) throws ArrayIndexOutOfBoundsException{
        if (lubrifiants.length <= nbLubrifiant){
            System.out.print("feur\n");
            throw new ArrayIndexOutOfBoundsException("Le magasin est rempli");
        }
        else {
            lubrifiants[nbLubrifiant] = lubrifiant;
            lubrifiant.setCode(nbLubrifiant);
            nbLubrifiant ++;
        }

    }

    public int produitDisponible(String nomProduit) {
        for(int i = 0; i < nbLubrifiant;i++){
            if(lubrifiants[i].getNom().equals(nomProduit)){
                return i;
            }
        }
        return -1;
    }

}
