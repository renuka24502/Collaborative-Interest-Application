import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
//import Utilities;

public class ViewProfile extends HttpServlet 
{
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/socialdatabase";
	//Datase crudentials
	final String USER = "root";
	final String PASS = "143myself";
protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
	String maker=request.getParameter("maker");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from register where uname='"+maker+"'");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		
		while(rs.next())
		{
			String username=rs.getString("uname");
			String gender=rs.getString("gender");
			String sport=rs.getString("play");
			String firstname=rs.getString("fname");
			String lastname=rs.getString("lname");
			String study=rs.getString("study");
			String party=rs.getString("party");	
			String movie=rs.getString("movie");
			String contactno=rs.getString("contactno");
			String email=rs.getString("email");
			String dob=rs.getString("dob");
			if(study.equals("null"))
			{
				study="No";
			}
			else
			{
				study="Yes";
			}
			if(party.equals("null"))
			{
				party="No";
			}
			else
			{
				party="Yes";
			}
			
			if(movie.equals("null"))
			{
				movie="No";
			}
			else
			{
				
				movie="Yes";
			}
			if(sport.equals("null"))
			{
				sport="No";
			} 
			else
			{
				sport="Yes";
			}
			out.println("<h2 align='center'>"+username+"'s Profile<h2>");
			out.println("<h3 align='center'>Personal Details</h3>");
			out.println("<table align='center'><tr><td>Username</td><td>"+username+"</td></tr>");
			out.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
			out.println("<tr><td>Firstname</td><td>"+firstname+"</td></tr>");
			out.println("<tr><td>Lastname</td><td>"+lastname+"</td></tr>");
			out.println("<tr><td>Date of Birth</td><td>"+dob+"</td></tr><table>");
			out.println("<h3 align='center'>Interests</h3>");
			out.println("<table align='center'><tr><td>Sports</td><td>"+sport+"</td></tr>");
			out.println("<tr><td>Study</td><td>"+study+"</td></tr>");
			out.println("<tr><td>Party</td><td>"+party+"</td></tr>");
			out.println("<tr><td>Movie</td><td>"+movie+"</td></tr></table>");
			out.println("<h3 align='center'>Contact Details</h3>");
			out.println("<table align='center'><tr><td>Email id</td><td>"+email+"</td></tr>");
			out.println("<tr><td>Phone Number</td><td>"+contactno+"</td></tr>");
			out.println("<tr><td>Message </td><form action='Message'><td><input type='hidden' name='msgto' value='"+username+"'><input type='hidden' name='msgfrom' value='"+user+"' value='"+username+"'><textarea name='msg'value='Enter your message here'></textarea><br><input type='submit' value='send message'></form></td></tr></table>");
			
		}
	
	}
	catch(Exception e)
	{
		out.print(e);
	}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	{
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
	String maker=request.getParameter("maker");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from register where uname='"+maker+"'");
		out.print("");
		out.print("<br><br><br><br><br><br><br>");
		
		while(rs.next())
		{
			String username=rs.getString("uname");
			String gender=rs.getString("gender");
			String sport=rs.getString("play");
			String firstname=rs.getString("fname");
			String lastname=rs.getString("lname");
			String study=rs.getString("study");
			String party=rs.getString("party");	
			String movie=rs.getString("movie");
			String contactno=rs.getString("contactno");
			String email=rs.getString("email");
			String dob=rs.getString("dob");
			if(study.equals("null"))
			{
				study="No";
			}
			else
			{
				study="Yes";
			}
			if(party.equals("null"))
			{
				party="No";
			}
			else
			{
				party="Yes";
			}
			
			if(movie.equals("null"))
			{
				movie="No";
			}
			else
			{
				
				movie="Yes";
			}
			if(sport.equals("null"))
			{
				sport="No";
			} 
			else
			{
				sport="Yes";
			}
			out.println("<h2 align='center'>"+username+"'s Profile<h2>");
			out.println("<h3 align='center'>Personal Details</h3>");
			out.println("<table align='center'><tr><td>Username</td><td>"+username+"</td></tr>");
			out.println("<tr><td>Gender</td><td>"+gender+"</td></tr>");
			out.println("<tr><td>Firstname</td><td>"+firstname+"</td></tr>");
			out.println("<tr><td>Lastname</td><td>"+lastname+"</td></tr>");
			out.println("<tr><td>Date of Birth</td><td>"+dob+"</td></tr><table>");
			out.println("<h3 align='center'>Interests</h3>");
			out.println("<table align='center'><tr><td>Sports</td><td>"+sport+"</td></tr>");
			out.println("<tr><td>Study</td><td>"+study+"</td></tr>");
			out.println("<tr><td>Party</td><td>"+party+"</td></tr>");
			out.println("<tr><td>Movie</td><td>"+movie+"</td></tr></table>");
			out.println("<h3 align='center'>Contact Details</h3>");
			out.println("<table align='center'><tr><td>Email id</td><td>"+email+"</td></tr>");
			out.println("<tr><td>Phone Number</td><td>"+contactno+"</td></tr>");
			out.println("<tr><td>Message </td><form action='Message'><td><input type='hidden' name='msgto' value='"+username+"'><input type='hidden' name='msgfrom' value='"+user+"' value='"+username+"'><textarea name='msg'value='Enter your message here'></textarea><input type='submit' value='send message'></form></td></tr></table>");
			
		}
	
	}
	catch(Exception e)
	{
		out.print(e);
	}
	}

}
}