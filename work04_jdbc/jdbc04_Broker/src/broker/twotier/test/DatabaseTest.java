package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		Database db = new Database("127.0.0.1");
//		db.addCustomer(new CustomerRec("999-999", "James", "NY"));
//		db.deleteCustomer("888-888");
//		db.updateCustomer(new CustomerRec("999-999", "James1", "NY1"));
		
//		ArrayList<SharesRec> v = db.getPortfolio("111-111");
//		for(SharesRec sr : v) System.out.println(v);
		
//		System.out.println(db.getCustomer("111-111"));
//		System.out.println(db.getAllCustomers());
		ArrayList<StockRec> stocks = db.getAllStocks();
		for(StockRec s : stocks) System.out.println(s);
		
		
	}

}
