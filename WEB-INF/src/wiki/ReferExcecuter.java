package wiki;

import java.util.ArrayList;
import fw.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReferExcecuter extends Executer{
	
	public Object execute(Object o){
		
		Boolean result = false;
		
		WikiPage wp = (WikiPage)o;
		String name = wp.getName();
		
		
		System.out.println(name);//test
		//postedDKey�ɂ̓t�H�[���œ��͂��ꂽ�폜�p�X�̕���������
		String DBN = "";
		//DBDKey�ɂ̓f�[�^�x�[�X�ɕۑ�����Ă���폜�p�X�i�w�肳�ꂽ�R�����g�ԍ��̂��́j������
		//wp�ɐڑ�
		accessor.getConnection();
		//�R�����g���擾----------------------------------------------------------------------
		String sql = "SELECT name FROM wiki_page WHERE name = '"+wp.getName()+"' AND Delete_flag = '0'";
		//System.out.println(sql);//test
		try{
			ResultSet rs = accessor.Update(sql);//��O
			rs.next();
			DBN = rs.getString("name");
			//System.out.println("���� = "+rs.getString("name"));//test
		//--------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("SQLException");
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		}
		
		if(name.equals(DBN)){
			//postedDKey��DBDKey�̓��e�����v�����Ȃ�폜�t���O�𗧂Ă�i�\�����Ȃ�������ReadExecuter�ōs����j
			System.out.println("���v�A�폜�������s");//test
			
			//WikiPageDAO.getInstance().delete(wikiPage);
			/*sql = "UPDATE Contents SET delete_flag = 1 WHERE post_number = ";
			sql = sql.concat(post_number.toString());
			System.out.println("�폜�����F"+sql);//test
			accessor.write(sql);*/
			
			result = true;
		}else{
			//�������Ȃ�
		}
		//wp����ؒf
		accessor.close();
		
		return result;
	}
	
}