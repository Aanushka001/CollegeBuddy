import java.io.IOException;

import java.io.PrintWriter;



import java.lang.ProcessBuilder.Redirect.Type;

import java.sql.*;
import java.util.jar.Attributes.Name;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.swing.JOptionPane;

@WebServlet(urlPatterns = {"/index"})

public class index extends HttpServlet {

protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

res.setContentType("text/html;charset=UTF-8"); PrintWriter pr = res.getWriter();

String username = req.getParameter("username"); String password = req.getParameter("password"); try {

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hack", "root", "");

String sql = "select * from user where username=? and password=?";

String sql2="Select * from user";
PreparedStatement s = con.prepareStatement(sql);
Statement s2=con.createStatement();
s.setString(1, username);
s.setString(2, password);
ResultSet rs = s.executeQuery();
ResultSet r=s2.executeQuery(sql2);

if (rs.next()) {
//    pr.print(""
      pr.print(""   
              +"<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Taskbar</title>\n" +
"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"index.css\">\n" +
"</head>\n" +
"<body>\n" +
"    <header>\n" +
"        <div class=\"navbar\">\n" +
"            <!-- Navigation Links -->\n" +
"            <div class=\"college-buddy-main\">College Buddy</div>\n" +
"            <a href=\"#notes\" class=\"nav-link\"><i class=\"fas fa-book\"></i> Notes</a>\n" +
"            <a href=\"#finance\" class=\"nav-link\"><i class=\"fas fa-money-bill-wave\"></i> Finance/Scholarship</a>\n" +
"            <!-- Add more icons as needed -->\n" +
"            <a href=\"#events\" class=\"nav-link\"><i class=\"fas fa-calendar-alt\"></i> Events</a>\n" +
"            <a href=\"#internship\" class=\"nav-link\"><i class=\"fas fa-briefcase\"></i> Internship</a>\n" +
"            <a href=\"#about\" class=\"nav-link\"><i class=\"fas fa-info-circle\"></i> About Us</a>\n" +
"            <a href=\"#contact\" class=\"nav-link\"><i class=\"fas fa-phone\"></i> Contact Us</a>\n" +
"        </div>\n" +
"    </header>\n" +
"    \n" +
"    <!-- Content Area -->\n" +
"    <div id=\"welcome\" class=\"section\">\n" +
"        <!-- Welcome content goes here -->\n" +
"        <h2>Welcome to College Buddy</h2>\n" +
"        <p>We're here to support you on your educational journey. Explore our resources and services to enhance your student experience.</p>\n" +
"    </div>\n" +
"    \n" +
"    <div id=\"notes\" class=\"section\" style=\"display: none;\">\n" +
"        <!-- Notes content goes here -->\n" +
"        <h2>Notes Section</h2>\n" +
"        <p>Click on the icon below to download the content:</p>\n" +
"        <div id=\"cse-material\" class=\"course-material\">\n" +
"            <a href=\"https://drive.google.com/drive/folders/1tFoPe1ljnkeAeCrNu6EZH_VRTuu6fQ2_?usp=sharing\" target=\"_blank\"> <!-- Replace \"path/to/your/pdf/file.pdf\" with the actual path to your PDF file -->\n" +
"                <i class=\"fas fa-laptop-code\"></i> CSE\n" +
"            </a>\n" +
"        </div>\n" +
"        <div id=\"medical-material\" class=\"course-material\"> <a href=\"https://drive.google.com/drive/folders/12pAvk0rJGEwwRDNHBC5EIascT4HoRcBG\" target=\"_blank\"><i class=\"fas fa-user-md\"></i> Medical</a></div>\n" +
"        <div id=\"mechanical-material\" class=\"course-material\"><a href=\"https://drive.google.com/drive/folders/0BxfQqBdt-h66akdlWXI3RGI1d00?resourcekey=0-R8Kbi6OxeA-U3CmQ4zZdsA\" target=\"_blank\"><i class=\"fas fa-cogs\"></i> Mechanical</a></div>\n" +
"        <div id=\"civil-material\" class=\"course-material\"><a href=\"https://drive.google.com/drive/folders/0B78_eKVLzY9HUDNoSGlLSnAzRmc\" target=\"_blank\"><i class=\"fas fa-hard-hat\"></i> Civil</a></div>\n" +
"        <div id=\"mba-material\" class=\"course-material\"><a href=\"https://drive.google.com/drive/folders/0B6x30pIiR1DzUDZZdGs5MTdwZTg?resourcekey=0-4fwkcHzMDzCLseOapOfw6A\" target=\"_blank\"><i class=\"fas fa-chart-line\"></i> MBA</a></div>\n" +
"    </div>\n" +
"    \n" +
"    <div id=\"finance\" class=\"section\" style=\"display: none;\">\n" +
"        <!-- Finance content goes here -->\n" +
"        <h2>Finance Session</h2>\n" +
"        <p>Click on the icon below to download the content:</p>\n" +
"        <div id=\"loan-material\" class=\"loan-material\">\n" +
"            <a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-money-bill-wave\"></i> Understanding and Managing Loan EMIs</a></div>\n" +
"        <div id=\"scholarship-material\" class=\"scholarship-material\">\n" +
"            <a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-money-bill-wave\"></i> Scholarship</a></div>\n" +
"    </div>\n" +
"    \n" +
"    <div id=\"events\" class=\"section\" style=\"display: none;\">\n" +
"        <h2><i class=\"fas fa-calendar-alt\"></i> Events Section</h2>\n" +
"        <p>Click on the icon below to download the content:</p>\n" +
"        <div id=\"Dhoom-material\" class=\"event-material\"><a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-flag\"></i> DHOOM</a></div>\n" +
"        <div id=\"Projection-material\" class=\"event-material\"><a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-video\"></i>Projection</a></div>\n" +
"        <div id=\"Convocation-material\" class=\"event-material\"><a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-graduation-cap\"></i> Convocation</a></div>\n" +
"        <div id=\"hackathon-material\" class=\"event-material\"><a href=\"https://drive.google.com/drive/my-drive\" target=\"_blank\"><i class=\"fas fa-laptop-code\"></i> Hackathon</a></div>\n" +
"    </div>\n" +
"    \n" +
"    <!-- Similar content for other sections -->    \n" +
"    <div id=\"internship\" class=\"section\" style=\"display: none;\">\n" +
"        <h2><i class=\"fas fa-briefcase\"></i> Internship Section</h2>\n" +
"        <p>Click on the icon below to download the content:</p>\n" +
"        <div id=\"startup-internships\" class=\"inter-material\"><a href=https://drive.google.com/drive/my-drive target=\"_blank\"><i class=\"fas fa-building\"></i> Startup Internships</a></div>\n" +
"        <div id=\"technology-internships\" class=\"inter-material\"><a href=https://drive.google.com/drive/my-drive target=\"_blank\"><i class=\"fas fa-laptop\"></i> Technology and IT Internships</a></div>\n" +
"        <div id=\"healthcare-internships\" class=\"inter-material\"><a href=https://drive.google.com/drive/my-drive target=\"_blank\"><i class=\"fas fa-hospital\"></i> Healthcare and Medical Internships</a></div>\n" +
"        <div id=\"research-internships\" class=\"inter-material\"><a href=https://drive.google.com/drive/my-drive target=\"_blank\"><i class=\"fas fa-flask\"></i> Research Internships</a></div>\n" +
"    </div>\n" +
"    \n" +
"    <div id=\"about\" class=\"section\" style=\"display: none;\">\n" +
"        <!-- About Us content goes here -->\n" +
"        <h2><i class=\"fas fa-info-circle\"></i> About Us Section</h2>\n" +
"        <p>Welcome to College Buddy!</p>\n" +
"        <p>We are dedicated to helping students succeed in their academic and professional journeys. Whether you're seeking study materials, financial advice, internship opportunities, or information about upcoming events, we've got you covered.</p>\n" +
"        <p>Our mission is to provide comprehensive support and resources to empower students to achieve their goals. With a user-friendly interface and a wide range of services, we aim to make your student experience as smooth and enriching as possible.</p>\n" +
"        <p>Feel free to explore our website and take advantage of all the resources we offer. If you have any   questions or feedback, don't hesitate to contact us. We're here to help you every step of the way!</p>\n" +
"    </div>\n" +
"    \n" +
"    <div id=\"contact\" class=\"section\" style=\"display: none;\">\n" +
"        <!-- Contact Us content goes here -->\n" +
"        <h2><i class=\"fas fa-phone\"></i> #########</h2>\n" +
"        <p>This is the section for contacting us.</p>\n" +
"    </div>\n" +
"    \n" +
"    <script>\n" +
"        document.addEventListener(\"DOMContentLoaded\", function() {\n" +
"            const sections = document.querySelectorAll('.section');\n" +
"            const navLinks = document.querySelectorAll('.nav-link');\n" +
"\n" +
"            navLinks.forEach((link, index) => {\n" +
"                link.addEventListener('click', function(event) {\n" +
"                    event.preventDefault(); // Prevent default behavior of links\n" +
"                    const href = this.getAttribute('href');\n" +
"                    const targetSection = document.querySelector(href);\n" +
"                    if (targetSection) {\n" +
"                        sections.forEach(section => {\n" +
"                            section.style.display = 'none';\n" +
"                        });\n" +
"                        targetSection.style.display = 'block';\n" +
"                    }\n" +
"                });\n" +
"            });\n" +
"        });\n" +
"    </script>\n" +
"</body>\n" +
"</html>\n" );



              
         

//            +"<html>"
//            +"<head>"
//            +"<meta charset=\"ISO-8859-1\">"
//            + "<title>Book Store</title>"
//            + "<link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"./favicons/apple-touch-icon.png\">"
//            + "<link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"./favicons/favicon-32x32.png\">"
//            + "<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"./favicons/favicon-16x16.png\">"
//            
//            + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" >"
//            + "<link rel=\"stylesheet\" href=\"styles.css\">"
//            + "<style>\n" +
//"          \n" +
//"            \n" +
//"            .column {\n" +
//"            float: left;\n" +
//"            width: 33.33%;\n" +
//"            padding: 5px;\n" +
//"            }\n" +
//"            \n" +
//"         \n" +
//"            .row::after {\n" +
//"              content: \\;\n" +
//"              clear: both; \n" +
//"              display: table; \n" +
//"             }\n" +
//"\n" +
//"             div {text-align: center;}\n" +
//"    \n" +
//"    \n" +
//"            </style>"
//
//            + "</head>"
//            + "<body onload=\"funload()\">"
//            + "<header>"
//            + "<nav class=\"navbar navbar-expand-sm bg-dark\">\n" +
//"				<a class=\"navbar-brand\">\n" +
//"					<!-- The below line can be an image or a h1, either will work -->\n" +
//"					\n" +
//"				</a>\n" +
//"				\n" +
//"				<button style=\"background-color:white;\" class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
//"				    <span class=\"navbar-toggler-icon\" ></span>\n" +
//"				 </button>\n" +
//"\n" +
//"                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">                \n" +
//"				<ul class=\"navbar-nav\" >\n" +
//"					<li class=\"nav-item\"><span><a class=\"nav-link active\" href=\"index.html\">Home</a></span></li>\n" +
//"					<li class=\"nav-item \"><span><a class=\"nav-link\" href=\"CustomerLogin.html\">Login</a></span></li>\n" +      
//"					<li class=\"nav-item \"><span><a class=\"nav-link\" href=\"Order.html\">MyOrder</a></span></li>\n" +
//                                        
//"				</ul>\n" +
//"				</div>\n" +
//"			</nav>"
//            
//            + "</header>"
//            + ""
//            + "<br>"
//            + "<div id=\"topmid\"><h1>Welcome to My Online <br>Book Store</h1></div>"
//            + "<br>"
//
//            + "<div class=\"row\">\n" +
//            "  <div class=\"column\">\n" +
//            "    <img src=\"pic1.jpeg\" alt=\"Snow\" style=\"width:80%\"><br>\n"
//           // + "<a href="+"Orderr.jsp"+"><table><input type=submit value="+"one"+" name="+"one"+" id="+"one"+"></table></a>"+ 
//            + "<a href="+"Orderr.jsp"+"><button type="+"button"+" onclick="+"sendValue('one')"+">Buy</button></a>"+
//            
//            
//            "  </div>\n"
//            
//            +"  <div class=\"column\">\n" +
//            "    <img src=\"pic2.jpeg\" alt=\"Forest\" style=\"width:80%\"><br>\n" 
//            + "<A href="+"payment.html"+"><button>Buy</button></a>"+
//            "  </div>\n" +
//            "  <div class=\"column\">\n" +
//            "    <img src=\"pic3.jpeg\" alt=\"Mountains\" style=\"width:80%\"><br>\n" 
//            + "<A href="+"payment.html"+"><button>Buy</button></a>"+
//            "  </div>\n" +
//            "</div>"
//            + "<br>"
//            + "<div class=\"row\">\n" +
//            "  <div class=\"column\">\n" +
//            "    <img src=\"pic4.jpeg\" alt=\"Snow\" style=\"width:80%\"><br>\n"
//            + "<A href="+"payment.html"+"><button>Buy</button></a>"+
//            "  </div>\n" +
//            "  <div class=\"column\">\n" +
//            "    <img src=\"pic5.jpeg\" alt=\"Forest\" style=\"width:80%\"><br>\n" 
//            + "<A href="+"payment.html"+"><button>Buy</button></a>"+
//            "  </div>\n" +
//            "  <div class=\"column\">\n" +
//            "    <img src=\"pic6.jpeg\" alt=\"Mountains\" style=\"width:80%\"><br>\n"
//            + "<A href="+"payment.html"+"><button>Buy</button></a>"+
//            "  </div>\n" +
//            "</div>"
//            
//            
//            
//
//       
//            + "<table class=\"tab\">"
//            + "<tr>"
//            + "<td><a href=\"index.html\" id=\"happy\">Life is Learning<br>!!Welcome to our book store!!</a></td>"
//           
//            + "</tr>"
//            + "</table>"
//            + "</body>"
//            +"</html>"
//    );


} else {

//           PrintWriter ps = res.getWriter();
//           ps.println("wrong username or password");
//           RequestDispatcher rd = req.getRequestDispatcher("index.html");
//           rd.include(req, res);
PrintWriter ps = res.getWriter();
ps.println("<html>");
ps.println("<head>");
ps.println("<style>");
ps.println(".error-message {");
ps.println("    text-align: center;");
ps.println("    color: red;");
ps.println("    font-weight: bold;");
ps.println("    font-size: 24px;");
ps.println("}");
ps.println("</style>");
ps.println("</head>");
ps.println("<body>");
ps.println("<br><br><br><h1 class='error-message'>!! Wrong Username or Password !!</h1>");
RequestDispatcher rd = req.getRequestDispatcher("index.html");
rd.include(req, res);
ps.println("</body>");
ps.println("</html>");


       

}


} catch (SQLException | ClassNotFoundException e) { pr.print(e.toString());

}

}


@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

processRequest(request, response);

}

@Override

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

processRequest(request, response);

}

@Override

public String getServletInfo() {

return "Short description";

}

}
