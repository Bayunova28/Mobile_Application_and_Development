package com.Prak9;

public class Barang {
    private long _id;
    private String _namabarang; private String _kategoribarang; private long _hargabarang;


    //Constructor untuk Class Barang
    public Barang(){

    }

    //Method untuk set ID Barang
    public void setID(long id){
        this._id = id;
    }

    //Method untuk mendapatkan ID Barang
    public long getID(){
        return this._id;
    }

    //Method untuk set Nama Barang
    public void setNamaBarang(String namabarang){
        this._namabarang = namabarang;
    }

    //Method untuk mendapatkan Nama Barang
    public String getNamaBarang(){
        return this._namabarang;
    }

    //Method untuk set Kategori Barang
    public void setKategoriBarang(String kategoribarang){
        this._kategoribarang = kategoribarang;
    }

    //Method untuk mendapatkan Kategori Barang
    public String getKategoriBarang(){
        return this._kategoribarang;
    }

    //Method untuk set Harga Barang
    public void setHargaBarang(long hargabarang){
        this._hargabarang = hargabarang;
    }

    //Method untuk mendapatkan Harga Barang
    public long getHargaBarang(){
        return this._hargabarang;
    }

    //method override yang dipakai untuk mengubah objek Barang menjadi String
    @Override
    public String toString(){
        return "Nama Barang\t\t\t\t: " + _namabarang + " \nKategori Barang\t\t: " + _kategoribarang + " \nHarga Barang\t\t\t\t: " + _hargabarang;
    }
}
