package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DetailItem extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_item, container, false);

        ImageView mItemImage = view.findViewById(R.id.detail_logo);
        TextView mItemName = view.findViewById(R.id.detail_name);
        TextView mItemAddress = view.findViewById(R.id.detail_address);
        TextView mItemSlogan = view.findViewById(R.id.detail_slogan);
        String sc = getArguments().getString("scDetail");
        int item =  getArguments().getInt("item");
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
        return view;
    }
}
