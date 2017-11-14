/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "OrderConfirmation", urlPatterns = {"/OrderConfirmation"})
public class OrderConfirmation extends HttpServlet {

@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get order credentials
        String stripeToken = request.getParameter("stripeToken");
        String shopName = request.getParameter("shopName");
        String productName = request.getParameter("productName");
        String discount = request.getParameter("discount");
        String offerID = UUID.randomUUID().toString();        
        HttpSession session = request.getSession(true);
        String username = (String)session.getAttribute("userid");
        
        //mail attributes
        String to = "";
        String subject = "Deal from Smart Drinks";  
        String msg = "Thank you for choosing smart drinks, your deal of "+discount+" on "+productName+
                " at "+shopName+" is ready. Your coupon id is: " +offerID+"." + " Enjoy your drink!!";        
       
        Connection con = null;
        Statement st = null;
        Statement st2 = null;
        int count = 0;
        ResultSet rs = null;
        
        PrintWriter out = response.getWriter();
        
        
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(OrderConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smartdrinkdb",
                    "smartdrink123", "smartdrink!");
    } catch (SQLException ex) {
        Logger.getLogger(OrderConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //store the order credentials into the database
        try {
             st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    try {
        count = st.executeUpdate("insert into OFFERS(offer_id, shop_name, product_name, discount, stripe_token, username) values ('" + offerID + "','" + shopName + "','" + productName + "','" + discount + "','" + stripeToken + "','" + username + "' )" );
    } catch (SQLException ex) {
        Logger.getLogger(OrderConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    if (count <= 0) {
        out.write("<html><body>");
        
        out.write("<center>\n" +
                  "<h1><font color=\"red\"> OUPS SOMETHING WENT WRONG,"
                + " PLEASE TRY AGAIN!!!</font></h1>");

        out.write("</html></body>");
    }
        

    
    
    
    //get the email of the user
    try {
             st2 = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    try {
        rs = st2.executeQuery("select * from MEMBERS where username='"+username+"'");
    } catch (SQLException ex) {
        Logger.getLogger(OrderConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        if (rs.next())
        to = rs.getString("email");
    } catch (SQLException ex) {
        Logger.getLogger(OrderConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
      
    
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  
    Session mailSession = Session.getDefaultInstance(props,  
            new javax.mail.Authenticator() {
               
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("smartdrink1@gmail.com","6979248855");//change accordingly
                }  
            });
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(mailSession);  
   message.setFrom(new InternetAddress("smartdrink1@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject(subject);  
   message.setText(msg);  
     
   //send message  
   Transport.send(message);  
  
        out.write("<html><body>");
        
        out.write("<center>\n" +
                  "<h1><font color=\"purple\"> ENJOY YOUR SMART-DRINK-DEAL!!!</font></h1>\n" +
                  "</center>");
        out.write("<p align=\"center\">  A confirmation Email"
                + " alongside with your coupon id has sent to : " +to+" </p>");
        out.write("</html></body>");
        
        
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
    
    }


}
