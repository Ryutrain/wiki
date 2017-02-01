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
		//DeleteBean�Ɋe���͍��ڂ���
		try{
			db.setPost_number(Integer.parseInt(name));
		}catch(NumberFormatException e){
			db.setPost_number(0);
		}
		db.setDelete_key(delete_key);
		//�폜�p�X�� ' �� '' �ɕϊ�����
		CheckReplace cr = new CheckReplace();
		db = cr.check(db);
		//DeleteExecuter��execute���Ăяo���A�R�����g�̍폜�����݂�B���ʂ�Boolean�ŕԂ����
		Boolean b = (Boolean) DE.execute(db);
		
		String result;
		if(b){
			result="�R�����g�̍폜�ɐ������܂����B";
		}else{
			result="�R�����g�̍폜�Ɏ��s���܂����B";
		}
		System.out.println(result);//�e�X�g�p���b�Z�[�W
		
		req.setAttribute("result",result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req,res);
		
	}
}