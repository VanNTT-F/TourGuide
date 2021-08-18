package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomePage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ImageButton mHotel = view.findViewById(R.id.hotel_img);
        mHotel.setOnClickListener(v -> Services("hotel"));

        ImageButton mATM = view.findViewById(R.id.atm_img);
        mATM.setOnClickListener(v -> Services("atm"));

        ImageButton mHospital = view.findViewById(R.id.hospital_img);
        mHospital.setOnClickListener(v -> Services("hospital"));

        ImageButton mMetro = view.findViewById(R.id.metro_img);
        mMetro.setOnClickListener(v -> Services("metro"));
    }
    public void Services(String sc) {
        Fragment mList = new DetailList();
        Bundle args = new Bundle();
        args.putString("service", sc);
        mList.setArguments(args);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_list, mList);
        ft.setReorderingAllowed(true).addToBackStack(null).commit();
    }
}