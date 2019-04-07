package Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
	
		   public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {

			   PrintWriter pw = res.getWriter();
			   res.setContentType("text/html");
			   HttpSession hs = req.getSession(false);
			   if(hs!=null) {
			   
					   hs.invalidate();
					   pw.println("<html><body><center>");
					   pw.println("<h1>You are successfull logout</h1>");
					   pw.println("<a href ='Login.html'>Click here to Login</a>");
					   pw.println("</center></body></html>");
					   
					   
					  // RequestDispatcher rd = req.getRequestDispatcher("Login.html");
					   //rd.forward(req,res);
			   }
		   }
}
