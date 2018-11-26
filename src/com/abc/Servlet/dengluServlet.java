package com.abc.Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class dengluServlet
 */
public class dengluServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name;
	public static String password;
	public static String pwd;
	public static String username;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dengluServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
				JOptionPane.showMessageDialog(null, "欢迎你！" + name);
				response.sendRedirect("Zhuye.html");
			} else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
				response.sendRedirect("denglu.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
