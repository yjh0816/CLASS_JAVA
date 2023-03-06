package com.itskb.ws03.service;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.dto.UserDto;

public class BankService {
	static int ACCOUNT_SIZE = 10;
	static int USER_SIZE = 5;
	int ACCOUNT_CURRENT_SIZE = 0;
	int USER_CURRENT_SIZE = 0;
	AccountDto[] accountList = new AccountDto[ACCOUNT_SIZE];
	UserDto[] userList = new UserDto[USER_SIZE];
	public BankService() {
		if (this.ACCOUNT_CURRENT_SIZE < ACCOUNT_SIZE && this.USER_CURRENT_SIZE < USER_SIZE) {
//			AccountDto accountDto = new AccountDto();
//			UserDto userDto = new UserDto();
			this.userList[0] = new UserDto(1, "kim", "333@333.com", "01011111111", false);
			this.userList[1] = new UserDto(2, "lee", "333@333.com", "01011111111", false);
			this.userList[2] = new UserDto(3, "park", "333@333.com", "01011111111", false);
			this.userList[3] = new UserDto(4, "choi", "333@333.com", "01011111111", false);
			this.userList[4] = new UserDto(5, "shin", "333@333.com", "01011111111", false);


			this.accountList[0] = new AccountDto(1, "1", 123, 1);
			this.accountList[1] = new AccountDto(2, "2", 123, 1);
			this.accountList[2] = new AccountDto(3, "3", 123, 2);
			this.accountList[3] = new AccountDto(4, "4", 123, 2);
			this.accountList[4] = new AccountDto(5, "5", 123, 2);
//			this.accountList[ACCOUNT_CURRENT_SIZE] = accountDto;
//			this.userList[USER_CURRENT_SIZE] = userDto;

//			this.ACCOUNT_CURRENT_SIZE++;
//			this.USER_CURRENT_SIZE++;
	        this.ACCOUNT_CURRENT_SIZE = 5;
	        this.USER_CURRENT_SIZE = 5;
		}
	}
	public AccountDto[] getAccountList(int userSeq) {
//		AccountDto[] temp;
		AccountDto[] temp = new AccountDto[2];
		int count = 0;
		for(int i=0; i<this.ACCOUNT_CURRENT_SIZE; i++) {
			if (this.accountList[i].userSeq == userSeq) {
				temp[count] = this.accountList[i];
				count++;
			}
		}
		return temp;
	}
	public UserDto getUserDetail(int userSeq) {
		UserDto temp = null;
		for(UserDto ud: this.userList) {
			if (ud.userSeq == userSeq) {
				temp = ud;
			}
		}
		return temp;
	}
}
