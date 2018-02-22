package midsummer.com.lordecalculatormidsummerv2.model.merchant;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by cityme on 2/7/18.
 */

public interface MerchantDataSource {

    interface MerchantActionListener{
        void onAction(Merchant merchant);
    }

    interface MerchantListListener{
        void onLoaded(RealmResults<Merchant> merchants);
    }

    void addMerchant(String name, String phone, boolean isHost, float rateDe, float rateLo, float rateXien, MerchantActionListener callback);
    void addMerchant(Merchant merchant, MerchantActionListener callback);
    void deleteMerchant(long merchantId, MerchantActionListener callback);
    void updateMerchant(long merchantId, String name, String phone, boolean isHost, float rateDe, float rateLo, float rateXien, MerchantActionListener callback);
    void loadAllMerchant(MerchantListListener callback);
    void loadMerchant(long merchantId,  MerchantActionListener callback);
    void destroy();

}
