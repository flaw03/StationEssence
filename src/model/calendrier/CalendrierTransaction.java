package model.calendrier;

import model.transaction.CarnetTransaction;
import model.transaction.Transaction;

public class CalendrierTransaction extends Calendrier{

    private final MoisTransaction[] tabMoisTranscation;
    public CalendrierTransaction() {
        tabMoisTranscation = new MoisTransaction[12];
        for (int i = 0; i<12 ; i++){
            tabMoisTranscation[i] = new MoisTransaction(nomMois[i],jourMois[i]) ;
        }
    }

//    @Override

    public void ajouterTransaction(Transaction transaction){
        tabMoisTranscation[mois].ajouterTransaction(jour,transaction);
    }

    public Transaction getTransactionNum(int jour, int mois, int numeroTransaction) {
        jour --;
        mois --;
        return tabMoisTranscation[mois].getTransactionNum(jour, numeroTransaction);
    }

    public CarnetTransaction getInfoTransactionClient(int jour, int mois, String nomClient) {
        jour --;
        mois --;
        return tabMoisTranscation[mois].getInfoTransactionClient(jour, nomClient);
    }

    public CarnetTransaction getInfoTransaction(int jour , int mois) {
        mois--;
        jour--;
        return tabMoisTranscation[mois].getInfoTransaction(jour);
    }

}
