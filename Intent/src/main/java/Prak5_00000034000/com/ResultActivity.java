package Prak5_00000034000.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String umur;
    private String alamat;
    private String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        TextView txtResult = (TextView)findViewById(R.id.txtResult);


        Intent i = getIntent();
        umur = i.getStringExtra("vumur");
        alamat = i.getStringExtra("valamat");
        phone = i.getStringExtra("vphone");
        String hasil = "Nama : "+ i.getStringExtra("vnama")+" \n"+ "Jenis Kelamin : " + i.getStringExtra("vkelamin")+" \n"+"Umur : "+umur+"\n"+"Alamat : "+alamat+"\n"+"Phone : "+phone;
        txtResult.setText(hasil);
    }
}
