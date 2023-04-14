package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 <servlet>
 	<servlet-name>FormServlet
 	<servlet-name>web.servlet.form.FormServlet
 </servlet>
 <servlet-mapping>
 	<servlet-name>FormServlet
 	<url-pattern>/FS
 </servlet-mapping>
 */
@WebServlet("/FS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public FormServlet() {

    }
    //thread..
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스는 이쪽으로 들어옵니다..");
		
		//폼에 입력된 값 받아서 다시 브라우저로 응답...
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.print("<ul><li>ID : "+ userId+"</li>");
		out.print("<li>PASSWORD : "+ userPass+"</li></ul>");
		out.print("</body></html>");
	}


}
