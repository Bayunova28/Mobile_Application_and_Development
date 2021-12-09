package Prak5_00000034000.com;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity1 = (Button)findViewById(R.id.btnActivity1);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityOne.class);
                startActivity(i);
            }
        });

        Button btnActivity2 = (Button)findViewById(R.id.btnActivity2);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), ActivityTwo.class);
                startActivity(x);
            }
        });

        Button btnActivity3 = (Button)findViewById(R.id.btnActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(getApplicationContext(), ActivityThree.class);
                startActivity(y);
            }
        });

        Button btnActivity4 = (Button)findViewById(R.id.btnActivity4);
        btnActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(getApplicationContext(), ActivityFour.class);
                startActivity(z);
            }
        });

        Button btnForm = (Button)findViewById(R.id.btnForm);
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextTextPersonName = (EditText)findViewById(R.id.editTextTextPersonName);
                Intent i = new Intent(getApplicationContext(), FormActivity.class);
                i.putExtra("nama",editTextTextPersonName.getText().toString());
                startActivity(i);
            }
        });
    }
}