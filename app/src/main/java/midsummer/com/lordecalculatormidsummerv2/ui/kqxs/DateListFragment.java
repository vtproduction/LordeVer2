package midsummer.com.lordecalculatormidsummerv2.ui.kqxs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jaychang.srv.SimpleRecyclerView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.base.BaseFragment;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;
import midsummer.com.lordecalculatormidsummerv2.ui.cell.DateCell;

/**
 * Created by cityme on 2/7/18.
 */

public class DateListFragment extends BaseFragment {
    DateCell.DateCellClickListener dateCellClickListener;
    View.OnClickListener onBackBtnClickCallback;
    @BindView(R.id.recycler_view)
    SimpleRecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.btn_back)
    Button btnBack;

    public static DateListFragment newInstance(DateCell.DateCellClickListener dateCellClickListener, View.OnClickListener onBackBtnClickCallback) {
        DateListFragment dateListFragment = new DateListFragment();
        dateListFragment.dateCellClickListener = dateCellClickListener;
        dateListFragment.onBackBtnClickCallback = onBackBtnClickCallback;
        return dateListFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_list, container, false);

        unbinder = ButterKnife.bind(this, view);
        btnBack.setOnClickListener(onBackBtnClickCallback);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadDate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void loadDate(){
        try {
            recyclerView.removeAllCells();
            DateTime now = DateTime.now();
            DateTime startDate = DateTimeUtil.stringToDate("2018-01-01T00:00:00.000Z");
            List<DateTime> dates = new ArrayList<>();
            int days = Days.daysBetween(startDate, now).getDays()+1;
            for (int i=0; i < days; i++) {
                DateTime d = startDate.withFieldAdded(DurationFieldType.days(), i);
                dates.add(d);
            }

            for (DateTime dateTime : dates){
                recyclerView.addCell(0,new DateCell(dateTime, dateCellClickListener));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
