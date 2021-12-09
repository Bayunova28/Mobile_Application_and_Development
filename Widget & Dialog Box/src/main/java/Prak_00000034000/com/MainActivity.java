package Prak_00000034000.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinAsal;
    private String[] asal = {"- Pilih Negara Asal -","Australia","Belanda","Brunei Darussalam","Filipina","Indonesia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmain);

        spinAsal = (Spinner) findViewById(R.id.spinAsal);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, asal);
        spinAsal.setAdapter(adapter);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText txtNama = (EditText)findViewById(R.id.txtNama);
                String nama = txtNama.getText().toString();

                EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
                String email = txtEmail.getText().toString();

                EditText txtPhone = (EditText)findViewById(R.id.txtPhone);
                String telp = txtPhone.getText().toString();

                final String asal = spinAsal.getSelectedItem().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Data Register");
                builder.setMessage("Apakah data yang Anda masukkan sudah benar?\n" +
                        "Nama : " + nama  + "\n" +
                        "Email : " + email + "\n" +
                        "Telp   : " + telp  + "\n" +
                        "Asal   : " + asal  + "\n");
                builder.setNeutralButton("Tutup", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), "Data Registrasi Anda berhasil disimpan", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}