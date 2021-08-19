
package funix.prm.project;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft;
    Fragment mHome, mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHome = new HomePage();
        ft = fm.beginTransaction();
        ft.add(R.id.fragment_list, mHome);
        ft.setReorderingAllowed(true).addToBackStack(null).commit();
    }
}
