import java.util.ArrayList;

public class Main {

	
	public static void main(String[] arg) {
		
		// Declaring and initializing the mediator class to save list of companies and objects
		Mediator mediator = new Mediator();
		
		int size =100;
		
	// Creating 100 Companies
		for(int i=0; i<size; i++) {
			mediator.addCompany(new Company());
		}
	
	// Creating 100 Investors
		for(int i=0; i<size; i++) {
			mediator.addInvestor(new Investor());
		}
	}
}
