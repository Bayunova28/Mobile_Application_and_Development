package Prak6_00000034000.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PenjumlahanActivity fragJumlah = new PenjumlahanActivity();
        fragJumlah.setArguments(getIntent().getExtras());

        PenguranganActivity fragKurang = new PenguranganActivity();
        fragKurang.setArguments(getIntent().getExtras());

        PerkalianActivity fragKali = new PerkalianActivity();
        fragKali.setArguments(getIntent().getExtras());

        FragmentManager fragmentManager = getSupportFragmentManager();

        Button btnJumlah = (Button)findViewById(R.id.btnJumlah);
        btnJumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragPenjumlahan = fragmentManager.beginTransaction();
                fragPenjumlahan.replace(R.id.frame3, fragJumlah);
                fragPenjumlahan.addToBackStack(null);
                fragPenjumlahan.commit();
            }
        });


        Button btnKurang = (Button)findViewById(R.id.btnKurang);
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragPengurangan = fragmentManager.beginTransaction();
                fragPengurangan.replace(R.id.frame3, fragKurang);
                fragPengurangan.addToBackStack(null);
                fragPengurangan.commit();
            }
        });

        Button btnKali = (Button)findViewById(R.id.btnKali);
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragPerkalian = fragmentManager.beginTransaction();
                fragPerkalian.replace(R.id.frame3, fragKali);
                fragPerkalian.addToBackStack(null);
                fragPerkalian.commit();
            }
        });
    }
}