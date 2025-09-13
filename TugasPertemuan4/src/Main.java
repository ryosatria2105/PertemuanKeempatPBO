import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Create.createTable();

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1 -> Insert.insertData();
                case 2 -> Read.lihatData();
                case 3 -> Update.updateData();
                case 4 -> Delete.deleteData();
                case 5 -> running = false;
                default -> System.out.println("❌ Pilihan tidak valid.");
            }

            if (running) {
                System.out.print("\nApakah anda ingin kembali ke menu utama? (y/n): ");
                String lagi = sc.nextLine();
                if (!lagi.equalsIgnoreCase("y")) {
                    running = false;
                }
            }
        }
        System.out.println("👋 Program selesai. Thank uuu..... semoga harimu bahagia!");
    }
}
