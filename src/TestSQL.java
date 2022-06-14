import java.sql.*;

public class TestSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.conn();
        System.out.println(DB.getType(20));
        DB.getTypeWhere("type LIKE '%ý%'");
        DB.getAllTypes();
        DB.close();
    }
}
