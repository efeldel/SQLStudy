import java.sql.*;
public class DB {
    public static Connection conn;
    public static Statement stat;
    public static ResultSet res;
    static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку?н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };

    public static void conn() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
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
            System.out.println("Ошибка SQL!");
        }
    }
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
            System.out.println("Ошибка SQL!");
        }
    }
    public static void insertType(String type) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO 'types' ('type') VALUES ('" + type + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(type + " уже существует");
        }
    }

    public static void addAllTypes() {
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
        for (String type : types) {
            try {
                stat.executeUpdate("INSERT INTO 'types' ('type') VALUES ('" + type + "')");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(type + " уже существует");
            }
        }
    }

    public static void deleteType(int id) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM 'types' WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }

    public static void updateType(int id, String newType) {
        try {
            stat = conn.createStatement();
            stat.executeUpdate("UPDATE 'types' SET type = '" + newType + "' WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }

    public static String getType(int id) throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE id = "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
        return res.getString("type");
    }
    public static void getTypeWhere (String where) throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE "+ where);
            System.out.println("Породы кошек подходящие под условия: " + where +":");
            while(res.next()) {
                System.out.println(res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }
    public static void getAllTypes() throws SQLException {
        try {
            stat = conn.createStatement();
            res = stat.executeQuery("SELECT type FROM 'types' WHERE 1");
            System.out.println("Породы кошек:");
            while(res.next()) {
                System.out.println(res.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }

    public static void close() throws SQLException {
        conn.close();
    }
}
