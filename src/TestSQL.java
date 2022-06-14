import java.sql.*;

public class TestSQL {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
            Statement stat = conn.createStatement();
            stat.execute("CREATE TABLE if not exist 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "'type' VARCHAR(100) NOT NULL");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC הנאיגונ הכÿ ÑÓÁÄ םו םאיהום!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Îרטבךא SQL!");
        }
    }
}
