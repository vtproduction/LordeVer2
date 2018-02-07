package midsummer.com.lordecalculatormidsummerv2.model.kqsx;

/**
 * Created by cityme on 2/7/18.
 */

public interface KQXSDataSource {

    interface KQXSActionListener{
        void onAction(KQXS kqxs);
    }


    void addKQXS(String date, int[] data, KQXSActionListener callback);
    void updateKQXS(String date, int[] data, KQXSActionListener callback);
    void findKQXS(String date, KQXSActionListener callback);

    void destroy();

}
