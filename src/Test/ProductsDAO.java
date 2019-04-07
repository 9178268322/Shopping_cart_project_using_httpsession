package Test;

import java.sql.*;
import java.util.*;

public class ProductsDAO {
	
	           
				public Collection getProducts() {
				
						
						try {
						        
								Connection con = DBConnection.getCon();
								Statement st = con.createStatement();
								ResultSet rs = st.executeQuery("select * from product");
								ArrayList products = new ArrayList();
								while(rs.next()) {
										Product p = new Product();
										p.code = rs.getString(1);
										p.name = rs.getString(2);
										p.price = rs.getFloat(3);
										p.qty = rs.getInt(4);
										
										products.add(p);
								}
								return products;
								
						} 
						catch(Exception e) {return null;}
						
			  }
}
