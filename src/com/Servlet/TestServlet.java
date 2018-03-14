package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.AccessToken;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		System.out.println(AccessToken.access_token);
		arg0.setAttribute("json", AccessToken.access_token);
		arg0.getRequestDispatcher("test.jsp").forward(arg0, arg1);
	}
}
