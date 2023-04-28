package model.calendrier;

public class CalendrierStock extends Calendrier {

    private final MoisStock[] moisStocks;

    public CalendrierStock (String nomProduit) {
        moisStocks = new MoisStock[12];
        for (int i = 0; i < 12; i++) {
            moisStocks[i] = new MoisStock(nomMois[i], jourMois[i], nomProduit);
        }
    }

//    @Override
    public void jourSuivant(int nbrVente, int stockInitial, int stockFinal, int reaProvisionnement, int prix, int prixTotal) {
        moisStocks[mois].getInfoStock(jour).init(nbrVente,stockInitial,stockFinal,reaProvisionnement,prix,prixTotal);
        jourSuivant();
    }

    public InfoStock obtenirInfoStock(int jourDemander, int moisDemander) throws IllegalArgumentException , ArrayIndexOutOfBoundsException{
        moisDemander --;
        jourDemander--;
        if ( jourDemander < 0 || moisDemander < 0 ||
             moisDemander >= 12 || jourDemander >= jourMois[moisDemander]  ) {
                throw new ArrayIndexOutOfBoundsException("Date hos du tableau ");
        }
        else if (Calendrier.mois<= moisDemander && Calendrier.jour <= jourDemander){
            throw new IllegalArgumentException("Pas d'information disponible");
        }
        return moisStocks[moisDemander].getInfoStock(jourDemander);
    }

}
