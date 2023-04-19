package com.edu;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String path = "";
		System.out.println(command);
		if (command.equals("wordCount")) {
			path = wordCount(request, response);
		} else if (command.equals("kickCount")) {
			path = kickCount(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}// process()

	private String wordCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String words = request.getParameter("words");
		String result = new Count().execute(words);
		request.setAttribute("result", result);

		return "Result.jsp";
	}
	private String kickCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String fname = request.getParameter("fname");
		String path = request.getServletContext().getRealPath("/res");
		System.out.println(path);
		
		File f = new File(path, fname);
		
		int result = Kickboard.execute(f);
		request.setAttribute("result", result);

		return "Result.jsp";
		
	}

}
