package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController {

    private final String URL;
    private final String userName1;
    private final String password1;
    private Connection connection;

    public DataBaseController() throws ClassNotFoundException, SQLException {
        this.URL = "jdbc:mysql://localhost/ChatRoom";
        this.userName1 = "root";
        this.password1 = "1080682805fghFGH@#";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL, userName1, password1);
    }

    public boolean saveMassage(String massage, String userName) {
        try {
            final String SQLCommand = "INSERT INTO chat (ID , massage) VALUES ('" + userName + "','" + massage + "')";
            Statement commandState = connection.prepareStatement(SQLCommand);
            commandState.execute(SQLCommand);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
