package midsummer.com.lordecalculatormidsummerv2.ui.cell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;
import com.jaychang.srv.Updatable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import midsummer.com.lordecalculatormidsummerv2.R;
import midsummer.com.lordecalculatormidsummerv2.model.merchant.Merchant;

/**
 * Created by cityme on 2/9/18.
 */

public class MerchantCell extends SimpleCell<Merchant, MerchantCell.ViewHolder> implements Updatable<Merchant>{

    public interface MerchantCellClickListener{
        void onMerchantCellClicked(Merchant merchant);
    }

    private MerchantCellClickListener callback;

    public MerchantCell(@NonNull Merchant item, MerchantCellClickListener callback) {
        super(item);
        this.callback = callback;
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.item_merchant_list;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Context context, Object o) {
        viewHolder.updateCell(getItem());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Merchant merchant) {
        return false;
    }

    @Override
    public Object getChangePayload(@NonNull Merchant merchant) {
        return null;
    }

    public class ViewHolder extends SimpleViewHolder {
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_is_host)
        TextView txtIsHost;
        @BindView(R.id.txt_phone_number)
        TextView txtPhoneNumber;
        @BindView(R.id.txt_rate_de)
        TextView txtRateDe;
        @BindView(R.id.txt_rate_lo)
        TextView txtRateLo;
        @BindView(R.id.txt_rate_xien)
        TextView txtRateXien;
        @BindView(R.id.btn_edit)
        Button btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btn_edit)
        public void onViewClicked() {
            callback.onMerchantCellClicked(merchant);
        }

        private Merchant merchant;
        void updateCell(Merchant merchant){
            try {
                this.merchant = merchant;
                txtName.setText(merchant.getName());
                txtIsHost.setVisibility(merchant.isHost()  ? View.VISIBLE : View.GONE);
                txtPhoneNumber.setText(merchant.getPhoneNumber());
                txtRateDe.setText(merchant.getRateDE() + "");
                txtRateLo.setText(merchant.getRateLO() + "");
                txtRateXien.setText(merchant.getRateXIEN() + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
