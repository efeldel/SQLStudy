import java.sql.*;

public class TestSQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        DB.insertType("����������� �����");
        DB.insertType("������������� ����");
        DB.insertType("������������ ��������������");
        DB.close();
    }
}
