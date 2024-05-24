package MenuGame;

import Inventory.*;
import MapGame.*;
import Sun.*;
import Plant.*;
import Zombies.*;
import Koordinat.*;
import MenuGame.*;
import Deck.*;
import Inventory.*;

//import java.util.concurrent.*;
import java.util.Scanner;

public class Start {


        public static void Start(Inventory inven, Peta peta){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        
        inven.displayInventory();
      
        boolean isRunningStart = true;
        
        while (isRunningStart) {

            // Meminta input dari user
            System.out.println("");
            System.out.println("Pilih tindakan:");
            System.out.println("1. Memilih tanaman untuk deck");
            System.out.println("2. Menukar posisi tanaman pada inventory");
            System.out.println("3. Menghapus tanaman dari deck");
            System.out.println("4. Melihat deck");
            System.out.println("5. Menukar posisi tanaman pada deck");
            System.out.println("6. Start Game");
            System.out.printf("Masukkan input tindakan (1/2/3/4/5/6) : ");
            int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        if(inven.getDeckInven().size() <6){
                            System.out.println("");
                            inven.displayInventory();
                            System.out.println("");
                            System.out.printf("Masukkan nomor indeks tanaman yang ingin dimasukkan ke deck : ");
                            int indexChoose = scanner.nextInt();
                            if(indexChoose > inven.getInven().size()){
                                System.out.println("Indeks invalid!!");
                                break;
                            }
                            inven.choosePlant(indexChoose - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0
                            System.out.println("");
                            inven.displayInventory();
                            System.out.println("");
                            inven.displayDeck();
                            System.out.println("");
                            break;
                        }
                        else{
                            System.out.println("");
                            System.out.println("Deck Sudah Penuh (6 Tanaman) !!! ");
                            break;
                        }
                    case 2:
                        System.out.println("");
                        inven.displayInventory();
                        System.out.println("");
                        System.out.printf("Masukkan nomor indeks tanaman yang ingin ditukar posisinya: ");
                        int indexSwap1 = scanner.nextInt();
                        if (indexSwap1 < 1 || indexSwap1 > inven.getInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        System.out.printf("Masukkan nomor indeks tanaman lain untuk ditukar posisinya: ");
                        int indexSwap2 = scanner.nextInt();
                        if (indexSwap2 < 1 || indexSwap1 > inven.getInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        else if (indexSwap1 == indexSwap2){
                            System.out.println("Tidak boleh menukar pada indeks yang sama!");
                            break;                            
                        }
                        System.out.println("");
                        Object plant1 = inven.getInven().get(indexSwap1 - 1);
                        Object plant2 = inven.getInven().get(indexSwap2 - 1);
                        System.out.println("Berhasil menukar " + ((Plant) plant1).getName() + " dengan " + ((Plant) plant2).getName() + "!!!" );
                        inven.swapPlant(indexSwap1 - 1, indexSwap2 - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0
                        System.out.println("");
                        inven.displayInventory();
                        break;
                    case 3:
                        if(inven.getDeckInven().size()>0){
                            System.out.println("");
                            inven.displayDeck();
                            System.out.println("");
                            System.out.printf("Masukkan nomor indeks tanaman yang ingin dihapus dari deck: ");
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
                    case 4 :
                        if (inven.getDeckInven().size() == 0){
                            System.out.println("");
                            System.out.println("Deck masih kosong!");
                            break;
                        }
                        else{
                            System.out.println("");
                            inven.displayDeck();
                            break;
                        }
                    case 5 :
                        System.out.println("");
                        inven.displayDeck();
                        System.out.println("");
                        System.out.printf("Masukkan nomor indeks tanaman yang ingin ditukar posisinya: ");
                        int indexSwap3 = scanner.nextInt();
                        if (indexSwap3 < 1 || indexSwap3 > inven.getDeckInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        System.out.printf("Masukkan nomor indeks tanaman lain untuk ditukar posisinya: ");
                        int indexSwap4 = scanner.nextInt();
                        if (indexSwap4 < 1 || indexSwap4 > inven.getDeckInven().size()){
                            System.out.println("Indeks tidak valid!");
                            break;
                        }
                        else if (indexSwap3 == indexSwap4){
                            System.out.println("Tidak boleh menukar pada indeks yang sama!");
                            break;                            
                        }
                        System.out.println("");
                        Object plant3 = inven.getDeckInven().get(indexSwap3 - 1);
                        Object plant4 = inven.getDeckInven().get(indexSwap4 - 1);
                        System.out.println("Berhasil menukar " + ((Plant) plant3).getName() + " dengan " + ((Plant) plant4).getName() + "!!!" );
                        inven.swapPlantDeck(indexSwap3 - 1, indexSwap4 - 1); // Karena indeks dimulai dari 1, sementara ArrayList dimulai dari 0
                        System.out.println("");
                        inven.displayDeck();
                        break;

                    case 6 :
                        if (inven.getDeckInven().size() == 6){
                            System.out.println("");
                            System.out.println("Deck sudah penuh!!! Game dimulaii !!!");
                            Game.play(inven);
                            break;
                        }                        
                        else{
                            System.out.println("");
                            System.out.println("Deck belum penuh!!! isi deck terlebih dahulu");
                            break;
                        }
                    default:
                        System.out.println("Pilihan tidak valid.");

                }
                // System.out.println("Apakah Anda ingin melanjutkan? (ya/tidak)");
                // String lanjut = scanner.next();

                // if (!lanjut.equalsIgnoreCase("ya")) {
                //     isRunningStart = false;
                // }
            }
        
    }
}