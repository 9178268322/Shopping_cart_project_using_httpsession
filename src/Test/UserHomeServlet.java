package Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserHomeServlet extends HttpServlet {
	
				     public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
				    		 											
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
							    	pw.println("<title>Shopping cart Example</title>");
							    	pw.println("</head>");
							    	pw.println("<body>");
							    	pw.println("<table width ='100%' height ='90%' border ='1'>");
							    	pw.println("<tr align ='center'>");
							    	pw.println("<td height ='39' colspan ='2'>");
							    	pw.println("<strong><font size ='5'>MyShopping Site</font></strong>");
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
							    	pw.println("<font size ='6'>Welcome: "+uname+"</font>");
							    	pw.println("</td>");
							    	pw.println("</tr>");
							    	pw.println("<tr align ='center'>");
							    	pw.println("<td colspan ='2'><em>&copy;copyrights 2016-17</em></td>");
							    	pw.println("</tr>");
							    	pw.println("</table>");
							    	pw.println("</body>");
							    	pw.println("</html>");
							    	pw.flush();
							    	pw.close();
				    }
}
