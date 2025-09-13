import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
    public static void insertData() {
        Scanner sc = new Scanner(System.in);
        String sql = "INSERT INTO pegawai (id, nama, jabatan, gaji, departemen) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            while (true) {
                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("Nama: ");
                String nama = sc.nextLine();

                System.out.print("Jabatan: ");
                String jabatan = sc.nextLine();

                System.out.print("Gaji: ");
                double gaji = Double.parseDouble(sc.nextLine());

                System.out.print("Departemen: ");
                String departemen = sc.nextLine();

                pstmt.setInt(1, id);
                pstmt.setString(2, nama);
                pstmt.setString(3, jabatan);
                pstmt.setDouble(4, gaji);
                pstmt.setString(5, departemen);

                pstmt.executeUpdate();
                System.out.println("✅ Data berhasil ditambahkan.");

                System.out.print("Apakah anda ingin menambahkan data lagi? (y/n): ");
                String lagi = sc.nextLine();
                if (!lagi.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
