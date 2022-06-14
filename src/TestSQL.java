import java.sql.*;

public class TestSQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        DB.insertType("Абиссинская кошка");
        DB.insertType("Австралийский мист");
        DB.insertType("Американская жесткошерстная");
        DB.close();
    }
}
