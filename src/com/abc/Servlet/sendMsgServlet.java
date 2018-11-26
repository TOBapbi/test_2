package com.abc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ValiMsgUtils;

@WebServlet("/sendMsg")
public class sendMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sendMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		if(value.matches("^1[34578]\\d{9}$")){
			request.getSession().setAttribute("valiNum", ValiMsgUtils.send(value));
			System.out.println("短信发送成功");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
