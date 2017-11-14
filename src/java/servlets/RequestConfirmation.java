
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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RequestConfirmation", urlPatterns = {"/RequestConfirmation"})
public class RequestConfirmation extends HttpServlet {


@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get request credentials
        String r_category = request.getParameter("r_category");
        String r_id = UUID.randomUUID().toString();        
        HttpSession session = request.getSession(true);
        String  b_name = (String)session.getAttribute("b_userid");
        
        //mail attributes
        String to = "";
        String subject = "Confirmation of your request from Smart Drinks";  
        String msg = "Your request for "+ r_category + " category has been succefuly submited to our system."
                + "Thank you for choosing smart drink for your business. We will contact you soon!";        
       
        Connection con = null;
        Statement st = null;
        Statement st2 = null;
        int count = 0;
        ResultSet rs = null;
        
        PrintWriter out = response.getWriter();
        
        
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smartdrinkdb",
                    "smartdrink123", "smartdrink!");
    } catch (SQLException ex) {
        Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //store the order credentials into the database
        try {
             st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    try {
        count = st.executeUpdate("insert into REQUEST(R_ID, R_CATEGORY, B_NAME) values ('" + r_id + "','" + r_category + "','" + b_name +  "' )" );
    } catch (SQLException ex) {
        Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    try {
        rs = st2.executeQuery("select * from BUSINESS where B_NAME='"+b_name+"'");
    } catch (SQLException ex) {
        Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        if (rs.next())
        to = rs.getString("B_EMAIL");
    } catch (SQLException ex) {
        Logger.getLogger(RequestConfirmation.class.getName()).log(Level.SEVERE, null, ex);
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
                  "<h1><font color=\"purple\"> THANK YOU FOR YOUR REQUEST!!!</font></h1>\n" +
                  "</center>");
        out.write("<p align=\"center\">  A confirmation Email"
                + " has sent to : " +to+" </p>");
        out.write("</html></body>");
        
        
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
    
    }

}
