import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        //DB.create();
        DB.insertCat("�����", "��������", 5, 8.0);
        DB.insertCat("����", "��������", 2, 5.2);
        DB.insertCat("����", "������", 10, 12.5);
        DB.close();
    }
}
