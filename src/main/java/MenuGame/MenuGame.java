package MenuGame;

import java.util.Scanner;
import Inventory.*;
import Thread.ThreadControl;
import MapGame.*;
import Deck.*;


public class MenuGame {

    public static void printMenu() {
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\033[33m"; // Kode warna kuning
        String pink = "\033[95m"; // Kode warna pink
        String reset = "\033[0m"; // Reset warna

        String[] menu = {
            green + "                        ,---.    ,---..-./`)     _______   .---.  .---.    ____        .-''-.    .---.             " + reset,
            green + "                        |    \\  /    |\\ .-.')   /   __  \\  |   |  |_ _|  .'  __ `.   .'_ _   \\   | ,_|             " + reset,
            green + "                        |  ,  \\/  ,  |/ `-' \\  | ,_/  \\__) |   |  ( ' ) /   '  \\  \\ / ( ` )   ',-./  )             " + reset,
            green + "                        |  |\\_   /|  | `-'`\"`,-./  )       |   '-(_{;}_)|___|  /  |. (_ o _)  |\\  '_ '`)           " + reset,
            green + "                        |  _( )_/ |  | .---. \\  '_ '`)     |      (_,_)    _.-`   ||  (_,_)___| > (_)  )           " + reset,
            green + "                        | (_ o _) |  | |   |  > (_)  )  __ | _ _--.   | .'   _    |'  \\   .---.(  .  .-'           " + reset,
            green + "                        |  (_,_)  |  | |   | (  .  .-'_/  )|( ' ) |   | |  _( )_  | \\  `-'    / `-'`-'|___         " + reset,
            green + "                        |  |      |  | |   |  `-'`-'     / (_{;}_)|   | \\ (_ o _) /  \\       /   |        \\        " + reset,
            green + "                        '--'      '--' '---'    `._____.'  '(_,_) '---'  '.(_,_).'    `'-..-'    `--------`        " + reset,
            yellow + "                                                        ,---.  ,---.  .-'''-.                                      " + reset,
            yellow + "                                                        |   /  |   | / _     \\                                     " + reset,
            yellow + "                                                        |  |   |  .'(`' )/`--'                                     " + reset,
            yellow + "                                                        |  | _ |  |(_ o _).                                        " + reset,
            yellow + "                                                        |  _( )_  | (_,_). '.                                      " + reset,
            yellow + "                                                        \\ (_ o._) /.---.  \\  :                                     " + reset,
            yellow + "                                                         \\ (_,_) / \\    `-'  |                                     " + reset,
            yellow + "                                                          \\     /   \\       /                                     " + reset,
            yellow + "                                                           `---`     `-...-'                                       " + reset,
            pink + "                          .---.        ____      .---.        ____    .-------.    ____    ,---.   .--.            " + reset,
            pink + "                          | ,_|      .'  __ `.   | ,_|      .'  __ `. \\  _(`)_ \\ .'  __ `. |    \\  |  |            " + reset,
            pink + "                        ,-./  )     /   '  \\  \\,-./  )     /   '  \\  \\| (_ o._)|/   '  \\  \\|  ,  \\ |  |            " + reset,
            pink + "                        \\  '_ '`)   |___|  /  |\\  '_ '`)   |___|  /  ||  (_,_) /|___|  /  ||  |\\_ \\|  |            " + reset,
            pink + "                         > (_)  )      _.-`   | > (_)  )      _.-`   ||   '-.-'    _.-`   ||  _( )_\\  |            " + reset,
            pink + "                        (  .  .-'   .'   _    |(  .  .-'   .'   _    ||   |     .'   _    || (_ o _)  |            " + reset,
            pink + "                         `-'`-'|___ |  _( )_  | `-'`-'|___ |  _( )_  ||   |     |  _( )_  ||  (_,_\\  |            " + reset,
            pink + "                          |        \\\\ (_ o _) /  |        \\\\ (_ o _) //   )     \\ (_ o _) /|  |    |  |            " + reset,
            pink + "                          `--------` '.(_,_).'   `--------` '.(_,_).' `---'      '.(_,_).' '--'    '--'            " + reset
        };

        for (String line : menu) {
            System.out.println(line);
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.out.println("Printing interrupted.");
            }
        }
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice;

        printMenu();

        try{
            while (isRunning) {
                System.out.println("\n======= PLANT VS ZOMBIE =======");
                System.out.println("Menu: ");
                System.out.println("1. Start");
                System.out.println("2. Help");
                System.out.println("3. Plants List");
                System.out.println("4. Zombies List");
                System.out.println("5. Exit");
                System.out.print("Pilih menu: ");
                
                choice = Integer.parseInt(scanner.nextLine());
                // scanner.nextLine();  

                switch (choice) {
                    case 1:
                        System.out.println("Memulai permainan...");
                        ThreadControl.startAllThreads();
                        Peta peta = new Peta();
                        Inventory inven = new Inventory(peta);
                        Start.Start(inven,peta);
                        isRunning = false;
                        break;
                    case 2:
                        System.out.println("\n1. Deskripsi permainan");
                        System.out.println("2. Cara bermain");
                        System.out.println("3. Daftar command");
                        System.out.println("Pilih menu : (1/2/3)");
                        int choose = scanner.nextInt();
                        scanner.nextLine(); 
                        switch (choose) {
                            case 1:
                                System.out.println("Michael vs Lalapan adalah game versi sederhana dari permainan populer Plant vs Zombie.\n" +
                                                    "Tujuan dari permainan ini adalah melindungi rumah pemain dari serangan zombie.\n" + 
                                                    "Untuk mewujudkan hal tersebut, disediakan beberapa tanaman yang mampu menyerang zombie.\n" +
                                                    "Pemain harus menanam tanaman secara strategis untuk melindungi rumah dari serangan zombie.\n" +
                                                    "Setiap tanaman dan zombie memiliki aksi dan atribut nya masing - masing.\n" +
                                                    "Dalam panduan ini, kami akan memberikan informasi cara memainkan game ini.");
                                break;
                            case 2:
                                displayHowToPlay();
                                break;
                            case 3:
                                displayCommandList();
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Plants List:");
                        System.out.println("1. Sunflower");
                        System.out.println("2. Peashooter");
                        System.out.println("3. Wall-nut");
                        System.out.println("4. Snow Pea");
                        System.out.println("5. Squash");
                        System.out.println("6. Lilypad");
                        System.out.println("7. Cabbage Pult");
                        System.out.println("8. Cherry Bomb");
                        System.out.println("9. Repeater");
                        System.out.println("10. Tangle Kelp");
                        System.out.println("Pilih tanaman untuk dilihat atributnya : (1/2/3/dst)");
                        int pilih = scanner.nextInt();
                        scanner.nextLine(); 
                        switch (pilih) {
                            case 1:
                                System.out.println("Nama: Sunflower" + "\n" + "Health: 100" + "\n" + "Attack Damage: 0" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: false" + "\n" + "Cost: 50" + "\n" + "Range: 0" + "\n" + "Cooldown: 10" + "\n");
                                break;
                            case 2:
                                System.out.println("Nama: Peashooter" + "\n" + "Health: 100" + "\n" + "Attack Damage: 25" + "\n" + "Attack Speed: 4" + "\n" + "isAquatic: false" + "\n" + "Cost: 100" + "\n" + "Range: -1" + "\n" + "Cooldown: 10" + "\n");
                                break;
                            case 3:
                                System.out.println("Nama: Wall-nut" + "\n" + "Health: 1000" + "\n" + "Attack Damage: 0" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: false" + "\n" + "Cost: 50" + "\n" + "Range: 0" + "\n" + "Cooldown: 20" + "\n");
                                break;
                            case 4: 
                                System.out.println("Nama: Snow Pea" + "\n" + "Health: 100" + "\n" + "Attack Damage: 25" + "\n" + "Attack Speed: 4" + "\n" + "isAquatic: false" + "\n" + "Cost: 175" + "\n" + "Range: -1" + "\n" + "Cooldown: 10" + "\n");
                                break;
                            case 5:
                                System.out.println("Nama: Squash" + "\n" + "Health: 100" + "\n" + "Attack Damage: 5000" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: false" + "\n" + "Cost: 50" + "\n" + "Range: 1" + "\n" + "Cooldown: 20" + "\n");
                                break;
                            case 6:
                                System.out.println("Nama: Lilypad" + "\n" + "Health: 100" + "\n" + "Attack Damage: 0" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: true" + "\n" + "Cost: 25" + "\n" + "Range: 0" + "\n" + "Cooldown: 10" + "\n");
                                break;
                            case 7:
                                System.out.println("Nama: Cabbage Pult" + "\n" + "Health: 100" + "\n" + "Attack Damage: 20" + "\n" + "Attack Speed: 1.5" + "\n" + "isAquatic: false" + "\n" + "Cost: 100" + "\n" + "Range: 3" + "\n" + "Cooldown: 5" + "\n");
                                break;
                            case 8: 
                                System.out.println("Nama: Cherry Bomb" + "\n" + "Health: 150" + "\n" + "Attack Damage: 1000" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: false" + "\n" + "Cost: 150" + "\n" + "Range: 3" + "\n" + "Cooldown: 30" + "\n");
                                break;
                            case 9:
                                System.out.println("Nama: Repeater" + "\n" + "Health: 300" + "\n" + "Attack Damage: 20" + "\n" + "Attack Speed: 1.5" + "\n" + "isAquatic: false" + "\n" + "Cost: 200" + "\n" + "Range: 3" + "\n" + "Cooldown: 0.5" + "\n");
                                break;
                            case 10:
                                System.out.println("Nama: Tangle Kelp" + "\n" + "Health: 100" + "\n" + "Attack Damage: 5000" + "\n" + "Attack Speed: 0" + "\n" + "isAquatic: true" + "\n" + "Cost: 25" + "\n" + "Range: 1" + "\n" + "Cooldown: 5" + "\n");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("Zombies List:");
                        System.out.println("1. Normal Zombie");
                        System.out.println("2. Conehead Zombie");
                        System.out.println("3. Pole Vaulting Zombie");
                        System.out.println("4. Buckethead Zombie");
                        System.out.println("5. Ducky Tube Zombie");
                        System.out.println("6. Dolphin Rider Zombie");
                        System.out.println("7. Flag Zombie");
                        System.out.println("8. Screendoor Zombie");
                        System.out.println("9. Snorkel Zombie");
                        System.out.println("10. Football Zombie");
                        System.out.println("Pilih zombie untuk dilihat atributnya : (1/2/3/dst)");
                        int pilih2 = scanner.nextInt();
                        scanner.nextLine(); 
                        switch (pilih2) {
                            case 1:
                                System.out.println("Nama: Normal Zombie"+ "\n" + "Health: 125" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 2:
                                System.out.println("Nama: Conehead Zombie" + "\n"+ "Health: 250" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 3:
                                System.out.println("Nama: Pole Vaulting Zombie" + "\n" + "Health: 175" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 4: 
                                System.out.println("Nama: Buckethead Zombie" + "\n" + "Health: 300" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 5:
                                System.out.println("Nama: Ducky Tube Zombie" + "\n" + "Health: 100" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: true" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 6:
                                System.out.println("Nama: Dolphin Rider Zombie" + "\n" + "Health: 175" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: true" + "\n" + "Slowed: 0" + "\n" + "Speed: 5" + "\n");
                                break;
                            case 7:
                                System.out.println("Nama: Flag Zombie" + "\n" + "Health: 300" + "\n" + "Attack Damage: 50" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 1" + "\n");
                                break;
                            case 8: 
                                System.out.println("Nama: Screendoor Zombie" + "\n" + "Health: 500" + "\n" + "Attack Damage: 75" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 1" + "\n");
                                break;
                            case 9:
                                System.out.println("Nama: Snorkel Zombie" + "\n" + "Health: 200" + "\n" + "Attack Damage: 150" + "\n" + "Attack Speed: 1" + "\n" + "isAquatic: true" + "\n" + "Slowed: 0" + "\n" + "Speed: 1" + "\n");
                                break;
                            case 10:
                                System.out.println("Nama: Football Zombie" + "\n" + "Health: 300" + "\n" + "Attack Damage: 100" + "\n" + "Attack Speed: 7" + "\n" + "isAquatic: false" + "\n" + "Slowed: 0" + "\n" + "Speed: 1" + "\n");
                                break;
                            }
                        break;
                    case 5:
                        System.out.println("Keluar dari permainan. Sampai jumpa!");
                        ThreadControl.stopAllThreads();
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Masukkan harus berupa angka. Silakan coba lagi.");
            scanner.nextLine(); // Membuang token yang tidak valid
        }
        scanner.close();
    }

    private static void displayHowToPlay() {
        System.out.println("Cara bermain:");
        System.out.println("1. Mengunduh folder “Tubes-OOP-PlantsVsZombies” dari GitHub.");
        System.out.println("2. Setelah diunduh, buka folder tersebut menggunakan Command Prompt pada direktori folder tersebut.");
        System.out.println("3. Masukkan perintah berikut “.\\run”, lalu game bisa dijalankan.");
        System.out.println();
        System.out.println("Ketentuan permainan:");
        System.out.println("- Sun yang dihasilkan oleh Sunflower akan langsung disimpan (tidak perlu diambil manual).");
        System.out.println("- Pada pagi hari, pemain akan mendapatkan 25 sun untuk setiap interval waktu yang acak antara 5-10 detik.");
        System.out.println("- Deck hanya dapat menyimpan 6 jenis tanaman saja dan harus terisi penuh sebelum permainan dimulai.");
        System.out.println("- Pada permainan ini, 1 hari memiliki 200 detik yang terdiri dari 100 detik pagi hari dan 100 detik malam hari.");
        System.out.println("- Zombie hanya akan dimunculkan pada detik ke 20 sampai 160.");
        System.out.println("- Pemain menang jika jumlah zombie pada permainan telah habis dan kalah jika salah satu zombie telah mencapai kolom pertama pada peta permainan.");
        System.out.println();
        System.out.println("Di awal permainan, kamu akan ditampilkan oleh 5 pilihan menu diantaranya “Start”, “Help”, “Plant List”, “Zombie List”, dan “Exit”.");
        System.out.println("Untuk pilihan “Start”, akan menampilkan inventory tanaman beserta cost nya dan beberapa tindakan yang bisa dilakukan oleh pemain.");
        System.out.println("“Memilih tanaman untuk deck” akan meminta inputan pemain untuk memilih tanaman yang ingin dimasukkan ke dalam deck.");
        System.out.println("“Menukar posisi tanaman” akan meminta inputan pemain dengan memilih dua tanaman yang ingin ditukar posisinya.");
        System.out.println("“Menghapus tanaman dari deck” akan meminta inputan pemain dengan memilih tanaman yang ingin dihapus dari deck.");
        System.out.println("“Melihat deck” akan menampilkan deck tanaman.");
        System.out.println("“Start Game” akan memulai game jika deck telah terisi penuh.");
        System.out.println();
    }

    private static void displayCommandList() {
        System.out.println("Daftar command:");
        System.out.println("1. <1 x y indexplant> - Menanam tanaman di koordinat (x,y) dengan indeks tanaman yang dipilih dari deck.");
        System.out.println("   Contoh: 1 2 3 1 (menanam tanaman indeks pertama dari deck di koordinat (2,3)).");
        System.out.println("2. <2 x y> - Menghapus tanaman yang ada di koordinat (x,y).");
        System.out.println("   Contoh: 2 2 3 (menghapus tanaman di koordinat (2,3)).");
        System.out.println("3. <3> - Menampilkan peta permainan saat ini.");
        System.out.println("   Contoh: 3.");
        System.out.println();
    }
}