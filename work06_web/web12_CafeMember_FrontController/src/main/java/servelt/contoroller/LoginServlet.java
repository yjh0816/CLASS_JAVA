package servelt.contoroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성

		//1. 양방향 한글 처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //2. 폼값 받는다
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String path = "index.html";
        
        //3. DAO 리턴받아서 비즈니스 로직 호출....반환값있다
        
        //4. 반환값을 바인딩
        
        //5. 페이지 이동...login_result.jsp / (login_fail.jsp)

        try {
        	MemberVO rvo = MemberDAOImpl.getInstance().login(id,password);
        	HttpSession session = request.getSession();
        	if(rvo!=null)
        		session.setAttribute("vo", rvo);
        		System.out.println("JSESSION :: "+session.getId());
    		path = "login_result.jsp";
		} catch (Exception e) {
			path = "login_fail.jsp";
			System.out.println(e);
		}
        request.getRequestDispatcher(path).forward(request, response);
        
	}

}
