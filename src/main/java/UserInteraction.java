import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInteraction {
    public static UserCredential getCredentialsFromUser () {
        Scanner scanner = new Scanner(System.in);

        UserCredential userCredential = new UserCredential();
        System.out.println("Introdu IP:");
        userCredential.ip = scanner.nextLine();
        System.out.println("Introdu Port:");
        userCredential.port = scanner.nextLine();
        System.out.println("Introdu Database Name:");
        userCredential.database = scanner.nextLine();
        System.out.println("Introdu User:");
        userCredential.user = scanner.nextLine();
        System.out.println("Introdu Password:");
        userCredential.password = scanner.nextLine();

        return userCredential;
    }
    public static String getQuery () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu un Query");
//        String queryIntrodus = scanner.nextLine();
//        return  queryIntrodus;
        return scanner.nextLine();
    }
    public static void  showResult (ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i =1; i<=columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.printf("%25s", columnName);
        }
        System.out.println("");
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%25s", rs.getObject(i));
            }
            System.out.println("");
        }
    }
}
