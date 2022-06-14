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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ SQL!");
        }
    }

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

    public static void close() throws SQLException {
        conn.close();
        stat.close();
    }
}
