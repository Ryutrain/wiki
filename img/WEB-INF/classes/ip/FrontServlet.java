package ip;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Front extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			
			req.setCharaterEncoding("Windows-31J");
			
			RequestContext rc = new WebRequestContext();
		}
}