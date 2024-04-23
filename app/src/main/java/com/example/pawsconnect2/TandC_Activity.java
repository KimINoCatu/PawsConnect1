package com.example.pawsconnect2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TandC_Activity extends AppCompatActivity {

    SharedPreferences sharedPref;
    String SHARED_PREF_NAME = "myPref";
    String KEY_NEVER_SHOW_AGAIN = "neverShowAgain";
    CheckBox neverShowAgainCB;
    public Button agreeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tand_cactivity);

        sharedPref = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        neverShowAgainCB = findViewById(R.id.checkBox);

        agreeBtn = findViewById(R.id.agreeBtn);

        agreeBtn.setOnClickListener(v -> {
            if (neverShowAgainCB.isChecked()) {
                editor.putBoolean(KEY_NEVER_SHOW_AGAIN, true);
                editor.apply();
            }
            Intent intent = new Intent(this, PetsListActivity.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}