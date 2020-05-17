import java.util.ArrayList;
import java.util.UUID;

public class Investor {

	private String id;
	private int budget;
	private int purchasedShares;
	
	/*Behavior Design Pattern - OBSERVER Design Pattern
	 *Every time a Investor purchase a share, share list will be updated
	*/
	private ArrayList<Share> shares = new ArrayList<Share>();
	
	
	public Investor() {
		
		id =  UUID.randomUUID().toString();
		budget = (int)(Math.random() * (10000 - 1000 + 1) + 1000);
		purchasedShares = 0;
	}
	
	//Return id of investor
	public String getId() {
		return id;
	}
	//returns budget of investor for purchases
	public int getBudget() {
		return budget;
	}
	
	//share is added to list of investor's purchases
	public void addShare(Share share) {
		shares.add(share);
		purchasedShares++;
	}
	
	//returns the count of purchases by investors
	public int getPurchasedShares() {
		return purchasedShares;
	}
}
