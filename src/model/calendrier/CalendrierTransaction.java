package model.calendrier;

import model.transaction.Transaction;

public class CalendrierTransaction extends Calendrier{

    private MoisTransaction[] tabMoisTranscation;
    public CalendrierTransaction(int jour, int mois) {
        super(jour, mois);
        tabMoisTranscation = new MoisTransaction[12];
        for (int i = 0; i<12 ; i++){
            tabMoisTranscation[i] = new MoisTransaction(nomMois[i],jourMois[i]) ;
        }
    }

//    @Override
    public void jourSuivant() {
        if (jour + 1 >= jourMois[mois] ){
            mois = (mois + 1 ) % 12;
            jour = 0;
        }
        else{
            jour ++;
        }
    }

    public void ajouterTransaction(Transaction transaction){
        tabMoisTranscation[mois].ajouterTransaction(jour,transaction);
    }

    public Transaction getTransactionNum(int jour, int mois, int numeroTransaction) {
        jour --;
        mois --;
        return tabMoisTranscation[mois].getTransactionNum(jour, numeroTransaction);
    }

    public InfoTransaction getInfoTransactionClient(int jour, int mois, String nomClient) {
        jour --;
        mois --;
        return tabMoisTranscation[mois].getInfoTransactionClient(jour, nomClient);
    }

    public InfoTransaction getInfoTransaction(int jour ,int mois) {
        mois--;
        jour--;
        return tabMoisTranscation[mois].getInfoTransaction(jour);
    }

}
