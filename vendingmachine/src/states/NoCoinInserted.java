package states;

import vendingmachine.VendingMachine;

public class NoCoinInserted implements State{
	
	private VendingMachine vendingMachine = null;
	
	public NoCoinInserted(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	@Override
	public void insertCoin(double amount) {
		vendingMachine.setAmount(amount);
		vendingMachine.setCurrState(vendingMachine.getCoinInserted());
	}
	@Override
	public void pushButton(int aisleNo) {
		throw new IllegalStateException("No coin inserted yet");
	}
	@Override
	public void dispense(int aisleNo) {
		throw new IllegalStateException("No coin inserted yet");
	}
}
