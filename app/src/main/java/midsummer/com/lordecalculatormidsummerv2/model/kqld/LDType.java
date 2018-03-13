package midsummer.com.lordecalculatormidsummerv2.model.kqld;

import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.MainApplication;

/**
 * Created by cityme on 2/23/18.
 */

public class LDType {
    public static final int LO = 1;
    public static final int DE = 2;
    public static final int XIEN = 3;
    public static final int XIEN_QUAY = 4;
    public static final int DAU = 5;
    public static final int DIT = 6;
    public static final int DAU_DIT = 7;

    public static String getLDUnit(int type){
        switch (type){
            case LO: return MainApplication.getInstance().getString(R.string.diem);
            /*case DE: return R.string.de;
            case XIEN: return R.string.xien;
            case XIEN_QUAY: return R.string.xien_quay;
            case DAU: return R.string.dau;
            case DIT: return R.string.dit;
            case DAU_DIT: return R.string.dau_dit;*/
            default: MainApplication.getInstance().getString(R.string.nghin);
        }
        return MainApplication.getInstance().getString(R.string.nghin);
    }

    public static int getLDTypeRes(int type){
        switch (type){
            case LO: return R.string.lo;
            case DE: return R.string.de;
            case XIEN: return R.string.xien;
            case XIEN_QUAY: return R.string.xien_quay;
            case DAU: return R.string.dau;
            case DIT: return R.string.dit;
            case DAU_DIT: return R.string.dau_dit;
            default: return R.string.blank;
        }
    }

    public static boolean isDe(int type){
        return type == DE || type == DAU || type == DIT || type == DAU_DIT;
    }

    public static boolean isDauDit(int type){
        return type == DAU || type == DIT || type == DAU_DIT;
    }

    public static boolean isLoXien(int type){
        return type == XIEN || type == XIEN_QUAY;
    }
}
