
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


@WebServlet("/adminloginServlet")
public class adminloginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

      resp.setContentType("text/html");
      
    String email,password,username,confirmpassword;
    username=req.getParameter("username");
    password=req.getParameter("password");
    email=req.getParameter("email");
    confirmpassword=req.getParameter("confirm-password");
    
//    lastname=req.getParameter("lastname");
//    address=req.getParameter("address");
//    phone=req.getParameter("phone");
    PrintWriter ps=resp.getWriter();

    try{    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hack","root","");
        Statement s=con.createStatement();
        String q="insert into user values('"+username+"','"+email+"','"+password+"','"+confirmpassword+"')";
        if(s.executeUpdate(q)==1){
            //ps.print("Registered Succussfully");
            //ps.println("<a href='/webdemo/login'>GO to Login</a>");
        }
    }catch(Exception e){
        ps.println(e.toString());
    }   
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
    

      ps.println("<html>"
              + "<head>"
              + "<title>Preview</title>"
              +"<style>"
               +" body {"+
"    background-image: url(\"img2.jpg\");\n" +
"    background-position: center;\n" +
"    background-size: cover;\n" +
"    opacity: 0.9;}"
              +"pre {\n" +
"                font-family: Arial;\n" +
"                \n" +
               
"            }"
              +"</style>"
              + "</head>"
             
              + "<body backgound="+"/img2.jpg"+"><br><br>"
             
              +"<H1 style=text-align:center>Registered Successfully</h1>"
              +"<h2></h2>"
             
              + "<pre style=text-align:center>Welcome <b>"+username+"</b>  you are registered as a user</pre>"
                      + "<pre style=text-align:center><a href="+"index.html"+">Click Here </a>To goto to Login page</pre>"
                                      + "</body>"
                                      + "</html>");
        
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}








