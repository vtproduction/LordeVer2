package midsummer.com.lordecalculatormidsummerv2.model.kqsx;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by cityme on 2/7/18.
 */

public class KQXS extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    public long id;


    public String date;


    public int GDB;
    public int G1;
    public int G2_1;
    public int G2_2;
    public int G3_1;
    public int G3_2;
    public int G3_3;
    public int G3_4;
    public int G3_5;
    public int G3_6;
    public int G4_1;
    public int G4_2;
    public int G4_3;
    public int G4_4;
    public int G5_1;
    public int G5_2;
    public int G5_3;
    public int G5_4;
    public int G5_5;
    public int G5_6;
    public int G6_1;
    public int G6_2;
    public int G6_3;
    public int G7_1;
    public int G7_2;
    public int G7_3;
    public int G7_4;

    @Override
    public String toString() {
        return "KQXS{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", GDB=" + GDB +
                ", G1=" + G1 +
                ", G2_1=" + G2_1 +
                ", G2_2=" + G2_2 +
                ", G3_1=" + G3_1 +
                ", G3_2=" + G3_2 +
                ", G3_3=" + G3_3 +
                ", G3_4=" + G3_4 +
                ", G3_5=" + G3_5 +
                ", G3_6=" + G3_6 +
                ", G4_1=" + G4_1 +
                ", G4_2=" + G4_2 +
                ", G4_3=" + G4_3 +
                ", G4_4=" + G4_4 +
                ", G5_1=" + G5_1 +
                ", G5_2=" + G5_2 +
                ", G5_3=" + G5_3 +
                ", G5_4=" + G5_4 +
                ", G5_5=" + G5_5 +
                ", G5_6=" + G5_6 +
                ", G6_1=" + G6_1 +
                ", G6_2=" + G6_2 +
                ", G6_3=" + G6_3 +
                ", G7_1=" + G7_1 +
                ", G7_2=" + G7_2 +
                ", G7_3=" + G7_3 +
                ", G7_4=" + G7_4 +
                '}';
    }

    public int[] getData(){
        int[] data = new int[27];
        data[0] = getGDB();
        data[1] = getG1();
        data[2] = getG2_1();
        data[3] = getG2_2();
        data[4] = getG3_1();
        data[5] = getG3_2();
        data[6] = getG3_3();
        data[7] = getG3_4();
        data[8] = getG3_5();
        data[9] = getG3_6();
        data[10] = getG4_1();
        data[11] = getG4_2();
        data[12] = getG4_3();
        data[13] = getG4_4();
        data[14] = getG5_1();
        data[15] = getG5_2();
        data[16] = getG5_3();
        data[17] = getG5_4();
        data[18] = getG5_5();
        data[19] = getG5_6();
        data[20] = getG6_1();
        data[21] = getG6_2();
        data[22] = getG6_3();
        data[23] = getG7_1();
        data[24] = getG7_2();
        data[25] = getG7_3();
        data[26] = getG7_4();
        return data;

    }

    public void setData(int[] data) throws Exception {
        if (data.length != 27){
            throw new Exception("wrong size!!!!");
        }
        setGDB(data[0]);
        setG1(data[1]);
        setG2_1(data[2]);
        setG2_2(data[3]);
        setG3_1(data[4]);
        setG3_2(data[5]);
        setG3_3(data[6]);
        setG3_4(data[7]);
        setG3_5(data[8]);
        setG3_6(data[9]);
        setG4_1(data[10]);
        setG4_2(data[11]);
        setG4_3(data[12]);
        setG4_4(data[13]);
        setG5_1(data[14]);
        setG5_2(data[15]);
        setG5_3(data[16]);
        setG5_4(data[17]);
        setG5_5(data[18]);
        setG5_6(data[19]);
        setG6_1(data[20]);
        setG6_2(data[21]);
        setG6_3(data[22]);
        setG7_1(data[23]);
        setG7_2(data[24]);
        setG7_3(data[25]);
        setG7_4(data[26]);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setGDB(int GDB) {
        this.GDB = GDB;
    }

    public int getGDB() {
        return GDB;
    }

    public int getG1() {
        return G1;
    }

    public int getG2_1() {
        return G2_1;
    }

    public int getG2_2() {
        return G2_2;
    }

    public int getG3_1() {
        return G3_1;
    }

    public int getG3_2() {
        return G3_2;
    }

    public int getG3_3() {
        return G3_3;
    }

    public int getG3_4() {
        return G3_4;
    }

    public int getG3_5() {
        return G3_5;
    }

    public int getG3_6() {
        return G3_6;
    }

    public int getG4_1() {
        return G4_1;
    }

    public int getG4_2() {
        return G4_2;
    }

    public int getG4_3() {
        return G4_3;
    }

    public int getG4_4() {
        return G4_4;
    }

    public int getG5_1() {
        return G5_1;
    }

    public int getG5_2() {
        return G5_2;
    }

    public int getG5_3() {
        return G5_3;
    }

    public int getG5_4() {
        return G5_4;
    }

    public int getG5_5() {
        return G5_5;
    }

    public int getG5_6() {
        return G5_6;
    }

    public int getG6_1() {
        return G6_1;
    }

    public int getG6_2() {
        return G6_2;
    }

    public int getG6_3() {
        return G6_3;
    }

    public int getG7_1() {
        return G7_1;
    }

    public int getG7_2() {
        return G7_2;
    }

    public int getG7_3() {
        return G7_3;
    }

    public int getG7_4() {
        return G7_4;
    }

    public void setG1(int g1) {
        G1 = g1;
    }

    public void setG2_1(int g2_1) {
        G2_1 = g2_1;
    }

    public void setG2_2(int g2_2) {
        G2_2 = g2_2;
    }

    public void setG3_1(int g3_1) {
        G3_1 = g3_1;
    }

    public void setG3_2(int g3_2) {
        G3_2 = g3_2;
    }

    public void setG3_3(int g3_3) {
        G3_3 = g3_3;
    }

    public void setG3_4(int g3_4) {
        G3_4 = g3_4;
    }

    public void setG3_5(int g3_5) {
        G3_5 = g3_5;
    }

    public void setG3_6(int g3_6) {
        G3_6 = g3_6;
    }

    public void setG4_1(int g4_1) {
        G4_1 = g4_1;
    }

    public void setG4_2(int g4_2) {
        G4_2 = g4_2;
    }

    public void setG4_3(int g4_3) {
        G4_3 = g4_3;
    }

    public void setG4_4(int g4_4) {
        G4_4 = g4_4;
    }

    public void setG5_1(int g5_1) {
        G5_1 = g5_1;
    }

    public void setG5_2(int g5_2) {
        G5_2 = g5_2;
    }

    public void setG5_3(int g5_3) {
        G5_3 = g5_3;
    }

    public void setG5_4(int g5_4) {
        G5_4 = g5_4;
    }

    public void setG5_5(int g5_5) {
        G5_5 = g5_5;
    }

    public void setG5_6(int g5_6) {
        G5_6 = g5_6;
    }

    public void setG6_1(int g6_1) {
        G6_1 = g6_1;
    }

    public void setG6_2(int g6_2) {
        G6_2 = g6_2;
    }

    public void setG6_3(int g6_3) {
        G6_3 = g6_3;
    }

    public void setG7_1(int g7_1) {
        G7_1 = g7_1;
    }

    public void setG7_2(int g7_2) {
        G7_2 = g7_2;
    }

    public void setG7_3(int g7_3) {
        G7_3 = g7_3;
    }

    public void setG7_4(int g7_4) {
        G7_4 = g7_4;
    }
}
