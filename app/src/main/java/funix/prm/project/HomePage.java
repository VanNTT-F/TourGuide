package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;

public class HomePage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    //4 image buttons with onClickListener event:
    //      --> replacing home_page fragment with detail_list fragment
    //onClickListener event is handled via local Services() method (as below)
        ImageButton mHotel = view.findViewById(R.id.hotel_img);
        mHotel.setOnClickListener(v -> Services("hotel"));

        ImageButton mATM = view.findViewById(R.id.atm_img);
        mATM.setOnClickListener(v -> Services("atm"));

        ImageButton mHospital = view.findViewById(R.id.hospital_img);
        mHospital.setOnClickListener(v -> Services("hospital"));

        ImageButton mMetro = view.findViewById(R.id.metro_img);
        mMetro.setOnClickListener(v -> Services("metro"));

        MaterialToolbar mTitleBar = getActivity().findViewById(R.id.titleBar);
        mTitleBar.setNavigationIcon(null);
    }

    //Local method to replace home_page fragment with detail_list fragment
    //Use Bundle to set sc argument with value of clicked ImageButton (hotel/atm/hospital/metro)
    //      --> pass sc argument to detail_fragment
    private void Services(String sc) {
        Bundle argsList = new Bundle();
        argsList.putString("service", sc);
        Fragment mList = new DetailList();
        mList.setArguments(argsList);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_list, mList);
        ft.setReorderingAllowed(true).addToBackStack(null).commit();
    }
}