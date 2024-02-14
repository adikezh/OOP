// Import statements go here
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class PreferencesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String venue = request.getParameter("venue");
        String datetime = request.getParameter("datetime");
        String dresscode = request.getParameter("dresscode");

        // Database connection and SQL insert statements go here
        // You would use JDBC to connect to your database named "base" and insert the data
        String insertSQL = "INSERT INTO preferences (country, city, venue, datetime, dresscode) VALUES (?, ?, ?, ?, ?)";
        String dbURL = "jdbc:mysql://localhost/yourDatabaseName";
        String user = "username";
        String pass = "password";

        // Use PreparedStatement for security against SQL injection
        try (Connection conn = DriverManager.getConnection(dbURL, user, pass);
            PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
     
            pstmt.setString(1, country);
            pstmt.setString(2, city);
            pstmt.setString(3, venue);
            pstmt.setString(4, datetime);
            pstmt.setString(5, dresscode);
            int rowsAffected = pstmt.executeUpdate();
    
            if (rowsAffected > 0) {
                // Redirect to the "3rdsite.html" page
                response.sendRedirect("3rdsite.html");
            } else {
                // Handle the case where no rows were inserted
            }
    
} catch (SQLException e) {
    // Handle SQL exceptions
    // Optionally, redirect to an error page or return an error message
}
            }
        }
