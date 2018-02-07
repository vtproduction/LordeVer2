package midsummer.com.lordecalculatormidsummerv2.model.merchant;

import io.realm.Realm;
import midsummer.com.lordecalculatormidsummerv2.helper.RealmUtil;

/**
 * Created by cityme on 2/7/18.
 */

public class MerchantRepository implements MerchantDataSource {


    @Override
    public void addMerchant(final Merchant merchant, final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(merchant);
                callback.onAction(merchant);
            }
        });
    }

    @Override
    public void deleteMerchant(final long merchantId, final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Merchant merchant =  realm.where(Merchant.class).equalTo("id",merchantId)
                        .findFirst();
                if (merchant != null) merchant.deleteFromRealm();
                callback.onAction(null);
            }
        });
    }

    @Override
    public void updateMerchant(final Merchant merchant, final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(merchant);
                callback.onAction(merchant);
            }
        });
    }


    @Override
    public void destroy() {
        RealmUtil.destroyRealm();
    }
}
