import java.util.ArrayList;
import java.util.UUID;

public class Company {
	
	private String id;
	private String publishedYear;
	private ArrayList<Share> shares = new ArrayList<Share>();
	
	public Company() {
		
		this.id =  UUID.randomUUID().toString();
		
		int totalShares = (int)Math.random() * (1000 - 500 + 1) + 500;
		int price;
		
		for (int i = 0; i<totalShares; i++) {
			
			price =(int)Math.random() * (100 - 10 + 1) + 10;
			shares.add(new Share(price));
		}
		
		
	}
    
}