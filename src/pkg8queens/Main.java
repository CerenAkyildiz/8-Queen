/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8queens;

/**
 *
 * @author Emre
 */
public class Main {

    public static void main(String[] args) {
        Main v = new Main();
        int[][] border = new int[8][8];
        border = v.Create(); //Satranç Tahtasına Rastgele Vezir Dizilimi Yapıldı

        //Rastgele Dizilim Çıktısı 
        for (int i = 0; i < border.length; i++) {
            for (int j = 0; j < border.length; j++) {
                System.out.print(border[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        v.Test(border); //Çakışma Sayısı Hesaplandı.
    }

    public int [][] Create(){ 
        System.out.println("Create Metodu ");
        int [][] vezir=new int [8][8]; 
        int rastgelesayi=0; 
        for (int j = 0; j < vezir.length; j++) { 
            rastgelesayi=(int)((Math.random()*8)); 
            vezir[rastgelesayi][j]=1; 
        } 
        return vezir;
    }
    
    public void Test(int[][] border) {
        int cak_vezir_sayisi = 0;
        int col = 0;
        int row = 0;

        //Aynı Satır Kontrolü 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (border[i][j] == 1) {
                    row = i;
                    col = j;
                    while (row > 0 && col > 0) {
                        row--;
                        col--;
                        if (border[row][col] == 1) {
                            cak_vezir_sayisi++;
                        }
                        //sol üst çapraz

                    }
                    row = i;
                    col = j;
                    while (row < 7 && col < 7) {
                        row++;
                        col++;
                        if (border[row][col] == 1) {
                            cak_vezir_sayisi++;
                            //sağ alt çapraz
                        }
                    }
                    row = i;
                    col = j;
                    while (row < 7 && col > 0) {
                        row++;
                        col--;
                        if (border[row][col] == 1) {
                            cak_vezir_sayisi++;
                            //sol alt çapraz
                        }
                    }
                    row = i;
                    col = j;
                    while (row > 0 && col < 7) {
                        row--;
                        col++;
                        if (border[row][col] == 1) {
                            cak_vezir_sayisi++;
                            //sağ üst çapraz
                        }
                    }

                    //Satır Kontrolü
                    for (int k = 0; k < 8; k++) {
                        // Satırlarda Çakışma Sayısı 
                        if (border[i][j] == border[i][k] && j != k) {
                            cak_vezir_sayisi++;
                        }
                    }
                }
            }
        }

        //Cakisma Sayisi Ekrana Yazıldı
        System.out.println("Cakisma Sayisi: " + cak_vezir_sayisi);
    }
}
