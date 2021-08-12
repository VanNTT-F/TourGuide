
package funix.prm.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class HotelList extends Fragment {
    private final String[] mItemName =
                    {"The Queen Hotel & Spa\n67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Hanoi Nostalgia Hotel & Spa\n13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Church Legend Hotel Hanoi\n46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Little Hanoi Diamond Hotel\n11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Flamingo Dai Lai Resort\nThôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam",
                     "Annam Legend Hotel\n27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Hanoi Zesty Hotel\n20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam",
                     "Bluebell Hotel\n41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam"
                    };
    private final int mItemImage = R.drawable.hotel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.detail_list, container, false);
        ListView mListview = rootView.findViewById(R.id.hotel_list);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), mItemImage, mItemName);
        mListview.setAdapter(customAdapter);
        return rootView;
    }
}
