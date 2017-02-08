package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;

public class HistoryDAO{

	//ResultSet�̂P�s��WikiPage�̃C���X�^���X�ɕϊ�����N���X
	//�����ł������p����Ȃ��̂ŁA
	//�����N���X�Ƃ��āA���̏ꏊ�ŃC���X�^���X�����܂��B
	private ResultSetBeanMapping<WikiPage> allMapping =
			new ResultSetBeanMapping<WikiPage>(){
		
		public WikiPage createFromResultSet(ResultSet rs)
			throws SQLException{
			
					
					WikiPage page = new WikiPage();
					
					page.setName(rs.getString("name"));
					page.setUpdateTime(rs.getTimestamp("update_time"));
					page.setIpaddress(rs.getString("ip"));
					
					return page;
		}
	};
	
	//���̃N���X�̃C���X�^���X���擾���܂��B
	public static HistoryDAO getInstance(){
		return new HistoryDAO();
	}
	
	//�S���������s���܂��B
	//�߂�l��WikiPage�I�u�W�F�N�g��List�ł��B

				
	public List<WikiPage> historyAll() throws SQLException{
		String sql = "SELECT name,update_time,ip FROM wiki_history"
						+" WHERE delete_flag='0'"
						+" ORDER BY update_time DESC";
		//System.out.println(sql);
		return DBManager.simpleFind(sql,allMapping);
	}
	//�w�肵�����O�Ɉ�v���郌�R�[�h���������܂��B
}
	