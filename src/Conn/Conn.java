package Conn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	static String driverName = "com.mysql.jdbc.Driver";
	static String dbURL = "jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8";
	static String user = "root";
	static String password = "abab123";

	
	public static Connection connect() {
		Connection con = null;
		// 1. 瑁呰浇椹卞姩
		try {
			Class.forName(driverName);
			System.out.println(" ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ");
		}
		// 2. 杩炴帴鏁版嵁搴�
		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
		}
		return con;
	}

	// 3. 鑾峰彇鏁版嵁搴撴搷浣滆鍙�
	public static PreparedStatement getPreparedStatement(Connection con, String sql, Object...objects) {
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				for(int i= 0; i < objects.length; i++){
					if(objects[i]==null) { break;}
					else {
					ps.setObject(i+1, objects[i]);
//					System.out.println(objects[i]);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ps;
	}

	// 4.1 鎵ц鏌ヨ璇彞骞惰幏寰楃粨鏋滈泦
    public static ResultSet getResult(PreparedStatement ps){
    	ResultSet rs= null;
    	try {
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
    	return rs;
    }
    
    // 4.2 鎵ц闈炴煡璇�
    public static int execute(PreparedStatement ps){
    	int rs= 0;
    	try {
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }  
    
    //4.3 閫氳繃瀛樺偍杩囩▼杩涜澶勭悊
    public static int executeProduse(Connection con, String str, Object...obj){		
        try {
        	str = "{call "+ str + " }";
        	System.out.println(str);
            CallableStatement sp=con.prepareCall(str);
            //涓篠ql璧嬪��
			for(int i= 0 ; i<= obj.length - 1; i++){
				sp.setObject(i+1, obj[i]);
			}
//			sp.registerOutParameter(obj.length, Types.INTEGER);
            sp.execute();
//            System.out.println("鏌ヨ鎴愬姛: "+sp.getInt(obj.length));
//            return sp.getInt(3);
            return 1;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("");
            return 0;
        } 
    }
    
	// 5. 鍏抽棴杩炴帴
	public static void close(Connection con) {
		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (pstmt != null) {
//				pstmt.close();
//			}
			con.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
