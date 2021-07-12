package com.spamdoop.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spamdoop.core.Obfuscator;

public class ObfuscationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String type = req.getParameter("type");
			if (type.equals("obf")) {
				(new Obfuscator()).run();
				resp.sendRedirect("obf.jsp?msg=Started the obfuscation Process");
			} else if (type.equals("view")) {
				File folder = new File("/root/tmp_obf");
				List<String> files = new ArrayList<>();
				for (String f : folder.list()) {
					files.add(f);
				}
				req.setAttribute("files", files);
				req.getRequestDispatcher("obf_view.jsp").forward(req, resp);;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("obf.jsp?msg=Something went wrong");
		}
	}

}
