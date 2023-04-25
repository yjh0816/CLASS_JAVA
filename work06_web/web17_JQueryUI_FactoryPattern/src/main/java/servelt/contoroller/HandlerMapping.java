package servelt.contoroller;
/*
 * 서블릿이 제공하는 command값에 따라서
 * Component를 여기서 직접 생성한다.
 * 
 * 여러개의 Component를 생성하는 공장
 * 무조건 하나만 생성되도록 싱글톤 패턴으로 작성
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {
		System.out.println("Creating HandlerMapping...Singleton...");
	}
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	//command값에 따라서 Component를 생성하는 기능
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("subject.do")) {
			controller = new SubjectController();
		} else if(command.equals("branches.do")) {
			controller = new BranchesController();
		}
		return controller;
	}
}
