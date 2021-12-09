package Prak_00000034000.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Widget_Dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget__dialog);

        Button btnToast = (Button)findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNama = (EditText)findViewById(R.id.txtNama);
                String nama = txtNama.getText().toString();

                Toast.makeText(getApplicationContext(), "Halo "+nama+"...", Toast.LENGTH_SHORT).show();
            }
        });

        final Button btnDialog = (Button)findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNama = (EditText)findViewById(R.id.txtNama);
                String nama = txtNama.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(Widget_Dialog.this);
                builder.setTitle("Sapaan");
                builder.setMessage("Halo "+nama+"...");
                builder.setNeutralButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }
}