
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import org.json.JSONObject;

import java.util.HashMap;

public class MySqlDataStoreUtilities
{
	
	public static MongoClient mongo = new MongoClient("localhost", 27017);
	public static DB database = mongo.getDB("ReviewsSocial");
	
	public boolean checkRent(String username,String productname)
	    {
	       
	               
	            DBCollection collection = database.getCollection("RentNlikeProdUserUpdate");
	    		BasicDBObject query = new BasicDBObject();
	                BasicDBObject query2 = new BasicDBObject();
	    		
	    		query2.put("rent", 1);
	    		query.put("uname",username);
	    		query.put("productname",productname);
	    		DBCursor cursor2= collection.find(query,query2);
		        if(cursor2.hasNext())    
		            return true;
		        else
		            return false;
	         
	    }
		
		public boolean insertRent(String productname,String username)
	    {
	        DBCollection collection = database.getCollection("RentNlikeProdUserUpdate");
	        BasicDBObject document = new BasicDBObject();
		document.put("uname", username);
		document.put("productname", productname);
	        document.put("rent", 1);
		document.put("likes", 0);
		                        
	                try {
	                    collection.insert(document);
	                }
	                catch (Exception E)
	                {
	                    return false;
	                }
	                return true;
	    }    		

	

		
	public boolean checkLike(String username,String productname)
	    {
	         
	             DBCollection collection = database.getCollection("RentNlikeProdUserUpdate");
	             BasicDBObject query = new BasicDBObject();
	                        BasicDBObject query2 = new BasicDBObject();
	            
	             query2.put("likes", 1);
	             query.put("uname",username);
	             query.put("productname",productname);
	            
	             DBCursor cursor2= collection.find(query,query2);
	                if(cursor2.hasNext())    
	                    return true;
	                else
	                    return false;
	                
	      }

    public boolean insertliked(String productname,String username)
	    {
        DBCollection collection = database.getCollection("RentNlikeProdUserUpdate");
        BasicDBObject document = new BasicDBObject();
	document.put("uname", username);
	document.put("productname", productname);
        document.put("rent", 0);
	document.put("likes", 1);
	                        
                try {
                    collection.insert(document);
                }
                catch (Exception E)
                {
                    return false;
                }
                return true;
    }
	
	
	
	
	public boolean ProductLikeUpdate(String productid)
	    {
		  DBCollection collection = database.getCollection("AllProducts");
	        BasicDBObject query2 = new BasicDBObject();
	        query2.append("$inc", new BasicDBObject().append("likes", 1));

		BasicDBObject searchQuery = new BasicDBObject().append("productcode",productid);

	        try {
		collection.update(searchQuery, query2);
	        }
	        catch (Exception E) {
	            return false;
	        }
	        return true;
	    }				
			
	public boolean Loaddata(Map<String,List<String>> mymap)
    {
     int count=0;
            for (Map.Entry<String, List<String>> entry : mymap.entrySet()) 
       		 {
       	            String key1productcode = entry.getKey();
       	            int k=0;
       	           List<String> values = entry.getValue();
       	           String category=values.get(k);
       	           String productname=values.get(k+1);
       	           String rentalprice=values.get(k+2);
                   String description=values.get(k+3);
    	           Integer quantity=Integer.parseInt(values.get(k+4));
    	          
    	           
       	           
       	         DBCollection collection = database.getCollection("productsxml");
       	         BasicDBObject document = new BasicDBObject();
       	                
       	         document.put("category",category);
       	         document.put("productcode",key1productcode);
       	         document.put("productname",productname);
       	         document.put("rentalprice",rentalprice);
       	         document.put("description",description);
       	         document.put("quantity",quantity);
       		                        
       	         collection.insert(document);
       	              count++;
       	               
       		 }
            if (count>0)
            	return true;
            else
			return false; 
       	  } 
    
	
	
	 public List<List> Fetchproductlist() 
	 {
        List<List> CategoryItems = new ArrayList<List>();
           
        try {
        	 DBCollection collection = database.getCollection("productsxml");
     		BasicDBObject query = new BasicDBObject();
     		BasicDBObject query1 = new BasicDBObject();
                 
     		query.put("productcode", 1);
                 query.put("productname", 1);
                 query.put("rentalprice", 1);
                 query.put("description", 1);
                 query.put("quantity", 1);
     		
     		DBCursor cursor2= collection.find(query1,query);
              int count2=-1;
              
            
              
            while(cursor2.hasNext())
            {   
            	 // typecasting obj to JSONObject
                
                DBObject result= cursor2.next();

				//this line will convert the DbObject to JSONObject
				
				JSONObject json = new JSONObject(JSON.serialize(result));

				String productcode = json.getString( "productcode" );
				String productname = json.getString( "productname" );
				String rentalprice = json.getString("rentalprice");
				String description = json.getString("description");
				int quantity = json.getInt("quantity");
                
                count2++;
                ArrayList CatItems = new ArrayList();

                 CatItems.add(0, productname);
                 CatItems.add(1, productcode);
                 CatItems.add(2, rentalprice);
                 CatItems.add(3, description);
                 CatItems.add(4, quantity);
                
                
                CategoryItems.add(CatItems);
                
            }
           
  
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        return CategoryItems;
    }
    
    
}