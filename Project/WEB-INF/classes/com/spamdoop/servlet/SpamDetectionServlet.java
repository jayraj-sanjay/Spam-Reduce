package com.spamdoop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spamdoop.core.SpamDetector;
import com.spamdoop.util.RunCommand;

public class SpamDetectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SpamDetector.run();
			resp.sendRedirect("spamdetection.jsp?msg=Completed the Spam Detection process");
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("spamdetection.jsp?msg=Something went wrong");
		}
	}

}
