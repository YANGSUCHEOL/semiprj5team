package common;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			//프로퍼티즈 파일 읽기
			Properties prop = new Properties(); //MAP 계열 컬렉션
			
			String filePath = JDBCTemplate.class.getResource("/db/info.properties").getPath();
			prop.load(new FileInputStream(filePath));
				
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("[ERROR] getConnection중 예외발생!!!");
			e.printStackTrace();
		}
		return conn;
	}
	
	//커밋
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//롤백
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
