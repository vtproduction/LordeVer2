package midsummer.com.lordecalculatormidsummerv2.ui.addLordeData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaychang.srv.SimpleRecyclerView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.helper.LogUtil;
import midsummer.com.lordecalculatormidsummerv2.model.kqld.LDType;
import midsummer.com.lordecalculatormidsummerv2.ui.cell.LordeCell;

/**
 * Created by cityme on 2/23/18.
 */

public class AddLordeDataActivity extends BaseActivity implements AddLordeDialog.AddLordeDataListener{


    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.recycler_view)
    SimpleRecyclerView recyclerView;
    @BindView(R.id.btn_add_lo)
    Button btnAddLo;
    @BindView(R.id.btn_add_de)
    Button btnAddDe;
    @BindView(R.id.btn_add_xien)
    Button btnAddXien;
    @BindView(R.id.btn_add_dau)
    Button btnAddDau;
    @BindView(R.id.btn_add_dit)
    Button btnAddDit;
    @BindView(R.id.btn_add_dau_dit)
    Button btnAddDauDit;
    @BindView(R.id.btn_add_xien_quay)
    Button btnAddXienQuay;


    AddLordeDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lorde_data);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_submit, R.id.btn_add_xien_quay, R.id.btn_add_lo, R.id.btn_add_de, R.id.btn_add_xien, R.id.btn_add_dau, R.id.btn_add_dit, R.id.btn_add_dau_dit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_submit:
                onSubmit();
                break;
            case R.id.btn_add_lo:
                onAdd(LDType.LO);
                break;
            case R.id.btn_add_de:
                onAdd(LDType.DE);
                break;
            case R.id.btn_add_xien:
                onAdd(LDType.XIEN);
                break;
            case R.id.btn_add_dau:
                onAdd(LDType.DAU);
                break;
            case R.id.btn_add_dit:
                onAdd(LDType.DIT);
                break;
            case R.id.btn_add_dau_dit:
                onAdd(LDType.DAU_DIT);
                break;
            case R.id.btn_add_xien_quay:
                onAdd(LDType.XIEN_QUAY);
                break;
        }
    }


    private void onAdd(int type){
        dialog = AddLordeDialog.newInstance(type, this);
        dialog.show(getSupportFragmentManager(),"dialog");
    }


    @Override
    public void onAdded(int type, String numbers, float value) {
        String temp = "";
        long id = Calendar.getInstance().getTimeInMillis();
        recyclerView.addCell(new LordeCell(new LordeCell.ViewModel(id, type, numbers, value), new LordeCell.CellClickListener() {
            @Override
            public void onEdit(LordeCell.ViewModel viewModel) {
                int j = -1;
                for(int i = 0; i < recyclerView.getItemCount(); i++)
                    if (((LordeCell.ViewModel)recyclerView.getCell(i).getItem()).getId() == viewModel.getId()){
                        j = i;
                        break;
                    }
                if (j != -1)
                    recyclerView.updateCell(j, viewModel);
            }

            @Override
            public void onDelete(LordeCell.ViewModel viewModel) {
                int j = -1;
                for(int i = 0; i < recyclerView.getItemCount(); i++)
                    if (((LordeCell.ViewModel)recyclerView.getCell(i).getItem()).getId() == viewModel.getId()){
                        j = i;
                        break;
                    }
                if (j != -1)
                    recyclerView.removeCell(j);
            }
        }));
    }

    private void onSubmit(){

    }
}
