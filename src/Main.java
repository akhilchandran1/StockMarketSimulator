import java.util.ArrayList;

public class Main {

	public static ArrayList<Company> companies = new ArrayList<Company>();
	public static ArrayList<Investor> investors = new ArrayList<Investor>();
	
	public static void main(String[] arg) {
		
		System.out.println("");
		
	}
	
	// Creating 100 Companies
	public void createCompanies() {
	
		int size = 100;
		for(int i=0; i<size; i++) {
			companies.add(new Company());
		}
	}
	// Creating 100 Investors
	public void createInvestors() {
		
		int size = 100;
		for(int i=0; i<size; i++) {
			investors.add(new Investor());
		}
	}
}
