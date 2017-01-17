package ipip;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			req.setCharacterEncoding("Windows-31J");
			
			RequestContext rc = new WebRequestContext();
			re.setRequest(req);
			
			AbstractCommand command = CommandFactory.getCommand(rc);
			
			command init(rc);
			
			ResponseContext resc=command.execute();
			
			Object bean=resc.getResult();
			
			req.setAttribute("data",bean);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher(resc.getTarget());
			
			dispatcher.forward(req,res);
		}
}