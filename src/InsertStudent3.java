import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent3 {

	public static void main(String[] args) {
		String url = "jbdc:mysql";
		String user = "shop_user";
		String password = "pass";
		
		String sql = "INSERT INTO m_user"
				+ "(user_id, user_name, emali, birthday)"
				+ "VALUES"
				+ "('ZU01', 'ZU01名前', emali, '2002-03-04')";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement()){
			int cnt = stmt.executeUpdate(sql);
			
			System.out.println("\n" + cnt +"件登録しました。");
		}catch(SQLException e) {
			System.out.println("\nエラーが発生しました");
		}

	}

}
