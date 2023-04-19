package servelt.contoroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
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
        
        //3. DAO 리턴받아서 비즈니스 로직 호출....반환값있다
        MemberVO vo = null;
        try {
        	vo = MemberDAOImpl.getInstance().findByIdMember(id);
		} catch (Exception e) {
			
		}
        
        //4. 반환값을 바인딩
        request.setAttribute("vo", vo);
        
        //5. 페이지 이동...find_ok.jsp / (find_fail.jsp)
        if(vo!=null)
        	request.getRequestDispatcher("find_ok.jsp").forward(request, response);
        else
        	response.sendRedirect("./error/find_fail.html");
	}

}
