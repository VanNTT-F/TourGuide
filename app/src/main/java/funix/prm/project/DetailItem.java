package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;

public class DetailItem extends Fragment {
    String sc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Get scItem and ItemPosition argument from detail_list fragment
        sc = this.getArguments().getString("scItem");
        int item =  getArguments().getInt("ItemPosition");
        //Create view of detail-item fragment
        View view = inflater.inflate(R.layout.detail_item, container, false);

        ImageView mItemImage = view.findViewById(R.id.detail_logo);
        TextView mItemName = view.findViewById(R.id.detail_name);
        TextView mItemAddress = view.findViewById(R.id.detail_address);
        TextView mItemSlogan = view.findViewById(R.id.detail_slogan);

        //Use switch condition with scItem and ItemPosition parameters:
        //      --> get each item detail values showing on screen
        switch (sc) {
            case "hotel":
                mItemImage.setImageResource(R.drawable.hotel);
                mItemName.setText(getResources().getStringArray(R.array.hotel_name)[item]);
                mItemAddress.setText(getResources().getStringArray(R.array.hotel_address)[item]);
                mItemSlogan.setText(getResources().getString(R.string.hotel_slogan));
                break;
            case "atm":
                mItemImage.setImageResource(R.drawable.atm_machine);
                mItemName.setText(getResources().getStringArray(R.array.atm_name)[item]);
                mItemAddress.setText(getResources().getStringArray(R.array.atm_address)[item]);
                mItemSlogan.setText(getResources().getString(R.string.atm_slogan));
                break;
            case "hospital":
                mItemImage.setImageResource(R.drawable.hospital);
                mItemName.setText(getResources().getStringArray(R.array.hospital_name)[item]);
                mItemAddress.setText(getResources().getStringArray(R.array.hospital_address)[item]);
                mItemSlogan.setText(getResources().getString(R.string.hospital_slogan));
                break;
            case "metro":
                mItemImage.setImageResource(R.drawable.metro);
                mItemName.setText(getResources().getStringArray(R.array.metro_name)[item]);
                mItemAddress.setText(getResources().getStringArray(R.array.metro_route)[item]);
                mItemSlogan.setText(getResources().getString(R.string.metro_slogan));
                break;
        }
        //return view of detail_item fragment
        return view;
    }

    //in onViewCreated() method: set toolbar navigation button
    //navigationOnClickListener event:
    //      --> Use Bundle to reset service argument and pass to detail_list fragment
    //      --> return to detail_list fragment (replace detail_item fragment with detail_list fragment)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle argsList = new Bundle();
        Fragment mList = new DetailList();
        argsList.putString("service", sc);
        MaterialToolbar mTitleBar = getActivity().findViewById(R.id.titleBar);
        mTitleBar.setNavigationOnClickListener(v -> {
            mList.setArguments(argsList);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_list, mList).commit();
        });
    }
}
