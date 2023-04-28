package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

public class MyBatisFrameworkUnitTest1 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//1. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//2. SqlSession -- SqlSessionTemplate
		SqlSession session = factory.openSession();

		//3. 쿼리문 실행
		List<Item> list = session.selectList("ns.sql.ItemMapper.getItemList");
		for(Item vo: list) {
			System.out.println(vo);
		}
		System.out.println("\n==============================================\n");
		Item item = session.selectOne("ns.sql.ItemMapper.getItem", 1111);
		System.out.println(item);
	}

}
