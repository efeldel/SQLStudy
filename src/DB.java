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
    static String[] names = {"Гарфилд",
            "Том",
            "Гудвин",
            "Рокки",
            "Ленивец",
            "Пушок",
            "Спорти",
            "Бегемот",
            "Пират",
            "Гудини",
            "Зорро",
            "Саймон",
            "Альбус",
            "Базилио",
            "Леопольд",
            "Нарцисс",
            "Атос",
            "Каспер",
            "Валлито",
            "Оксфорд",
            "Бисквит",
            "Соня",
            "Клеопатра",
            "Цунами",
            "Забияка",
            "Матильда",
            "Кнопка",
            "Масяня",
            "Царапка",
            "Серсея",
            "Ворсинка",
            "Амели",
            "Наоми",
            "Маркиза",
            "Изольда",
            "Вальс",
            "Несквик",
            "Златан",
            "Баскет",
            "Изюм",
            "Цукат",
            "Мокко",
            "Месси",
            "Кокос",
            "Адидас",
            "Бейлиз",
            "Тайгер",
            "Зефир",
            "Мохи",
            "Валенсия",
            "Баунти",
            "Свити",
            "Текила",
            "Ириска",
            "Карамель",
            "Виски",
            "Кукуруза",
            "Гренка",
            "Фасолька",
            "Льдинка",
            "Китана",
            "Офелия",
            "Дайкири",
            "Брусника",
            "Аватар",
            "Космос",
            "Призрак",
            "Изумруд",
            "Плинтус",
            "Яндекс",
            "Крисмас",
            "Метеор",
            "Оптимус",
            "Смайлик",
            "Цельсий",
            "Краска",
            "Дейзи",
            "Пенка",
            "Веста",
            "Астра",
            "Эйприл",
            "Среда",
            "Бусинка",
            "Гайка",
            "Елка",
            "Золушка",
            "Мята",
            "Радость",
            "Сиам",
            "Оскар",
            "Феликс",
            "Гарри",
            "Байрон",
            "Чарли",
            "Симба",
            "Тао",
            "Абу",
            "Ватсон",
            "Енисей",
            "Измир",
            "Кайзер",
            "Васаби",
            "Байкал",
            "Багира",
            "Айрис",
            "Диана",
            "Мими",
            "Сакура",
            "Индия",
            "Тиффани",
            "Скарлетт",
            "Пикси",
            "Лиззи",
            "Алиса",
            "Лило",
            "Ямайка",
            "Пэрис",
            "Мальта",
            "Аляска"
    };
// COMMON
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
            System.out.println("Ошибка SQL!");
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
                System.out.println("Ошибка SQL!");
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
