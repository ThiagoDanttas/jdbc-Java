import java.sql.*;


public class Program {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DB.getConnection();

            String sql = "UPDATE coursejdbc.seller " +
                    "SET BaseSalary = BaseSalary + ? " +
                    "WHERE (DepartmentId = ?)";

            ps = connection.prepareStatement(sql);
            ps.setDouble(1, 100.0);
            ps.setInt(2, 1);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Rows affected : " + rowsAffected);


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        finally {

            DB.closeStatement(ps);
            DB.closeConnection();

        }

    }
}