package Users;

import java.util.*;
import java.io.*;
import java.util.HashMap;

public class ClsUser implements java.io.Serializable{
	
	public String userName;
	public String firstName;
	public String lastName;
	public String emailId;
	public String password;
	

		public ClsUser(String userName, String firstName, String lastName, String emailId, String password){
	
	
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.password=password;
	
	}
	
	public ClsUser()
	{
		
	}
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String emailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	
}