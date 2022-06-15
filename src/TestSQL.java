import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        //DB.create();
        DB.insertCat("Лютик", "Домашняя", 5, 8.0);
        DB.insertCat("Киса", "Дворовая", 2, 5.2);
        DB.insertCat("Даша", "Гавана", 10, 12.5);
        DB.close();
    }
}
