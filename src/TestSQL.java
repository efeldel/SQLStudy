import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        DB.create();
        DB.addMoreCats(5000);
        DB.close();
    }
}
