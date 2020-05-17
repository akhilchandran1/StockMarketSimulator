import java.util.ArrayList;
import java.util.UUID;

public class Company {
	
	private String id;
	private int availableShares;
	private int soldShares;
	
	/*Behavior Design Pattern - OBSERVER Design Pattern
	 *Every time a share is sold, we will remove it to update the shares list of each company
	*/
	
	
	public ArrayList<Share> shares = new ArrayList<Share>();
	
	//Constructor of company
	public Company() {
		
		this.id =  UUID.randomUUID().toString();
		
		int totalShares = (int)(Math.random() * (1000 - 500 + 1) + 500);
		
		int price;
		
		for (int i = 0; i<totalShares; i++) {
			
			price =(int)(Math.random() * (100 - 10 + 1) + 10);
			shares.add(new Share(price));
		}
		
		availableShares = totalShares;
	}
	
	//Returns id of Company
	public String getId() {
		return id;
	}
	
	//Return list of shares
	public ArrayList<Share> getShares() {
		return shares;
	}
	
	// A shared purchased by investor is removed from company
	public void removeShare(Share share) {
		shares.remove(share);
		soldShares++;
		availableShares--;
	}
	
	// return count of total sold shares by a company
	public int getSoldShares() {
		return soldShares;
	}
	
	// return available shares for investors to buy
	public int getAvailableShares() {
		return availableShares;
	}
    
}