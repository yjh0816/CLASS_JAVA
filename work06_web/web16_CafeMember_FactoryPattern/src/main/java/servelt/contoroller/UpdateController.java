package servelt.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {
/*
 * MVC -- FindController 서블릿과 동일
 * FrontController -- 서블릿 안의 find() 함수와 동일
 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        MemberVO pvo = new MemberVO(id, password, name, address);
        
        String path = "index.jsp";
        try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			//수정된 객체의 내용을 반드시 바인딩…세션.
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { //로그인 된 상태에서만 수정작업이 되도록
				session.setAttribute("vo", pvo);
			}
			path = "update_result.jsp";
		} catch (Exception e) {
			
		}
		
		return new ModelAndView(path);
	}

}
