import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent3 {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/pc_shop_db";
		final String USER = "shop_user";
		final String PASS = "pass";
		
		String sql = "INSERT INTO m_user"
				+ "(user_id, user_name, email, birth_day)"
				+ "VALUES"
				+ "('ZU02', 'ZU02名前', email, '2002-03-04')";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = con.createStatement()){
			int cnt = stmt.executeUpdate(sql);
			
			System.out.println("\n" + cnt +"件登録しました。");
		}catch(SQLException e) {
			System.out.println("\nエラーが発生しました");
			e.printStackTrace();
		}

	}

}
