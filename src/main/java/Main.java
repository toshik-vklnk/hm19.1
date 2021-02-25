import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:sqlite:C:\\SQLite\\homework.db";

        Connection connection = createConnection(dbUrl);

        createCitiesTable(connection);

    }

    public static Connection createConnection(String dbUrl) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static void createCitiesTable(Connection connection) throws SQLException {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS cities (\n"
                + "id TEXT PRIMARY KEY DEFAULT (uuidGenerator()),\n"
                + "name TEXT NOT NULL\n"
                + ");";
        try (Statement statement = connection.createStatement()){
            statement.execute(sqlCommand);
        }
    }

    public String uuidGenerator() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
