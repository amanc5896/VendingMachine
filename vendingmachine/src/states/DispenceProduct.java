package states;

import java.text.DecimalFormat;

import dataset.Inventory;
import dataset.Product;
import vendingmachine.VendingMachine;

public class DispenceProduct implements State{
	
	VendingMachine vendingMachine = null;
	DecimalFormat df = new DecimalFormat("####0.00");
	
	public DispenceProduct(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	@Override
	public void insertCoin(double amount) {
		throw new IllegalStateException("Dispencing Product. Not expecting any amount");
	}
	@Override
	public void pushButton(int aisleNo) {
		throw new IllegalStateException("Dispencing Product. Not expecting any operation");
	}
	@Override
	public void dispense(int aisleNo) {
		Inventory inventory = vendingMachine.getInventory();
		Product product = inventory.getProduct(aisleNo);
		
		double change = vendingMachine.getAmount()-product.getPrice();
		inventory.updateProductCount(aisleNo);
		vendingMachine.setAmount(0.0);
		vendingMachine.setCurrState(vendingMachine.getNoCoinInserted());
		
		System.out.println("Product "+product.getProductName()+" dispenced.");
		System.out.println("Please collect the change : "+df.format(change));
	}
}
