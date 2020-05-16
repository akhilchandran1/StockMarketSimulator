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
	
	public int sharesSold = 0;
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
        
    	int index = companies.get(c).shares.size()-1;
    	
    	if(index==0)
    		return;
    	
    	int price = companies.get(c).shares.get(index).getPrice();
    	int budget = investors.get(i).getBudget();
    	
        if(price <= budget) {
        	
        	investors.get(i).addShare(companies.get(c).shares.get(index));
        	companies.get(c).removeShare(companies.get(c).shares.get(index));
        	
        	sharesSold++;
        }
        checkDoubleUp();
        checkNoSales();
        	
        }
    

    //  If a company sells 10 shares, the share price is double up
    public void checkDoubleUp() {
    	
    	for(Company c: companies) {
    		if(c.getSoldShares()==10) {
    			
    			for(Share s: c.shares) {
    				s.setPrice(s.getPrice()*2);
    			}
    		}
    	}
    }
    
    // If any 10 shares are sold (from any company), and a company hasn’t sold any, the
    //price is reduced to 2%
    public void checkNoSales() {
    	
    	if(sharesSold==10) {
    		
    		for(Company c: companies) {			
        		if(c.getSoldShares()==0) {
        			
        			for(Share s: c.shares) {
        				s.setPrice(s.getPrice()-(s.getPrice()*2/100));
        			}
        		}
        	}
    	}
    }
    
}