import java.util.ArrayList;

//Behavior Design Pattern - MEDIATOR
//Mediator class will hold the list of all the companies and investors
// Benefit of using this pattern is; it will make easy the transactions of share between companies and investors 
class Mediator{
	
	/*
	 * Creational Design Pattern - SINGLETON
	 */

	//creating instance of mediator class as static
	static Mediator m = new Mediator();
	
    public static ArrayList<Company> companies;
    public static ArrayList<Investor> investors;
    
    //Default Constructor is set to private 
    // So other classes cannot create instance of this class
    private Mediator(){
        this.companies = new ArrayList<>();
        this.investors = new ArrayList<>();
    }
    
    // Return Mediator Instance
    public static Mediator getInstance() {
    	
    	return m;
    }

    // Adding a new Company to Array
    public void addCompany(Company company){
        this.companies.add(company);
    }
    
    // Adding a new Invester to Array
    public void addInvestor(Investor investor) {
    	this.investors.add(investor);
    }

    public void trade(int c, int i ){
    	
    	int price = companies.get(c).shares.get(companies.get(c).shares.size()-1).getPrice();
    	int budget = investors.get(i).getBudget();
    	
        if(price < budget) {
        	
        }
    
    }
}