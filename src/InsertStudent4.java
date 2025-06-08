import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudent4 {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/pc_shop_db";
		final String USER = "shop_user";
		final String PASS = "pass";
		
		String sql = "INSERT INTO student VALUES(6, '小林', 95)";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			//DBに接続
			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println( "接続しました。");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//リソースを解放
				if(stmt != null)stmt.close();
				if(con != null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
