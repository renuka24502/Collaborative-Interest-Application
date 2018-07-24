
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
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
//import Utilities;

public class PostPlay extends HttpServlet 
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
	String maker= request.getParameter("maker");
	String adate=request.getParameter("date");
	String loc=request.getParameter("loc");
	String activity= "play";
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String postdate=date.toString();
	
    DBCollection collection = database.getCollection("activities");
    BasicDBObject document = new BasicDBObject();
    document.put("username", user);
    document.put("activity", activity);
    document.put("sport", maker);
    document.put("postdate", postdate);
    document.put("activitydate", adate);
    document.put("location", loc);

    try {
        collection.insert(document);
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Your Activity for play is shared. If anyone wants you to be your partner they will be able to find you.');");
        out.println("window.location.href = 'Play';");
        out.println("</script>");
    } catch (Exception e) {
        System.out.println(e);
    }

}

}

