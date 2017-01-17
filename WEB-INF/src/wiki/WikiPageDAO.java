package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;

public class WikiPageDAO{

	//ResultSetの１行をWikiPageのインスタンスに変換するクラス
	//ここでしか利用されないので、
	//無名クラスとして、この場所でインスタンス化します。
	private ResultSetBeanMapping<WikiPage> allMapping =
			new ResultSetBeanMapping<WikiPage>(){
		
		public WikiPage createFromResultSet(ResultSet rs)
			throws SQLException{
			
			WikiPage page = new WikiPage();
			page.setName(rs.getString("name"));
			page.setContent(rs.getString("content"));
			page.setUpdateTime(rs.getTimestamp("update_time"));
			page.setIpaddress(rs.getString("ip"));
			return page;
			}
		};
	
	//このクラスのインスタンスを取得します。
	public static WikiPageDAO getInstance(){
		return new WikiPageDAO();
	}
	
	//全件検索を行います。
	//戻り値はWikiPageオブジェクトのListです。
	public List<WikiPage> findAll() throws SQLException{
		String sql = "SELECT * FROM wiki_page"
						+" WHERE delete_flag='0'";
						+" ORDER BY update_time DESC";
		return DBManager.simpleFind(sql,allMapping);
	}
	
	//指定した名前に一致するレコードを検索します。
	
	public WikiPage findByName(String name) throws SQLException{
		String sql = "SELECT * FROM wiki_page"
						+" WHERE name='"+ name + "'"
						+"AND delete_flag='0'";
		
		List<WikiPage> list = DBManager.simpleFind(sql,allMapping);
		if(list.size()==0){
			return null;
		}else if(list.size() > 1){
			throw new IllegalArgumentException("record > 1");
		}
		
		return list.get(0);
	}
	
	//指定したWikiPageを元にINSERTを実行します。
	public void insert(WikiPage page) throws SQLException{
		System.out.println(page.getIpaddress());
		String sql = //"INSERT INTO wiki_page(name,content)"
				   "INSERT INTO wiki_page(name,content,ip,delete_flag)"
						+ " VALUES("
						+ "'" + page.getName() + "'"
						+ ",'" + page.getContent() + "'"
						+ ",'" + page.getIpaddress() + "'"
						+ ",'0'"
						+ ")";
		System.out.println(sql);
		DBManager.simpleUpdate(sql);
	}
	
	//指定したWikiPageを元にUPDATEを実行します。
	public void update(WikiPage page) throws SQLException{
		String sql = "UPDATE wiki_page"
						+ " SET "
						+ " content='" + page.getContent() + "'"
						+ ",ip='" + page.getIpaddress() + "'"
						+ " WHERE name = '" + page.getName() + "'";
		DBManager.simpleUpdate(sql);
	}
	
		//指定したWikiPageを元にDELETEを実行します。(非推奨)
	public void delete(WikiPage page) throws SQLException{
		String sql = "UPDATE wiki_page"
						+ " SET "
						+ " delete_flag='1'"
						+ " WHERE name = '" + page.getName() + "'";
		DBManager.simpleUpdate(sql);
		
		/*String sql = "DELETE FROM wiki_page WHERE name= '"
						+ page.getName() + "'";
		DBManager.simpleUpdate(sql);*/
	}
}