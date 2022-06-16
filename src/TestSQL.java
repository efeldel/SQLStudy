import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        System.out.println(DB.getCat(3).getString("name"));
        DB.getCatWhere("age = 10");
        DB.getAllCats();
        DB.close();
    }
}
