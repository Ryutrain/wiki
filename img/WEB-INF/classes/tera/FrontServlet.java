package tera;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontServlet extends javax.servlet.http.HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		
			doPost(req,res);
			
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException, ServletException{
			
			req.setCharacterEncoding("Windows-31J");
			
			Map data = req.getParameterMap();
			
			String path = req.getServletPath();
			AbstractCommand command = CommandFactory.getCommand(path);
			
			command.init(data);
			
			String url = command.execute();
			
			Object result = command.getResult();
			req.setAttribute("result", result);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(url);
			
			dispatcher.forward(req,res);
		}
}