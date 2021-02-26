import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SQLException {
        City kiev = new City(uuidGenerator(), "Киев");
        City zaporozhe = new City(uuidGenerator(), "Запорожье");

        Connection connection = CitiesService.createConnection(CitiesService.dbUrl);

        CitiesService.createCitiesTable(connection);

        CitiesService.addCity(kiev, connection);
        CitiesService.addCity(zaporozhe, connection);

        CitiesService.getCity(connection);

        connection.close();
    }

    public static String uuidGenerator() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
