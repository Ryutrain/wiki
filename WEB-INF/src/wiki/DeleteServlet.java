import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet{
	DeleteExecuter DE=new DeleteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		String name = req.getParameter("name");
		String delete_key = req.getParameter("delete_key");
		if(delete_key.length()==0){
			delete_key=" ";
		}
		
		DeleteBean db = new DeleteBean();
		//DeleteBeanに各入力項目を代入
		try{
			db.setPost_number(Integer.parseInt(name));
		}catch(NumberFormatException e){
			db.setPost_number(0);
		}
		db.setDelete_key(delete_key);
		//削除パスの ' を '' に変換する
		CheckReplace cr = new CheckReplace();
		db = cr.check(db);
		//DeleteExecuterのexecuteを呼び出し、コメントの削除を試みる。結果はBooleanで返される
		Boolean b = (Boolean) DE.execute(db);
		
		String result;
		if(b){
			result="コメントの削除に成功しました。";
		}else{
			result="コメントの削除に失敗しました。";
		}
		System.out.println(result);//テスト用メッセージ
		
		req.setAttribute("result",result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req,res);
		
	}
}