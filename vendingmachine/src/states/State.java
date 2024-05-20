package states;

public interface State {
	public void insertCoin(double amount);
	public void pushButton(int aisleNo);
	public void dispense(int aisleNo);
}
