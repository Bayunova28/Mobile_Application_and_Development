package com.Prak9;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements AdapterView.OnItemLongClickListener {

    private MyDBHandler dbHandler;
    private ArrayList<Barang> values;
    private Button btnEdit;
    private Button btnDelete;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Buat objek untuk Class MyDBHandler
        dbHandler = new MyDBHandler(this);

//Membuka koneksi database
        try {
            dbHandler.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        values = dbHandler.getAllBarang();

        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(this, android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        ListView list = (ListView)findViewById(android.R.id.list);
        list.setOnItemLongClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(),tambah.class);
            startActivity(i);
        }
        });
    }

    //Method yang digunakan jika ListView ditekan agak lama
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int
            i, long l) {
//Menampilkan dialog dan mengambil layout dari dialog.xml
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        // tidak bisa mengeluarkan title jadi manual dari design dialog.xml
        // dialog.setTitle("Pilih Aksi");
        dialog.show();

        final Barang barang = (Barang)getListAdapter().getItem(i);
        final long id = barang.getID();

        btnEdit = dialog.findViewById(R.id.btnEdit);
        btnDelete = dialog.findViewById(R.id.btnHapus);

//Method yang digunakan jika Button Edit pada dialog.xml ditekan
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
            Barang barang = dbHandler.getBarang(id);
            Intent i = new Intent(getApplicationContext(),edit.class);
            Bundle bundle = new Bundle();
            bundle.putLong("id", barang.getID());
            bundle.putString("nama", barang.getNamaBarang());
            bundle.putString("kategori", barang.getKategoriBarang());
            bundle.putLong("harga", barang.getHargaBarang());
            i.putExtras(bundle);
            startActivity(i);
            dialog.dismiss();
        }
        });

//Method yang digunakan jika Button Delete pada dialog.xml ditekan
        btnDelete.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            AlertDialog.Builder konfirm = new AlertDialog.Builder(context);
            konfirm.setTitle("Hapus Barang");
            konfirm.setMessage("Anda yakin akan menghapus barang ini?");
            konfirm.setPositiveButton("Ya", new
                    DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbHandler.deleteBarang(id);

//Menutup MainActivity dan membukanya kembali untuk merefresh konten ListView
                            finish();
                            startActivity(getIntent());
                            Toast.makeText(MainActivity.this, "Barang berhasil dihapus",Toast.LENGTH_LONG).show();
                        }
                    });
            konfirm.setNegativeButton("Tidak", new
                    DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            konfirm.show(); dialog.dismiss();
        }
        });
        return true;
    }
}

