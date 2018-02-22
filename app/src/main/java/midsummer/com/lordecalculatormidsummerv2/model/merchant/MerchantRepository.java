package midsummer.com.lordecalculatormidsummerv2.model.merchant;

import org.joda.time.DateTime;

import io.realm.Realm;
import io.realm.RealmResults;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;
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
                callback.onAction(merchant);
            }
        });
    }




    @Override
    public void destroy() {
        RealmUtil.destroyRealm();
    }


    @Override
    public void loadAllMerchant(final MerchantListListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Merchant> merchants = realm.where(Merchant.class).findAll();
                callback.onLoaded(merchants);
            }
        });
    }

    @Override
    public void loadMerchant(final long merchantId, final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Merchant merchant = realm.where(Merchant.class).equalTo("id", merchantId).findFirst();
                callback.onAction(merchant);
            }
        });
    }

    @Override
    public void addMerchant(final String name, final String phone, final boolean isHost, final float rateDe, final float rateLo, final float rateXien, final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Merchant merchant = new Merchant(DateTime.now().getMillis(),name, phone, isHost, rateDe, rateLo, rateXien);
                realm.copyToRealmOrUpdate(merchant);
                callback.onAction(merchant);
            }
        });
    }

    @Override
    public void updateMerchant(final long merchantId,final String name,final String phone,
                               final boolean isHost,final float rateDe,final float rateLo,final float rateXien,final MerchantActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Merchant merchant = realm.where(Merchant.class).equalTo("id", merchantId).findFirst();
                if (merchant != null){
                    merchant.setName(name);
                    merchant.setPhoneNumber(phone);
                    merchant.setRateDE(rateDe);
                    merchant.setRateLO(rateLo);
                    merchant.setRateXIEN(rateXien);
                    merchant.setHost(isHost);
                    realm.copyToRealmOrUpdate(merchant);
                    callback.onAction(merchant);
                }else
                    callback.onAction(null);
            }
        });
    }
}
