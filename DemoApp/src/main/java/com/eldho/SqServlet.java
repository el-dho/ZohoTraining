package com.eldho;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/sq")

public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Cookie[] cookies = req.getCookies();
		int k = 0;

		for (Cookie c : cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}

//		HttpSession session = req.getSession();
//		int k = (int) session.getAttribute("k");

//		int k  = Integer.parseInt(req.getParameter("k"));

//		int k = (int) req.getAttribute("k");

		k = k * k;

		PrintWriter out = res.getWriter();
		out.println("Result is :" + k);

		ServletContext ctx = getServletContext();
		String str = ctx.getInitParameter("phone");
		out.println("From servlet context: " + str);

		ServletConfig cfg = getServletConfig();
		str = cfg.getInitParameter("colour");
		out.println("From servlet config: " + str);
	}

}
