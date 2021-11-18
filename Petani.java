/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
import java.util.Arrays;

public class Petani extends Kotak {
  void Tambah(String buah) {
    this.tambah_Kotak(buah);
  }
  
  void Tampil() {
    System.out.println("===============================Tugas UTS PBO===============================");
    System.out.println("===================================No 6====================================");
    System.out.println("");
    System.out.println(Arrays.deepToString(
     this.susun_ulang ? this.jumlah_kotak : this.kotak
    ));
    System.out.println("");
    System.out.println("===========================Muhammad Rifqi Darmawan=========================");
    System.out.println("================================Reguler TI20A==============================");
    System.out.println("");
  }

  void Susun() {
    this.Susun_Ulang_box();
  }

  public static void main(String[] args) {
    Petani buah = new Petani();
    buah.Tambah("DURIAN");
    buah.Tambah("SALAK");
    buah.Tambah("SEMANGKA");
    buah.Tambah("JERUK");
    buah.Tambah("NANGKA");
    buah.Tambah("MELON");
    buah.Tambah("SRIKAYA");
    buah.Susun();
    buah.Tampil();
  }
}

class Kotak {
  public int maksimal_buah = 7;
  public int buah_saat_ini = 0;
  public boolean susun_ulang = false;
  public String[] kotak = new String[maksimal_buah];
  public String[][] jumlah_kotak = new String[3][3];

  void maksimal_buah(int angka) {
    this.maksimal_buah = angka;
  }

  void tambah_Kotak(String buah) {
    this.kotak[buah_saat_ini] = buah;
    this.buah_saat_ini++;
  }

  void Susun_Ulang_box() {
    this.sortKotak();
    this.tempat_kotak();
    this.susun_ulang = true;
  }

  void tempat_kotak() {
    int kotak = 0;
    int tempat_kotak = 0;
    int ukuran_kotak = this.kotak.length;
    String[] kotak_buah = this.kotak;
    String[][] jumlah_kotak = this.jumlah_kotak;
    String alur = kotak_buah[0];
    for (int i = 0; i < kotak_buah.length; i++) {
      String buah = kotak_buah[i];
      if (alur.charAt(alur.length() - 1) != buah.charAt(buah.length() - 1)) {
        alur = buah;
        tempat_kotak++;
        kotak = 0;
      } 
      if (alur.charAt(alur.length() - 1) == buah.charAt(buah.length() - 1)) {
        jumlah_kotak[tempat_kotak][kotak] = buah;
        kotak += 1;
      } 
    }
  }

  void sortKotak() {
    String[] buah = this.kotak;
    for (int i = 0; i < buah.length; i++) {
      String temp = buah[i];
      int tempCharLength = temp.length();
      int posisi = i;
      while( 
          posisi >= 1 && 
          buah[posisi - 1].charAt(
            buah[posisi - 1].length() - 1
          ) < temp.charAt(temp.length() - 1) 
        ) {
        buah[posisi] = buah[posisi - 1];
        posisi--;
      }
      buah[posisi] = temp;
    }
  }
}