package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/")	//http://127.0.0.1:8899/
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("regPhone")
	public String getRegPhone(Model model) {
		model.addAttribute("title","핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}
	
	@PostMapping("savePhone")
	public String doRegPhone(Model model, Phone phone) {
		try {
			//성공페이지
			phoneService.insert(phone);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
		}catch(Exception e) {
			//실패페이지
			model.addAttribute("title","핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone") //모든 폰정보 가져오기..get
	public String doList(Model model) {
		try {
			List<Phone> list = phoneService.select();
			//error
			model.addAttribute("phones",list);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 리스트");
			return "PhoneList";
		}catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 목록 조회중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("detail")
	public String doDetail(Model model, Phone phone) {
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("phone",selected);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 상세 조회");
			return "PhoneView";
		} catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 상세 보기중 에러 발생");
			return "Error";
		}
	}
	
	//비동기
	@PostMapping("deleteAjax")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num ,Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);//삭제하고자 하는 num을 다 받아온다
			phoneService.delete(temp);
			return "";
		} catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 폰 삭제 중 에러 발생");
			return "Error";
		}
	}
	////////////// 로그인 기능 :: UserInfoController ////////////////
	@GetMapping("login")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = phoneService.select(user);
			if(selected!=null) { //로그인 되었다면
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone";
			} else { //로그인 실패했다면
				return "Login";
			}
		} catch(Exception e) {
			model.addAttribute("title","핸드폰 관리 - 에러");
			model.addAttribute("message","문제 내용 - 회원 로그인 중 에러 발생");
			return "Error";
		}
	}
}
