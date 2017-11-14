
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "BusinessLogin", urlPatterns = {"/BusinessLogin"})
public class BusinessLogin extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    HttpSession session = null;
    Connection con = null;
    Statement st = null;    
    String b_name = request.getParameter("uname");     
    String b_pass = request.getParameter("pass");
    //ServletContext servletContext = getServletContext();
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusinessLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smartdrinkdb",
                    "smartdrink123", "smartdrink!");
        } catch (SQLException ex) {
            Logger.getLogger(BusinessLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
             st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BusinessLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from BUSINESS where B_NAME='" + b_name + "' and B_PASSWORD='" + b_pass + "'");
        } catch (SQLException ex) {
            Logger.getLogger(BusinessLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                session = request.getSession(true);
                session.setAttribute("b_userid", b_name);
                response.sendRedirect("doRequest.jsp");
            } else  {
                response.sendRedirect("businessInvalidPassword.jsp");
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}