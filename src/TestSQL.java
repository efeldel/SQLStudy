import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        DB.deleteType(1);
        DB.updateType(2,"Домашняя");
        DB.close();
    }
}
