package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductsServlet extends HttpServlet {
	
				     public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException {
				    		                                     
								  HttpSession hs = req.getSession(false);
								  
								  if(hs==null) {
									     RequestDispatcher rd = req.getRequestDispatcher("Login.html");
									     rd.forward(req,res);
									     return;
								  }
								  
								  String uname = (String)hs.getAttribute("UserName");	
								  ArrayList products =(ArrayList)hs.getAttribute("products");
								  if(products==null) {
										  products = new ArrayList();
										  hs.setAttribute("products",products);
								  }
								  
								  String [] pcodes = req.getParameterValues("products");
								  for(int i=0;i<pcodes.length;i++) {
										  if(req.getParameter(pcodes[i]).equals(""))
											     continue;
										  Product p = new Product();
										  p.code = pcodes[i];
										  int j = products.indexOf(p);
										  
										  if(j!=-1) {
												  p =(Product)products.get(j);
												  p.qty+=Integer.parseInt(req.getParameter(pcodes[i]));
										  }
										  else {
												  p.name = req.getParameter(pcodes[i]+"Name");
												  p.qty = Integer.parseInt(req.getParameter(pcodes[i]));
												  products.add(p);
										  }
								  } // end of for
								  
								  res.setContentType("text/html");
								  PrintWriter pw = res.getWriter();
								  pw.println("<html>");
								  pw.println("<head>");
								  pw.println("<title>Shopping cart Example</title>");
								  pw.println("</head>");
								  pw.println("</html>");
								  pw.println("<table width ='100%' height ='90%' border'1'>");
							      pw.println("<tr align ='center'>");
							      pw.println("<td height ='39' colspan ='2'><strong><font size ='5'>MyShopping site</font></strong></td>");
							      pw.println("</tr>");
							      pw.println("<tr>");
							      pw.println("<td width ='18%' height ='500' valign ='top'><p>&nbsp;</p>");
							      pw.println("<blockquote>");
							      pw.println("<p><a href ='"+res.encodeURL("getProducts")+"'>View products</a></p>");
							      pw.println("<p><a href = '"+res.encodeURL("getCart")+"'>View Cart Details</a></p>");
							      pw.println("<p><a href ='"+res.encodeURL("logout")+"'>Logout</a></p>");
							      pw.println("</blockquote>");
							      pw.println("</td>");
							      pw.println("<td width ='82%' align ='left' valign ='top'>");
							      pw.println("<p><font size ='6'>Welcome:"+uname+"</font></p>");
							      pw.println("Product Added Successfully to your cart");
							      pw.println("</td>");
							      pw.println("</tr>");
							      pw.println("<tr align ='center'>");
							      pw.println("<td colspan ='2'><em>&copy;copyrights 2016-17</em></td>");
							      pw.println("</tr>");
							      pw.println("</table>");
							      pw.println("</body></html>");
							      pw.flush();
							      pw.close();
						  
					}

}
