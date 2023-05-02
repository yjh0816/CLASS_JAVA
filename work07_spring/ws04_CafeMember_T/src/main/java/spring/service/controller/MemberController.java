package spring.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.service.domain.MemberVO;
import spring.service.model.MemberDAO;
import spring.service.model.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("find.do")
	public String find(Model model, String id) throws Exception {
		MemberVO rvo = memberService.getMember(id);
		if(rvo!=null) {
			model.addAttribute("vo",rvo);
			return "find_ok";
		} else {
			return "find_fail";
		}
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, MemberVO pvo) throws Exception {
		MemberVO rvo = memberService.login(pvo);
		if(rvo!=null) {
			//login, update는 반드시 session에 값을 바인딩
			request.getSession().setAttribute("vo",rvo);
			return "login_result";
		} else {
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("register.do")
	public String register(MemberVO pvo) throws Exception {
		memberDAO.registerMember(pvo);
		return "redirect:/showAll.do";
	}
	
	@RequestMapping("showAll.do")
	public String showAll(Model model) throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		model.addAttribute("list",list);
		
		return "allView";
	}
	
	@RequestMapping("update.do")
	public String update(HttpSession session, MemberVO pvo) throws Exception {
		memberDAO.updateMember(pvo);
		//로그인된 상태에서만 수정 가능...
		
		if(session.getAttribute("vo") != null) {
			session.setAttribute("vo", pvo);
			return "update_result";
		} 
		return null;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) { //로그인된 상태라면 로그아웃
			session.invalidate(); //세션을 죽이고 
			return "logout";
		}
		return null;
	}
}//class
