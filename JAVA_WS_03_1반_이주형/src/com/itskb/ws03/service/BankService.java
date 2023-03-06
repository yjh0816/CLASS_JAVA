package com.itskb.ws03.service;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.dto.UserDto;

public class BankService {
	final int ACCOUNT_SIZE = 5;
	final int USER_SIZE = 10;
	int aIndex = 0;
	int uIndex = 0;
	AccountDto[] accountList;
	UserDto[] userList;
	public BankService() {
		if (aIndex < ACCOUNT_SIZE && uIndex < USER_SIZE) {
			accountList = new AccountDto[ACCOUNT_SIZE];
			userList = new UserDto[USER_SIZE];
			userList[uIndex++] = new UserDto(1, "kim", "333@333.com", "01011111111", false);
			userList[uIndex++] = new UserDto(2, "lee", "333@333.com", "01011111111", false);
			userList[uIndex++] = new UserDto(3, "park", "333@333.com", "01011111111", false);
			userList[uIndex++] = new UserDto(4, "choi", "333@333.com", "01011111111", false);
			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);
//			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);
//			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);
//			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);
//			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);
//			userList[uIndex++] = new UserDto(5, "shin", "333@333.com", "01011111111", false);

			accountList[aIndex++] = new AccountDto(1, "1", 123, 1);
			accountList[aIndex++] = new AccountDto(2, "2", 123, 1);
			accountList[aIndex++] = new AccountDto(3, "3", 123, 2);
			accountList[aIndex++] = new AccountDto(4, "4", 123, 2);
			accountList[aIndex++] = new AccountDto(5, "5", 123, 2);
//			this.accountList[ACCOUNT_CURRENT_SIZE] = accountDto;
//			this.userList[USER_CURRENT_SIZE] = userDto;

//			this.ACCOUNT_CURRENT_SIZE++;
//			this.USER_CURRENT_SIZE++;
		}
	}
	public AccountDto[] getAccountList(int userSeq) {
		int count = 0;
		for(int i=0; i<aIndex; i++) {
			if (accountList[i].userSeq == userSeq) {
				count++;
			}
		}
		AccountDto[] temp = new AccountDto[count];
		count = 0;
		
		for(int i=0; i<aIndex; i++) {
			if (accountList[i].userSeq == userSeq) {
				temp[count++] = accountList[i];
			}
		}
		return temp;
	}
	public UserDto getUserDetail(int userSeq) {
		UserDto temp = null;
		for(int i=0; i<uIndex; i++) {
			if (userList[i].userSeq == userSeq) {
				temp = userList[i];
				break;
			}
		}
		return temp;
	}
}
