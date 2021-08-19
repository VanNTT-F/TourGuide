package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;

public class DetailList extends Fragment {
    int mItemImage = 0;
    String[] mItemName = null;
    String[] mItemAddress = null;
    String sc;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sc = getArguments().getString("service");
        View view = inflater.inflate(R.layout.detail_list, container, false);
        switch (sc) {
            case "hotel":
                mItemImage = R.drawable.hotel;
                mItemName = getResources().getStringArray(R.array.hotel_name);
                mItemAddress = getResources().getStringArray(R.array.hotel_address);
                break;
            case "atm":
                mItemImage = R.drawable.atm_machine;
                mItemName = getResources().getStringArray(R.array.atm_name);
                mItemAddress = getResources().getStringArray(R.array.atm_address);
                break;
            case "hospital":
                mItemImage = R.drawable.hospital;
                mItemName = getResources().getStringArray(R.array.hospital_name);
                mItemAddress = getResources().getStringArray(R.array.hospital_address);
                break;
            case "metro":
                mItemImage = R.drawable.metro;
                mItemName = getResources().getStringArray(R.array.metro_name);
                mItemAddress = getResources().getStringArray(R.array.metro_route);
                break;
        }

        ListView mDetailList = view.findViewById(R.id.detail_list);
        CustomAdapter adapter = new CustomAdapter(this.getContext(), mItemImage, mItemName, mItemAddress);
        mDetailList.setAdapter(adapter);

        mDetailList.setOnItemClickListener((parent, view1, position, id) -> {
            Bundle argsItem = new Bundle();
            argsItem.putString("scItem", sc);
            argsItem.putInt("ItemPosition", position);
            Fragment mDetailItem = new DetailItem();
            mDetailItem.setArguments(argsItem);
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_list, mDetailItem).setReorderingAllowed(true).commit();
        });

        MaterialToolbar mTitleBar = getActivity().findViewById(R.id.titleBar);
        mTitleBar.setNavigationIcon(R.drawable.ic_back);
        mTitleBar.setNavigationOnClickListener(v ->
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_list, new HomePage()).commit());

        return view;

    }
}

