package midsummer.com.lordecalculatormidsummerv2.ui.merchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jaychang.srv.SimpleRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.Merchant;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.MerchantDataSource;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.MerchantRepository;
import midsummer.com.lordecalculatormidsummerv2.ui.cell.MerchantCell;

/**
 * Created by cityme on 2/9/18.
 */

public class MerchantListActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_add_merchant)
    Button btnAddMerchant;
    @BindView(R.id.recycler_view)
    SimpleRecyclerView recyclerView;
    private MerchantDataSource mMerchant;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadMerchant();
    }

    private void loadMerchant(){
        try {
            if (mMerchant == null)
                mMerchant = new MerchantRepository();
            mMerchant.loadAllMerchant(new MerchantDataSource.MerchantListListener() {
                @Override
                public void onLoaded(RealmResults<Merchant> merchants) {
                    setMerchantList(merchants);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setMerchantList(RealmResults<Merchant> merchants){
        try {
            recyclerView.removeAllCells();
            for (Merchant merchant : merchants){
                recyclerView.addCell(new MerchantCell(merchant, new MerchantCell.MerchantCellClickListener() {
                    @Override
                    public void onMerchantCellClicked(Merchant merchant) {

                    }
                }));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_add_merchant})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_add_merchant:
                onAddNewMerchant();
                break;
        }
    }



    private void onAddNewMerchant(){

    }
}
