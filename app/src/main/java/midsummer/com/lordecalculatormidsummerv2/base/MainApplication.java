package midsummer.com.lordecalculatormidsummerv2.base;

import android.content.pm.ApplicationInfo;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import io.realm.Realm;

/**
 * Created by cityme on 2/7/18.
 */

public class MainApplication extends MultiDexApplication{

    static MainApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Realm.init(this);
        instance = this;
    }


    public static MainApplication getInstance(){
        return instance;
    }



}
