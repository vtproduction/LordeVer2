package midsummer.com.lordecalculatormidsummerv2.ui.merchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.Merchant;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.MerchantDataSource;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.MerchantRepository;

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
    private Merchant merchant;
    MerchantDataSource mMerchant;
    public static final String ARGS_MERCHANT = "ARGS_MERCHANT";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_merchant);
        ButterKnife.bind(this);
        mMerchant = new MerchantRepository();
        if (getIntent().getLongExtra(ARGS_MERCHANT,0) != 0){
            mMerchant.loadMerchant(getIntent().getLongExtra(ARGS_MERCHANT, 0), new MerchantDataSource.MerchantActionListener() {
                @Override
                public void onAction(Merchant merchant) {
                    AddNewMerchantActivity.this.merchant = merchant;
                    displayMerchant();
                }
            });

        }
    }

    @OnClick({R.id.btn_back, R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_done:
                onAddNewMerchant();
                break;
        }
    }

    private void displayMerchant(){
        try {
            if (merchant == null) return;
            edtName.setText(merchant.getName());
            edtPhone.setText(merchant.getPhoneNumber());
            edtRateDe.setText(String.format("%.2f", merchant.getRateDE()));
            edtRateLo.setText(String.format("%.2f", merchant.getRateLO()));
            edtRateXien.setText(String.format("%.2f", merchant.getRateXIEN()));
            btnDone.setText(getString(R.string.cap_nhat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void onAddNewMerchant(){
        try {
            String name = edtName.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            boolean isHost = checkboxIsHost.isChecked();
            float rateDe = Float.parseFloat(edtRateDe.getText().toString().trim());
            float rateLo = Float.parseFloat(edtRateLo.getText().toString().trim());
            float rateXien = Float.parseFloat(edtRateXien.getText().toString().trim());

            if (merchant == null)
                mMerchant.addMerchant(name, phone, isHost, rateDe, rateLo, rateXien, new MerchantDataSource.MerchantActionListener() {
                    @Override
                    public void onAction(Merchant merchant) {
                        finish();
                    }
                });
            else{
                mMerchant.updateMerchant(merchant.getId(),name, phone, isHost, rateDe, rateLo, rateXien, new MerchantDataSource.MerchantActionListener() {
                    @Override
                    public void onAction(Merchant merchant) {
                        finish();
                    }
                });
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
