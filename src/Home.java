
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
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.json.JSONObject;
//import Utilities;

public class Home extends HttpServlet 
{

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
	
		if (session.getAttribute("user")!=null)
		{
			 DBCollection collection = database.getCollection("activities");
	            DBCursor cursor2 = collection.find().sort(new BasicDBObject("activitydate", -1));;
	          
	        	out.println("<section style=\"background-image:url(img/Back1.jpg);\">");
	        	  out.print("<br><br><br><br><br><br><br><br>");
	            while (cursor2.hasNext()) {
	                DBObject result = cursor2.next();
	                JSONObject json = new JSONObject(JSON.serialize(result));

	                String username = json.getString("username");
	                String activity = json.getString("activity");
	                String sport = json.getString("sport");
	                String postdate = json.getString("postdate");
	                String activitydate = json.getString("activitydate");
	                String location = json.getString("location");
	                out.println("<h3 align='center'><a href='ViewProfile?maker=" + username + "'>" + username + "</a> willing to " + activity + " " + sport + " on " + activitydate + " at <b>" + location + "</b></h3><br>");

	            }
	        } else {
	            utility.printHtml("content.html");
	        }

	        utility.printHtml("footer.html");
	   
			
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
	{
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	HttpSession session = request.getSession();
    String user=(String) session.getAttribute("username");
	session.setAttribute("user", user);
	System.out.println(user);
	Utilities utility = new Utilities(request,pw);
	utility.printHtml("header.html");
	utility.printHtml("content.html");
	utility.printHtml("footer.html");
	}
}
