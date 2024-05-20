package states;

import dataset.Inventory;
import dataset.Product;
import vendingmachine.VendingMachine;

public class CoinInserted implements State{
	
	VendingMachine vendingMachine = null;
	
	public CoinInserted(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	
	@Override
	public void insertCoin(double amount) {
		vendingMachine.setAmount(vendingMachine.getAmount()+amount);
	}
	@Override
	public void pushButton(int aisleNo) {
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNo);
		
		double price = product.getPrice();
		if(!vendingMachine.isSufficientAmount(price)) {
			throw new IllegalStateException("Entered amount is less than product price");
		}
		if(!inventory.isProductAvailable(aisleNo)) {
			throw new IllegalStateException("Product not available");
		}
		vendingMachine.setCurrState(vendingMachine.getDispenceProduct());
		
	}
	@Override
	public void dispense(int aisleNo) {
		throw new IllegalStateException("Cannot dispence product");
	}
}
