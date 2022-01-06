import db.Connectivity;
import service.DbService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connectivity connectivity = new Connectivity();
            DbService service = new DbService(connectivity.getConnection());

            //int cnt = service.create(
            //  3,
            //"pqr",
            //Date.valueOf(LocalDate.now()),
            // false
            //);
            //if (cnt > 0) {
            //  System.out.println("Employee created succesfully");
            //}

            //service.find();
            service.findEmployeeByName("abc");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
