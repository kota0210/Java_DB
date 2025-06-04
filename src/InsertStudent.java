import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudent {
	public static void main(String[] args) {
		final String URL = "jbdc";
		final String USER = "root";
		final String PASS = "pass";
		
		String sql = "INSERT INTO student VALUES(6, '小林', 95)";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			//DBに接続
			con = DriverManager.getConnection(URL, USER, PASS);
			//ステートメントを作成
			stmt = con.createStatement();
			//SQLを実行
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "件更新しました。");
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
