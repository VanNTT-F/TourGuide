
package funix.prm.project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class HotelList extends Fragment {
    private final String[] mItemName = getResources().getStringArray(R.array.hotelArray);
    private final int mItemImage = R.drawable.hotel;
    private Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.detail_list, container, false);
        ListView mListview = rootView.findViewById(R.id.hotel_list);
        CustomAdapter customAdapter = new CustomAdapter(mContext, mItemImage, mItemName);
        mListview.setAdapter(customAdapter);
        return rootView;
    }
}
