package midsummer.com.lordecalculatormidsummerv2.ui.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.joda.time.DateTime;

import java.util.Locale;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseFragment;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;
import midsummer.com.lordecalculatormidsummerv2.helper.LogUtil;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXS;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXSDataSource;
import midsummer.com.lordecalculatormidsummerv2.model.kqsx.KQXSRepository;
import midsummer.com.lordecalculatormidsummerv2.ui.addKQXS.AddKQXSActivity;

/**
 * Created by macbook on 2/7/18.
 */

public class KQXSDetailFragment extends BaseFragment {

    private KQXSDataSource mDataSource;

    public static KQXSDetailFragment newInstance() {
        KQXSDetailFragment fragment = new KQXSDetailFragment();
        fragment.mDataSource = new KQXSRepository();
        return fragment;
    }


    @BindView(R.id.txt_date)
    TextView txtDate;
    @BindView(R.id.btn_add_kqxs)
    Button btnAddKqxs;
    @BindView(R.id.container_empty)
    LinearLayout containerEmpty;
    @BindViews({R.id.txt_val_0, R.id.txt_val_1, R.id.txt_val_2,
            R.id.txt_val_3, R.id.txt_val_4, R.id.txt_val_5,
            R.id.txt_val_6, R.id.txt_val_7, R.id.txt_val_8,
            R.id.txt_val_9, R.id.txt_val_10, R.id.txt_val_11,
            R.id.txt_val_12, R.id.txt_val_13, R.id.txt_val_14,
            R.id.txt_val_15, R.id.txt_val_16, R.id.txt_val_17,
            R.id.txt_val_18, R.id.txt_val_19, R.id.txt_val_20,
            R.id.txt_val_21, R.id.txt_val_22, R.id.txt_val_23,
            R.id.txt_val_24, R.id.txt_val_25, R.id.txt_val_26})
    TextView[] txtVals;

    @BindViews({R.id.txt_dau_0, R.id.txt_dau_1, R.id.txt_dau_2, R.id.txt_dau_3, R.id.txt_dau_4, R.id.txt_dau_5,
            R.id.txt_dau_6, R.id.txt_dau_7, R.id.txt_dau_8, R.id.txt_dau_9})
    TextView[] txtDau;
    @BindViews({R.id.txt_dit_0, R.id.txt_dit_1, R.id.txt_dit_2, R.id.txt_dit_3, R.id.txt_dit_4, R.id.txt_dit_5,
            R.id.txt_dit_6, R.id.txt_dit_7, R.id.txt_dit_8, R.id.txt_dit_9})
    TextView[] txtDit;

    @BindView(R.id.container_kqxs)
    LinearLayout containerKqxs;
    @BindView(R.id.btn_edit)
    Button btnEdit;
    @BindView(R.id.container_statistic)
    LinearLayout containerStatistic;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =
                inflater.inflate(R.layout.fragment_kqxs, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData(DateTime.now());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    private DateTime dateTime;
    private KQXS kqxs;

    public void loadData(DateTime date) {
        try {
            this.dateTime = date;
            txtDate.setText(getString(R.string.kqxs_ngay) + " " + DateTimeUtil.displayDayOfWeek(date)
                    + ", " + DateTimeUtil.displayShortDate(date));
            mDataSource.findKQXS(DateTimeUtil.displayShortDate(date),
                    new KQXSDataSource.KQXSActionListener() {
                        @Override
                        public void onAction(KQXS kqxs) {
                            if (kqxs == null) {
                                containerEmpty.setVisibility(View.VISIBLE);
                                containerKqxs.setVisibility(View.GONE);
                                containerStatistic.setVisibility(View.GONE);
                                btnEdit.setVisibility(View.GONE);
                            } else {
                                KQXSDetailFragment.this.kqxs = kqxs;
                                containerKqxs.setVisibility(View.VISIBLE);
                                containerEmpty.setVisibility(View.GONE);
                                containerStatistic.setVisibility(View.VISIBLE);
                                btnEdit.setVisibility(View.VISIBLE);
                                clearAllText();
                                setData(kqxs);
                                setDauDit(kqxs);
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearAllText() {
        for (int i = 0; i < txtVals.length; i++)
            txtVals[i].setText("");
        for (int i = 0; i < txtDau.length; i++)
            txtDau[i].setText("");
        for (int i = 0; i < txtDit.length; i++)
            txtDit[i].setText("");
    }

    private void setDauDit(KQXS kqxs) {
        try {
            int[] data = kqxs.getData();
            for (int i = 0; i < data.length; i++) {
                String tmp = data[i] + "";
                int ditVal = Integer.parseInt(tmp.charAt(tmp.length() - 1) + "");
                int dauVal = Integer.parseInt(tmp.charAt(tmp.length() - 2) + "");
                String displayString = String.format(Locale.US, "%d%d; ", dauVal, ditVal);
                /*txtDau[dauVal].append(tmp +"; ");
                txtDit[ditVal].append(tmp +"; ");*/
                txtDau[dauVal].setText(txtDau[dauVal].getText() + displayString);
                txtDit[ditVal].setText(txtDit[ditVal].getText() + displayString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setData(KQXS kqxs) {
        try {
            int[] data = kqxs.getData();
            for (int i = 0; i < data.length; i++)
                txtVals[i].setText("" + data[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_edit, R.id.btn_add_kqxs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_edit:
                startActivity(new Intent(getContext(), AddKQXSActivity.class).putExtra(AddKQXSActivity.ARGS_DATE, DateTimeUtil.displayShortDate(dateTime))
                        .putExtra(AddKQXSActivity.ARGS_EDIT, true));
                break;
            case R.id.btn_add_kqxs:
                startActivity(new Intent(getContext(), AddKQXSActivity.class).putExtra(AddKQXSActivity.ARGS_DATE, DateTimeUtil.displayShortDate(dateTime))
                        .putExtra(AddKQXSActivity.ARGS_EDIT, false));
                break;
        }
    }
}
