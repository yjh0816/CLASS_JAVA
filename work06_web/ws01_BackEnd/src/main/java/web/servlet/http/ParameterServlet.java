package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
		out.print("<h2>job : "+ job+"</h2>");
		out.print("<h2>pageNo : "+ pageNo+"</h2>");
		out.print("<h2>searchWord : "+ searchWord+"</h2>");
		
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 폼 값 받는다.
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>name : ").append(name).append("</h2>");
		sb.append("<h2>email : ").append(email).append("</h2>");
		sb.append("<h2>gender : ").append(gender).append("</h2>");
		StringBuffer sb2 = new StringBuffer();
		for(String h: hobbys) {
			sb2.append(h).append(", ");
		}
		sb2.setLength(sb2.length()-2);
		
		sb.append("<h2>hobby : ").append(sb2).append("</h2>");
		
		sb.append("<h2>favorite : ").append(favorite).append("</h2>");
		sb.append("<h2>desc : ").append(desc).append("</h2>");
		out.append(sb);
		out.close();
	}

}
