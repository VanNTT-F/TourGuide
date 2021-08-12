package funix.prm.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton mHotel, mATM, mHospital, mMetro;
        mHotel = findViewById(R.id.hotel_img);
        mATM = findViewById(R.id.atm_img);

        mHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailList.class);
                intent.putExtra("service", "hotel");
                startActivity(intent);
            }
        });
        mATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailList.class);
                intent.putExtra("service", "atm");
                startActivity(intent);
            }
        });
    }
}