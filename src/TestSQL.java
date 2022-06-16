import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        DB.deleteCat(1);
        DB.deleteCat("name = 'Веста'");
        DB.updateCat("age = 1", "age = 8");
        DB.close();
    }
}
