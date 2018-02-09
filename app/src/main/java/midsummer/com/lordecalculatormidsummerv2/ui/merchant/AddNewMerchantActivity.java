package midsummer.com.lordecalculatormidsummerv2.ui.merchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;

/**
 * Created by cityme on 2/9/18.
 */

public class AddNewMerchantActivity extends BaseActivity {


    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.checkbox_is_host)
    CheckBox checkboxIsHost;
    @BindView(R.id.edt_rate_de)
    EditText edtRateDe;
    @BindView(R.id.edt_rate_lo)
    EditText edtRateLo;
    @BindView(R.id.edt_rate_xien)
    EditText edtRateXien;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_done)
    Button btnDone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_merchant);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                break;
            case R.id.btn_done:
                break;
        }
    }
}
