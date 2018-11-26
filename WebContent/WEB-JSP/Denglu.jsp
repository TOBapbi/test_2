<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.io.IOException,java.sql.Connection,java.sql.PreparedStatement,
    java.sql.ResultSet,java.sql.SQLException,java.sql.DriverManager,javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<title>Denglu</title>
</head>
<body>
<%!
public static String name;
public static String password;
public static String username;
public static String pwd;
%>

<% 
String sql = "select user,password from user_man where user=?";
request.setCharacterEncoding("UTF-8");
name = request.getParameter("username");
password = request.getParameter("password");

try (Connection c = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8",
		"root", "hdh123");
		PreparedStatement ps = c.prepareStatement(sql);) {
	ps.setString(1, name);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		username=rs.getString("user");
		pwd = rs.getString("password");// 得到查询出来的结果表的第三列，即密码，放入pwd中
		//System.out.println(pwd);
	}
	if (pwd.equals(password)&&username.equals(name)) {
		JOptionPane.showMessageDialog(null, "Wellcom！" + name);
		response.sendRedirect("index.html");
	} else {
		JOptionPane.showMessageDialog(null, "login false!");
		response.sendRedirect("denglu.html");
	}

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>

</body>
</html>