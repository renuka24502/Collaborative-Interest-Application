import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;
import java.io.*;

public class Search extends HttpServlet
{
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/socialdatabase";
	//Datase crudentials
	final String USER = "root";
	final String PASS = "143myself";
	HttpSession session; 
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		response.setContentType("text/html");
		//HttpSession session=session.getSession(true);
		
		PrintWriter out = response.getWriter();
		String name=request.getParameter("val");
if(name==null||name.trim().equals("")){
	out.print("<center><p><font color=\"white\">Please enter some keyword to search!</font></p></center>");
}else{
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
Statement ps=con.createStatement();
ResultSet rs=ps.executeQuery("select username,activity,sport from activities where activity like '"+name+"%' or sport like '"+name+"%'");

if(!rs.isBeforeFirst()) {    
 out.println("<center><p><font color=\"white\">No Mates Found!</p></font></center>"); 
}else{
out.print("<table align='center' border='1' cellpadding='2' width='100%'>");

while(rs.next()){
String username=rs.getString("username");
String activity=rs.getString("activity");
String sub=rs.getString("sport");

out.print("<tr><td><font color=\"white\"><b><a href='ViewProfile?maker="+username+"'>"+username+"</a></b> wants to "+activity+" "+sub+"</font></td></tr></center>");}
out.print("</table>");
}//end of else for rs.isBeforeFirst
con.close();
}catch(Exception e){out.print(e);}
}//end of else
		}
	
}
