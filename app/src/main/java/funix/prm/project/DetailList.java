package funix.prm.project;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DetailList extends MainActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list);
        String service = getIntent().getExtras().getString("service");
        TextView mTitle = findViewById(R.id.title_text);
        Fragment fragment;
        switch (service) {
            case "hotel":
                mTitle.setText(getText(R.string.hotel));
                fragment = new HotelList();
                break;
            case "atm":
                mTitle.setText(getText(R.string.atm));
                fragment = new ATMList();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + service);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_list,fragment).commit();
    }
}
