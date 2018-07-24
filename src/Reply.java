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

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

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

public class Reply extends HttpServlet 
{
	int i;
	public static MongoClient mongo = new MongoClient("localhost", 27017);
 	public static DB database = mongo.getDB("ReviewsSocial");
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
	String msgto=request.getParameter("msgto");
	String msgfrom=request.getParameter("msgfrom");
	String message=request.getParameter("message");
	
	DBCollection collection = database.getCollection("message");
    BasicDBObject document = new BasicDBObject();
document.put("msgto", msgto);
document.put("msgfrom", msgfrom);
    document.put("message", message);
    
    collection.insert(document);
			
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Your Message has been send.');");  
				out.println("window.location.href = 'Messages';");
				out.println("</script>");
			

	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	
		HttpSession session = request.getSession();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String user=(String) session.getAttribute("username");
	//session.setAttribute("usernew", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,out);
	utility.printHtml("header.html");
	String msgto=request.getParameter("msgto");
	String msgfrom=request.getParameter("msgfrom");
	String message=request.getParameter("msg");
	
	DBCollection collection = database.getCollection("message");
    BasicDBObject document = new BasicDBObject();
document.put("msgto", msgto);
document.put("msgfrom", msgfrom);
    document.put("message", message);
    
    collection.insert(document);
			
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Your Message has been send.');");  
				out.println("window.location.href = 'Messages';");
				out.println("</script>");

	}

}
