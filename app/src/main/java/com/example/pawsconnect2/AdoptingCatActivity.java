package com.example.pawsconnect2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdoptingCatActivity extends AppCompatActivity {


    public ImageButton BackToPetListBtn;
    public Button submitBtnC;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adopting_cat);

        BackToPetListBtn = findViewById(R.id.backToPetListBtn);
        submitBtnC = findViewById(R.id.submitBtnC);

        BackToPetListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdoptingCatActivity.this, PetsListActivity.class);
                startActivity(intent);
            }
        });
        submitBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdoptingCatActivity.this, MainActivity.class);
                AlertDialog.Builder adoptionSuccess = new AlertDialog.Builder(AdoptingCatActivity.this);
                View view = LayoutInflater.from(AdoptingCatActivity.this).inflate(R.layout.text_alert_layout, null);

                adoptionSuccess.setView(view);
                adoptionSuccess.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent homeIntent = new Intent(AdoptingCatActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                    }
                });

                AlertDialog SuccessDialog = adoptionSuccess.create();
                SuccessDialog.show();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}