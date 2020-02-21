package dhtest;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection conn;			//Connection对象（连接）
	//获取数据库连接
	public static Connection getConn(){
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhdemo?useSSL=false&serverTimezone=UTC","root","982705413");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//关闭连接
	public static void CloseConn(){
		try{
			conn.close();					//关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
