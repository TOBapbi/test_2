package dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sql {
	static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	10.100.4.92
	static String dbURL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
	
	static String user = "root";
	static String password = "hdh123";

	public static Connection connect() {
		Connection con = null;
		// 1. 装载驱动
		try {
			Class.forName(driverName);
			System.out.println("驱动成功 ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动失败 ");
		}

		// 2. 连接数据库
		try {
			con = DriverManager.getConnection(dbURL, user, password);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败！");
		}
		return con;
	}

	// 3. 获取数据库操作语句
	public static PreparedStatement getPreparedStatement(Connection con, String sql, Object[] obj) {
		PreparedStatement pst = null;
		if (con != null) {
			try {
				pst = con.prepareStatement(sql);
				//为Sql赋值
				for(int i= 0; i < obj.length; i++){
					pst.setObject(i+1, obj[i]);
					System.out.println(obj[i]);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pst;
	}

	// 4.1 执行查询语句并获得结果集
    public static ResultSet getResult(PreparedStatement pst){
    	ResultSet rs= null;
    	try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }
    
    // 4.2 执行非查询
    public static int execute(PreparedStatement pst){
    	int rs= 0;
    	try {
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return rs;
    }  
    
    //4.3 通过存储过程进行处理
    public static int executeProduse(Connection con, String str, Object[] obj){		
        try {
        	str = "{call "+ str + " }";
        	System.out.println(str);
            CallableStatement sp=con.prepareCall(str);
            //为Sql赋值
			for(int i= 0 ; i<= obj.length - 1; i++){
				sp.setObject(i+1, obj[i]);
			}
//			sp.registerOutParameter(obj.length, Types.INTEGER);
            sp.execute();
//            System.out.println("查询成功: "+sp.getInt(obj.length));
//            return sp.getInt(3);
            return 1;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("查询失败");
            return 0;
        } 
    }
    
	// 5. 关闭连接
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
