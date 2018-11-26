package com.abc.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		String sql = "insert into user_man values(null,?,?)";
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String vali = request.getParameter("vali");
		

		// System.out.println("name:" + name);

		// System.out.println("password:" + password);
		try (Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8",
				"root", "hdh123");
				// 根据sql语句创建PreparedStatement
				PreparedStatement ps = c.prepareStatement(sql);

		) {
			// 设置参数
			ps.setString(1, name);
			ps.setString(2, password);
			
			// 执行
			ps.execute();
			if(vali.equals(request.getSession().getAttribute("valiNum"))){
				response.sendRedirect(request.getContextPath() + "/denglu.html");
			}else{
				response.sendRedirect(request.getContextPath() + "/denglu.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
