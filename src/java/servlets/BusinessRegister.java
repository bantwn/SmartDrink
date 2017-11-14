
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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


@WebServlet(name = "BusinessRegister", urlPatterns = {"/BusinessRegister"})
public class BusinessRegister extends HttpServlet {

 @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            int count = 0;
            HttpSession session = null;
            Connection con = null;
            Statement st = null;
            String b_name = request.getParameter("bname");    
            String b_tel = request.getParameter("b_tel");
            String b_email = request.getParameter("bemail");
            String b_password = request.getParameter("b_pass");
            
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusinessRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smartdrinkdb",
                    "smartdrink123", "smartdrink!");
        } catch (SQLException ex) {
            Logger.getLogger(BusinessRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BusinessRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        try {
            count = st.executeUpdate("insert into BUSINESS(B_NAME, B_TEL, B_EMAIL, B_PASSWORD) values ('" + b_name + "','" + b_tel + "','" + b_email + "','" + b_password + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(BusinessRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (count > 0) {
        
        response.sendRedirect("businessWelcome.jsp");
       
    } else {
        response.sendRedirect("index.html");
    }
            
            
    }


}
