import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudente2 {

	public static void main(String[] args) {
		// 
		final String URL = "jdbc:mysql://localhost:3306/pc_shop_db";
		final String USER = "shop_user";
		final String PASS = "pass";
		
		String sql = "SELECT user_id, user_name, birth_day FROM m_user";
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			System.out.println("\n-------全件表示します。---------");
			
			while(res.next()) {
				String uId = res.getString("user_id");
				String name = res.getString("user_name");
				Date bDay = res.getDate("birth_day");
				
				System.out.println("【ID】" + uId);
				System.out.println("【名前】" + name);
				if(bDay == null) {
					System.out.println("【誕生日】（未登録）");
				}else {
					System.out.println("【誕生日】" + bDay);
				}
				System.out.println("------------------------------");
			}
		}catch(SQLException e){
			System.out.println("\nエラーが発生しました。");
		}

	}

}
