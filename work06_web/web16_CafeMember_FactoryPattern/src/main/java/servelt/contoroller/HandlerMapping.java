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
		if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("new RegisterController()...");
        } else if(command.equals("find")) {
        	controller = new FindController();
        	System.out.println("new FindController()...");
        } else if(command.equals("login")) {
        	controller = new LoginController();
        	System.out.println("new LoginController()...");
        } else if(command.equals("showAll")) {
        	controller = new ShowAllController();
        	System.out.println("new ShowAllController()...");
        } else if(command.equals("update")) {
        	controller = new UpdateController();
        	System.out.println("new UpdateController()...");
        }
		return controller;
	}
}
