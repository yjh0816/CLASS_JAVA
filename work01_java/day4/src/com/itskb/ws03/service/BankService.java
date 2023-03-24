package com.itskb.ws03.service;

import java.util.ArrayList;
import java.util.List;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.dto.UserDto;

public class BankService {
	List<AccountDto> accountList;
	List<UserDto> userList;

	
	public BankService() {
		accountList = new ArrayList<>();
		userList = new ArrayList<>();

		userList.add(new UserDto(1, "kim", "333@333.com", "01011111111", false));
		userList.add(new UserDto(2, "lee", "333@333.com", "01011111111", false));
		userList.add(new UserDto(3, "park", "333@333.com", "01011111111", false));
		userList.add(new UserDto(4, "choi", "333@333.com", "01011111111", false));
		userList.add(new UserDto(5, "shin", "333@333.com", "01011111111", false));
		
		accountList.add(new AccountDto(1, "1", 123, 1));
		accountList.add(new AccountDto(1, "1", 123, 1));
		accountList.add(new AccountDto(2, "2", 123, 1));
		accountList.add(new AccountDto(3, "3", 123, 2));
		accountList.add(new AccountDto(4, "4", 123, 2));
		accountList.add(new AccountDto(5, "5", 123, 2));


	}
	public List<AccountDto> getAccountList(int userSeq) {
		List<AccountDto> result = new ArrayList<>();
		for(AccountDto dto: accountList) {
			if (dto.userSeq == userSeq) {
				result.add(dto);
			}
		}
		return result;
	}
	public UserDto getUserDetail(int userSeq) {
		for(UserDto dto: userList) {
			if (dto.userSeq == userSeq) {
				return dto;
			}
		}
		return null;
	}
}
