import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=UTC";
        String user = "root";
        String pass = "abcd1234e5";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("something went wrong, driver is not found");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select name, avg(qnty) as qnty " +
                    "from ( select date_format(subscription_date, \"%Y-%m\")," +
                    " courses.name, count(course_id) as qnty from subscriptions " +
                    "join courses on courses.id = subscriptions.course_id " +
                    "group by date_format(subscription_date, \"%Y-%m\"), course_id " +
                    "order by date_format(subscription_date, \"%Y-%m\") ) as results group by name;");

            while (rs.next()) {
                System.out.printf("%35s: %6.2f \n", rs.getString("name"),
                        Double.parseDouble(rs.getString("qnty")));
            }

            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
