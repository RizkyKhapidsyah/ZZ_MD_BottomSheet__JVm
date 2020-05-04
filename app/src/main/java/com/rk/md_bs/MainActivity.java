package com.rk.md_bs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior BSB;
    TextView TV_State_IDJAVA;
    Button B_Perluas_IDJAVA, B_Perkecil_IDJAVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View NSV_BottomSheet_IDJAVA = findViewById(R.id.NSV_BottomSheet_IDXML);
        BSB = BottomSheetBehavior.from(NSV_BottomSheet_IDJAVA);

        TV_State_IDJAVA = findViewById(R.id.TV_State_IDXML);
        B_Perluas_IDJAVA = findViewById(R.id.B_Perluas_IDXML);
        B_Perkecil_IDJAVA = findViewById(R.id.B_Perkecil_IDXML);

        B_Perluas_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSB.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        B_Perkecil_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSB.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        BSB.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        TV_State_IDJAVA.setText("Diperkecil!");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        TV_State_IDJAVA.setText("Diperluas...");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        TV_State_IDJAVA.setText("Disembunyikan");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                TV_State_IDJAVA.setText("Sedang Menggeser...");
            }
        });


    }
}
