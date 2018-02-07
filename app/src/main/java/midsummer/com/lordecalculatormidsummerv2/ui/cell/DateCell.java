package midsummer.com.lordecalculatormidsummerv2.ui.cell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.helper.DateTimeUtil;

/**
 * Created by cityme on 2/7/18.
 */

public class DateCell extends SimpleCell<DateTime, DateCell.DateCellViewHolder>{
    private DateCellClickListener callback;

    public DateCell(@NonNull DateTime item, DateCellClickListener callback) {
        super(item);
        this.callback = callback;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_date;
    }

    @NonNull
    @Override
    protected DateCellViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new DateCellViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull DateCellViewHolder dateCellViewHolder, int i, @NonNull Context context, Object o) {
        dateCellViewHolder.setData(getItem());
    }

    public interface DateCellClickListener{
        void onDateClicked(DateTime dateTime);
    }
    public class DateCellViewHolder extends SimpleViewHolder {
        @BindView(R.id.txt_day_of_week)
        TextView txtDayOfWeek;
        @BindView(R.id.txt_date)
        TextView txtDate;

        private DateTime data;
        public DateCellViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onDateClicked(data);
                }
            });
        }


        void setData(DateTime data){
            try {
                this.data = data;
                txtDayOfWeek.setText(DateTimeUtil.displayDayOfWeek(data));
                txtDate.setText(DateTimeUtil.displayShortDate(data));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
