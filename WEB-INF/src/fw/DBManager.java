package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager{
	public static Connection getConnection(){
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost","sa","");
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}
	
	public static int simpleUpdate(String sql) throws SQLException{
		Connection con = null;
		Statement smt = null;
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			return smt.executeUpdate(sql);
		}finally{
			if(smt != null){
				try{
					smt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}

	
	
	
	public  static <T> List simpleFind(String sql,ResultSetBeanMapping<T> mapping)
	 throws SQLException{
		Connection con = null;
		Statement smt = null;
		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			
			List list = new ArrayList();
			
			while(rs.next()){
				Object bean = mapping.createFromResultSet(rs);
				
				list.add(bean);
			}
			
			return list;
		}finally{
			if(smt != null){
				try{
					smt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}
	
					