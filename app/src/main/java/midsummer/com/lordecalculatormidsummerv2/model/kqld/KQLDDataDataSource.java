package midsummer.com.lordecalculatormidsummerv2.model.kqld;

/**
 * Created by cityme on 2/23/18.
 */

public interface KQLDDataDataSource {
    interface actionKQLDDataListener{
        void onAction(KQLDData data);
    }

    void addKQLDData(int type, long kqldId, int[] numbers, float value, actionKQLDDataListener callback);
    void updateKQLDData(long id,long kqldId, int type, int[] numbers, float value, actionKQLDDataListener callback);
    void destroy();
}
