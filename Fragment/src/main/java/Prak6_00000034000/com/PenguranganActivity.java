package Prak6_00000034000.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PenguranganActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PenguranganActivity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PenguranganActivity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PenguranganActivity.
     */
    // TODO: Rename and change types and number of parameters
    public static PenguranganActivity newInstance(String param1, String param2) {
        PenguranganActivity fragment = new PenguranganActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengurangan_activity, container, false);

        final EditText editKurang1 = view.findViewById(R.id.editKurang1);
        final EditText editKurang2 = view.findViewById(R.id.editKurang2);
        final EditText editKurang3 = view.findViewById(R.id.editKurang3);
        Button btnKurang = (Button)view.findViewById(R.id.btnKurang);

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(editKurang1.getText().toString());
                int y = Integer.parseInt(editKurang2.getText().toString());
                int hasil = x - y;

                editKurang3.setText(""+hasil);
            }
        });
        return view;
    }
}