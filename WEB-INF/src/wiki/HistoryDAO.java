package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;

public class HistoryDAO{

	//ResultSetの１行をWikiPageのインスタンスに変換するクラス
	//ここでしか利用されないので、
	//無名クラスとして、この場所でインスタンス化します。
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
	
	//このクラスのインスタンスを取得します。
	public static HistoryDAO getInstance(){
		return new HistoryDAO();
	}
	
	//全件検索を行います。
	//戻り値はWikiPageオブジェクトのListです。

				
	public List<WikiPage> historyAll() throws SQLException{
		String sql = "SELECT name,update_time,ip FROM wiki_history"
						+" WHERE delete_flag='0'"
						+" ORDER BY update_time DESC";
		//System.out.println(sql);
		return DBManager.simpleFind(sql,allMapping);
	}
	//指定した名前に一致するレコードを検索します。
}
	