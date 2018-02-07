package midsummer.com.lordecalculatormidsummerv2.model.merchant;

/**
 * Created by cityme on 2/7/18.
 */

public interface MerchantDataSource {

    interface MerchantActionListener{
        void onAction(Merchant merchant);
    }


    void addMerchant(Merchant merchant, MerchantActionListener callback);
    void deleteMerchant(long merchantId, MerchantActionListener callback);
    void updateMerchant(Merchant merchant, MerchantActionListener callback);
    void destroy();

}
