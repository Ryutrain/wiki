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

	
	public static ResultSet Update(String sql) throws SQLException{
		try{
			Connection con = DBManager.getConnection();;
			System.out.println("ÇËÅ[Ç«");
			
			
			Statement st = con.createStatement();
			
			System.out.println(sql);
			
			ResultSet rs = st.executeQuery(sql);
			return rs;
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:Update() SQLException");
			e.printStackTrace();
			
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:Update() Exception");
		}
		return null;
	}
	
	public void close(){
		try{
			Connection con = null;
			con.close();
		}
		catch(SQLException e){}
		catch(Exception e){}
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
	
					