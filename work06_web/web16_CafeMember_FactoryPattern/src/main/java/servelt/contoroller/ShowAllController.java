package servelt.contoroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class ShowAllController implements Controller {
/*
 * MVC -- FindController 서블릿과 동일
 * FrontController -- 서블릿 안의 find() 함수와 동일
 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
        	ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
        	request.setAttribute("list", list);
        	path = "allView.jsp";
//        	request.getRequestDispatcher("allView.jsp").forward(request, response);
        } catch (Exception e) {
			
		}
		return new ModelAndView(path);
	}

}
