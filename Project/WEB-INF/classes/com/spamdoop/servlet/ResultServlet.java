package com.spamdoop.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spamdoop.pojo.Result;

public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String result_file = "/root/result/results.txt";
			File file = new File(result_file);
			if (!file.exists()) {
				resp.sendRedirect("results.jsp?msg=Result not available yet");
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String line = "";
				List<Result> result = new ArrayList<>();
				while ((line = br.readLine()) != null) {
					String[] arr = line.split("@-@-");
					Result res = new Result();
					res.setFilename(arr[0]);
					res.setIs_spam(arr[1]);
					List<String> sw = new ArrayList<>();
					if (arr[1].equals("true")) {
						String[] ar = arr[2].split(",");
						for (String a : ar) {
							if (a.trim().length() > 0)
								sw.add(a);
						}
					}
					res.setSpam_words(sw);
					result.add(res);
				}
				br.close();
				req.setAttribute("result", result);
				req.getRequestDispatcher("results.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("results.jsp?msg=Something went wrong");
		}
	}

}
