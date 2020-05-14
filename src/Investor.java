import java.util.UUID;

public class Investor {

	private String id;
	private int budget;
	
	public Investor() {
		
		id =  UUID.randomUUID().toString();
		budget = (int)Math.random() * (10000 - 1000 + 1) + 1000;
	}
}
