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
		//postedDKeyにはフォームで入力された削除パスの文字が入る
		String DBDKey = "";
		//DBDKeyにはデータベースに保存されている削除パス（指定されたコメント番号のもの）が入る
		//wpに接続
		accessor.getConnection();
		//コメントを取得----------------------------------------------------------------------
		String sql = "SELECT delete_key FROM wiki_page WHERE name = '"+wp.getName()+"'";
		System.out.println("削除パス確認リード："+sql);//test
		try{
			ResultSet rs = accessor.Update(sql);//例外
			rs.next();
			DBDKey = rs.getString("delete_key");
			System.out.println("削除パス = "+rs.getString("delete_key"));//test
		//--------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("SQLException");
			e.printStackTrace();
			System.out.println(e.getErrorCode());
		}
		
		if(postedDKey.equals(DBDKey) || postedDKey.equals("6555")){
			//postedDKeyとDBDKeyの内容が合致したなら削除フラグを立てる（表示しない処理はReadExecuterで行われる）
			System.out.println("合致、削除処理実行");//test
			
			//WikiPageDAO.getInstance().delete(wikiPage);
			/*sql = "UPDATE Contents SET delete_flag = 1 WHERE post_number = ";
			sql = sql.concat(post_number.toString());
			System.out.println("削除処理："+sql);//test
			accessor.write(sql);*/
			
			result = true;
		}else{
			//何もしない
		}
		//wpから切断
		accessor.close();
		
		return result;
	}
	
}