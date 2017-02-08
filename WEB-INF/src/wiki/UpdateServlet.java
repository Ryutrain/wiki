package wiki;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import check.*;

public class UpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		String cmd = req.getParameter("cmd");
		
		
		
		try{
			req.setCharacterEncoding("Windows-31J");
			//String ipaddress = InetAddress.getLocalHost().getHostAddress();
			String ipaddress = req.getRemoteAddr();

			WikiPage wikiPage = new WikiPage();
			wikiPage.setName(name);
			wikiPage.setContent(content);
			wikiPage.setIpaddress(ipaddress);
			
			System.out.println(ipaddress);
			
			
			
			if(cmd.equals("update")){
				WikiPageDAO.getInstance().update(wikiPage);
				RequestUtils.setMessage(req,name+"を更新");
				req.getRequestDispatcher("/list")
				.forward(req,res);
			}else if(cmd.equals("delete")){
				String delete_key = req.getParameter("delete_key");
				wikiPage.setDelete_Key(delete_key);
				
				if(delete_key.length()==0){
					delete_key=" ";
				}
				DeleteExecuter DE=new DeleteExecuter();
				CheckReplace cr = new CheckReplace();
				wikiPage = cr.check(wikiPage);
				Boolean b = (Boolean) DE.execute(wikiPage);
				if(b){
					WikiPageDAO.getInstance().delete(wikiPage);
					RequestUtils.setMessage(req,name+"を削除");
					req.getRequestDispatcher("/list")
					.forward(req,res);
				}else{
					RequestUtils.setMessage(req,"削除パスが違います");
					req.getRequestDispatcher("/refer")
					.forward(req,res);
				}
			}else{
				req.getRequestDispatcher("/refer")
				.forward(req,res);
			}
		}catch(SQLException e){
			throw new ServletException(e);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
