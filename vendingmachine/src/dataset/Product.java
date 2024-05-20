package dataset;

public class Product {
	
	private String productName;
	private int productId;
	private double price;
	
	public Product(String name, int id, double cost) {
		this.setProductId(id);
		this.setProductName(name);
		this.setPrice(cost);
	}
	
	public String getProductName() {
		return productName;
	}
	private void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	private void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	private void setPrice(double price) {
		this.price = price;
	}
	
	
}
