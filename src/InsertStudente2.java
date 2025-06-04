import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudente2 {

	public static void main(String[] args) {
		// 
		String url = "jbdc:mysql";
		String user = "shop_user";
		String password = "pass";
		
		String sql = "SELECT user_id, user_name, birth_day FROM m_user";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
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
