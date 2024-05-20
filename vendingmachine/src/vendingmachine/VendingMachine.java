package vendingmachine;

import dataset.Inventory;
import dataset.Product;
import states.CoinInserted;
import states.DispenceProduct;
import states.NoCoinInserted;
import states.State;

public class VendingMachine {
	 private double amount;
	 private State currState;
	 private Inventory inventory;
	 private NoCoinInserted noCoinInserted;
	 private CoinInserted coinInserted;
	 private DispenceProduct dispenceProduct;
	 private static final int AISLE_COUNT = 2;
	 
	 public VendingMachine() {
		 this.amount = 0.0;
		 noCoinInserted = new NoCoinInserted(this);
		 coinInserted = new CoinInserted(this);
		 dispenceProduct = new DispenceProduct(this);
		 this.currState = noCoinInserted;
		 inventory = new Inventory(AISLE_COUNT);
	 }
	 
	 
	 //update amount
	 public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public NoCoinInserted getNoCoinInserted() {
		return noCoinInserted;
	}

	public void setNoCoinInserted(NoCoinInserted noCoinInserted) {
		this.noCoinInserted = noCoinInserted;
	}

	public CoinInserted getCoinInserted() {
		return coinInserted;
	}

	public void setCoinInserted(CoinInserted coinInserted) {
		this.coinInserted = coinInserted;
	}

	public DispenceProduct getDispenceProduct() {
		return dispenceProduct;
	}

	public void setDispenceProduct(DispenceProduct dispenceProduct) {
		this.dispenceProduct = dispenceProduct;
	}

	 public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public State getCurrState() {
		return currState;
	}

	public void setCurrState(State currState) {
		this.currState = currState;
	}
	
	//display
	public void display() {
		inventory.display();
		System.out.println("\nChoose from the aisle above \n");
	}


	//check amount>=product amount
	 public boolean isSufficientAmount(double productAmount) {
		 return (productAmount<=this.amount);
	 }
	 //check product available
	 public boolean checkProductAvailable(int aisleNo) {
		 return inventory.isProductAvailable(aisleNo);
	 }
	 //insert coin
	 public void insertCoin(double coin) {
		 this.currState.insertCoin(coin);
		 System.out.println("Total inserted amount : "+ amount);
	 }
	 //press button
	 public void pressButton(int aisleNo) {
		 this.currState.pushButton(aisleNo);
		 this.currState.dispense(aisleNo);
	 }
	 //add product
	 public void addProduct(Product product) {
		 try {
			 inventory.addProduct(product);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
}
