package midsummer.com.lordecalculatormidsummerv2.helper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by cityme on 2/7/18.
 */

public class RealmUtil {
    private static Realm realm;


    public static Realm getRealm(){
        try {
            if (realm == null){
                RealmConfiguration config = new RealmConfiguration
                        .Builder()
                        .deleteRealmIfMigrationNeeded()
                        .build();
                realm = Realm.getInstance(config);
            }
            return realm;

        }catch (Exception e){
            LogUtil.e(e);
            return Realm.getDefaultInstance();
        }
    }



    public static void destroyRealm(){
        try {
            if (realm != null && !realm.isClosed()) realm.close();
        }catch (Exception e){
            LogUtil.e(e);
        }
    }
}
