package servelt.contoroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchesController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("handleRequest...진입...");
		
		// 디비 갔다가 왔다 치고...
		String result = "<ul><li>KB 선릉지점</li>"
				+"<li>KB 강남지점</li>"
				+"<li>KB 역삼지점</li>"
				+"<li>KB 강북지점</li>"
				+"<li>KB 가산 디지털단지지점</li>"
				+"<li>KB 강서지점</li></ul>";
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
