package web.servlet.life;

/*
 * Servlet API와
 * 컨테이너가 어떻게 CALLBACK 메소드를 호출하는지...순서
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ServletLifeCycleTest" ,urlPatterns={"/Life"}, loadOnStartup = 1)
public class ServletLifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count = 0;

    public ServletLifeCycleTest() {
    	System.out.println("1. Create servlet object by container");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("2. Call init() by container");
	}

	public void destroy() {
		System.out.println("4. Call destroy() by container. And servlet death, stop container");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. Call doGet() by container whenever request");
		
		//Client request process
		PrintWriter out = response.getWriter();
		
		//Print to Browser
		out.println("<body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: "+ ++count + "</b>");
		out.println("</body>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. Call doPost() by container whenever request");
	}

}
