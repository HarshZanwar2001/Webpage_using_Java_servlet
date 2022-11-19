import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class LoginFile extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("uname");  
String p=request.getParameter("pass");  

try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con = DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
PreparedStatement ps=con.prepareStatement("select password from BloodBank where username=?");  
ps.setString(1,n); 
ResultSet rs=ps.executeQuery();  

while(rs.next())
{
String check = rs.getString(1);


	if(p.equals(check))
	{
		out.println(n);	
		response.sendRedirect("http://localhost:8090/Blood/Welcome.html"); 
		
	}
	else
	{ 
		
		  response.sendRedirect("http://localhost:8090/Blood/Login.html");  
		 

	}
}
con.close();
}catch(Exception e){System.out.println("Database");}
out.close();
			}
              
			
			public static void main(String []args)
			{
				LoginFile lf= new LoginFile();
			}
}