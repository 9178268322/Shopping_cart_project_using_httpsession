package Test;

import java.sql.*;

public class UserDAO {
	
		    public boolean validate(String uname,String pass) {
		    
			    	boolean b = false;
			    	try {
			    	
				    		Connection con = DBConnection.getCon();
				    		PreparedStatement ps = con.prepareStatement("select * from userlogin where uname =? and pword =?");
				    									
				    		//Statement st = con.createStatement();
				    		//ResultSet rs = st.executeQuery("select * from userlogin where uname=\'"+uname+"\'and pword =\'"+pass+"\'");
				    		ps.setString(1,uname);
				    		ps.setString(2,pass);
				    		ResultSet rs = ps.executeQuery();
				    		b = rs.next();
			    	}
			    	catch(Exception e) {e.printStackTrace();}
			    	
			    	return b;
		 }
}
