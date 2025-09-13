import java.sql.Connection;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection conn = Koneksi.getConnection();

        if (conn != null) {
            System.out.println("✅ Koneksi ke database berhasil!");
        } else {
            System.out.println("❌ Koneksi ke database gagal!");
        }
    }
}
