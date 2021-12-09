package com.Prak9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    private long id;
    private String nama;
    private String kategori;
    private long harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText editNama = (EditText)findViewById(R.id.editNama);
        final EditText editKategori = (EditText)findViewById(R.id.editKategori);
        final EditText editHarga = (EditText)findViewById(R.id.editHarga);
        Button btnReset = (Button)findViewById(R.id.btnReset);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpan);

//Buat objek untuk Class MyDBHandler
        final MyDBHandler dbHandler = new MyDBHandler(this);

//Membuka koneksi database
        try { dbHandler.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getLong("id");
        nama = bundle.getString("nama");
        kategori = bundle.getString("kategori");
        harga = bundle.getLong("harga");

        this.setTitle("Edit Barang ID: "+id);
        editNama.setText(nama);
        editKategori.setText(kategori);
        editHarga.setText(Long.toString(harga));

        btnSimpan.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Barang barang = new Barang();
            barang.setID(id);
            String Bnama = editNama.getText().toString();
            String Bkategori = editKategori.getText().toString();
            long Bharga = Long.parseLong(editHarga.getText().toString());
            if (Bnama.isEmpty()||Bkategori.isEmpty()){
                Toast.makeText(edit.this, "Data ada yang Kosong",Toast.LENGTH_LONG).show();
            }else{
            barang.setNamaBarang(Bnama);
            barang.setKategoriBarang(Bkategori);
            barang.setHargaBarang(Bharga);
            dbHandler.updateBarang(barang);

            Toast.makeText(edit.this, "Barang berhasil diedit",Toast.LENGTH_LONG).show();
            Intent i = new Intent(edit.this, MainActivity.class);
            startActivity(i);
            edit.this.finish();
            dbHandler.close();
            }
        }
        });




        btnReset.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            editNama.setText("");
            editKategori.setText("");
            editHarga.setText("");
            editNama.requestFocus();
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
