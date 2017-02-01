package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoryListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		try{
			List<WikiPage> list = HistoryDAO.getInstance().historyAll();
			req.setAttribute("historylist",list);
			req.getRequestDispatcher("/historylist.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}
