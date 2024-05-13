package MenuGame;

import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;

import java.util.concurrent.*;
import java.util.Scanner;

public class Start {

        public static void Start(){
        Scanner scanner = new Scanner(System.in);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        System.out.println("detik awal game: " + seconds);

        //nyoba thread
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("");
        Inventory inven = new Inventory();
        inven.displayInventory();
      
        boolean isRunningStart = true;
        
        while (isRunningStart) {
            // Meminta input dari user
            System.out.println("");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Memilih tanaman untuk deck");
            System.out.println("2. Menukar posisi tanaman");
            System.out.println("3. Menghapus tanaman dari deck");
            System.out.println("Masukkan input tindakan : (1/2/3)");
            int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("");
                        inven.displayInventory();
                        System.out.println("");
                        System.out.println("Masukkan nomor indeks tanaman yang ingin dimasukkan ke deck:");
                        int indexChoose = scanner.nextInt();
                        inven.choosePlant(indexChoose - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0
                        System.out.println("");
                        inven.displayInventory();
                        System.out.println("");
                        inven.displayDeck();
                        break;
                    case 2:
                        System.out.println("");
                        inven.displayInventory();
                        System.out.println("");
                        System.out.println("Masukkan nomor indeks tanaman yang ingin ditukar posisinya:");
                        int indexSwap1 = scanner.nextInt();
                        if (indexSwap1 < 1 || indexSwap1 > inven.getInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        System.out.println("Masukkan nomor indeks tanaman lain untuk ditukar posisinya:");
                        int indexSwap2 = scanner.nextInt();
                        if (indexSwap2 < 1 || indexSwap1 > inven.getInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        else if (indexSwap1 == indexSwap2){
                            System.out.println("Tidak boleh menukar pada indeks yang sama!");
                            break;                            
                        }
                        inven.swapPlant(indexSwap1 - 1, indexSwap2 - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0

                        System.out.println("");
                        inven.displayInventory();
                        break;
                    case 3:
                        if(inven.getDeckInven().size()>0){
                            System.out.println("");
                            inven.displayDeck();
                            System.out.println("");
                            System.out.println("Masukkan nomor indeks tanaman yang ingin dihapus dari deck:");
                            int indexDelete = scanner.nextInt();
                            inven.deletePlant(indexDelete - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0
                            System.out.println("");
                            inven.displayInventory();
                            System.out.println("");
                            inven.displayDeck();
                            break;
                        }
                        else{
                            System.out.println("Deck masih kosong!");
                            break;
                        }
                    default:
                        System.out.println("Pilihan tidak valid.");

                }
                System.out.println("Apakah Anda ingin melanjutkan? (ya/tidak)");
                String lanjut = scanner.next();
                if (!lanjut.equalsIgnoreCase("ya")) {
                    isRunningStart = false;
                }
            }
            scanner.close(); // Penutupan scanner setelah loop while selesai
    }
}