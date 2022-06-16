import java.sql.*;
public class DB {
    public static Connection conn;
    public static Statement stat;
    public static ResultSet res;
    static String[] types = new String[]{"����������� �����",
            "������������� ����",
            "������������ ��������������",
            "������������ ���������������",
            "������������ �������",
            "������������ ���",
            "������������� �����",
            "����������� �����",
            "���������� �����",
            "���������� �����",
            "����������� ���������������",
            "���������� ��������������",
            "���������� ���������������",
            "���������� �����",
            "�������� �����",
            "������",
            "����������� �����",
            "�����-����",
            "������� ������",
            "����������� ���������������",
            "���������� ���",
            "��������� ������",
            "������",
            "�����",
            "������-����",
            "���������� �������",
            "������",
            "�������",
            "����-��?�",
            "���������� �������",
            "����� �����",
            "��������",
            "�������� ����",
            "��������",
            "���������� ������ �����",
            "������������ �����",
            "������",
            "���������� �����",
            "���������",
            "��������",
            "����������",
            "������� ������� �����",
            "�������",
            "�������",
            "�������-����",
            "�������� �����",
            "��������� �����",
            "������������ �����",
            "�������-����",
            "����-��",
            "����������� �����",
            "������� �����",
            "������",
            "���������� �����",
            "�������� ��������� �����",
            "�������� ���",
            "���������� ������",
            "�����",
            "�������",
            "������������ ���������������",
            "�������� �������"
    };
    static String[] names = {"�������",
            "���",
            "������",
            "�����",
            "�������",
            "�����",
            "������",
            "�������",
            "�����",
            "������",
            "�����",
            "������",
            "������",
            "�������",
            "��������",
            "�������",
            "����",
            "������",
            "�������",
            "�������",
            "�������",
            "����",
            "���������",
            "������",
            "�������",
            "��������",
            "������",
            "������",
            "�������",
            "������",
            "��������",
            "�����",
            "�����",
            "�������",
            "�������",
            "�����",
            "�������",
            "������",
            "������",
            "����",
            "�����",
            "�����",
            "�����",
            "�����",
            "������",
            "������",
            "������",
            "�����",
            "����",
            "��������",
            "������",
            "�����",
            "������",
            "������",
            "��������",
            "�����",
            "��������",
            "������",
            "��������",
            "�������",
            "������",
            "������",
            "�������",
            "��������",
            "������",
            "������",
            "�������",
            "�������",
            "�������",
            "������",
            "�������",
            "������",
            "�������",
            "�������",
            "�������",
            "������",
            "�����",
            "�����",
            "�����",
            "�����",
            "������",
            "�����",
            "�������",
            "�����",
            "����",
            "�������",
            "����",
            "�������",
            "����",
            "�����",
            "������",
            "�����",
            "������",
            "�����",
            "�����",
            "���",
            "���",
            "������",
            "������",
            "�����",
            "������",
            "������",
            "������",
            "������",
            "�����",
            "�����",
            "����",
            "������",
            "�����",
            "�������",
            "��������",
            "�����",
            "�����",
            "�����",
            "����",
            "������",
            "�����",
            "������",
            "������"
    };
// COMMON
    public static void conn() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC ������� ��� ���� �� ������!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

    public static void create() throws SQLException {
        try {
            stat = conn.createStatement();
            stat.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "'type' VARCHAR(100) UNIQUE NOT NULL)");
            stat.execute("CREATE TABLE if not exists 'cats' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "'name' VARCHAR(20) NOT NULL, 'type_id' INTEGER NOT NULL," +
                    "'age' INTEGER NOT NULL, 'weight' DOUBLE," +
                    "FOREIGN KEY (type_id) REFERENCES types (id))");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

    public static void close() throws SQLException {
        conn.close();
    }

// TYPES
    public static void insertType(String type) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO 'types' ('type') VALUES ('" + type + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(type + " ��� ����������");
        }
    }

    public static void addAllTypes() {
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
        for (String type : types) {
            try {
                stat.executeUpdate("INSERT INTO 'types' ('type') VALUES ('" + type + "')");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(type + " ��� ����������");
            }
        }
    }

    public static void deleteType(int id) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM 'types' WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

    public static void updateType(int id, String newType) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("UPDATE 'types' SET type = '" + newType + "' WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

    public static String getType(int id) throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE id = "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
        return res.getString("type");
    }

    public static void getTypeWhere (String where) throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE "+ where);
            System.out.println("������ ����� ���������� ��� �������: " + where +":");
            while(res.next()) {
                System.out.println(res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

    public static void getAllTypes() throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE 1");
            System.out.println("������ �����:");
            while(res.next()) {
                System.out.println(res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }
// CATS
    public static void insertCat(String name, String type, int age, Double weight) {
        try {
            stat = conn.createStatement();
            res = null;
            res = stat.executeQuery("SELECT id FROM types WHERE type ='" + type + "'");
            if (!res.next()) {
                insertType(type);
                res = stat.executeQuery("SELECT id FROM types WHERE type ='" + type + "'");
            }
            stat.executeUpdate("INSERT INTO 'cats' ('name', 'type_id', 'age', 'weight') " +
                    "VALUES ('" + name + "', '" + res.getInt("id") + "', '"
                    + age + "', '" + weight + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }
    public static void addMoreCats(int n) throws SQLException {
        for (int i = 0; i < n; i++) {
            int length = names.length;
            String name = names[(int) (Math.random() * length)];
            double weight = (Math.random() * 21) + 2;
            int age = ((int) (Math.random() * 20)) + 1;
            int type = ((int) (Math.random() * 61)) + 2;
            try {
                stat = conn.createStatement();
                stat.executeUpdate("INSERT INTO 'cats' ('name', 'type_id', 'age', 'weight') " +
                        "VALUES ('" + name + "', '" + type + "', '"
                        + age + "', '" + weight + "')");

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("������ SQL!");
            }
        }
    }

    public static void deleteCat(int id) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("DELETE FROM 'cats' WHERE 'id' = " + id);
    }

    public static void deleteCat(String where) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("DELETE FROM 'cats' WHERE " + where);
    }

    public static void updateCat(String set, String where) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate("UPDATE 'cats' SET " + set + " WHERE " + where);
    }

    public static ResultSet getCat(int id) throws SQLException {
        stat = conn.createStatement();
        res = stat.executeQuery("SELECT * FROM 'cats' WHERE id = " + id);
        return res;
    }

    public static void getCatWhere(String where) throws SQLException {

        stat = conn.createStatement();
        ResultSet resNew = stat.executeQuery("SELECT * FROM 'cats' WHERE " + where);
        while (resNew.next()) {
            System.out.println(resNew.getString("id") + ", "
            + resNew.getString("name") + ", "
            + DB.getType(resNew.getInt("type_id")) + ", "
            + resNew.getString("age") + ", "
            + resNew.getString("weight"));
        }
    }

    public static void getAllCats() throws SQLException {
        stat = conn.createStatement();
        ResultSet resNew = stat.executeQuery("SELECT * FROM 'cats'");
        while (resNew.next()) {
            System.out.println(resNew.getString("id") + ", "
                    + resNew.getString("name") + ", "
                    + DB.getType(resNew.getInt("type_id")) + ", "
                    + resNew.getString("age") + ", "
                    + resNew.getString("weight"));
        }
    }
}
