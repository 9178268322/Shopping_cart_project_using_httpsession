package Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class GetProductsServlet extends HttpServlet {
	
				ProductsDAO productsdao;
				public void init() {
				             productsdao = new ProductsDAO();	
				}
				
				public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
															
							HttpSession hs = req.getSession(false);
					    	if(hs==null) {  
					    	
						    		 RequestDispatcher rd = req.getRequestDispatcher("Login.html");
						    	     rd.forward(req,res);
						    	     return;
					    	}
		                    			
					    	String uname = (String)hs.getAttribute("UserName");
					    	res.setContentType("text/html");
					    	PrintWriter pw = res.getWriter();
					       	pw.println("<html>");
					       	pw.println("<head>");
					    	pw.println("<title>My Shopping Cart</title>");
					    	pw.println("</head>");
					    	pw.println("<body>");
					    	pw.println("<table width ='100%' height ='90%' border ='1'>");
					    	pw.println("<tr align ='center'>");
					    	pw.println("<td height ='39' colspan ='2'><strong><font size ='5'>MyShopping Cart</font></strong></td>");
					    	pw.println("</tr>");
					    	pw.println("<tr>");
					    	pw.println("<td width ='18%' height ='500' valign ='top'>");
					    	pw.println("<p>&nbsp;</p>");
					    	pw.println("<blockquote>");
					    	pw.println("<p><a href ='"+res.encodeURL("getProducts")+"'>View products</a></p>");
					    	pw.println("<p><a href = '"+res.encodeURL("getCart")+"'>View Cart Details</a></p>");
					    	pw.println("<p><a href ='"+res.encodeURL("logout")+"'>Logout</a></p>");
					    	pw.println("</blockquote>");
					    	pw.println("</td>");
					    	pw.println("<td width ='82%' align ='left' valign ='top'>");
					    	pw.println("<p><font size ='6'>Welcome: "+uname+"</font></p>");
					    	pw.println("<form method ='post' action ='"+res.encodeURL("addProducts")+"'>");
					    	pw.println("<table width ='100%' border ='1'>");
					    	pw.println("<tr>");
					    	pw.println("<th width ='8%'>check</th>");
					    	pw.println("<th width ='24%'>Product Code</th>");
					    	pw.println("<th width ='28%'>Product Name</th>");
					    	pw.println("<th width ='20%'>Available Quantity</th>");
					    	pw.println("<th width ='20%'>Required Quantity</th>");
					    	pw.println("</tr>");
					    	
					    	Collection products = productsdao.getProducts();
					    	if(products == null) {
					    	
						    		pw.println("<tr><td colspan ='5' align ='center'></td></tr>");
						    		pw.println("No Products Available");
					    	}
					    	else {
					    	
						    		Iterator ir = products.iterator();
						    		while(ir.hasNext()) {
							    			Product p =(Product)ir.next();
							    			pw.println("<tr>");
							    			pw.println("<td align ='center'>");
							    			pw.println("<input type ='checkbox' name ='products' value ='"+p.getCode()+"'/>");
							    			pw.println("<input type ='hidden' name='"+p.getCode()+"Name' value ='"+p.getName()+"'/>");
							    			pw.println("</td>");
							    			pw.println("<td>"+p.getCode()+"</td>");
							    			pw.println("<td>"+p.getName()+"</td>");
							    			pw.println("<td>"+p.getQty()+"</td>");
							    		    pw.println("<td><input type ='text' name ='"+p.getCode()+"'/></td>");
							    		    pw.println("</tr>");
						    		}
					    	}
					    	pw.println("</table>");
					    	pw.println("<br/><center>");
					    	pw.println("<input type ='submit' value='Add Products To Cart'>");
					    	pw.println("</center>");
					    	pw.println("</form>");
					    	pw.println("</td></tr>");
					    	pw.println("<tr align ='center'>");
					    	pw.println("<td colspan ='2'>");
					    	pw.println("<em>&copy:CopyRights 2016-17</em></td>");
					    	pw.println("</tr>");
					    	pw.println("</table>");
					    	pw.println("</body></html>");
					    	pw.flush();
					    	pw.close();
				}
				

}
