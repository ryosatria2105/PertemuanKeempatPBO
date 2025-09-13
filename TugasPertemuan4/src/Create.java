import java.sql.Connection;
import java.sql.Statement;

public class Create {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS pegawai (" +
                     "id INT PRIMARY KEY, " +
                     "nama VARCHAR(50) NOT NULL, " +
                     "jabatan VARCHAR(50) NOT NULL, " +
                     "gaji VARCHAR(50) NOT NULL, " +
                     "departemen VARCHAR(50) NOT NULL" +
                     ");";

        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabel berhasil dibuat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
