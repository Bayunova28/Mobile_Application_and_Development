package Prak6_00000034000.com;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PenjumlahanActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_penjumlahan, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnTambah = (Button)getActivity().findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editJumlah1 = (EditText)getActivity().findViewById(R.id.editJumlah1);
                EditText editJumlah2 = (EditText)getActivity().findViewById(R.id.editJumlah2);
                EditText editJumlah3 = (EditText)getActivity().findViewById(R.id.editJumlah3);

                String angka1 = editJumlah1.getText().toString();
                int x = Integer.parseInt(angka1);

                String angka2 = editJumlah2.getText().toString();
                int y = Integer.parseInt(angka2);

                int hasil = x + y;
                Integer convert = new Integer(hasil);
                String hasilAngka = convert.toString();

                editJumlah3.setText(hasilAngka);
            }
        });
    }
}