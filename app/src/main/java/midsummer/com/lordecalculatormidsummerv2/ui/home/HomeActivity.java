package midsummer.com.lordecalculatormidsummerv2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.ui.addLordeData.AddLordeDataActivity;
import midsummer.com.lordecalculatormidsummerv2.ui.kqxs.KQXSActivity;
import midsummer.com.lordecalculatormidsummerv2.ui.lordeData.LordeDataListActivity;
import midsummer.com.lordecalculatormidsummerv2.ui.merchant.MerchantListActivity;

/**
 * Created by cityme on 2/7/18.
 */

public class HomeActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(this, KQXSActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, AddLordeDataActivity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(this, MerchantListActivity.class));
                break;
            case R.id.btn_4:
                break;
        }
    }
}
