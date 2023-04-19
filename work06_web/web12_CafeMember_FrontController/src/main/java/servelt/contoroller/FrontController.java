package servelt.contoroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 양방향 한글 처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String command = request.getParameter("command");
        String path = "index.html";
        if(command.equals("register")) {
        	path = register(request, response);
        } else if(command.equals("find")) {
        	path = find(request, response);
        } else if(command.equals("login")) {
        	path = login(request, response);
        } else if(command.equals("showAll")) {
        	path = showAll(request, response);
        }
        
        request.getRequestDispatcher(path).forward(request, response);
	}//doProcess

	private String register(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        MemberVO pvo = new MemberVO(id, password, name, address);
        
        String path = "index.html";
        try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		} catch (Exception e) {
			
		}
        
        return path;
	}//register

	private String find(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = "find_fail.html";
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
//    		request.getRequestDispatcher("find_ok.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
		
		return path;
	}//find
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.html";
		
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
		return path;
	}//login
		
	private String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html";
		try {
        	ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
        	request.setAttribute("list", list);
        	path = "allView.jsp";
//        	request.getRequestDispatcher("allView.jsp").forward(request, response);
        } catch (Exception e) {
			
		}
		return path;
	}
	
	
}
