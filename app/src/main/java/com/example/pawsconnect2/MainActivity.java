package com.example.pawsconnect2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button AdoptBtn,PetListBtn,AboutUsBtn;
    String SHARED_PREF_NAME = "myPref";
    String KEY_NEVER_SHOW_AGAIN = "neverShowAgain";

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sharedPref = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        boolean TandCNeverShow = sharedPref.getBoolean(KEY_NEVER_SHOW_AGAIN, false);

        AdoptBtn = findViewById(R.id.adopt_btn);
        PetListBtn = findViewById(R.id.pet_list_btn);
        AboutUsBtn = findViewById(R.id.about_us_btn);

        EdgeToEdge.enable(this);

        AdoptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TandCNeverShow) {
                    Intent intent = new Intent(MainActivity.this, PetsListActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, TandC_Activity.class);
                    startActivity(intent);
                }
            }
        });

        PetListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, adopted_pets_activity.class);
                startActivity(intent);
            }
        });

        AboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "We are Done", Toast.LENGTH_SHORT).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}