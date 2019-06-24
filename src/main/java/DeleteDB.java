import java.sql.*;
import java.util.Scanner;

public class DeleteDB {
    public static void main(String[] args) {

        /*
          @author Babel
         * Conection with db created in mySQL
         * url - db abress default jdbc:mysql://localhost:3306/db_name?useTimezone=true&serverTimezone=UTC
         * user - db user name
         * password - db password
         *
         *myStmt.executeUpdate("delete from pracownicy where id = 4") - delete db
         */

        String url = "jdbc:mysql://localhost:3307/test?useTimezone=true&serverTimezone=UTC";
        System.out.print("User name: ");
        String user = sc.nextLine();
        System.out.print("User password: ");
        String password = sc.nextLine();

        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
            int rowsaffected = myStmt.executeUpdate("delete from pracownicy where id = 8");
            System.out.println("Namer of delete row: " + rowsaffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Scanner sc = new Scanner(System.in);
}