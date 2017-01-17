package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		try{
			List<WikiPage> list = WikiPageDAO.getInstance().findAll();
			req.setAttribute("list",list);
			req.getRequestDispatcher("/list.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}
