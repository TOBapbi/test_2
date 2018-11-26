package com.abc.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Bean.SC;
import Bean.LoginBean;
import dao.Cou;
import dao.ScDao;

@WebServlet("/SelectCousevrlet")
public class SelectCousevrlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public SelectCousevrlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String choiceR[] = request.getParameterValues("choiceCou");
		LoginBean stu = null;
		if(session.getAttribute("stu")==null){
			response.sendRedirect("../Login.jsp");
		}else{
			stu = (LoginBean) session.getAttribute("stu");}
		Cou selectc = new Cou();
		
		int id = stu.getId();
		if(choiceR.length!=0){
			SC sc[] = new SC[choiceR.length];
			for(int i =0;i<choiceR.length;i++){
				sc[i] = new SC();
				sc[i].setId(id);
				sc[i].setCouid(Integer.parseInt(choiceR[i]));
			}
			ScDao insert = new ScDao();
			int rs[] = insert.insertSc(sc);
		    System.out.println(" insert over!!");
		    response.sendRedirect("html");
			
		}

	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
