import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SQLException {
        City kharkiv = new City(uuidGenerator(), "Харьков");

        Connection connection = CitiesService.createConnection(CitiesService.dbUrl); // подключился к бд

        CitiesService.createCitiesTable(connection); // создал таблицу

        CitiesService.addCity(kharkiv, connection);

        connection.close();
    }

    public static String uuidGenerator() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
