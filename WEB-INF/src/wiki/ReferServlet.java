package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import check.*;

public class ReferServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		String name = req.getParameter("name");
		
		try{
			if(name != null){
				
				WikiPage wikiPage = WikiPageDAO.getInstance().findByName(name);
				ReferExcecuter RE=new ReferExcecuter();
				CheckReplace cr = new CheckReplace();
				WikiPage wikiPage2 = cr.check(wikiPage);
				Boolean b = (Boolean) RE.execute(wikiPage2);
				if(b){
					HttpSession session = req.getSession();
					session.setAttribute("wikiPage",wikiPage);
					req.getRequestDispatcher("/refer.jsp").forward(req,res);
				}else{
					req.getRequestDispatcher("/NotContents.jsp").forward(req,res);
				}
			}
			
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}
