package model.calendrier;

public class MoisStock {
    private final String noms;
    private final InfoStock[] infoStocks;

    public MoisStock(String noms ,int nbJour ,String nomProduit) {
        this.noms = noms;
        infoStocks = new InfoStock[nbJour];
        for (int i = 0; i < nbJour ; i++){
            infoStocks[i] = new InfoStock(this.noms , i+1 ,nomProduit);
        }
    }

    public String getNoms() {
        return noms;
    }

    public InfoStock getInfoStock(int jour)throws ArrayIndexOutOfBoundsException{
        if (jour >= infoStocks.length){
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        return infoStocks[jour];
    }


}
