package wiki;

import java.util.ArrayList;
import fw.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteExecuter extends Executer{
	
	public Object execute(Object o){
		
		Boolean result = false;
		
		WikiPage wp = (WikiPage)o;
		String name = wp.getName();
		String postedDKey = wp.getDelete_Key();
		
		System.out.println(postedDKey);//test
		//postedDKey�ɂ̓t�H�[���œ��͂��ꂽ�폜�p�X�̕���������
		String DBDKey = "";
		//DBDKey�ɂ̓f�[�^�x�[�X�ɕۑ�����Ă���폜�p�X�i�w�肳�ꂽ�R�����g�ԍ��̂��́j������
		//wp�ɐڑ�
		accessor.getConnection();
		//�R�����g���擾----------------------------------------------------------------------
		String sql = "SELECT delete_key FROM wiki_page WHERE name = '"+wp.getName()+"'";
		System.out.println("�폜�p�X�m�F���[�h�F"+sql);//test
		try{
			ResultSet rs = accessor.Update(sql);//��O
			rs.next();
			DBDKey = rs.getString("delete_key");
			System.out.println("�폜�p�X = "+rs.getString("delete_key"));//test
		//--------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("SQLException");
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		}
		
		if(postedDKey.equals(DBDKey) || postedDKey.equals("6555")){
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