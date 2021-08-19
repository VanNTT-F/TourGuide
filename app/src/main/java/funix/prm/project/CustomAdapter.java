package funix.prm.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mItemName;
    private String[] mItemAddress;
    private int mItemImage;
    private LayoutInflater mInflater;

    public CustomAdapter(Context getApplicationContext, int itemImage, String[] itemName, String[] itemAddress) {
        this.mContext = getApplicationContext;
        this.mItemName = itemName;
        this.mItemAddress = itemAddress;
        this.mItemImage = itemImage;
        mInflater = (LayoutInflater.from(mContext));
    }
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.row_item, viewGroup, false);
        TextView itemName = view.findViewById(R.id.item_name);
        TextView itemAddress = view.findViewById(R.id.item_address);
        ImageView itemImage = view.findViewById(R.id.item_img);
        itemName.setText(mItemName[i]);
        itemAddress.setText(mItemAddress[i]);
        itemImage.setImageResource(mItemImage);
        return view;
    }
    @Override
    public int getCount() {
        return mItemName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}