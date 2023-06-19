import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//IN THE NAME OF GOD
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            ServerSocket inPutServerSocket = new ServerSocket(6686);
            ServerSocket outPutServerSocket = new ServerSocket(2222);
            while (true){
                Socket inputSocket = inPutServerSocket.accept();
                Socket outPutSocket = outPutServerSocket.accept();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}













/*String URL = "jdbc:mysql://localhost/ChatRoom";
        String userName = "root";
        String password = "1080682805fghFGH@#";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,userName,password);*/