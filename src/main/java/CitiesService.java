import java.sql.*;

public class CitiesService {

    public static String dbUrl = "jdbc:sqlite:C:\\SQLite\\homework.db";

    public static Connection createConnection(String dbUrl) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static void createCitiesTable(Connection connection) throws SQLException {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS cities (\n"
                + " id TEXT PRIMARY KEY,\n"
                + " name TEXT UNIQUE\n"
                + ");";
        try (Statement statement = connection.createStatement()){
            statement.execute(sqlCommand);
        }
    }

    public static void addCity(City city, Connection connection) throws SQLException {
        String sqlCommand = "INSERT INTO cities VALUES ('" + city.id + "', '" + city.name + "');";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCommand);
        }
    }

    public static void getCity(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cities;");
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(id + " | " + name);
            }
    }

}
