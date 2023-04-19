package servelt.contoroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/AllMember")
public class AllMemberServlet extends HttpServlet {
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
        
        try {
        	ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
        	request.setAttribute("list", list);
        	request.getRequestDispatcher("allView.jsp").forward(request, response);
        } catch (Exception e) {
			
		}
        
	}

}
