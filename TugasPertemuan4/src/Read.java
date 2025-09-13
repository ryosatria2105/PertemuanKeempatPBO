import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read {
    public static void lihatData() {
        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM pegawai";
            ResultSet rs = stmt.executeQuery(sql);

            boolean adaData = false;
            while (rs.next()) {
                adaData = true;
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Nama: " + rs.getString("nama") +
                                   " | Jabatan: " + rs.getString("jabatan") +
                                   " | Gaji: " + rs.getDouble("gaji") +
                                   " | Departemen: " + rs.getString("departemen"));
            }

            if (!adaData) {
                System.out.println("? Belom ada data pegawai.");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
