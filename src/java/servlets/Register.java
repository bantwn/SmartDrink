/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
  
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
            String user = request.getParameter("uname");    
            String pwd = request.getParameter("pass");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smartdrinkdb",
                    "smartdrink123", "smartdrink!");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        try {
            count = st.executeUpdate("insert into MEMBERS(firstname, lastname, email, username, pass) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (count > 0) {
        
        response.sendRedirect("welcome.jsp");
       
    } else {
        response.sendRedirect("index.html");
    }
            
            
    }


}
