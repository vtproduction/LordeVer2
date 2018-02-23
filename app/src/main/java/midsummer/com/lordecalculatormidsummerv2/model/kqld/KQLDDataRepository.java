package midsummer.com.lordecalculatormidsummerv2.model.kqld;

import java.util.Calendar;

import io.realm.Realm;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;
import midsummer.com.lordecalculatormidsummerv2.helper.RealmUtil;

/**
 * Created by cityme on 2/23/18.
 */

public class KQLDDataRepository implements KQLDDataDataSource {


    @Override
    public void addKQLDData(final int type, final long kqldId, final int[] numbers, final float value, final actionKQLDDataListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                long id = Calendar.getInstance().getTimeInMillis();
                KQLDData data = new KQLDData();
                data.setId(id);
                data.setLordeId(kqldId);
                data.setValue(value);
                data.setType(type);
                String numString = "";
                for (int i : numbers)
                    numString += (i + " ");
                numString = numString.trim();
                data.setNums(numString);
                realm.copyToRealmOrUpdate(data);
                callback.onAction(data);
            }
        });
    }

    @Override
    public void updateKQLDData(final long id,final long kqldId,final int type,final int[] numbers,final float value, final actionKQLDDataListener callback) {
        RealmUtil.getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                KQLDData data = realm.where(KQLDData.class).equalTo("id",id).findFirst();
                if (data == null){
                    callback.onAction(null);
                    return;
                }
                data.setLordeId(kqldId);
                data.setValue(value);
                data.setType(type);
                String numString = "";
                for (int i : numbers)
                    numString += (i + " ");
                numString = numString.trim();
                data.setNums(numString);
                realm.copyToRealmOrUpdate(data);
                callback.onAction(data);
            }
        });
    }


    @Override
    public void destroy() {
        RealmUtil.destroyRealm();
    }
}
