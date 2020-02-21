package dhtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	Connection conn;											//数据库连接对象
	public Login checkLogin(String name, String password){		//验证登录用户名和密码
		try{
			conn = DBConn.getConn();							//获取连接对象
			PreparedStatement pstmt = conn.prepareStatement("select * from login where name=?"+ "and password=?");
			pstmt.setString(1, name);							//设置 SQL 语句参数1（用户名）
			pstmt.setString(2, password);						//设置 SQL 语句参数2（密码）
			ResultSet rs = pstmt.executeQuery();				//执行查询，返回结果集
			if(rs.next()){										//返回结果不为空，表示有此用户信息
				Login login = new Login();						//通过JavaBean对象保存值
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				return login;									//返回已经设值的JavaBean对象
			}
			return null;										//无此用户，验证失败，返回null
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.CloseConn();									//关闭连接
		}
	}
}
