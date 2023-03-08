package com.kb.cms;

public interface ICustMgr {

	//	1. 저장()
	void save(Customer c);

	//	2. 검색()
	void search();

	//	3. 상세검색()
	Customer search(int num);

	/**
	 * 주어진 고객번호를 검색하여 주소를 수정한다.
	 * @param num : 고객번호
	 * @param address : 수정된 주소
	 */
	void update(int num, String address);

	//	5. 삭제()
	void delete(int num);

}