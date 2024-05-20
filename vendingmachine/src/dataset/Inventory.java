package dataset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
	
	private Map<Integer, Product> aisleToProductMap;
	private Map<Integer, Integer> productIdToCountMap;
	Queue<Integer> availableAisle;
	
	public Inventory(int aisleCount) {
		aisleToProductMap = new HashMap<>();
		productIdToCountMap = new HashMap<>();
		availableAisle = new LinkedList<>();
		for(int i=1;i<=aisleCount;i++) {
			availableAisle.add(i);
		}
		
	}
	
	//display()
	public void display() {
		for(Integer aisleNo : aisleToProductMap.keySet()) {
			String productName = aisleToProductMap.get(aisleNo).getProductName();
			System.out.println("Aisle Number : "+ aisleNo+" \t Product : "+productName);
		}
	}
	
	//addProduct
	public void addProduct(Product product) throws Exception {
		int id = product.getProductId();
		int productCount = productIdToCountMap.getOrDefault(id, 0);
		if(productCount == 0) {
			if(availableAisle.size()==0) {
				throw new Exception("No more aisles available to put a product");
			}
			int currAisle = availableAisle.poll();
			aisleToProductMap.put(currAisle, product);			
		}
		productIdToCountMap.put(id, productCount+1);
	}
	
	//updateProduct
	public void updateProductCount(int aisleNo) {
		Product product = aisleToProductMap.get(aisleNo);
		int id = product.getProductId();
		int productCount = productIdToCountMap.get(id)-1;
		productIdToCountMap.put(id, productCount);
		if(productCount==0) {
			removeProduct(aisleNo);
		}
	}
	
	//removeProduct
	public void removeProduct(int aisleNo) {
		Product product = aisleToProductMap.get(aisleNo);
		int id = product.getProductId();
		productIdToCountMap.remove(id);
		aisleToProductMap.remove(aisleNo);
		availableAisle.add(aisleNo);
	}
	
	//getProduct
	public Product getProduct(int aisleNo) {
		return aisleToProductMap.get(aisleNo);
	}
	
	//checkProduct
	public boolean isProductAvailable(int aisleNo) {
		return aisleToProductMap.containsKey(aisleNo);
	}
	
}
