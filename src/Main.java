import java.util.ArrayList;

public class Main {

	
	public static Mediator m = Mediator.getInstance();
	public static void main(String[] arg) {
		
	
		
		int size =100;
		
	// Creating 100 Companies
		for(int i=0; i<size; i++) {
			m.addCompany(new Company());
		}
	
	// Creating 100 Investors
		for(int i=0; i<size; i++) {
			m.addInvestor(new Investor());
		}
	}
	
	public static void tradingDay() {
		
		//it is not specified that how companies and investors are going to trade
		//So we are going to choose a random investor and a random company that will trade
		//this process will continue until all the share are sold, or all investors are out of budget
		
		//A random Investor
		int c = (int) Math.random() * (100) ;
		int i = (int) Math.random() * (100) ;
		
		while(true) {
			m.trade(c,i);
			
		}
	}
	
	
	public static boolean allSharesSold() {
		
		for(Company c: m.companies) {
			
			if(c.getAvailableShares()>0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean outofBudget() {
		
		for(Investor i: m.investors) {
			if(i.getBudget() > 0) {
				return false;
			}
		}
		return true;
	}
	
}
