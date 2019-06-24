import java.sql.*;
import java.util.Scanner;

public class PreparedStatements {
    public static void main(String[] args) {

        /*
          @author Babel
         * Conection with db created in mySQL
         * url - db abress default jdbc:mysql://localhost:3306/db_name?useTimezone=true&serverTimezone=UTC
         * user - db user name
         * password - db password
         *
         * "select * from contacts where Salary > ?" - ? our parameter to send
         * PreparedStatement stmt = myConn.prepareStatement(sql); - create our own request to db
         * stmt.setDouble(1, 10000); - our parameter to check
         * ResultSet rs = stmt.executeQuery(); - our result
         */

        String url = "jdbc:mysql://localhost:3307/test?useTimezone=true&serverTimezone=UTC";
        System.out.print("User name: ");
        String user = sc.nextLine();
        System.out.print("User password: ");
        String password = sc.nextLine();

        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = myConn.prepareStatement("select * from contacts where Salary > ?");
            stmt.setDouble(1, 10000);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("Name") + " " + rs.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Scanner sc = new Scanner(System.in);
}
