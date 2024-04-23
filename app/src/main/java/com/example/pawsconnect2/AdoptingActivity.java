package com.example.pawsconnect2;

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

public class AdoptingActivity extends AppCompatActivity {


    public ImageButton BackToPetListBtn;
    public Button SubmitBtnD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_adopting);

        BackToPetListBtn = findViewById(R.id.backToPetListBtn);
        SubmitBtnD = findViewById(R.id.submitBtnD);

        BackToPetListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdoptingActivity.this, PetsListActivity.class);
                startActivity(intent);
            }
        });

        SubmitBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdoptingActivity.this, MainActivity.class);
                AlertDialog.Builder adoptionSuccess = new AlertDialog.Builder(AdoptingActivity.this);
                View view = LayoutInflater.from(AdoptingActivity.this).inflate(R.layout.text_alert_layout, null);

                adoptionSuccess.setView(view);
                adoptionSuccess.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent homeIntent = new Intent(AdoptingActivity.this, MainActivity.class);
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