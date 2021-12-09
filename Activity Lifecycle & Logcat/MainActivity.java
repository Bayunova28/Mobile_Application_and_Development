/*
activity lifecycle dapat mengalami perubahan pada
setiap action yang ditunjukan pada Logcat karena terdapat :
- onStart() => Ketika aktivitas memasuki status Dimulai,
             sistem memanggil callback ini. Panggilan onStart()
             membuat aktivitas terlihat oleh pengguna, saat aplikasi
             mempersiapkan aktivitas untuk memasuki latar depan dan
             menjadi interaktif. Misalnya, metode ini adalah tempat
             aplikasi menginisialisasi kode yang mengelola UI.

- onResume() => Setelah aktivitas memasuki status Dilanjutkan, aktivitas
              tersebut masuk ke latar depan, kemudian sistem memanggil
              callback onResume(). Ini adalah status saat aplikasi
              berinteraksi dengan pengguna. Aplikasi tetap dalam status
              ini sampai terjadi sesuatu untuk mengambil fokus dari aplikasi.
              Peristiwa yang terjadi misalnya adalah menerima panggilan telepon,
              pengguna beralih ke aktivitas lain, atau layar perangkat mati.
              Saat aktivitas berpindah ke status dilanjutkan, komponen berbasis
              siklus proses apa pun yang terkait dengan siklus proses aktivitas
              akan menerima peristiwa onResume. Di sinilah komponen siklus proses
              dapat mengaktifkan fungsi apa pun yang perlu dijalankan saat komponen
              terlihat dan berada di latar depan, seperti memulai pratinjau kamera.

- onPause() => Sistem akan memanggil metode ini sebagai indikasi pertama bahwa pengguna
               meninggalkan aktivitas Anda (meskipun tidak selalu berarti aktivitas sedang
               ditutup); hal ini menunjukkan bahwa aktivitas tidak lagi di latar depan
               (meskipun mungkin masih terlihat jika pengguna berada dalam mode multi-jendela).
               Gunakan metode onPause() untuk menjeda atau menyesuaikan operasi yang tidak boleh
               dilanjutkan (atau harus dilanjutkan dalam jumlah sedang) sementara Activity berada
               dalam status Dijeda, dan Anda berharap untuk segera melanjutkan
 */

package Prak2_00000034000.com;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("posisi","onCreate");

        Button tombol1 = (Button)findViewById(R.id.button);

        tombol1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("aksi","Tombol 1 diklik");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("posisi","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("posisi","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("posisi","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("posisi","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("posisi","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("posisi","onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("posisi","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("posisi","onRestoreInstanceState");
    }
}