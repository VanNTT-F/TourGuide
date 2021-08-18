package funix.prm.project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Fragment mHome, mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHome = new HomePage();
        mList = new DetailList();
        ft.add(R.id.fragment_list, mHome);
        ft.setReorderingAllowed(true).addToBackStack(null).commit();

        MaterialToolbar mTitleBar = findViewById(R.id.titleBar);
        mTitleBar.setNavigationOnClickListener(v -> {
            if (fm.getBackStackEntryCount() > 1) {
                fm.getBackStackEntryAt(1);
            }else {
                fm.getBackStackEntryAt(0);
                mTitleBar.setNavigationIcon(null);
            }
        });
    }
}
