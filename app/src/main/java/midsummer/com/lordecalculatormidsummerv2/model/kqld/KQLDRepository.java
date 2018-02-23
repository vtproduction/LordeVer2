package midsummer.com.lordecalculatormidsummerv2.model.kqld;

import org.joda.time.DateTime;

import io.realm.Realm;
import midsummer.com.lordecalculatormidsummerv2.helper.RealmUtil;

/**
 * Created by cityme on 2/23/18.
 */

public class KQLDRepository implements KQLDDataSource {

    @Override
    public void addKQLD(final long merchantId, final String date, final actionKQLDListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                long id = DateTime.now().getMillis();
                KQLD kqld = new KQLD();
                kqld.setId(id);
                kqld.setMerchantId(merchantId);
                kqld.setDate(date);
                realm.copyToRealmOrUpdate(kqld);
                callback.onAction(kqld);
            }
        });
    }

    @Override
    public void updateKQLD(final long id,final  long merchantId, final String date, final actionKQLDListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                KQLD kqld = realm.where(KQLD.class).equalTo("id", id).findFirst();
                if (kqld == null){
                    callback.onAction(null);
                    return;
                }
                kqld.setMerchantId(merchantId);
                kqld.setDate(date);
                realm.copyToRealmOrUpdate(kqld);
                callback.onAction(kqld);
            }
        });
    }

    @Override
    public void destroy() {
        RealmUtil.destroyRealm();
    }
}
