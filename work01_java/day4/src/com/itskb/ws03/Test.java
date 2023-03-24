package com.itskb.ws03;

import java.util.List;

import com.itskb.ws03.dto.AccountDto;
import com.itskb.ws03.service.BankService;

public class Test {

	public static void main(String[] args) {
		BankService bs = new BankService();
		List<AccountDto> accountList = bs.getAccountList(1);
		for(AccountDto ad: accountList) {
			System.out.println(ad);
		}
		System.out.println(bs.getUserDetail(1));
	}
}
