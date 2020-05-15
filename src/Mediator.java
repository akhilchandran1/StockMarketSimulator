import java.util.ArrayList;

//Mediator class will hold the list of all the companies and investors
// Benefit of using this pattern is; it will make easy the transactions of share between companies and investors 
class Mediator{

    private ArrayList<Company> companies;
    private ArrayList<Investor> investors;

    public Mediator(){
        this.companies = new ArrayList<>();
        this.investors = new ArrayList<>();
    }
    

    // Adding a new Company to Array
    public void addCompany(Company company){
        this.companies.add(company);
    }
    
    public void addInvestor(Investor investor) {
    	this.investors.add(investor);
    }

    public void saleShare(Share share){
        
        
    }
    
    public void buyShare(Share share){
        
        
    }
}