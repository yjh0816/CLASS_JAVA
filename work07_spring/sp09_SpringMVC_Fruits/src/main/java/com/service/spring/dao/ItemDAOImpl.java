package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Item;
@Repository
public class ItemDAOImpl implements ItemDAO {
	public static final String NS = "ns.sql.ItemMapper.";
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<Item> getItemList() throws Exception {
		return sqlsession.selectList(NS+"getItemList");
	}

	@Override
	public Item getItem(Integer itemId) throws Exception {
		return sqlsession.selectOne(NS+"getItem",itemId);
	}

}
