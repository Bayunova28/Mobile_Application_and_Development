package com.Prak9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tambah extends AppCompatActivity { @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tambah);

    final EditText edtNama = (EditText)findViewById(R.id.editNama);
    final EditText edtKategori = (EditText)findViewById(R.id.editKategori);
    final EditText edtHarga = (EditText)findViewById(R.id.editHarga);
    Button btnReset = (Button)findViewById(R.id.btnReset);
    Button btnSimpan = (Button)findViewById(R.id.btnSimpan);

//Buat objek untuk Class MyDBHandler
    final MyDBHandler dbHandler = new MyDBHandler(this);

//Membuka koneksi database
    try { dbHandler.open();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    btnSimpan.setOnClickListener(new View.OnClickListener() { @Override
    public void onClick(View view) {
        Barang barang = new Barang();
        String bNama = edtNama.getText().toString();
        String bKategori = edtKategori.getText().toString();
        long bHarga = Long.parseLong(edtHarga.getText().toString());
        if (bNama.isEmpty()||bKategori.isEmpty()){
            Toast.makeText(tambah.this, "Data ada yang kosong",Toast.LENGTH_LONG).show();
        }else {
            dbHandler.createBarang(bNama, bKategori, bHarga);

            Toast.makeText(tambah.this, "Barang berhasil ditambahkan", Toast.LENGTH_LONG).show();
            edtNama.setText("");
            edtKategori.setText("");
            edtHarga.setText("");
            edtNama.requestFocus();

            Intent i = new Intent(tambah.this, MainActivity.class);
            startActivity(i);
            tambah.this.finish();
            dbHandler.close();
        }
    }
    });

    btnReset.setOnClickListener(new View.OnClickListener() { @Override
    public void onClick(View view) {
        edtNama.setText("");
        edtKategori.setText("");
        edtHarga.setText("");
        edtNama.requestFocus();
        /*
        * Kode dibawah tidak dijalankan agar saat Reset tidak mengembalikan User Ke MainActivity
        tetapi hanya mereset input pada EdiText
        * */
        //Intent i = new Intent(tambah.this, MainActivity.class);
        //startActivity(i);
        //tambah.this.finish();
        //dbHandler.close();
    }

    });
}
}


