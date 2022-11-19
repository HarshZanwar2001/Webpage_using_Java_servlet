import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Doner extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String fname=request.getParameter("fname");  
String lname=request.getParameter("lname");  
Data date=request.getParameter("datebirth");  
String gender=request.getParameter("radio");
String bloodg=request.getParameter("bgroup");
String email=request.getParameter("email");
String dis =request.getParameter("districts");
String ph=Integer.ParseInt(request.getParameter("phno"));
  
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
out.println("Connection");
  
PreparedStatement ps=con.prepareStatement(  
"insert into Donars values(?,?,?,?,?,?,?,?)");  
  
ps.setString(1,fname);  
ps.setString(2,lname);  
ps.setString(3,date);   
ps.setString(4,gender);   
ps.setString(5,bloodg);   
ps.setString(6,email);   
ps.setString(7,dis);   
ps.setString(8,ph);   


          
int i=ps.executeUpdate();  
out.println("Successfull");

}catch (Exception e2) {System.out.println(e2);} 
out.close();
			}
			public static void main(String []args)
			{
				Doner d=new Doner();
			}
}
