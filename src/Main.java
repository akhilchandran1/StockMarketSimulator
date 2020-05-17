import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	public static Mediator m = Mediator.getInstance();
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] arg) {
		
		// Declaring and initializing the mediator class to save list of companies and objects
		
		
		int size =100;
		
	// Creating 100 Companies
		for(int i=0; i<size; i++) {
			m.addCompany(new Company());
		}
		
		System.out.println("companies Created");
	
	// Creating 100 Investors
		for(int i=0; i<size; i++) {
			m.addInvestor(new Investor());
		}
		System.out.println("investors Created");
		
		tradingDay();
		menu();
	}
	
	public static void tradingDay() {
		
		//it is not specified that how companies and investors are going to trade
		//So we are going to choose a random investor and a random company that will trade
		//this process will continue until all the share are sold, or all investors are out of budget
		System.out.println("trading................");
		int a=0;
		while(true) {
		//A random Investor
		//int c = (int) Math.random() * (100) ;
		//int i = (int) Math.random() * (100) ;
		//System.out.println(a+") "+c+" "+i);
			int comp, inv, sh;
			
			
			for(int i = 0; i<m.companies.size(); i++) {
				
				if(m.companies.get(i)!=null && m.investors.get(i)!=null) {
					m.trade(i,i);
				}
			}
	
			if(allSharesSold() || outofBudget()) {
				
				System.out.println("Trade End");
				break;
			}
			a++;
			
		}
	}
	
	// Method will return true if all shares are sold 
	public static boolean allSharesSold() {
		
		for(Company c: m.companies) {
			
			if(c.getAvailableShares()>0) {
				return false;
			}
		}
		return true;
	}
	// Method will return true if all investors spent their money
	public static boolean outofBudget() {
		
		for(Investor i: m.investors) {
			if(i.getBudget() > 0) {
				return false;
			}
		}
		return true;
	}
	

	
	// Menu prompt user to view reports
	public static void menu() {
		
			//Printing
			System.out.println("\n1) Company with highest capital \n2) Company with loest capital");
			System.out.println("3) Investor with highest number of shares \n4) Investor with lowest number of shares");
			System.out.println("5) Show Companies with doubled up share's prices\n6) Show Companies with 2% reduced share's prices");
			System.out.println("7) Exit");
			System.out.print("\n\t Choose an option: ");
			
			int c = input.nextInt();
			
			switch(c) {
				
			case 1:
				companyWithHighestCapital();
				break;
			case 2:
				companyWithLowestCapital();
				break;
			case 3:
				investorWithHighestShares();
				break;
			case 4:
				investorWithLowestShares();
				break;
			case 5:
				showDoubledUp();
				break;
			case 6:
				showReduced();
				break;
			case 7:
				exit();
			default:
				//Printing
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("\n\t Invalid input");
				System.out.println("");
				System.out.println("--------------------------------------------------------------------------------------------");
				menu(); // calling menu
			}
		
	}
	
	// Method prints the Highest Capital company's ID and SharesSold
	public static void companyWithHighestCapital() {
		
		int shares = m.companies.get(0).getSoldShares();
		int index =0;
		for(Company c: m.companies) {
			
			if(c.getSoldShares() > shares) {
				shares = c.getSoldShares();
				index = m.companies.indexOf(c);
			}
		}
		//Printing
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Company with highest Capital  **************");
		System.out.println("");
		System.out.println("ID : "+m.companies.get(index).getId());
		System.out.println("Shares : "+m.companies.get(index).getSoldShares());
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------");
		menu(); // calling menu
	}
	
	// Method prints the Lowest Capital company's ID and SharesSold
	public static void companyWithLowestCapital() {
			
		int shares = m.companies.get(0).getSoldShares();
		int index = 0;
		for(Company c: m.companies) {
			
			if(c.getSoldShares() < shares) {
				shares = c.getSoldShares();
				index = m.companies.indexOf(c);
			}
		}
		//Printing
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Company with lowest Capital  **************");
		System.out.println("");
		System.out.println("ID : "+m.companies.get(index).getId());
		System.out.println("Shares : "+m.companies.get(index).getSoldShares());
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------");
		menu();// calling menu
	}
	
	// Method prints the ID and SharesPurchased of investor with highest purchases
	public static void investorWithHighestShares() {
		
		int index =0;
		int shares = m.investors.get(0).getPurchasedShares();
		for(Investor i: m.investors) {
			
			if(i.getPurchasedShares() > shares) {
				shares = i.getPurchasedShares();
				index = m.investors.indexOf(i);
			}
		}
		//Printing
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Investor with highest shares  **************");
		System.out.println("");
		System.out.println("ID : "+m.investors.get(index).getId());
		System.out.println("Shares : "+m.investors.get(index).getPurchasedShares());
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------");
		menu();// calling menu
	}
	// Method prints the ID and SharesPurchased of investor with lowest purchases
	public static void investorWithLowestShares() {
	
		int index =0;
		int shares = m.investors.get(0).getPurchasedShares();
		for(Investor i: m.investors) {
			
			if(i.getPurchasedShares() < shares) {
				shares = i.getPurchasedShares();
				index = m.investors.indexOf(i);
			}
		}
		//Printing
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Investor with Lowest shares  **************");
		System.out.println("");
		System.out.println("ID : "+m.investors.get(index).getId());
		System.out.println("Shares : "+m.investors.get(index).getPurchasedShares());
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------");
		menu();// calling menu
	}
	
	// Method Prints the IDs of all the companies with doubled up share's prices
	public static void showDoubledUp(){
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Companies with Doubled up share's price  **************");
		
		for(Company c: m.doubledUp) {
			System.out.println("id: "+c.getId());
		
			
		}
		//Printing
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("");
		menu();// calling menu
	}
	
	// Method Prints the IDs of all the companies with 2% reduction in share's prices
	public static void showReduced(){
		
		//Printing
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("**********  Companies with 2% reduced share's prices  **************");
		System.out.println("");
		System.out.println(m.reduced.size());
		for(Company c: m.reduced) {
			System.out.println("id: "+c.getId());
			
			for(Share s: c.shares) {
				System.out.println( c.shares.indexOf(s)+1+") $"+ s.getPrice());
				
			}
			
		}
		//Printing
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("");
		menu();// calling menu
	}
	
	//exit method
	public static void exit() {
		//Printing
		System.out.println("*******************************************************");
		System.out.println("            Thank you for Trading             ");
		System.out.println("                    Good Bye.......!                   "); // printing Good bye message
		System.out.println("*******************************************************");
		System.exit(0);// exit
	}
}
