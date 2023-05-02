package com.service.spring.controlloer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverController {
	
	@RequestMapping("findBoard.do")
	public String findBoard() {
		System.out.println("findBoard.do...요청 처리함..");
		return "board_result";
	}
	
	@RequestMapping("findProduct.do")
	public String findProduct() {
		System.out.println("findProduct.do...요청 처리함..");
		return "product_result";
	}
	
	@RequestMapping("register.do")
	public String register(Model model) {
		System.out.println("register.do...요청 처리함..");
		model.addAttribute("info","InternalResourceViewResolver");
		return "register_result";
	}
}
