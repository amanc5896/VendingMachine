package driver;

import dataset.Product;
import vendingmachine.VendingMachine;

public class Driver {

	public static void main(String [] args) {
		final Product cocacola = new Product("Coca Cola",123,20.5);
		VendingMachine vendingMachine = new VendingMachine();
		for(int i=1;i<=4;i++) {
			vendingMachine.addProduct(cocacola);
		}
		final Product sprite = new Product("Sprite",456,15.8);
		for(int i=1;i<=6;i++) {
			vendingMachine.addProduct(sprite);
		}
		vendingMachine.display();
		vendingMachine.insertCoin(10);
		vendingMachine.insertCoin(12.3);
		vendingMachine.pressButton(1);
		
		vendingMachine.insertCoin(10);
		vendingMachine.insertCoin(20.3);
		vendingMachine.pressButton(2);
	}
}
