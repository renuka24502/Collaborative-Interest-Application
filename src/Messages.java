
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
//import Utilities;

public class Messages extends HttpServlet 
{
	final MongoClient mongo = new MongoClient("localhost", 27017);
 	final DB database = mongo.getDB("ReviewsSocial");
        
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
	
        DBCollection collection = database.getCollection("message");
        BasicDBObject query = new BasicDBObject();
        query.put("msgto", user);
        
        DBCursor cursor2=collection.find(query);
        
        out.println("<section style=\"background-image:url(img/post_activity5.jpg);\">");
                
		out.println("<br><br><br><br><br><br><br>");
		out.println("<h3 align='center'>Your Messages</h3>");
                
        while(cursor2.hasNext())
                {       
                    
                    // typecasting obj to JSONObject                   
                    DBObject result= cursor2.next();

                    //this line will convert the DbObject to JSONObject

                    JSONObject json = new JSONObject(JSON.serialize(result));

			String msgfrom=json.getString("msgfrom");
			String msg=json.getString("message");
			
            out.println("<form action='Reply'><table align='center'><tr><td>"+msgfrom+"</b> said <b>'"+msg+"'</td></tr>");
                        
			out.println("<tr><td><textarea name='message' value='Enter message here'></textarea></td></tr>");
			
			out.println("<tr><input type='hidden' name='msgto' value='"+msgfrom+"'><input type='hidden' name='msgfrom' value='"+user+"'><td><input type='submit' value='reply'></td></tr></table></form>");
		}		
		
out.println("<h3 align='center'><a href='MyProfile'>Go Back to your Profile</a></h3>");
out.println("</section>");
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
	
        DBCollection collection = database.getCollection("message");
        BasicDBObject query = new BasicDBObject();
        query.put("msgto", user);
        
        DBCursor cursor2= collection.find(query);
        
                out.print("");
		out.print("<br><br><br><br><br><br><br>");
		out.println("<h3 align='center'>Your Messages</h3>");
                
        while(cursor2.hasNext())
                {       
                    
                    // typecasting obj to JSONObject                   
                    DBObject result= cursor2.next();

                    //this line will convert the DbObject to JSONObject

                    JSONObject json = new JSONObject(JSON.serialize(result));

			String msgfrom=json.getString("msgfrom");
			String msg=json.getString("message");
			
                        out.println("<form action='Reply'><table align='center'><tr><td>"+msgfrom+"</b> said <b>'"+msg+"'</td></tr>");
			out.println("<tr><td><textarea name='message' value='Enter message here'></textarea></td></tr>");
			out.println("<tr><input type='hidden' name='msgto' value='"+msgfrom+"'><input type='hidden' name='msgfrom' value='"+user+"'><td><input type='submit' value='reply'></td></tr></table></form>");
		}		
		
        out.println("<h3 align='center'><a href='MyProfile'>Go Back to your Profile</a></h3>");
	}
}