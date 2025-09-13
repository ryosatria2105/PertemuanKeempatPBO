import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/db_karyawan"; // ganti nama DB
    static final String USER = "postgres";  // ganti username
    static final String PASS = "masryoo21";  // ganti password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Gagal koneksi: " + e.getMessage());
            return null;
        }
    }
}
