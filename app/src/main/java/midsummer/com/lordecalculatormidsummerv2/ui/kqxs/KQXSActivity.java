package midsummer.com.lordecalculatormidsummerv2.ui.kqxs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseActivity;
import midsummer.com.lordecalculatormidsummerv2.helper.LogUtil;
import midsummer.com.lordecalculatormidsummerv2.ui.cell.DateCell;

/**
 * Created by cityme on 2/7/18.
 */

public class KQXSActivity extends BaseActivity implements DateCell.DateCellClickListener{


    @BindView(R.id.container_list)
    FrameLayout containerList;
    @BindView(R.id.container_detail)
    FrameLayout containerDetail;


    DateListFragment dateListFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kqxs);
        ButterKnife.bind(this);

        dateListFragment = DateListFragment.newInstance(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_list,dateListFragment,"dateList")
                .commitNowAllowingStateLoss();
    }


    @Override
    public void onDateClicked(DateTime dateTime) {
        LogUtil.d("onDateClicked: " + dateTime.toString());
    }
}
