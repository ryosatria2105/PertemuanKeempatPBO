import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
    public static void updateData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan nama kolom yang mau diubah:");
        String klm1 = sc.nextLine();

        System.out.println("Masukkan data baru:");
        String klm2 = sc.nextLine();

        System.out.println("Masukkan nama kolom yang menjadi acuan perubahan:");
        String klm3 = sc.nextLine();

        System.out.println("Masukkan data yang ada pada kolom acuan:");
        String klm4 = sc.nextLine();

        String sql = "UPDATE pegawai SET " + klm1 + "=? WHERE " + klm3 + "=?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, klm2);
            pstmt.setString(2, klm4);

            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("✅ Data berhasil diperbarui.");
            } else {
                System.out.println("⚠️ Data tidak ditemukan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
