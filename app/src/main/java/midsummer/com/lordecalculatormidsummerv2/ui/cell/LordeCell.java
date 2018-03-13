package midsummer.com.lordecalculatormidsummerv2.ui.cell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;
import com.jaychang.srv.Updatable;

import butterknife.BindView;
import butterknife.ButterKnife;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.model.kqld.LDType;

/**
 * Created by macbook on 2/24/18.
 */

public class LordeCell extends SimpleCell<LordeCell.ViewModel, LordeCell.LordeCellViewHolder> implements Updatable<LordeCell.ViewModel>{

    public interface CellClickListener{
        void onEdit(ViewModel viewModel);
        void onDelete(ViewModel viewModel);
    }

    private CellClickListener callback;

    public LordeCell(@NonNull ViewModel item, CellClickListener callback) {
        super(item);
        this.callback = callback;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.item_lorde_cell;
    }

    @NonNull
    @Override
    protected LordeCellViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new LordeCellViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull LordeCellViewHolder lordeCellViewHolder, int i, @NonNull Context context, Object o) {
        lordeCellViewHolder.setData(getItem());
    }

    @Override
    public boolean areContentsTheSame(@NonNull ViewModel viewModel) {
        return false;
    }

    @Override
    public Object getChangePayload(@NonNull ViewModel viewModel) {
        return null;
    }

    public class LordeCellViewHolder extends SimpleViewHolder {
        @BindView(R.id.txt_type)
        TextView txtType;
        @BindView(R.id.txt_numbers)
        TextView txtNumbers;
        @BindView(R.id.txt_value)
        TextView txtValue;
        @BindView(R.id.container_cell)
        CardView containerCell;


        public LordeCellViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        ViewModel model;
        private void setData(ViewModel viewModel){
            try {
                this.model = viewModel;
                txtType.setText(LDType.getLDTypeRes(viewModel.getType()));
                txtNumbers.setText(viewModel.getNumbers());
                txtValue.setText(String.format("%.1f", model.getValue()) + " " + LDType.getLDUnit(viewModel.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static class ViewModel {
        long id;
        int type;
        String numbers;
        float value;

        public ViewModel(long id, int type, String numbers, float value) {
            this.id = id;
            this.type = type;
            this.numbers = numbers;
            this.value = value;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNumbers() {
            return numbers;
        }

        public void setNumbers(String numbers) {
            this.numbers = numbers;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }
    }
}
