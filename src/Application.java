import constant.SQL.Info;
import java.sql.*;

public class Application {
    public static void main(String arg[]) {
        String query = "SELECT * FROM Book";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Info.JDBC_URL, Info.SQL_ID, Info.SQL_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}