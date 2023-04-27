package model.calendrier;

public class MoisStock {
    private final String noms;
    private final InfoStock[] infoStock;

    public MoisStock(String noms ,int nbJour ,String nomProduit) {
        this.noms = noms;
        infoStock = new InfoStock[nbJour];
        for (int i = 0; i < nbJour ; i++){
            infoStock[i] = new InfoStock(this.noms , i+1 ,nomProduit);
        }
    }

    public InfoStock getInfoStock(int jour)throws ArrayIndexOutOfBoundsException{
        if (jour >= infoStock.length){
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        return infoStock[jour];
    }


}
