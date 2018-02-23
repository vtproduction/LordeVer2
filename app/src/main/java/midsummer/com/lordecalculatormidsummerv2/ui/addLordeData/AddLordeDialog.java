package midsummer.com.lordecalculatormidsummerv2.ui.addLordeData;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.model.kqld.LDType;

/**
 * Created by cityme on 2/23/18.
 */

public class AddLordeDialog extends DialogFragment {


    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.edt_numbers)
    EditText edtNumbers;
    @BindView(R.id.edt_value)
    EditText edtValue;
    @BindView(R.id.txt_unit)
    TextView txtUnit;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.btn_cancel)
    Button btnCancel;

    private Unbinder unbinder;
    private int type;

    public static AddLordeDialog newInstance(int type){
        AddLordeDialog dialog = new AddLordeDialog();
        dialog.type = type;
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_add_ld, container, false);
        unbinder = ButterKnife.bind(this, mainView);
        setData();
        return mainView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_submit, R.id.btn_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                onSubmit();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }

    private void setData(){
        switch (type){
            case LDType.LO:
                txtTitle.setText(R.string.lo);
                txtUnit.setText(R.string.diem);
                break;
            case LDType.DE:
                txtTitle.setText(R.string.de);
                txtUnit.setText(R.string.nghin);
                break;
            case LDType.XIEN:
                txtTitle.setText(R.string.xien);
                txtUnit.setText(R.string.diem);
                break;
            case LDType.XIEN_QUAY:
                txtTitle.setText(R.string.xien_quay);
                txtUnit.setText(R.string.diem);
                break;
            case LDType.DAU:
                txtTitle.setText(R.string.dau);
                txtUnit.setText(R.string.nghin);
                break;
            case LDType.DIT:
                txtTitle.setText(R.string.dit);
                txtUnit.setText(R.string.nghin);
                break;
            case LDType.DAU_DIT:
                txtTitle.setText(R.string.dau_dit);
                txtUnit.setText(R.string.nghin);
                break;
        }
    }


    public void onSubmit(){

    }
}
