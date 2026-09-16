package com.example.dasar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvEkspresi, tvHasil;
    private String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEkspresi = findViewById(R.id.tvEkspresi);
        tvHasil = findViewById(R.id.tvHasil);
    }

    // Fungsi tunggal untuk menangani klik tombol (android:onClick="onKlikTombol")
    public void onKlikTombol(View view) {
        Button tombol = (Button) view;
        String teks = tombol.getText().toString();

        if (teks.equals("C")) {
            data = "";
            tvHasil.setText("0");
        } else if (teks.equals("=")) {
            // TUGAS: Panggil fungsi hitung ketika tombol sama dengan diklik
            hitungHasil();
        } else if (teks.equals("( )")) {
            // Logika sederhana buka-tutup kurung
            if (data.contains("(") && !data.endsWith("(")) {
                data += ")";
            } else {
                data += "(";
            }
        } else {
            // Mencegah operator di awal atau double operator
            data += teks;
        }

        tvEkspresi.setText(data);
    }

    private void hitungHasil() {
        try {

            if (data.contains("+")) {
                String[] bagian = data.split("\\+");
                double res = Double.parseDouble(bagian[0]) + Double.parseDouble(bagian[1]);
                tvHasil.setText(String.valueOf(res));
            } else if (data.contains("-")) {
                String[] bagian = data.split("-");
                double res = Double.parseDouble(bagian[0]) - Double.parseDouble(bagian[1]);
                tvHasil.setText(String.valueOf(res));
            } else if (data.contains("*")) {
                String[] bagian = data.split("\\*");
                double res = Double.parseDouble(bagian[0]) * Double.parseDouble(bagian[1]);
                tvHasil.setText(String.valueOf(res));
            } else if (data.contains("/")) {
                String[] bagian = data.split("/");
                if (Double.parseDouble(bagian[1]) != 0) {
                    double res = Double.parseDouble(bagian[0]) / Double.parseDouble(bagian[1]);
                    tvHasil.setText(String.valueOf(res));
                } else {
                    tvHasil.setText("Error: /0");
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Format Salah!", Toast.LENGTH_SHORT).show();
        }
    }
}
