import java.sql.*;


public class Program {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DB.getConnection();

            String sql = "DELETE FROM seller "
                    + "WHERE "
                    + "Id = ?";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, 7 );

            int rowsAffected = ps.executeUpdate();

            System.out.println("Rows affected : " + rowsAffected);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {

            DB.closeStatement(ps);
            DB.closeConnection();

        }

    }
}