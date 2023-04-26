package spring.service.test;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;
import spring.service.user.impl.MemberDAOImpl;
import spring.service.user.impl.MemberServiceImpl;

public class MyBatisSpringDIAppTest {

	public static void main(String[] args) throws Exception{
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"/beans/memberservice.xml"}
				);
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		 
		MemberVO vo = new MemberVO("777", "123", "아이유", "여의도");
		
		
		//1.
//		System.out.println(":: 1. getMember(SELECT)  ? ");
//		System.out.println(memberService.getMember("111"));
		
		//2.
//		System.out.println(":: 2. showAllMember(SELECT)  ? ");
//		List<MemberVO> list = memberService.showAllMember();
//		for (int i =0 ;  i < list.size() ; i++) {
//			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
//			System.out.println( list.get(i).toString() );
//		}
		
		//3.
		System.out.println(":: 3. idExist(SELECT)  ? "+ memberService.idExist("111"));
		
	}

}










