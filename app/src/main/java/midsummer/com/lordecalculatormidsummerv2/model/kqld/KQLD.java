package midsummer.com.lordecalculatormidsummerv2.model.kqld;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cityme on 2/23/18.
 */

public class KQLD extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    public long id;
    public String date;
    public long merchantId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }
}
