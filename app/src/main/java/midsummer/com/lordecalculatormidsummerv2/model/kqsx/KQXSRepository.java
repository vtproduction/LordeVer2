package midsummer.com.lordecalculatormidsummerv2.model.kqsx;

import org.joda.time.DateTime;

import io.realm.Realm;
import midsummer.com.lordecalculatormidsummerv2.helper.LogUtil;
import midsummer.com.lordecalculatormidsummerv2.helper.RealmUtil;

/**
 * Created by cityme on 2/7/18.
 */

public class KQXSRepository implements KQXSDataSource {


    @Override
    public void addKQXS(final String date, final int[] data, final KQXSActionListener callback) {
        LogUtil.d("addKQXS: " + date);
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    long id = DateTime.now().getMillis();
                    KQXS kqxs = new KQXS();
                    kqxs.setId(id);
                    kqxs.setDate(date);
                    kqxs.setData(data);
                    realm.copyToRealmOrUpdate(kqxs);
                    callback.onAction(kqxs);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onAction(null);
                }
            }
        });
    }

    @Override
    public void updateKQXS(final String date,final  int[] data,final  KQXSActionListener callback) {
        LogUtil.d("updateKQXS: " + date);
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    KQXS kqxs = realm.where(KQXS.class).equalTo("date", date).findFirst();
                    if (kqxs == null){
                        callback.onAction(null);
                        return;
                    }
                    kqxs.setData(data);
                    realm.copyToRealmOrUpdate(kqxs);
                    callback.onAction(kqxs);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onAction(null);
                }
            }
        });
    }

    @Override
    public void findKQXS(final String date, final KQXSActionListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    KQXS kqxs = realm.where(KQXS.class).equalTo("date", date).findFirst();
                    if (kqxs == null){
                        callback.onAction(null);
                        return;
                    }
                    callback.onAction(kqxs);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onAction(null);
                }
            }
        });
    }

    @Override
    public void destroy() {
        RealmUtil.destroyRealm();
    }
}
