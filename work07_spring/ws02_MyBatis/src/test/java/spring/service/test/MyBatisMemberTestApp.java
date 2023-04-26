package spring.service.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {
	public static void main(String[] args) throws Exception{		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session=factory.openSession();
		List<MemberVO> list=session.selectList("MemberMapper.showAllMember");
		
		//0. showAllMember :: 모든 Member 정보
		System.out.println(":: 0. all Member(SELECT)  ? ");
		
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");

		
		//1. registerMember
		MemberVO member = new MemberVO("jaja","0404","James","광진구");
		
//		Object obj = session.insert("MemberMapper.registerMember", member);
//		session.commit();
//		System.out.println(":: 1. registerMember(INSERT)  result ? "+obj); //1
//		System.out.println("\n");
		
		
		//2. idExist
//		String userName = (String)session.selectOne("MemberMapper.idExist", "jaja");
//		System.out.println(":: 2. idExist(SELECT)  ? "+userName); //James
//		System.out.println("\n");
					
	
		//3. updateMember
//		member.setName("JAMES");
//		member.setId("jaja");
//		int updateResult = session.update("MemberMapper.updateMember", member);
//		session.commit(); //이부분 반드시 해줘야 한다.
//		System.out.println(":: 3. updateMember(UPDATE) result ? "+updateResult);//1
//		System.out.println("\n");
		
		//4. getMember
//		MemberVO member = (MemberVO)session.selectOne("MemberMapper.getMember", "jaja");
//		System.out.println(":: 4. getMember(SELECT)  ? "+member);
//		System.out.println("\n");
		
		
		//5. login
//		member.setId("jaja");
//		member.setPassword("0404");
//		String name = (String)session.selectOne("MemberMapper.login", member);
//		System.out.println(":: 5. login(SELECT)  ? "+name);
		
		//6. deleteMember
//		int deleteResult = session.delete("MemberMapper.deleteMember", "jaja");
//		session.commit(); 
//		System.out.println(":: 6. deleteMember(DELETE) result ? "+deleteResult);
//		System.out.println("\n");
	}//end of main
}//end of class


















