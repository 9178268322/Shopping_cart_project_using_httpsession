package Test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetCartDetailsServlet extends HttpServlet {
	
			 public void doGet(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException {
					                                
						 HttpSession hs = req.getSession(false);
						
						 if(hs==null) {
						  
							     RequestDispatcher rd = req.getRequestDispatcher("Login.html");
							     rd.forward(req,res);
							     return;
						 }
						 
						 String uname = (String)hs.getAttribute("UserName");
						 PrintWriter pw = res.getWriter();
						 res.setContentType("text/html");
						 
						 pw.println("<html><head>");
						 pw.println("<title>Shopping Cart</title>");
					     pw.println("</head><body>");
					   	 pw.println("<table width ='100%' height ='90%' border'1'>");
					   	 pw.println("<tr align ='center'>");
					   	 pw.println("<td height ='39' colspan ='2'><strong><font size ='5'>MyShopping Site</font></strong></td>");
					   	 pw.println("</tr>");
				    	 pw.println("<tr>");
				    	 pw.println("<td width ='18%' height ='500' valign ='top'><p>&nbsp;</p>");
				    	 pw.println("<blockquote><p>");
				    	 pw.println("<a href ='"+res.encodeURL("getProducts")+"'>View products</a>");
				    	 pw.println("</p><p>");
					   	 pw.println("<a href = '"+res.encodeURL("getCart")+"'>View Cart Details</a>");
					   	 pw.println("</p>");
					   	 pw.println("<a href ='"+res.encodeURL("logout")+"'>Logout</a>");
					   	 pw.println("</p>");
				    	 pw.println("</blockquote></td>");
				    	 pw.println("<td width ='82%' align ='left' valign ='top'><p>");
				    	 pw.println("<font size ='6'>Welcome: "+uname+"</font></p>");
				    	 pw.println("<center>Your cart contains the following products");
				    	 pw.println("<table width ='80%' border ='1'>");
					     pw.println("<tr>");
					   	 pw.println("<th width ='24%'>Product Code</th>");
					   	 pw.println("<th width ='28%'>Product Name</th>");
					   	 pw.println("<th width ='20%'>Quantity</th>");
					   	 pw.println("</tr>");
					    	
				    	 Collection products = (Collection)hs.getAttribute("products");
				    	 if(products == null) {
					    	
					    		pw.println("<tr><td colspan ='3' align ='center'>");
					    		pw.println("You have not added any products into cart");
					    		pw.println("</td></tr>");
					    }
					    else {
					    	
					    		Iterator ir = products.iterator();
					    		while(ir.hasNext()) {
					    		
						    			Product p = (Product)ir.next();
						    			pw.println("<tr>");
						    			pw.println("<td>"+p.getCode()+"</td>");
						    			pw.println("<td>"+p.getName()+"</td>");
						    			pw.println("<td>"+p.getQty()+"</td>");
						    			pw.println("</tr>");
					    		}
					   	}
					    	   pw.println("</table></center>");
					    	   pw.println("</td></tr>");
						       pw.println("<tr align ='center'>");
						       pw.println("<td colspan ='2'><em>&copy;copyrights 2016-17</em></td>");
						       pw.println("</tr>");
						       pw.println("</table>");
						       pw.println("</body></html>");
						       pw.flush();
						       pw.close();
			 }

}
