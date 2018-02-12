package midsummer.com.lordecalculatormidsummerv2.model.merchant;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cityme on 2/7/18.
 */

public class Merchant extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    public long id;

    public String name;
    public String phoneNumber;
    public boolean isHost;
    public float rateDE;
    public float rateLO;
    public float rateXIEN;

    public Merchant() {
    }

    public Merchant(long id, String name, String phoneNumber, boolean isHost, float rateDE, float rateLO, float rateXIEN) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isHost = isHost;
        this.rateDE = rateDE;
        this.rateLO = rateLO;
        this.rateXIEN = rateXIEN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean host) {
        isHost = host;
    }

    public float getRateDE() {
        return rateDE;
    }

    public void setRateDE(float rateDE) {
        this.rateDE = rateDE;
    }

    public float getRateLO() {
        return rateLO;
    }

    public void setRateLO(float rateLO) {
        this.rateLO = rateLO;
    }

    public float getRateXIEN() {
        return rateXIEN;
    }

    public void setRateXIEN(float rateXIEN) {
        this.rateXIEN = rateXIEN;
    }


    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isHost=" + isHost +
                ", rateDE=" + rateDE +
                ", rateLO=" + rateLO +
                ", rateXIEN=" + rateXIEN +
                '}';
    }
}
