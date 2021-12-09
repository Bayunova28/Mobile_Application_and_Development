package Prak5_00000034000.com;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    private String jenisKelamin;
    private String nama;
    private String umur;
    private String alamat;
    private String phone;
    private Spinner spinKelamin;
    private String[] kelamin = {"- Jenis Kelamin -","Pria","Wanita"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        TextView txtHello = (TextView)findViewById(R.id.txtResult);
        Intent i = getIntent();
        final String nama = "Hello "+i.getStringExtra("nama")+"!";
        txtHello.setText(nama);

        spinKelamin = (Spinner)findViewById(R.id.spinKelamin);
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, kelamin);
        spinKelamin.setAdapter(adapter);

        spinKelamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = adapterView.getItemAtPosition(i).toString();
                jenisKelamin = itemValue;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final TextView txtUmur = (TextView)findViewById(R.id.txtUmur);
        final TextView txtAlamat = (TextView)findViewById(R.id.txtAlamat);
        final TextView txtPhone = (TextView)findViewById(R.id.txtPhone);

        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtHello = (TextView)findViewById(R.id.txtResult);
                Intent x = new Intent(getApplicationContext(), ResultActivity.class);
                x.putExtra("vnama", nama);
                x.putExtra("ykelamin", jenisKelamin);
                x.putExtra("vumur", txtUmur.getText().toString());
                x.putExtra("valamat", txtAlamat.getText().toString());
                x.putExtra("vphone", txtPhone.getText().toString());
                startActivity(x);
            }
        });

    }
}