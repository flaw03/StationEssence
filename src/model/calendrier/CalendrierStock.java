package model.calendrier;

public class CalendrierStock extends Calendrier {

    private final MoisStock[] moisStocks;

    public CalendrierStock(int jour, int mois, String nomProduit) throws IllegalArgumentException{
        super(jour, mois);
        moisStocks = new MoisStock[12];
        for (int i = 0; i < 12; i++) {
            moisStocks[i] = new MoisStock(nomMois[i], jourMois[i], nomProduit);
        }
    }

//    @Override
    public void jourSuivant(int nbrVente, int stockInitial, int stockFinal, int reaProvisionnement, int prix, int prixTotal) {
        moisStocks[mois].getInfoStock(jour).init(nbrVente,stockInitial,stockFinal,reaProvisionnement,prix,prixTotal);
        if (jour + 1 >= jourMois[mois] ){
            mois = (mois + 1 )% 12;
            jour = 0;
        }
        else{
            jour ++;
        }
    }

    public InfoStock obtenirInfoStock(int jourDemander, int moisDemander) throws IllegalArgumentException , ArrayIndexOutOfBoundsException{
        moisDemander --;
        jourDemander--;
        if ( jourDemander < 0 || moisDemander < 0 ||
             moisDemander >= 12 || jourDemander >= jourMois[moisDemander]  ) {
                throw new ArrayIndexOutOfBoundsException("Date hos du tableau ");
        }
        else if (this.mois<= moisDemander && this.jour <= jourDemander){
            throw new IllegalArgumentException("Pas d'information disponible");
        }
        return moisStocks[moisDemander].getInfoStock(jourDemander);
    }

}
