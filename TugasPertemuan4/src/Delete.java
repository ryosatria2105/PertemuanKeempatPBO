import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void deleteData() {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = Koneksi.getConnection()) {
            System.out.println("Input nama kolom yang akan dihapus ");
            String kolom = sc.nextLine();

            System.out.println("Input data pada kolom yang akan dihapus:");
            String data = sc.nextLine();

            String sql;
            PreparedStatement ps;

            // Kalau kolom id (integer)
            if (kolom.equalsIgnoreCase("id")) {
                sql = "DELETE FROM pegawai WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(data)); // konversi string ke int
            } else {
                // Kolom lain dianggap string
                sql = "DELETE FROM pegawai WHERE " + kolom + " = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, data);
            }

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
