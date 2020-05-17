import java.util.UUID;

public class Share {

	//private String id =  UUID.randomUUID().toString();
	private int price;
	
	//Constructor of Share just assign a value to price
	public Share(int price) {
		this.price = price;
	}
	
	//Return price
	public int getPrice() {
		return price;
	}
	
	//set the new price to a share
	public void setPrice(int price) {
		this.price = price;
	}
	
}
