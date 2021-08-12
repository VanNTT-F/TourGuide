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
    private Context mContent;
    private int mItemImage;
    private String[] mItemName;
    private LayoutInflater mInflater;

    public CustomAdapter(Context getApplicationContext, int itemImage, String[] itemName) {
        this.mContent = getApplicationContext;
        this.mItemImage = itemImage;
        this.mItemName = itemName;

    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        mInflater = (LayoutInflater.from(mContent));
        view = mInflater.inflate(R.layout.row_item, null);
        TextView itemName = view.findViewById(R.id.item_name);
        ImageView itemImage = view.findViewById(R.id.item_img);
        itemName.setText(mItemName[i]);
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
