package com.spamdoop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spamdoop.util.RunCommand;

public class ViewFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RunCommand.run("rm -rf /root/input");
			RunCommand.run("mkdir /root/input");
			RunCommand.run("hadoop fs -get input/* /root/input/");
			
			String command = "ls /root/input";
			String output = RunCommand.run(command);
			System.out.println("Command output: "+output);
			String[] arr = output.split("@-@-");
			List<String> files = new ArrayList<>();
			files.addAll(Arrays.asList(arr));
			req.setAttribute("files", files);
			req.getRequestDispatcher("viewfiles.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("viewfiles.jsp?msg=Something went wrong");
		}
	}

}
