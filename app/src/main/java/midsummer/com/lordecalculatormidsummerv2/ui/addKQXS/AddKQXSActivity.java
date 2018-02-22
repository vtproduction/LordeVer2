package midsummer.com.lordecalculatormidsummerv2.ui.addKQXS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXS;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXSDataSource;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXSRepository;

/**
 * Created by macbook on 2/7/18.
 */

public class AddKQXSActivity extends BaseActivity {

    @BindView(R.id.txt_date)
    TextView txtDate;
    @BindViews({R.id.txt_val_0, R.id.txt_val_1, R.id.txt_val_2,
            R.id.txt_val_3, R.id.txt_val_4, R.id.txt_val_5,
            R.id.txt_val_6, R.id.txt_val_7, R.id.txt_val_8,
            R.id.txt_val_9, R.id.txt_val_10, R.id.txt_val_11,
            R.id.txt_val_12, R.id.txt_val_13, R.id.txt_val_14,
            R.id.txt_val_15, R.id.txt_val_16, R.id.txt_val_17,
            R.id.txt_val_18, R.id.txt_val_19, R.id.txt_val_20,
            R.id.txt_val_21, R.id.txt_val_22, R.id.txt_val_23,
            R.id.txt_val_24, R.id.txt_val_25, R.id.txt_val_26})
    EditText[] edtVals;
    @BindView(R.id.container_kqxs)
    LinearLayout containerKqxs;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_submit)
    Button btnSubmit;


    private
    private KQXSDataSource mDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kqxs);
        ButterKnife.bind(this);
        mDataSource = new KQXSRepository();
    }

    @OnClick({R.id.btn_cancel, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                onBackPressed();
                break;
            case R.id.btn_submit:
                onSubmit();
                break;
        }
    }


    private void onSubmit(){
        int[] data = new int[27];
        for (int i = 0; i < edtVals.length; i++)
            data[i] = Integer.parseInt(edtVals[i].getText().toString());
        mDataSource.addKQXS(DateTimeUtil.displayShortDate(DateTime.now()),
                data, new KQXSDataSource.KQXSActionListener() {
                    @Override
                    public void onAction(KQXS kqxs) {
                        finish();
                    }
                });
    }
}
