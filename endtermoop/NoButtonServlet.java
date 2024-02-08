// Import required Java and SQL libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class NoButtonServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL="jdbc:mysql://localhost/yourDatabaseName";

        // Database credentials
        final String USER = "username";
        final String PASS = "password";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection conn = null;
        Statement stmt = null;
        try{
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE NoButtonClicks SET count = count + 1 WHERE id = 1";
            stmt.executeUpdate(sql);

            // Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if(stmt!=null)
                    stmt.close();
            } catch(SQLException se2) {
            } try {
                if(conn!=null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
``