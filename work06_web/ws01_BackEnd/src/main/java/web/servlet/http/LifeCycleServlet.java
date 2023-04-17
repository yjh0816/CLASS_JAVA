package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LifeCycleServlet() {
    	System.out.println("LifeCycleServlet() is called!!!");
	}
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("init() is called!!!");
    }
    @Override
    public void destroy() {
    	super.destroy();
    	System.out.println("destroy() is called!!!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>안녕하세요, LifeCycleServlet 입니다.</h2>");
		System.out.println("doGet() is called!!!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//out.println("<h2>Get LifeCycleServlet</h2>");
		System.out.println("doPost() is called!!!");
	}

}
