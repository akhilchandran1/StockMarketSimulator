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
		budget = (int)Math.random() * (10000 - 1000 + 1) + 1000;
		purchasedShares = 0;
	}
	
	
	public int getBudget() {
		return budget;
	}
	
	
	public void addShare(Share share) {
		shares.add(share);
	}
}
