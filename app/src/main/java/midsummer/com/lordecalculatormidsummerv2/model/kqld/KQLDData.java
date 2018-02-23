package midsummer.com.lordecalculatormidsummerv2.model.kqld;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cityme on 2/23/18.
 */

public class KQLDData extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    public long id;

    public long lordeId;
    public String nums;
    public float value;
    public int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLordeId() {
        return lordeId;
    }

    public void setLordeId(long lordeId) {
        this.lordeId = lordeId;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
