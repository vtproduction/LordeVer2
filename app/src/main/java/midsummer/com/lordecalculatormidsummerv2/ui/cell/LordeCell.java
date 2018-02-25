package midsummer.com.lordecalculatormidsummerv2.ui.cell;

import android.support.annotation.NonNull;
import android.view.View;

import com.jaychang.srv.SimpleViewHolder;

/**
 * Created by macbook on 2/24/18.
 */

public class LordeCell {



    public class LordeCellViewHolder extends SimpleViewHolder{

        public LordeCellViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



    public class ViewModel{
        int type;
        String numbers;

    }
}
