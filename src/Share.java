import java.util.UUID;

public class Share {

	//private String id =  UUID.randomUUID().toString();
	private int price;
	
	public Share(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
