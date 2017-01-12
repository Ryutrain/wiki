package wiki;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		req.setCharacterEncoding("Windows-31J");
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		/*try {
    		  byte[] byteData1 = name.getBytes("ISO-8859");
    		  byte[] byteData2 = content.getBytes("ISO-8859-2");
    		  name = new String(byteData1, "Windows-31J");
    		  content = new String(byteData2, "Shift_JIS");
    	}catch(UnsupportedEncodingException e){
     		 System.out.println(e);
		}*/
		System.out.println(name+" "+content);
		
		try{
			//ipアドレスを取得
			//String ipaddress = InetAddress.getLocalHost().getHostAddress();
			//String ipaddress = req.getRemoteAddr();
			String ipaddress = req.getRemoteHost();
			
			
			
			WikiPage wikiPage= new WikiPage();
			wikiPage.setName(name);
			wikiPage.setContent(content);
			
			//ipアドレスをセット！！！！！！！！！！
			wikiPage.setIpaddress(ipaddress);
			
			
			WikiPageDAO.getInstance().insert(wikiPage);
			RequestUtils.setMessage(req,name+"を作成");
			
			
			req.getRequestDispatcher("/refer.jsp").forward(req,res);
		}catch(SQLException e){
			throw new ServletException(e);
		}catch(UnknownHostException e){
			throw new ServletException(e);
	}
}
}
