package midsummer.com.lordecalculatormidsummerv2.model.kqld;

/**
 * Created by cityme on 2/23/18.
 */

public interface KQLDDataSource {
    interface actionKQLDListener{
        void onAction(KQLD data);
    }

    void addKQLD(long merchantId, String date, actionKQLDListener callback);
    void updateKQLD(long id,long merchantId, String date, actionKQLDListener callback);
    void destroy();
}
