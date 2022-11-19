import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class RegisterFile extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("uname");  
String p=request.getParameter("pass");  
String cp=request.getParameter("confor");  
  
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into BloodBank values(?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,cp);   
          
int i=ps.executeUpdate();  

}catch (Exception e2) {System.out.println(e2);} 

        response.sendRedirect("http://localhost:8090/Blood/Login.html");  

out.close();  
}  
public static void main(String []args)
{
	RegisterFile rf=new RegisterFile();
}
  
} 